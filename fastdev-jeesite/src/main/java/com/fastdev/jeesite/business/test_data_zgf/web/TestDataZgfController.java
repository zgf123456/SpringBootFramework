package com.fastdev.jeesite.business.test_data_zgf.web;

import com.fastdev.jeesite.business.test_data_zgf.entity.TestDataZgf;
import com.fastdev.jeesite.business.test_data_zgf.service.TestDataZgfService;
import com.fastdev.jeesite.common.config.Global;
import com.fastdev.jeesite.common.persistence.Page;
import com.fastdev.jeesite.common.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试描述Controller
 * @author zgf
 * @version 2017-06-20
 */
@Controller
@RequestMapping(value = "${adminPath}/test_data_zgf/testDataZgf")
public class TestDataZgfController extends BaseController {

	@Autowired
	private TestDataZgfService testDataZgfService;
	
	@ModelAttribute
	public TestDataZgf get(@RequestParam(required=false) String id) {
		TestDataZgf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testDataZgfService.get(id);
		}
		if (entity == null){
			entity = new TestDataZgf();
		}
		return entity;
	}
	
	@RequiresPermissions("test_data_zgf:testDataZgf:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestDataZgf testDataZgf, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TestDataZgf> page = testDataZgfService.findPage(new Page<TestDataZgf>(request, response), testDataZgf);
		model.addAttribute("page", page);
		return "modules/test_data_zgf/testDataZgfList";
	}

	@RequiresPermissions("test_data_zgf:testDataZgf:view")
	@RequestMapping(value = "form")
	public String form(TestDataZgf testDataZgf, Model model) {
		model.addAttribute("testDataZgf", testDataZgf);
		return "modules/test_data_zgf/testDataZgfForm";
	}

	@RequiresPermissions("test_data_zgf:testDataZgf:edit")
	@RequestMapping(value = "save")
	public String save(TestDataZgf testDataZgf, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testDataZgf)){
			return form(testDataZgf, model);
		}
		testDataZgfService.save(testDataZgf);
		addMessage(redirectAttributes, "保存测试成功");
		return "redirect:"+ Global.getAdminPath()+"/test_data_zgf/testDataZgf/?repage";
	}
	
	@RequiresPermissions("test_data_zgf:testDataZgf:edit")
	@RequestMapping(value = "delete")
	public String delete(TestDataZgf testDataZgf, RedirectAttributes redirectAttributes) {
		testDataZgfService.delete(testDataZgf);
		addMessage(redirectAttributes, "删除测试成功");
		return "redirect:"+Global.getAdminPath()+"/test_data_zgf/testDataZgf/?repage";
	}

}
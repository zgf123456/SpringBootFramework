package com.fastdev.jeesite.business.testdatazgf.web;

import com.fastdev.jeesite.business.testdatazgf.entity.TestDataZgf;
import com.fastdev.jeesite.business.testdatazgf.service.TestDataZgfService;
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
 * 代码生成测试Controller
 * @author zhengguofeng
 * @version 2017-07-14
 */
@Controller
@RequestMapping(value = "${adminPath}/testdatazgf/testDataZgf")
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
	
	@RequiresPermissions("testdatazgf:testDataZgf:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestDataZgf testDataZgf, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TestDataZgf> page = testDataZgfService.findPage(new Page<TestDataZgf>(request, response), testDataZgf); 
		model.addAttribute("page", page);
		return "modules/testdatazgf/testDataZgfList";
	}

	@RequiresPermissions("testdatazgf:testDataZgf:view")
	@RequestMapping(value = "form")
	public String form(TestDataZgf testDataZgf, Model model) {
		model.addAttribute("testDataZgf", testDataZgf);
		return "modules/testdatazgf/testDataZgfForm";
	}

	@RequiresPermissions("testdatazgf:testDataZgf:edit")
	@RequestMapping(value = "save")
	public String save(TestDataZgf testDataZgf, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testDataZgf)){
			return form(testDataZgf, model);
		}
		testDataZgfService.save(testDataZgf);
		addMessage(redirectAttributes, "保存代码生成测试成功");
		return "redirect:"+Global.getAdminPath()+"/testdatazgf/testDataZgf/?repage";
	}
	
	@RequiresPermissions("testdatazgf:testDataZgf:edit")
	@RequestMapping(value = "delete")
	public String delete(TestDataZgf testDataZgf, RedirectAttributes redirectAttributes) {
		testDataZgfService.delete(testDataZgf);
		addMessage(redirectAttributes, "删除代码生成测试成功");
		return "redirect:"+Global.getAdminPath()+"/testdatazgf/testDataZgf/?repage";
	}

}
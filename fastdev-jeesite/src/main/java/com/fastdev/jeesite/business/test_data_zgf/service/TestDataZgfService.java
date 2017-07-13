package com.fastdev.jeesite.business.test_data_zgf.service;

import com.fastdev.jeesite.business.test_data_zgf.dao.TestDataZgfDao;
import com.fastdev.jeesite.business.test_data_zgf.entity.TestDataZgf;
import com.fastdev.jeesite.common.persistence.Page;
import com.fastdev.jeesite.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 测试描述Service
 * @author zgf
 * @version 2017-06-20
 */
@Service
@Transactional(readOnly = true)
public class TestDataZgfService extends CrudService<TestDataZgfDao, TestDataZgf> {

	public TestDataZgf get(String id) {
		return super.get(id);
	}
	
	public List<TestDataZgf> findList(TestDataZgf testDataZgf) {
		return super.findList(testDataZgf);
	}
	
	public Page<TestDataZgf> findPage(Page<TestDataZgf> page, TestDataZgf testDataZgf) {
		return super.findPage(page, testDataZgf);
	}
	
	@Transactional(readOnly = false)
	public void save(TestDataZgf testDataZgf) {
		super.save(testDataZgf);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestDataZgf testDataZgf) {
		super.delete(testDataZgf);
	}
	
}
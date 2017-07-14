package com.fastdev.jeesite.business.testdatazgf.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastdev.jeesite.common.persistence.Page;
import com.fastdev.jeesite.common.service.CrudService;
import com.fastdev.jeesite.business.testdatazgf.entity.TestDataZgf;
import com.fastdev.jeesite.business.testdatazgf.dao.TestDataZgfDao;

/**
 * 代码生成测试Service
 * @author zhengguofeng
 * @version 2017-07-14
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
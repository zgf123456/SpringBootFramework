package com.fastdev.jeesite.business.test_data_zgf.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.test_data_zgf.entity.TestDataZgf;
import com.fastdev.jeesite.common.persistence.CrudDao;

/**
 * 测试描述DAO接口
 * @author zgf
 * @version 2017-06-20
 */
@FastdevMybatisMapper
public interface TestDataZgfDao extends CrudDao<TestDataZgf> {
	
}
package com.fastdev.jeesite.business.gen.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.gen.entity.GenTable;
import com.fastdev.jeesite.common.persistence.CrudDao;

/**
 * 业务表DAO接口
 */
@FastdevMybatisMapper
public interface GenTableDao extends CrudDao<GenTable> {
	
}

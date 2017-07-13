package com.fastdev.jeesite.business.gen.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.gen.entity.GenTableColumn;
import com.fastdev.jeesite.common.persistence.CrudDao;

/**
 * 业务表字段DAO接口
 */
@FastdevMybatisMapper
public interface GenTableColumnDao extends CrudDao<GenTableColumn> {
	
	public void deleteByGenTableId(String genTableId);
}

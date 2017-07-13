package com.fastdev.jeesite.business.gen.dao;


import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.gen.entity.GenTable;
import com.fastdev.jeesite.business.gen.entity.GenTableColumn;
import com.fastdev.jeesite.common.persistence.CrudDao;

import java.util.List;

/**
 * 业务表字段DAO接口
 */
@FastdevMybatisMapper
public interface GenDataBaseDictDao extends CrudDao<GenTableColumn> {

	/**
	 * 查询表列表
	 * @param genTable
	 * @return
	 */
	List<GenTable> findTableList(GenTable genTable);

	/**
	 * 获取数据表字段
	 * @param genTable
	 * @return
	 */
	List<GenTableColumn> findTableColumnList(GenTable genTable);
	
	/**
	 * 获取数据表主键
	 * @param genTable
	 * @return
	 */
	List<String> findTablePK(GenTable genTable);
	
}

package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.sys.entity.Office;
import com.fastdev.jeesite.common.persistence.TreeDao;

/**
 * 机构DAO接口
 */
@FastdevMybatisMapper
public interface OfficeDao extends TreeDao<Office> {

}

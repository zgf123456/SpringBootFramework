package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.sys.entity.Area;
import com.fastdev.jeesite.common.persistence.TreeDao;

/**
 * 区域DAO接口
 */
@FastdevMybatisMapper
public interface AreaDao extends TreeDao<Area> {
}

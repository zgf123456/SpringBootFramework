package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.jeesite.business.sys.entity.Area;
import com.fastdev.jeesite.common.persistence.TreeDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 区域DAO接口
 */
@Mapper
public interface AreaDao extends TreeDao<Area> {
}

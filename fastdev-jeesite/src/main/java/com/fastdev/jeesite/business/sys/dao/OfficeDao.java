package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.jeesite.business.sys.entity.Office;
import com.fastdev.jeesite.common.persistence.TreeDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 机构DAO接口
 */
@Mapper
public interface OfficeDao extends TreeDao<Office> {

}

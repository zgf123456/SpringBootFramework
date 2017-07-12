
package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.jeesite.business.sys.entity.Log;
import com.fastdev.jeesite.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志DAO接口
 */
@Mapper
public interface LogDao extends CrudDao<Log> {

}


package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.sys.entity.Log;
import com.fastdev.jeesite.common.persistence.CrudDao;

/**
 * 日志DAO接口
 */
@FastdevMybatisMapper
public interface LogDao extends CrudDao<Log> {
}

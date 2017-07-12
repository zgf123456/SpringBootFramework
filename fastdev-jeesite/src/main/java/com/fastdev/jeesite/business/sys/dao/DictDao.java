package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.sys.entity.Dict;
import com.fastdev.jeesite.common.persistence.CrudDao;

import java.util.List;

/**
 * 字典DAO接口
 */
@FastdevMybatisMapper
public interface DictDao extends CrudDao<Dict> {
    List<String> findTypeList(Dict dict);

}

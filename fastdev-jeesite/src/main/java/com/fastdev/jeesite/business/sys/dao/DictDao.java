package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.jeesite.business.sys.entity.Dict;
import com.fastdev.jeesite.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典DAO接口
 */
@Mapper
public interface DictDao extends CrudDao<Dict> {

    List<String> findTypeList(Dict dict);

}

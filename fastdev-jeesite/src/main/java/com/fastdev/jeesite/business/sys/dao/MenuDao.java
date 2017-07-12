package com.fastdev.jeesite.business.sys.dao;

import com.fastdev.common.mybatis.annotation.FastdevMybatisMapper;
import com.fastdev.jeesite.business.sys.entity.Menu;
import com.fastdev.jeesite.common.persistence.CrudDao;

import java.util.List;

/**
 * 菜单DAO接口
 */
@FastdevMybatisMapper
public interface MenuDao extends CrudDao<Menu> {

    List<Menu> findByParentIdsLike(Menu menu);

    List<Menu> findByUserId(Menu menu);

    int updateParentIds(Menu menu);

    int updateSort(Menu menu);

}

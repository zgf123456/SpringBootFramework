package com.fastdev.jeesite.business.sys.service;

import com.fastdev.jeesite.business.sys.dao.DictDao;
import com.fastdev.jeesite.business.sys.entity.Dict;
import com.fastdev.jeesite.business.sys.utils.DictUtils;
import com.fastdev.jeesite.common.service.CrudService;
import com.fastdev.jeesite.common.utils.CacheUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典Service
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

}

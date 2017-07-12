package com.fastdev.jeesite.business.sys.service;

import com.fastdev.jeesite.business.sys.dao.LogDao;
import com.fastdev.jeesite.business.sys.entity.Log;
import com.fastdev.jeesite.common.persistence.Page;
import com.fastdev.jeesite.common.service.CrudService;
import com.fastdev.jeesite.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志Service
 */
@Service
@Transactional(readOnly = true)
public class LogService extends CrudService<LogDao, Log> {

	@Override
	public Page<Log> findPage(Page<Log> page, Log log) {
		
		// 设置默认时间范围，默认当前月
		if (log.getBeginDate() == null){
			log.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
		}
		if (log.getEndDate() == null){
			log.setEndDate(DateUtils.addMonths(log.getBeginDate(), 1));
		}
		
		return super.findPage(page, log);
		
	}
	
}

package com.fastdev.jeesite.business.sys.service;

import com.fastdev.jeesite.business.sys.dao.AreaDao;
import com.fastdev.jeesite.business.sys.entity.Area;
import com.fastdev.jeesite.business.sys.utils.UserUtils;
import com.fastdev.jeesite.common.service.TreeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区域Service
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {

    public List<Area> findAll() {
        return UserUtils.getAreaList();
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Area area) {
        super.save(area);
        UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Area area) {
        super.delete(area);
        UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
    }

}

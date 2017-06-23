package com.fastdev.task.frame.services;

import com.fastdev.task.frame.mapper.QuartzJobConfigMapper;
import com.fastdev.task.frame.model.QuartzJobConfig;
import com.fastdev.task.frame.model.QuartzJobConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zgf on 17/6/22.
 */
@Service
public class QuartzJobConfigService {

    @Autowired
    private QuartzJobConfigMapper quartzJobConfigMapper;

    /**
     * 查询所有启动的任务
     *
     * @return
     */
    public List<QuartzJobConfig> queryEnableJob() {
        QuartzJobConfigExample quartzJobConfigExample = new QuartzJobConfigExample();
        quartzJobConfigExample.createCriteria().andEnableEqualTo("0");
        return quartzJobConfigMapper.selectByExample(quartzJobConfigExample);
    }
}

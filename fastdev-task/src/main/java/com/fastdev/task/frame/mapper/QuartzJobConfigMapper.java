package com.fastdev.task.frame.mapper;

import com.fastdev.task.frame.model.QuartzJobConfig;
import com.fastdev.task.frame.model.QuartzJobConfigExample;

import java.util.List;

public interface QuartzJobConfigMapper {
    int countByExample(QuartzJobConfigExample example);

    List<QuartzJobConfig> selectByExample(QuartzJobConfigExample example);

    QuartzJobConfig selectByPrimaryKey(Integer id);
}
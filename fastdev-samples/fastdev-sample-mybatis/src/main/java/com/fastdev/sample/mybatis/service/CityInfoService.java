package com.fastdev.sample.mybatis.service;

import com.fastdev.sample.mybatis.mappers.CityInfoMapper;
import com.fastdev.sample.mybatis.model.CityInfo;
import com.fastdev.sample.mybatis.model.CityInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zgf on 17/6/21.
 */
@Service
public class CityInfoService {
    @Autowired
    private CityInfoMapper cityInfoMapper;

    public List<CityInfo> queryByLemmaItem(String lemmaItem) {
        CityInfoExample example = new CityInfoExample();
        example.createCriteria().andLemmaItemEqualTo(lemmaItem);
        return cityInfoMapper.selectByExample(example);
    }
}

package com.fastdev.test.mybatis.service;

import com.fastdev.test.mybatis.mappers.CityInfoMapper;
import com.fastdev.test.mybatis.model.CityInfo;
import com.fastdev.test.mybatis.model.CityInfoExample;
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

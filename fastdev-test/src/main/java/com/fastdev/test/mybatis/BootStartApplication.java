package com.fastdev.test.mybatis;

import com.fastdev.test.mybatis.model.CityInfo;
import com.fastdev.test.mybatis.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.List;

/**
 * Created by zgf on 17/4/10.
 */
//@SpringBootApplication
public class BootStartApplication implements CommandLineRunner {

    @Autowired
    private CityInfoService cityInfoService;

    @Override
    public void run(String... strings) throws Exception {
        List<CityInfo> cityInfos = cityInfoService.queryByLemmaItem("110102");
        System.out.println(cityInfos);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootStartApplication.class, args);
    }
}

package com.fastdev.sample.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * springboot 启动类不能发在default package目录下
 */

@SpringBootApplication
public class ShiroApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShiroApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShiroApplication.class, args);
    }

}

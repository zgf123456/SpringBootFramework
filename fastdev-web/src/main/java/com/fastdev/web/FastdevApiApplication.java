package com.fastdev.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zgf on 17/7/11.
 */
@SpringBootApplication
@ComponentScan("com.fastdev")
public class FastdevApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FastdevApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FastdevApiApplication.class, args);
    }

}

package com.fastdev.jeesite;

import com.fastdev.common.annotation.CustomeLogAspect;
import com.fastdev.jeesite.business.sys.service.SystemService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 *
 */
@EnableCaching
@SpringBootApplication
@ServletComponentScan("com.fastdev")
@ComponentScan(value = "com.fastdev", lazyInit = true, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = CustomeLogAspect.class)})
public class FastdevJeesiteApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FastdevJeesiteApplication.class).web(true).run(args);
        SystemService.printKeyLoadMessage();
    }
}

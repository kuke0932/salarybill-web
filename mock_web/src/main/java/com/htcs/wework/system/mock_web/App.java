package com.htcs.wework.system.mock_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author zhaokaiyuan
 * @create 2018-03-01 11:52
 **/
//@MapperScan(value = {"com.htcs.wework.system.mapper"})
//@ComponentScan(basePackages = {"com.htcs.wework.*"}/*, excludeFilters ={ @ComponentScan.Filter(pattern = "com.htcs.wework.system.dao.*DAO")}*/)
@SpringBootApplication(scanBasePackages = "com.htcs.wework.*")
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }


}

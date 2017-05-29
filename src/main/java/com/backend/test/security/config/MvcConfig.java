package com.backend.test.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/admin/get_json_from_url").setViewName("admin");
        registry.addViewController("/usr/post_json_from_url").setViewName("usr");
        registry.addViewController("/usr/list_addresses").setViewName("usr");
        registry.addViewController("/dba/clear_session").setViewName("dba");
    }

}
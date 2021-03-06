package com.example.exampleproject.Service.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class ConfigController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/business-page").setViewName("business-page");
        registry.addViewController("/product-category").setViewName("product-category");
        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }
}
package com.hand.springboot.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description
 *
 * @author liangwusun 2021/03/29 14:08
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public  void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(timeInterceptor);
    }
}

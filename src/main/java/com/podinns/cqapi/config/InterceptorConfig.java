package com.podinns.cqapi.config;

import com.podinns.cqapi.interceptor.LogcostInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Project Name:${project_name}
 *
 * @Author : Lib
 * @Date: ${date}-${time}
 * @Description Copyright (c) ${year}, libao@podinns.com All Rights Reserved.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Value("${cqapi.appId}")
    private  String appId;
    @Value("${cqapi.appSecret}")
    private  String appSecret;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LogcostInterceptor interceptor = new LogcostInterceptor();
        interceptor.setAppId(appId);
        interceptor.setAppSecret(appSecret);
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**");
        super.addInterceptors(registry);
    }
}

package com.base;

import com.base.filter.CrosFilter;
import com.base.handler.Oauth2Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 *  config文件
 *  1、注入拦截器【Interceptor】bean
 *  2、注入跨域【Filter】bean
 */
@Configuration
public class AppConfigurer implements WebMvcConfigurer {

    @Autowired
    private Oauth2Interceptor oauth2Interceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/public/cube/search/readme");
//        registry.addViewController("/config").setViewName("forward:/cuberefer/config");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(oauth2Interceptor).addPathPatterns("/**");
    }
    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CrosFilter());
        return bean ;
    }
}

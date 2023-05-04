package com.wangyue.config;

import com.wangyue.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  配置拦截器 放行哪些路径
        List<String> asList = Arrays.asList("/user/register", "/user/login","/user/slogin");
        registry.addInterceptor(loginInterceptor).excludePathPatterns(asList);

//        registry.addInterceptor(loginInterceptor);
    }
}

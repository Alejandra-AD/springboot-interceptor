package com.curso.springboot.app.interceptor.springboot_interceptor;

import java.util.logging.Handler;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfiguration implements WebMvcConfigurer {

    private HandlerInterceptor interceptor;

    public AppConfiguration(@Qualifier("timeInterceptor") HandlerInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(interceptor);
        registry.addInterceptor(interceptor).addPathPatterns("/app/foo","/app/bar");
    }

    
    

}

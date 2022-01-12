package org.wys.demo.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wys.demo.spring.intercept.LoginInterceptor;
import org.wys.demo.spring.intercept.ViewIntercept;

/**
 * @author wys
 * @date 2021/12/24
 */
@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;
    private final ViewIntercept viewIntercept;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(viewIntercept)
                .addPathPatterns("/**");
    }
}

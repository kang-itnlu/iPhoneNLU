package com.nlu.fit.iphonenlu;

import com.nlu.fit.iphonenlu.interceptor.Globallnterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	Globallnterceptor globalInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/assets/**");
		// cái này là sẽ không hiển thị globalInterceptor lên các ip bên dưới
	}
	
	
	
}

package com.training.product.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.product.filter.RequestTracing;
import com.training.product.filter.RequestTracingAdvance;

@Configuration
public class FilterConfiguration {

	@Bean
	public FilterRegistrationBean<RequestTracing> loggingFilter() {
		FilterRegistrationBean<RequestTracing> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestTracing());
		registrationBean.addUrlPatterns("/database/*");
		registrationBean.setOrder(2);

		return registrationBean;
	}

}
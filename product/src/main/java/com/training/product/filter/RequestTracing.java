package com.training.product.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestTracing implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		log.info("RequestTracing - START doFilter");
		filterchain.doFilter(request, response);
		log.info("RequestTracing - END   doFilter");
	}
}
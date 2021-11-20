package com.swguan.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = { "/*" }, asyncSupported = true)
public class TimeFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(TimeFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long begin = new Date().getTime();
		logger.info("Filter-Time：Enter TimeFilter");
		chain.doFilter(request, response);
		long end = new Date().getTime();
		logger.info("Filter-Time：Finish TimeFilter : "+ (end - begin) + "ms");
	}

}

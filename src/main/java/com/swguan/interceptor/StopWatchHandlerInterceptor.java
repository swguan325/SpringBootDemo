package com.swguan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;

public class StopWatchHandlerInterceptor implements HandlerInterceptor {

	private NamedThreadLocal<Long> localTimer = new NamedThreadLocal<>("StopWatch-Timer");
	private Logger logger = LoggerFactory.getLogger(StopWatchHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long beginTime = System.currentTimeMillis();
		localTimer.set(beginTime);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime = System.currentTimeMillis();
		long beginTime = localTimer.get();
		long consumeTime = endTime - beginTime;
		logger.info(String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
	}

}

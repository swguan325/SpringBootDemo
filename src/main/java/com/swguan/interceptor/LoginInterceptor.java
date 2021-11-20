package com.swguan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		System.out.println(" --- LoginInterceptor.preHandle Start --- ");
		System.out.println("Request URL: " + request.getRequestURL());
		System.out.println("Start Time: " + System.currentTimeMillis());

		request.setAttribute("startTime", startTime);
		System.out.println(" --- LoginInterceptor.preHandle End --- ");

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(" --- LoginInterceptor.postHandle Start --- ");
		System.out.println("Request URL: " + request.getRequestURL());
		System.out.println(" --- LoginInterceptor.postHandle End --- ");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(" ---- LoginInterceptor.afterCompletion Start --- ");

		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("Request URL: " + request.getRequestURL());
		System.out.println("End Time: " + endTime);

		System.out.println("Time Taken: " + (endTime - startTime));

		System.out.println(" ---- LoginInterceptor.afterCompletion End --- ");
	}

}

package com.swguan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
@Order(1)
@Aspect
public class LogAop {

	private Logger logger = LoggerFactory.getLogger(LogAop.class);

	@Pointcut("execution(public * com.swguan.controller..*(..))")
	public void log() {

	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("[AOP-log]：Before");
	}

	@After("log()")
	public void doAfter(JoinPoint joinPoint) {
		logger.info("[AOP-log]：After");
	}

	@Around("log()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[AOP-log]：Around-Enter");
		logger.info("[AOP-log]：Around-parameters=" + JSONObject.toJSONString(joinPoint.getArgs()));
		Object object = joinPoint.proceed();
		logger.info("[AOP-log]：Around-result=" + JSONObject.toJSONString(object));
		logger.info("[AOP-log]：Around-Finish");
		return object;
	}
}

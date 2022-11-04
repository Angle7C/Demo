package com.example.demo.advice;


import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

@Aspect
@Component
public class HttpAspect {
         
	private final static Logger logger =LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.example.demo.controller.*.*(..))")
	public void log() {}
	
	@Before("log()")
	public void logbefore(JoinPoint point) {
		ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request =attributes.getRequest();
		logger.info("url={}",request.getRequestURI());
		logger.info("method={}",request.getMethod());
		logger.info("IP:PORT={}",request.getRemoteAddr());
		logger.info("Class_Method={}",point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName());
		
		Object[] args=point.getArgs();
		String argsStr="";
		for(Object arg : args) {
			argsStr+=arg.toString();
		}
		logger.info("args={}",argsStr);
	}
	
	@AfterReturning(pointcut="log()",returning="ret")
	public void logAfterRet(Object ret) {
		logger.info("response={}",ret.toString());
	}
	
	
	
	
	
}

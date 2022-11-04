package com.example.demo.exception.handle;

import com.example.demo.exception.enums.ErrorEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.component.advice.HttpAspect;
import com.example.demo.entity.model.JsonResult;
import com.example.demo.exception.MyException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger =LoggerFactory.getLogger(HttpAspect.class);
	
	@ExceptionHandler(value=Exception.class)
	public JsonResult<?> handle(Exception e) {
		logger.error("【系统异常】：",e);
		return JsonResult.fail(ErrorEnums.UNKNOWN_ERROR.getCode(), ErrorEnums.UNKNOWN_ERROR.getMessage());
	}
	
	@ExceptionHandler(value=MyException.class)
	public JsonResult<?> myhandle(MyException e) {
		logger.error("【操作异常】：",e);
		return JsonResult.fail(e.getCode(),e.getMessage());
	}
	
	

}

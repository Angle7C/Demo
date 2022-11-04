package com.example.demo.advice;
 
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
import com.example.demo.exception.MyException;
import com.example.demo.exception.enums.ErrorEnums;
 
@Aspect
@Component
public class ErrorThrowAspect {
 
    private final static Logger logger = LoggerFactory.getLogger(ErrorThrowAspect.class);
     
    @Pointcut("execution(public * com.example.demo.service.*.*(..))")
    public void error() {}
     
     
    //service中的方法运行中抛出异常时，做统一化处理
    @Around("error()")
    public Object catchMyException(ProceedingJoinPoint point) {
        Object ret = null;
        try {
            ret = point.proceed();
        } catch (Throwable e) {
            logger.info("error={}",e);
            String methodName = point.getSignature().getName().toLowerCase();
            if(methodName.indexOf("add")!=-1||methodName.indexOf("insert")!=-1) {
                throw new MyException(ErrorEnums.ADD_ERROR);
            }else if(methodName.indexOf("remove")!=-1||methodName.indexOf("delete")!=-1) {
                throw new MyException(ErrorEnums.REMOVE_ERROR);
            }else if(methodName.indexOf("edit")!=-1||methodName.indexOf("update")!=-1) {
                throw new MyException(ErrorEnums.EDIT_ERROR);
            }else if(methodName.indexOf("find")!=-1||methodName.indexOf("query")!=-1) {
                throw new MyException(ErrorEnums.FIND_ERROR);
            }else {
                throw new MyException(ErrorEnums.UNKNOWN_ERROR);
            }
        }
        return ret;
    }
     
    //service中的方法返回时，如果返回内容不合理，在此做统一化处理
    @AfterReturning(pointcut = "error()",returning = "ret")
    public void returnCheck(JoinPoint point,Object ret) {
        String methodName =  point.getSignature().getName().toLowerCase();
        if(ret!=null) {
            if(ret instanceof Integer) {
                int retValue = ((Integer)ret).intValue();
                if(retValue<=0) {
                    if(methodName.indexOf("add")!=-1||methodName.indexOf("insert")!=-1) {
                        throw new MyException(ErrorEnums.ADD_ERROR);
                    }else if(methodName.indexOf("remove")!=-1||methodName.indexOf("delete")!=-1) {
                        throw new MyException(ErrorEnums.REMOVE_ERROR);
                    }else if(methodName.indexOf("edit")!=-1||methodName.indexOf("update")!=-1) {
                        throw new MyException(ErrorEnums.EDIT_ERROR);
                    }
                }
            }
        }
         
    }
}
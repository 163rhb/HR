package org.rhb.vhr.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.slf4j.LoggerFactory.getLogger;

@Aspect
@Configuration
public class LoggerAop {


    private static final Logger logger = getLogger(LoggerAop.class);
    //如果是包下所有类的方法则org.rhb.vhr.controller.sys.basic.*.*
    @Pointcut("execution(public * org.rhb.vhr.controller.sys.basic.EmpBasicController.*(..))")
    public void WebLog(){

    }
    @Before("WebLog()")
    public void dobefore(JoinPoint joinPoint)
    {
        System.out.println(joinPoint.getSignature().getName());
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("URL : "+request.getRequestURI());
        logger.info("PORT : ",request.getRemoteAddr());
    }
    //returning 获取返回值
    @AfterReturning(returning = "ret" ,pointcut = "WebLog()")
    public  void doReturn(Object ret){
        logger.info("RESPONSE : "+ret);

    }

}

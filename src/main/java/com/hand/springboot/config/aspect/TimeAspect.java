package com.hand.springboot.config.aspect;

import com.hand.springboot.config.filter.TimeFilter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author liangwusun 2021/03/29 14:29
 */
@Aspect
@Component
public class TimeAspect {

    protected Logger logger= LoggerFactory.getLogger(TimeAspect.class);

    @Around("execution(* com.hand.springboot.api.controller.UserController.*(..))")
    public  Object handlerControllerMethod(ProceedingJoinPoint pjd) throws Throwable{
        logger.info("Time Aspect Start......");
        Object[] args = pjd.getArgs();
        for (Object arg : args) {
            logger.info("arg is " + arg);
        }
        long start = System.currentTimeMillis();
        Object proceed = pjd.proceed();
        long end = System.currentTimeMillis();
        logger.info("Aspect Used Time: " + (start - end));
        logger.info("Time Aspect End......");
        return proceed;
    }
}

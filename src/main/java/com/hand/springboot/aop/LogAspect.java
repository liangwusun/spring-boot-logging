package com.hand.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * description
 *
 * @author liangwusun 2021/03/25 9:13
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.hand.springboot.aop.MathCalculator.*(..))")
    public void pointCut(){
        System.out.println("这会在什么时候执行呢");
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("1:"+joinPoint.getSignature().getName()+"除法运行。。。。。参数列表是："+"{"+ Arrays.toString(args)+"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("2:"+joinPoint.getSignature().getName()+"除法结束。。。。。");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("3:"+joinPoint.getSignature().getName()+"除法正常返回。。。。。计算结果是："+"{"+ result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public  void logException(JoinPoint joinPoint,Exception exception){
        System.out.println("4:"+joinPoint.getSignature().getName()+"除法计算异常。。。。。计异常信息："+"{"+ exception+"}");
    }
}

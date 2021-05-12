package com.hand.springboot.config;

import com.hand.springboot.aop.LogAspect;
import com.hand.springboot.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * description
 *
 * @author liangwusun 2021/03/25 9:32
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAop {

    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}

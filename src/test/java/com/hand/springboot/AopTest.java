package com.hand.springboot;

import com.hand.springboot.aop.MathCalculator;
import com.hand.springboot.config.MainConfigOfAop;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description
 *
 * @author liangwusun 2021/03/25 9:35
 */
public class AopTest {

    @Test
    public void testAop(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(3,2);
        System.out.println("mathCalculator========="+mathCalculator);
    }
}

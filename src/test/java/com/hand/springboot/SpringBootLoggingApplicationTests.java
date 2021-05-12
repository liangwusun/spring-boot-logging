package com.hand.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootLoggingApplicationTests {

    //创建logger对象
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        //分级输出log
        logger.trace("--trace--");
        logger.debug("--debug--");
        logger.info("--info--");
        logger.warn("--warn--");
        logger.error("--error--");

    }

}

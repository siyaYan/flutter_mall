package com.example.demo;

import org.junit.Test;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class LoggerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test() {
        logger.trace("trace 级别的日志");
        logger.debug("debug 级别的日志");
        logger.info("info 级别的日志");
        logger.warn("warn 级别的日志");
        logger.error("error 级别的日志");
    }
}
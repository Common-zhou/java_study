package com.geetest.guava.utilities;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/25
 * @Time 22:19
 */
public class TestStopWatch {
    Logger logger = LoggerFactory.getLogger(TestStopWatch.class);

    @Test
    public void testStopWatch() throws InterruptedException {
//        process(1545551);
        processByStopWatch(1564561321456L);
    }

    private void process(long orderNo) throws InterruptedException {
        logger.info("start process order :[{}]", orderNo);
        long startNano = System.nanoTime();
        TimeUnit.SECONDS.sleep(1);
        logger.info("process order [{}] success, consume time:{} ns.", orderNo, (System.nanoTime() - startNano));
    }

    private void processByStopWatch(long orderNo) throws InterruptedException {
        logger.info("start process order : [{}]", orderNo);
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.MILLISECONDS.sleep(100);
        logger.info("process order [{}] success, consume time:{} .", orderNo, stopwatch.stop());

    }
}

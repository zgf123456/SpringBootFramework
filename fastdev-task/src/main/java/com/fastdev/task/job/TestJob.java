package com.fastdev.task.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by zgf on 17/6/22.
 */
@Service
public class TestJob implements Runnable {
    private Logger logger = LoggerFactory.getLogger(TestJob.class);

    @Override
    public void run() {
        logger.info("TestJob 执行开始");
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        logger.info("TestJob 执行结束, 耗时{}ms", (endTime - startTime));
    }
}

package com.fastdev.task.job;

import com.fastdev.task.job.services.TestJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zgf on 17/6/22.
 */
@Service
public class TestJob implements Runnable {
    private Logger logger = LoggerFactory.getLogger(TestJob.class);

    @Autowired
    private TestJobService testJobService;

    @Override
    public void run() {
        logger.info("TestJob 执行开始");
        long startTime = System.currentTimeMillis();

        testJobService.test();

        long endTime = System.currentTimeMillis();
        logger.info("TestJob 执行结束, 耗时{}ms", (endTime - startTime));
    }
}

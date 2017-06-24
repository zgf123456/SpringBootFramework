package com.fastdev.task.frame;

import com.fastdev.task.util.SpringUtil;
import com.fastdev.task.frame.model.QuartzJobConfig;
import com.fastdev.task.frame.services.QuartzJobConfigService;
import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zgf on 17/4/10.
 */
@SpringBootApplication
@ComponentScan("com.fastdev.task")
public class TaskStartApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(TaskStartApplication.class);
    private boolean isRun = true;
    private List<QuartzJobConfig> quartzJobConfigs = null;
    private ExecutorService executorService = null;

    @Autowired
    private QuartzJobConfigService quartzJobConfigService;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("task framework start");
        init();
        while (isRun) {
            try {
                if (quartzJobConfigs != null) {
                    Date currentDate = Calendar.getInstance().getTime();
                    for (QuartzJobConfig quartzJob : quartzJobConfigs) {
                        try {
                            logger.debug(quartzJob.toString());
                            boolean validExpression = CronExpression.isValidExpression(quartzJob.getCron());
                            if (!validExpression) {
                                logger.error("错误的定时器表达式,{}", quartzJob);
                                continue;
                            }

                            CronExpression cronExpression = new CronExpression(quartzJob.getCron());

                            // 判断是否符合执行条件
                            boolean satisfiedBy = cronExpression.isSatisfiedBy(currentDate);
                            if (!satisfiedBy) {
                                logger.debug("未达到执行条件,{}", quartzJob);
                                continue;
                            }

                            String className = quartzJob.getClassName();
                            Object bean = SpringUtil.getApplicationContext().getBean(className);
                            if (bean == null) {
                                logger.error("未找到任务执行对象{},{}", className, quartzJob);
                                continue;
                            }

                            if (!(bean instanceof Runnable)) {
                                logger.error("任务执行对象{}不是可执行对象,{}", className, quartzJob);
                                continue;
                            }
                            executorService.execute((Runnable) bean);
                        } catch (Exception e) {
                            logger.error(e.getMessage(), e);
                        }
                    }
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
                logger.info("中断退出定时任务");
                isRun = false;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        logger.info("task framework stop");
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskStartApplication.class, args);
    }


    private void init() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                quartzJobConfigs = quartzJobConfigService.queryEnableJob();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 5000);

        executorService = Executors.newFixedThreadPool(100);
    }
}

package com.fastdev.task.frame;

import com.fastdev.task.frame.model.QuartzJobConfig;
import com.fastdev.task.frame.services.QuartzJobConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
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
                    for (QuartzJobConfig quartzJob : quartzJobConfigs) {
                        System.out.println("" + quartzJob);
//                        executorService.execute();
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

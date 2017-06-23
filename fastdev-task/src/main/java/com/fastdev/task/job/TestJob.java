package com.fastdev.task.job;

import org.springframework.stereotype.Service;

/**
 * Created by zgf on 17/6/22.
 */
@Service
public class TestJob implements Runnable {
    @Override
    public void run() {
        System.out.println("test job");
    }
}

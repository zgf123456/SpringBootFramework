package com.fastdev.task.test;

import com.fastdev.task.frame.TaskStartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zgf on 17/6/24.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = TaskStartApplication.class)
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TaskTest {

    @Test
    public void test1() {
//        Object bean = SpringUtil.getApplicationContext().getBean("com.fastdev.task.frame.Job.TestJob");
//        System.out.println(bean);
    }

}

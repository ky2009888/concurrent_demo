package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ky2009666
 * @description 演示定时线程池的使用方法
 * @date 2021/5/19
 **/
@Slf4j(topic = "ScheduledExecutorService")
public class ShowTimeTaskThread {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.schedule(()->{
            log.info("task1 running");
        },10, TimeUnit.SECONDS);
        service.schedule(()->{
            log.info("task2 running");
        },5,TimeUnit.SECONDS);
        //循环执行任务
        service.scheduleAtFixedRate(()->{
            log.info("task3每隔3秒钟执行一次任务");
        },1,3, TimeUnit.SECONDS);
    }
}

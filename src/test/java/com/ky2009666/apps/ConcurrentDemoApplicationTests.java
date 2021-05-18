package com.ky2009666.apps;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j(topic = "并发编程:ConcurrentDemoApplicationTests")
class ConcurrentDemoApplicationTests {
    /**
     * 定义常量文件名称.
     */
    public static final String POM_XML = "F:\\workspace-source\\concurrent_demo\\pom.xml";

    @Test
    void contextLoads() {
        log.info("开始了------------------------");
        List<String> strings = FileUtil.readLines(POM_XML, StandardCharsets.UTF_8);
        Assert.notNull(strings);
        log.info("{}",strings);
    }
    @Test
    void asynReadFile(){
        log.info("异步执行开始-------");
        new Thread(
                ()->{
                    List<String> strings = FileUtil.readLines(POM_XML,StandardCharsets.UTF_8);
                    log.info("{}",strings);
                }).start();
        log.info("异步执行结束-------");
    }
    /**
     * 创建线程的方法1.
     */
    @Test
    void testCreatThread(){
        Thread thread = new Thread(()->{
            log.info("打印多线程创建的方法1");
        });
        thread.setName("thread1");
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                log.info("打印多线程创建的方法2");
            }
        };
        thread2.setName("thread2");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("打印多线程创建的方法3");
            }
        };
        Thread thread3 = new Thread(runnable, "thread3");
        Runnable runnable2 = ()-> log.info("打印多线程创建的方法4");
        Thread thread4 = new Thread(runnable2,"thread4");
        Thread thread5 = new Thread(()->log.info("打印多线程创建的方法5"), "thread5");
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

    /**
     * 演示使用FutureTask的方法
     */
    @Test
    void testFutureTask() throws ExecutionException, InterruptedException {
        //通过futrureTask的方式来执行
        FutureTask futrueTask = new FutureTask<Integer>(()->{
            log.info("正在执行任务6");
            return 0;
        });
        Thread thread = new Thread(futrueTask,"thread->futureTask");
        thread.start();
        Object resultObj = futrueTask.get();
        log.info("执行结果:{}",resultObj.toString());
    }

    /**
     * 演示在windows环境通过tasklist查看进程，通过taskkill杀死进程.
     */
    @Test
    void testThreadLoop(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("running");
            }
            }, "thread1").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("running");
            }
            },"thread2").start();
    }
    @Test
    void testMain0(){
        log.info("testMain0");
        main1();
    }
    void main1(){
        log.info("testMain1");
        main2();
    }
    void main2(){
        log.info("testMain2");
        main3();
    }
    void main3(){
        log.info("testMain3");
        main4();
    }
    void main4(){
        log.info("testMain4");
    }
    static volatile int num = 9;
    @Test
    void testYieldMethod() throws InterruptedException {
        detailsJoinMethod();
        log.info("{}",num);
    }
    void detailsMethod(){
        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = 10;
        },"detailsMethod");
        thread.start();
    }
    void detailsJoinMethod() throws InterruptedException {
        Thread thread = new Thread(()->{
            num = 10;
        },"detailsMethod");
        thread.start();
        thread.join(1000);
    }
}

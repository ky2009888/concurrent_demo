package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ky2009666
 * @description 演示线程锁Synchronized的使用方法
 * @date 2021/5/18
 **/
@Slf4j(topic = "synchronized")
public class ShowSynchronizedUsgV1 {
    /**
     * 定义数字1.
     */
    private static int num = 0;
    /**
     * 定义锁对象.
     */
    private static Object lockObject0 = new Object();
    /**
     * 定义锁对象.
     */
    private static Object lockObject1 = new Object();

    /**
     * main方法.
     * @param args 命令行参数.
     * @throws InterruptedException 打断异常.
     */
    public static void main(String[] args) throws InterruptedException {
        //线程1
        Thread thread1 = new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    //锁定最核心代码
                    synchronized (lockObject0) {
                        num++;
                    }
            }
        },"thread1");
        //线程2
        Thread thread2 = new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    synchronized (lockObject1) {
                        num--;
                    }
            }
        }, "thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        //join
        thread2.join();
        log.info("最终执行结果:{}",num);
    }
}

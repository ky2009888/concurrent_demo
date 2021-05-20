package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ky2009666
 * @description 读写数据
 * @date 2021/5/20
 **/
@Slf4j(topic = "时间戳锁读写数据")
public class ThreadPoolsReadWriteDataUsg {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(()->{
            StampedLockShowUsg showUsg = new StampedLockShowUsg();
            int num = showUsg.readData();
            log.info("读取到的数据:{}",num);
        });
        executorService.execute(()->{
            StampedLockShowUsg showUsg = new StampedLockShowUsg();
            int num = showUsg.writeData(9);
            log.info("读取到的数据:{}",num);
        });
        executorService.execute(()->{
            StampedLockShowUsg showUsg = new StampedLockShowUsg();
            int num = showUsg.readData();
            log.info("读取到的数据:{}",num);
        });
    }
}

package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author ky2009666
 * @description StampedLock用法展示
 * @date 2021/5/20
 **/
@Slf4j(topic = "盖戳锁的使用")
public class StampedLockShowUsg {
    /**
     * 定义锁.
     */
    private StampedLock lock = new StampedLock();
    /**
     * 定义数据.
     */
    private int data;

    public static void main(String[] args) {
        log.info("{}", 1);
    }

    public int readData() {
        long stamed = lock.tryOptimisticRead();
        if (lock.validate(stamed)) {
            return data;
        }
        try {
            stamed = lock.readLock();
            TimeUnit.SECONDS.sleep(2);
            return data;
        } catch (Exception e) {
            lock.unlockRead(stamed);
        }
        return data;
    }

    public int writeData(int data) {
        long stamed = lock.writeLock();
        try {
            TimeUnit.SECONDS.sleep(1);
            this.data = data;
        } catch (Exception e) {
            lock.unlockWrite(stamed);
        }
        return data;
    }
}

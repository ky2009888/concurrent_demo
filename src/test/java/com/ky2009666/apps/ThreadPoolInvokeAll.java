package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ky2009666
 * @description 通过线程池调用多个方法
 * @date 2021/5/19
 **/
@Slf4j(topic = "ThreadPoolInvokeAll")
public class ThreadPoolInvokeAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Object>> futures = executorService.invokeAll(Arrays.asList(
                () -> "hello", () -> "world"
        ));
        futures.forEach(f->{
            try {
               log.info("{}",f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}

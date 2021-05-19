package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ky2009666
 * @description invoke any
 * @date 2021/5/19
 **/
@Slf4j(topic = "ThreadPoolInvokeAny")
public class ThreadPoolInvokeAny {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //只要其中一个多线程执行之后就返回结果
        Object result = executorService.invokeAny(Arrays.asList(() -> "start", () -> "end"));
        log.info("{}",result);
        //关闭线程池
        executorService.shutdown();
        executorService.shutdownNow();
    }
}

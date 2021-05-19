package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 提交线程池使用方式.
 * @author ky2009666
 * @date 2021/5/19
 **/
@Slf4j(topic = "ThreadPoolSubmitShow")
public class ThreadPoolSubmitShow {
    public static void main2(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new Callable<String>() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public String call() throws Exception {
                return "call()";
            }
        });
        log.info("{}",future.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(
                ()-> { return "call()"; }
        );
        log.info("{}",future.get());
    }
}

package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ky2009666
 * @description 查看线程的状态
 * @date 2021/5/18
 **/
@Slf4j(topic = "thread-state")
public class ShowThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            log.info("running");
        }, "thread");
        Thread.State state = thread.getState();
        log.info("{}",state);
        thread.start();
        log.info("{}",thread.getState());
        //定义阻塞队列
       /* BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                5,1000, TimeUnit.SECONDS,workQueue);
        threadPoolExecutor.execute(()->{
            log.info("线程池开始工作了------------------>");
        });*/
        Executors.newSingleThreadExecutor().execute(()->{
            log.info("单个线程池");
        });
    }
    /**
     * Thread state for a thread which has not yet started.
     */
   /* NEW,*/

    /**
     * Thread state for a runnable thread.  A thread in the runnable
     * state is executing in the Java virtual machine but it may
     * be waiting for other resources from the operating system
     * such as processor.
     */
   /* RUNNABLE,*/

    /**
     * Thread state for a thread blocked waiting for a monitor lock.
     * A thread in the blocked state is waiting for a monitor lock
     * to enter a synchronized block/method or
     * reenter a synchronized block/method after calling
     * {@link Object#wait() Object.wait}.
     */
  /*  BLOCKED,*/

    /**
     * Thread state for a waiting thread.
     * A thread is in the waiting state due to calling one of the
     * following methods:
     * <ul>
     *   <li>{@link Object#wait() Object.wait} with no timeout</li>
     *   <li>{@link #join() Thread.join} with no timeout</li>
     *   <li>{@link LockSupport#park() LockSupport.park}</li>
     * </ul>
     *
     * <p>A thread in the waiting state is waiting for another thread to
     * perform a particular action.
     *
     * For example, a thread that has called <tt>Object.wait()</tt>
     * on an object is waiting for another thread to call
     * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
     * that object. A thread that has called <tt>Thread.join()</tt>
     * is waiting for a specified thread to terminate.
     */
   /* WAITING,*/

    /**
     * Thread state for a waiting thread with a specified waiting time.
     * A thread is in the timed waiting state due to calling one of
     * the following methods with a specified positive waiting time:
     * <ul>
     *   <li>{@link #sleep Thread.sleep}</li>
     *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
     *   <li>{@link #join(long) Thread.join} with timeout</li>
     *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
     *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
     * </ul>
     */
   /* TIMED_WAITING,*/

    /**
     * Thread state for a terminated thread.
     * The thread has completed execution.
     */
   /* TERMINATED;*/
}

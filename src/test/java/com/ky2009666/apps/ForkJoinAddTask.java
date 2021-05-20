package com.ky2009666.apps;

import java.util.concurrent.RecursiveTask;

/**
 * @author ky2009666
 * @description 通过fork join的方式分解任务
 * @date 2021/5/20
 **/
public class ForkJoinAddTask extends RecursiveTask<Integer> {
    /**
     * 定义结算的数字.
     */
    private int num;

    public ForkJoinAddTask(int nums){
        this.num = nums;
    }
    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        ForkJoinAddTask joinAddTask = new ForkJoinAddTask(num);
        joinAddTask.fork();
        return num+joinAddTask.join();
    }
}

package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskDemo extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000;// 阈值
    private Long start;
    private Long end;

    public ForkJoinTaskDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;
// 如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
// 如果任务大于阈值，就分裂成两个子任务计算
            Long middle = (start + end) / 2;
            ForkJoinTaskDemo leftTask = new ForkJoinTaskDemo(start, middle);
            ForkJoinTaskDemo rightTask = new ForkJoinTaskDemo(middle + 1, end);
// 执行子任务
            leftTask.fork();
            rightTask.fork();
// 等待子任务执行完，并得到其结果
            Long leftResult = leftTask.join();
            Long rightResult = rightTask.join();
// 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
// 生成一个计算任务，负责计算1+2+3+4
        ForkJoinTaskDemo task = new ForkJoinTaskDemo(1L, 1000000000L);
// 执行一个任务
        long timestamp1start = System.currentTimeMillis();

        Future<Long> result = forkJoinPool.submit(task);
        long timestamp1end = System.currentTimeMillis();

        new Thread(new Runnable() {
            public void run() {
                long timestamp2start = System.currentTimeMillis();
                long sum = 0;
                for (int i = 1; i <= 1000000000l; i++) {
                    sum += i;
                }
                long timestamp2end = System.currentTimeMillis();
                System.out.println(sum);
                System.out.println("single");
                System.out.println(timestamp2end - timestamp2start);
                System.out.println("end");
            }
        }).start();

        try {
            System.out.println(result.get());
            System.out.println(timestamp1end - timestamp1start);

        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
    }
}
package com.Executors_;

import java.util.concurrent.*;

public class Future_Demo {
    static Future<Long> future;
    static FutureTask futureTask;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
//        ExecutorService executor = Executors.newCachedThreadPool();
//          ExecutorService executor = Executors.newSingleThreadExecutor();

//        ExecutorService executor = Executors.newScheduledThreadPool(2);
//        ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Callable<Long> task = new Callable<Long>() {

            public Long call() throws Exception {
//                future.cancel(true);
//                Thread.sleep(3000);
                return 1L;
            }
        };
        future = executor.submit(task);
//        executor.submit(futureTask);
//        futureTask.run();
//        futureTask = executor.submit(task);
//        Thread.sleep(1000);
        System.out.println(future.isDone());
        System.out.println(future.get(1000, TimeUnit.MICROSECONDS));

    }

}

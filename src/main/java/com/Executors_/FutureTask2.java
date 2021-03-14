package com.Executors_;

import java.util.concurrent.*;

public class FutureTask2 {
    static Future<Long> future;
    static FutureTask<Long> futureTask;

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

        futureTask = new FutureTask<Long>(task);
        executor.submit(futureTask);
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get(2, TimeUnit.SECONDS));

    }

}

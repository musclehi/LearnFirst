package com.Executors_;

import java.util.concurrent.*;

public class Future_Demo2 {
    static Future<Long> future;
    static FutureTask futureTask;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Long> task = new Callable<Long>() {

            public Long call() throws Exception {
                for (int i = 1; i < 200; i++) {
                    Thread.sleep(500);
                    System.out.println(i);
                }
                return 1L;
            }
        };
        Callable<Long> task2 = new Callable<Long>() {

            public Long call() throws Exception {
                for (int j = 1; j < 200; j++) {
                    Thread.sleep(500);
                    System.out.println(j);
                }
                return 1L;
            }
        };
        future = executor.submit(task);
        future = executor.submit(task2);

        System.out.println(future.isDone());
        System.out.println(future.get(1000, TimeUnit.MICROSECONDS));

    }

}

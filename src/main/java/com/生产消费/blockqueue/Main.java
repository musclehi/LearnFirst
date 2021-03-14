package com.生产消费.blockqueue;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    static Future<Long> future;

    public static void main(String[] args) throws Exception {
        try {
            final ExecutorService executorService = Executors.newFixedThreadPool(2);

            Callable<Long> task = new Callable<Long>() {
                //            @Override
                public Long call() throws Exception {

                    BlockingQueue<List<Long>> queue = new ArrayBlockingQueue<List<Long>>(2);
                    // 开启 producer线程向队列中生产消息

                    IdProvider task1 = new IdProvider(queue);
                    executorService.submit(task1);
                    List<Long> ids;
//                    while ((ids = queue.take()).get(0) != -1L) {
                    while (true){
                        //根据ids进行操作
                        ids = queue.take();
                        System.out.println((ids));

                    }
//                    return 1L;
                }
            };

            executorService.submit(task);

            Thread.sleep(3000);
            System.out.println("ssss2");
//            System.out.println(task.);
//            executorService.shutdown();
            //future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

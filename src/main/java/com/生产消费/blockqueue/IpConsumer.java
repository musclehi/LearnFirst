package com.生产消费.blockqueue;


import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class IpConsumer implements Callable<Long> {

    BlockingQueue<List<Long>> queue;

    public IpConsumer(BlockingQueue<List<Long>> queue) {
        this.queue = queue;
    }

    //    @Override
    public Long call() throws Exception {


        try {
            List<Long> ids;
            while ((ids = queue.take()).get(0) != (-1)) {
//            while (true) {
//                ids = queue.take();
                System.out.println((ids));
//                if((ids.get(0) == (-1))){
//                    break;
//                }
//                System.out.println((ids.get(0) != (-1)));
            }
//            while (!ids.isEmpty()){
//                System.out.println(ids);
//                ids=queue.take();
//            }
            System.out.println("end");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1L;
    }

}

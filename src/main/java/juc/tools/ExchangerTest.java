package juc.tools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();
        executor.execute(() -> {
            String data1 = "Ling";
            try {
                String result = (String) exchanger.exchange(data1);
                System.out.println(data1 + " "+ result);
            }catch (Exception e){

            }

        });

        executor.execute(()-> {
            String data1 = "huhx";
            try {
                String result = (String) exchanger.exchange(data1);
                System.out.println(data1 + " "+ result);
            }catch (Exception e){

            }

        });
        executor.shutdown();
    }

}
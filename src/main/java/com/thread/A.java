package com.thread;

import java.util.ArrayList;
import java.util.List;

public class A extends Thread {
    @Override

    public void run() {
        try {
            List<B> bs = new ArrayList<>();
            System.out.println("a running");
            for(int i=0;i<3;i++){
                B b = new B();
                bs.add(b);
                b.start();

            }
            for (B b:
                 bs) {
                b.join();
            }
            System.out.println("a end");

        } catch (Exception e) {

        }
    }
}
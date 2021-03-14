package com.thread;

public class B extends Thread {
    @Override

    public void run() {
        try {
            System.out.println("b running");
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }
}
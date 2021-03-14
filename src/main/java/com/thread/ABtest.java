package com.thread;


public class ABtest {

    public static volatile int count = 0;


    public static void main(String[] args) throws Exception {

        new A().start();


    }
}




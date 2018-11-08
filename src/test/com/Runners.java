package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runners {
    public static void main(String args[]){
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i=0;i<20;i++){
            exec.execute(new RegisterTask());
        }
        exec.shutdown();
    }
}

package com.Executors_.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("ABtest");
            }
        }, 5000, 4000);//2000表示第一次执行任务延迟时间，40表示以后每隔多长时间执行一次run里面的任务

    }
}

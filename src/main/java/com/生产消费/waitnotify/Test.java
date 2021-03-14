package com.生产消费.waitnotify;

public class Test {
    static int finalI;

    public static void main(String[] args) {
        final Storage storage = new Storage();

        for (int i = 1; i < 6; i++) {
            finalI = i;
            new Thread(new Runnable() {
//                @Override
                public void run() {
                    storage.produce(String.format("生成者%d:", finalI));
                }
            }).start();
        }

        for (int i = 1; i < 4; i++) {
            finalI = i;
            new Thread(new Runnable() {
//                @Override
                public void run() {
                    storage.consume(String.format("生成者%d:", finalI));
                }
            }).start();
        }
    }
}
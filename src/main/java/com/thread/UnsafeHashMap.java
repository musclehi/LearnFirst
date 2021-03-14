package com.thread;

import java.util.HashMap;
import java.util.UUID;

public class UnsafeHashMap {

    public static void main(String args[]) throws Exception {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {

                        public void run() {
                            map.put(UUID.randomUUID().toString(), "1");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

}

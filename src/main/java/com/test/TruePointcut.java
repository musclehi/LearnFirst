package com.test;

import java.io.Serializable;

class TruePointcut implements Pointcut, Serializable {
    public static final TruePointcut INSTANCE = new TruePointcut();

    private TruePointcut() {
    }


    public int getClassFilter() {
        return 1314;
    }

    @Override
    public String toString() {
        return "Pointcut.TRUE";
    }
}

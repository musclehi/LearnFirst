package com.test;

public interface Pointcut {
    Pointcut TRUE = TruePointcut.INSTANCE;
    int getClassFilter();

}


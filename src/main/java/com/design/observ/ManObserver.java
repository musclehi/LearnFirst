package com.design.observ;

import java.util.Observable;
import java.util.Observer;

public class ManObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
package com.design.observ;

import java.util.Observable;

public class NewspaperObservable extends Observable {

    public void notifyAllMan(String info)
    {
        setChanged();
        notifyObservers(info);
    }
}
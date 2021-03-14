package com.design.observ;

public class Test {
    public static void main(String[] arge)
    {
        NewspaperObservable newspaperObservable = new NewspaperObservable();
        newspaperObservable.addObserver(new ManObserver());
        newspaperObservable.addObserver(new ManObserver());
        newspaperObservable.notifyAllMan("have a new paper");
    }
}
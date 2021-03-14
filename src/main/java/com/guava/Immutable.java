package com.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.Iterator;

public class Immutable {

//    不可变集合
    public static final ImmutableSet<String> colorsSet = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple","red");


    public static void main(String args[]) {

//        不可变集合
        System.out.println(colorsSet.size());
        System.out.println(colorsSet.contains("red"));

        ImmutableList<String> colorsList = ImmutableList.copyOf(colorsSet);

//        asList视图,asList()返回的 ImmutableList 通常是——并不总是——开销稳定的视图实现
        ImmutableList<String> colorsAsList = colorsSet.asList();

        Iterator<String> iterator = colorsList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


}

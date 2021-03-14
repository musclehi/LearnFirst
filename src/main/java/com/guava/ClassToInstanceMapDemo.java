package com.guava;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;


public class ClassToInstanceMapDemo {

//    键是类型，而值是符合键所指类型的对象。
    public static void main(String args[]) {
        ClassToInstanceMap<Number> numbers = MutableClassToInstanceMap.create();
        numbers.putInstance(Integer.class, Integer.valueOf(0));
        numbers.putInstance(Integer.class, Integer.valueOf(1));
        numbers.putInstance(Long.class, Long.valueOf(2));
        System.out.println(numbers.getInstance(Integer.class));
        System.out.println(numbers.getInstance(Long.class));


    }
}


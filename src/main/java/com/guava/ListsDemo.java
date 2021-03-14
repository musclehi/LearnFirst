package com.guava;


import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.List;

public class ListsDemo {


//    guava的Lists的静态方法
    public static void main(String args[]) {

        List countUp = Ints.asList(1, 2, 3, 4, 5);
        List countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
        List<List> parts = Lists.partition(countUp, 3);//{{1,2}, {3,4}, {5}}
        System.out.println(countDown);
        System.out.println(parts);

//        List<Integer> lists = Lists.newArrayListWithExpectedSize(2);
        List<Integer> lists = Lists.newArrayListWithCapacity(2);
        lists.add(1);
        lists.add(2);
        lists.add(3);
        System.out.println(lists);

    }


}

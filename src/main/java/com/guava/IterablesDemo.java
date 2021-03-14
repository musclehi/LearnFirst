package com.guava;

import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;

import java.util.Iterator;

public class IterablesDemo {


//    guava的Iterables的静态方法   Iterables类似于Collections，Iterable类似于Collection
//    concat(Iterable<Iterable>)，frequency(Iterable, Object),partition,limit,getFirst
//    getOnlyElement,

    public static void main(String args[]) {
        Iterable<Integer> iterable = Iterables.concat(
                Ints.asList(2, 2, 3),
                Ints.asList(4, 5, 6),
                Ints.asList(4, 5, 6)); // concatenated包括元素 1, 2, 3, 4, 5, 6

        System.out.println(iterable);
        System.out.println(Iterables.frequency(iterable,5));
        System.out.println(Iterables.limit(iterable,5));
        System.out.println(Iterables.getFirst(iterable,1));
        System.out.println(Iterables.partition(iterable,2));
        System.out.println(Iterables.getLast(iterable));
        System.out.println(iterable);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


//如果set不是单元素集，就会出错了！

    }


}

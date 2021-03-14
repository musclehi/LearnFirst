package com.guava;

import com.google.common.collect.Sets;

import java.util.Set;

public class SetsDemo {


//    guava的Sets的静态方法
    public static void main(String args[]) {

        Set<Integer> sets = Sets.newHashSet( 3, 4, 5, 6);
        Set<Integer> sets2 = Sets.newHashSet(3, 4, 6,5);
        // 交集
        System.out.println("交集为：");
        Sets.SetView<Integer> intersection = Sets.intersection(sets, sets2);
        for (Integer temp : intersection) {
            System.out.println(temp);
        }
        // 差集,sets有二sets2没有
        System.out.println("差集为：");
        Sets.SetView<Integer> diff = Sets.difference(sets, sets2);
        for (Integer temp : diff) {
            System.out.println(temp);
        }
        // 并集
        System.out.println("并集为：");
        Sets.SetView<Integer> union = Sets.union(sets, sets2);
        for (Integer temp : union) {
            System.out.println(temp);
        }

        System.out.println(Sets.difference(sets,sets2).equals(Sets.difference(sets2,sets)));
        System.out.println(sets.equals(sets2));

        //所有子集
        Set<Set<Integer>> animalSets = Sets.powerSet(sets);
        System.out.println(animalSets);
    }


}

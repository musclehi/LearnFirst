package com.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Map;

public class MapsDemo {


//    guava的Maps的静态方法
    public static void main(String args[]) {

        Map<String, Integer> left = ImmutableMap.of("a", 2, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 2, "d", 3);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        System.out.println(diff);
//        两个 Map 中都有的映射项，包括匹配的键与值
        System.out.println(diff.entriesInCommon());
//        键相同但是值不同值映射项
        System.out.println(diff.entriesDiffering());
//        键只存在于左边 Map 的映射项
        System.out.println(diff.entriesOnlyOnLeft());
//        键只存在于左边 Map 的映射项
        System.out.println(diff.entriesOnlyOnRight());


    }


}

package com.guava;


import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.Map;

public class MultimapsDemo {


//    guava的Multisets的静态方法
    public static void main(String args[]) {

//        1 start  Multimaps.index(Iterable, Function)
        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };
//        Multimaps.index(Iterable, Function)
//        通常针对的场景是：有一组对象，它们有共同的特定
//        属性，我们希望按照这个属性的值查询对象，但属性值不一定是独一无二的。
//        比方说，我们想把字符串按长度分组。
        ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
        System.out.println(digitsByLength.get(3));
        /*
         * digitsByLength maps:
         * 3 => {"one", "two", "six"}
         * 4 => {"zero", "four", "five", "nine"}
         * 5 => {"three", "seven", "eight"}
         */

        //        1 end

//        2 start
//        ImmutableMultimap.inverse()
//         反转
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));
        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap.<Integer, String>create());
        System.out.println(inverse);
////注意我们选择的实现，因为选了TreeMultimap，得到的反转结果是有序的
/*
* inverse maps:
* 1 => {"a"}
* 2 => {"a", "b", "c"}
* 3 => {"c"}
* 4 => {"a", "b"}
* 5 => {"c"}
* 6 => {"b"}
* */

        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        SetMultimap<String, Integer> multimap2 = Multimaps.forMap(map);
// multimap：["a" => {1}, "b" => {1}, "c" => {2}]
        System.out.println(map);
        System.out.println(multimap2);
        System.out.println(multimap2.get("a"));
        Multimap<Integer, String> inverse2 = Multimaps.invertFrom(multimap2, HashMultimap.<Integer, String>create());
        System.out.println(inverse2);
// inverse：[1 => {"a","b"}, 2 => {"c"}]









    }


}

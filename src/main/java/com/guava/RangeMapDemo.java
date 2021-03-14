package com.guava;

import com.google.common.collect.*;


public class RangeMapDemo {

//    RangeMap 描述了”不相交的、非空的区间”到特定值的映射。和 RangeSet 不同，RangeMap 不会合并相
//邻的映射，即便相邻的区间映射到相同的值
    public static void main(String args[]) {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
        System.out.println(rangeMap);

        rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
        System.out.println(rangeMap);

        rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
        System.out.println(rangeMap);

        rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}
        System.out.println(rangeMap);



    }
}


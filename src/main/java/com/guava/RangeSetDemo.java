package com.guava;

import com.google.common.collect.*;


public class RangeSetDemo {

//    RangeSet描述了一组不相连的、非空的区间。当把一个区间添加到可变的RangeSet时，所有相连的区间会被
//合并，空区间会被忽略。
    public static void main(String args[]) {
        RangeSet rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        System.out.println(rangeSet);

        rangeSet.add(Range.closedOpen(11, 15));
        System.out.println(rangeSet);

        rangeSet.add(Range.open(15, 20));
        System.out.println(rangeSet);

        rangeSet.add(Range.openClosed(0, 0));
        System.out.println(rangeSet);

        rangeSet.remove(Range.open(5, 10));
        System.out.println(rangeSet);



    }
}


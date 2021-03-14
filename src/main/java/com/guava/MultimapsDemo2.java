package com.guava;


import com.base.User;
import com.google.common.collect.*;

public class MultimapsDemo2 {


//    guava的Multisets的静态方法
    public static void main(String args[]) {


//        1 start  Multimaps.index(Iterable, Function)
        User user1 = new User(1,"zhao1",1);
        User user2 = new User(2,"zhao2",1);
        User user3 = new User(3,"zhao3",1);
        User user4 = new User(1,"zhao1",2);
        User user5 = new User(2,"zhao2",2);
        User user6 = new User(3,"zhao3",2);
        ImmutableSet<User> digits = ImmutableSet.of(user1, user2, user3);
        ImmutableSet<User> digits2 = ImmutableSet.of(user4, user5, user6);
       System.out.println(digits.equals(digits2));

    }


}

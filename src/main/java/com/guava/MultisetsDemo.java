package com.guava;

import com.base.User;
import com.google.common.collect.*;

public class MultisetsDemo {


//    guava的Multisets的静态方法
    public static void main(String args[]) {

        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);
        multiset1.add("b");
        System.out.println(Multisets.copyHighestCountFirst(multiset1));
        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);
        System.out.println(multiset1);
        System.out.println(multiset1.size());

//        是否包含了所有不重复元素
        System.out.println(multiset1.containsAll(multiset2)); //返回true；因为包含了所有不重复元素，
        //虽然multiset1实际上包含2个"a"，而multiset2包含5个"a"

//        如果左边>右边，返回true
        System.out.println(Multisets.containsOccurrences(multiset2, multiset1)); // returns false

//        从左边删除右边,重复的只删除一个
        Multisets.removeOccurrences(multiset2,multiset1); // multiset2 现在包含3个"a"
        System.out.println(multiset2);

//        从左边删除右边，重复元素都删除
        System.out.println(multiset2.removeAll(multiset1));//multiset2移除所有"a"，虽然multiset1只有2个"a"
        System.out.println(multiset2.isEmpty()) ; // returns true

        User user1 = new User(1,"1",1);
        User user2 = new User(2,"2",2);
        User user3 = new User(3,"3",3);
        User user4 = new User(4,"4",4);
        User user5 = new User(2,"2",2);
        Multiset<User> multisets1 = HashMultiset.create();
        Multiset<User> multisets2 = HashMultiset.create();
        multisets1.add(user1,1);
        multisets1.add(user5,1);
        multisets1.add(user2,4);
        multisets2.add(user2,2);
//        multisets2.add(user3,3);
        System.out.println(multisets1);
        System.out.println(multisets2);
        System.out.println(Multisets.containsOccurrences(multisets1, multisets2));
        System.out.println(Multisets.removeOccurrences(multisets1, multisets2));
        System.out.println(multisets1);




    }


}

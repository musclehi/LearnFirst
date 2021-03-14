package com.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;


public class BiMapDemo {

//    双向Map
    public static void main(String args[]) {

        BiMap<String,String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一","Monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");
        //如果你想把键映射到已经存在的值，会抛出 IllegalArgumentException 异常,使用forcePut
//        weekNameMap.put("星期八","Sunday");
        weekNameMap.forcePut("星期八","Sunday");


        System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
    }
}


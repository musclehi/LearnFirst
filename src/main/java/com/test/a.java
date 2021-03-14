package com.test;


import com.base.User;
import com.base.User2;
import org.springframework.beans.BeanUtils;

public class a {


    public static void main(String[] args) throws Exception {

        StringBuilder stringBuilder = new StringBuilder(1);
        stringBuilder.append(1);
        stringBuilder.append(2);
        stringBuilder.append(3);
        stringBuilder.append(4);
        System.out.println(stringBuilder);
        Boolean b = test();
        System.out.println(System.currentTimeMillis());
    }

    public static  boolean test(){
        return true;
    }


}




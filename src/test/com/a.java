package com;

public class a {
    public static void main(String args[]){
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        String s3 = "aaa";
        String s4 = "aaa";
        System.out.println(s1.intern()==s1);
        System.out.println(s1.intern()==s3);
        s1.intern();
        s2.intern();
        System.out.println(s4==s3);

//        String str2 = new String("str")+new String("01");
//        String str1 = "str01";
//        str2.intern();
//        System.out.println(str2.intern()==str1);

    }
}

package com.json;

import com.base.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class exchange {
    public static void main(String[] args) {
//        class -> json字符串
        User user = new User(1, "2", 1);
        System.out.println(user);
        String userString = JSON.toJSONString(user);
        System.out.println(userString);

//        json字符串 -> class
        user = JSONObject.parseObject(userString, User.class);
        System.out.println(user);

//        解析json字符串中的某个键的值
        int id = JSON.parseObject(userString).getInteger("id");
        System.out.println(id);


    }
}

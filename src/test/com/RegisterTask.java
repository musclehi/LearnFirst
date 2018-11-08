package com;

import com.entity.User;
import com.service.UserService;

public class RegisterTask implements Runnable {
    public void run() {
        UserService service = new UserService();
        User user = new User();
        user.setUserName("zhao4");
        user.setPassWord("111111");
       System.out.println(service.addUser(user));
    }
}


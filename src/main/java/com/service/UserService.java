package com.service;

import com.dao.UserDao;
import com.entity.User;

public class UserService {
    public int addUser(User user) {
        synchronized (user.getUserName().intern()) {
            if (findUserByUsername(user.getUserName()) > 0) {
                return 202;
            } else {
                return new UserDao().addUser(user);//返回1
            }
        }
    }

    public int findUser(User user) {
        return new UserDao().findUser(user);
    }

    public int findUserByUsername(String username) {
        return new UserDao().findUserByUsername(username);
    }
}

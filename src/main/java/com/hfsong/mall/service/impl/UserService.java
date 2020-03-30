package com.hfsong.mall.service.impl;

import com.hfsong.mall.bean.User;

import java.util.List;

public interface UserService {
        int login(User user);

        List<User> queryAllUsers();

}

package com.hfsong.mall.dao;

import com.hfsong.mall.bean.User;

import java.util.List;

public interface UserDao {
    int login(User user);

    List<User> queryAllUser();

}

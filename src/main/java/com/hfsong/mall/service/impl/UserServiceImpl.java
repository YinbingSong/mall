package com.hfsong.mall.service.impl;

import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.UserDao;
import com.hfsong.mall.dao.impl.UserDaoImpl;
import com.hfsong.mall.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public int login(User user) {
        return 0;
    }

    @Override
    public List<User> queryAllUsers() {
        return null;
    }
}

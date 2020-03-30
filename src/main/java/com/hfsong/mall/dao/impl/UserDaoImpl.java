package com.hfsong.mall.dao.impl;

import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.UserDao;
import com.hfsong.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public int login(User user) {

        //sql
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        User query = null;
        try {
            query = runner.query("select * from user where email = ? and pwd = ?",
                    new BeanHandler<>(User.class),
                    user.getEmail(),
                    user.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if(query != null){
            return 200;
        }
        return 404;
    }

    @Override
    public List<User> queryAllUser() {
        //sql
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<User> userList = null;
        try {
            userList = runner.query("select * from user",new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}

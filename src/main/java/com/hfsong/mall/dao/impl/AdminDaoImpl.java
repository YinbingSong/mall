package com.hfsong.mall.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.hfsong.mall.bean.*;
import com.hfsong.mall.bean.Admin.Admin;
import com.hfsong.mall.bean.Admin.AdminChangePwd;
import com.hfsong.mall.dao.AdminDao;
import com.hfsong.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    //    管理员登陆
    @Override
    public int login(Admin admin) {
        //sql
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        Admin query = null;
        try {
            query = runner.query("select * from admin where email = ? and pwd = ?",
                    new BeanHandler<>(Admin.class),
                    admin.getEmail(),
                    admin.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (query != null) {
            return 200;
        }
        return 404;
    }

    //    查询全部管理员
    @Override
    public List<Admin> queryAllAdmins() {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<Admin> adminList = null;
        try {
            adminList = runner.query("select * from admin", new BeanListHandler<Admin>(Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    //    添加管理员
    @Override
    public int addAdminss(Admin admin) {

        //sql
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        try {
            update = runner.update("insert into admin values (null, ?, ?, ?)",
                    admin.getEmail(),
                    admin.getNickname(),
                    admin.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (update != 0) {
            return 200;
        }
        return 404;
    }

    //    删除管理员
    @Override
    public int deleteAdmins(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        try {
            update = runner.update("delete from admin where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (update != 0) {
            return 200;
        }
        return 404;
    }

    //    获得管理员信息
    @Override
    public Admin getAdminsInfo(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        Admin query = null;
        try {
            query = runner.query("select * from admin where id = ?",
                    new BeanHandler<>(Admin.class),
                    id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    //    修改管理员信息
    @Override
    public int updateAdminss(Admin admin) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        try {
            update = runner.update("update admin set email = ?, nickname = ?, pwd = ? where id = ?",
                    admin.getEmail(),
                    admin.getNickname(),
                    admin.getPwd(),
                    admin.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (update != 0) {
            return 200;
        }
        return 404;
    }

//    查询管理员
    @Override
    public List<Admin> getSearchAdmins(Admin admin) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        String baseSql = "select * from admin where 1 = 1 ";
        List<Object> params = new ArrayList<>();
        if (!StringUtils.isEmpty(admin.getEmail())) {
            baseSql = baseSql + " and email like ?";
            // 模糊查询email账号
            params.add("%" + admin.getEmail() + "%");
        }
        if (!StringUtils.isEmpty(admin.getNickname())) {
            baseSql = baseSql + " and nickname like ?";
            // 模糊查询nickname用户名
            params.add("%" + admin.getNickname() + "%");
        }

        List<Admin> adminList = null;
        try {
            adminList = runner.query(baseSql, new BeanListHandler<Admin>(Admin.class),
                    params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

//    修改管理员密码

    @Override
    public int changePwd(AdminChangePwd adminChangePwd) {
//        新密码为空
        if (adminChangePwd.getNewPwd() == null){
            return 300;
        }
//        两次密码输入不一致
        if (!adminChangePwd.getNewPwd().equals(adminChangePwd.getConfirmPwd())){
            return 301;
        }

        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        Admin query = null;
        try {
            query = runner.query("select * from admin where email = ? and pwd = ?",
                    new BeanHandler<>(Admin.class),
                    adminChangePwd.getToken(),
                    adminChangePwd.getOldPwd());
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (query != null) {
            return 200;
        }
        //信息填写错误
        return 404;
    }

    @Override
    public List<User> allUser() {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<User> userList = null;
        try {
            userList = runner.query("select * from user", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public int deleteUser(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        try {
            update = runner.update("delete from user where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (update != 0) {
            return 200;
        }
        return 404;
    }

    @Override
    public List<User> searchUser(int word) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<User> userList = null;
        try {
            userList = runner.query("select * from admin where nickname = ? ",
                    new BeanListHandler<User>(User.class),
                    word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


}

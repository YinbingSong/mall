package com.hfsong.mall.dao.impl;

import com.hfsong.mall.bean.Admin;
import com.hfsong.mall.dao.AdminDao;
import com.hfsong.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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
        if(query != null){
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
        if(update != 0){
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
            update =runner.update("delete from admin where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if(update != 0){
            return 200;
        }
        return 404;
    }
}

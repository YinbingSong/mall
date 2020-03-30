/**
 * User: zsquirrel
 * Date: 2020/3/28
 * Time: 2:49 下午
 */
package com.hfsong.mall.service.impl;

import com.hfsong.mall.dao.impl.AdminDaoImpl;
import com.hfsong.mall.service.AdminService;
import com.hfsong.mall.bean.Admin;
import com.hfsong.mall.dao.AdminDao;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public List<Admin> queryAllAdmins() {
        return adminDao.queryAllAdmins();
    }
}

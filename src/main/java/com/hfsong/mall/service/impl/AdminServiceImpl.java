/**
 * User: zsquirrel
 * Date: 2020/3/28
 * Time: 2:49 下午
 */
package com.hfsong.mall.service.impl;

import com.hfsong.mall.bean.AdminChangePwd;
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

    @Override
    public int addAdminss(Admin admin) {
        return adminDao.addAdminss(admin);
    }

    @Override
    public int deleteAdmins(int id) {
        return adminDao.deleteAdmins(id);
    }

    @Override
    public Admin getAdminsInfo(int id) {
        return adminDao.getAdminsInfo(id);
    }

    @Override
    public int updateAdminss(Admin admin) {
        return  adminDao.updateAdminss(admin);
    }

    @Override
    public List<Admin> getSearchAdmins(Admin admin) {
        return adminDao.getSearchAdmins(admin);
    }

    @Override
    public int changePwd(AdminChangePwd adminChangePwd) {
        return adminDao.changePwd(adminChangePwd);
    }
}

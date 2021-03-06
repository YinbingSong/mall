package com.hfsong.mall.service;

import com.hfsong.mall.bean.*;
import com.hfsong.mall.bean.Admin.Admin;
import com.hfsong.mall.bean.Admin.AdminChangePwd;

import java.util.List;

public interface AdminService {
    int login(Admin admin);

    List<Admin> queryAllAdmins();

    int addAdminss(Admin admin);

    int deleteAdmins(int id);

    Admin getAdminsInfo(int id);

    int updateAdminss(Admin admin);

    List<Admin> getSearchAdmins(Admin admin);

    int changePwd(AdminChangePwd adminChangePwd);

    List<User> allUser();

    int deleteUser(int id);

    List<User> searchUser(int word);
}

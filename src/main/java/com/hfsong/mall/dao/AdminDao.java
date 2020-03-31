package com.hfsong.mall.dao;

import com.hfsong.mall.bean.Admin;
import com.hfsong.mall.bean.User;

import java.util.List;

public interface AdminDao {

    int login(Admin admin);

    List<Admin> queryAllAdmins();

//    List<Admin> querySearchAdmins(Admin admin);

    int addAdminss(Admin admin);

    int deleteAdmins(int id);

    Admin getAdminsInfo(int id);

    int updateAdminss(Admin admin);

//    List<User> allUser();


}

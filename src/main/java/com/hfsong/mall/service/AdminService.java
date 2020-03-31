/**
 * User: zsquirrel
 * Date: 2020/3/28
 * Time: 2:49 下午
 */
package com.hfsong.mall.service;

import com.hfsong.mall.bean.Admin;

import java.util.List;

public interface AdminService {
    int login(Admin admin);

    List<Admin> queryAllAdmins();

    int addAdminss(Admin admin);

    int deleteAdmins(int id);
}

package com.hfsong.mall.dao;

import com.hfsong.mall.bean.Type.Type;

import java.util.List;

public interface TypeDao {


    List<Type> allTypes();


    int addType(int name);
}

package com.hfsong.mall.service;

import com.hfsong.mall.bean.Type.Type;

import java.util.List;

public interface TypeService {
    List<Type> queryAllType();

    int addType(int name);

}

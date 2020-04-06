package com.hfsong.mall.service.impl;

import com.hfsong.mall.bean.Type.Type;
import com.hfsong.mall.dao.TypeDao;
import com.hfsong.mall.dao.impl.TypeDaoImpl;
import com.hfsong.mall.service.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    private TypeDao typeDao = new TypeDaoImpl();
    @Override
    public List<Type> queryAllType() {
        return typeDao.allTypes();
    }


    @Override
    public int addType(int name) {
        return typeDao.addType(name);
    }
}

package com.hfsong.mall.dao.impl;

import com.hfsong.mall.bean.Type.Type;
import com.hfsong.mall.dao.TypeDao;
import com.hfsong.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    @Override
    public List<Type> allTypes() {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<Type> typeList = null;
        try {
            typeList = runner.query("select * from type", new BeanListHandler<Type>(Type.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeList;
    }


    @Override
    public int addType(int name) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        try {
            update = runner.update("insert into type values (null, ?)",
                    name);
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (update != 0) {
            return 200;
        }
        return 404;
    }
}

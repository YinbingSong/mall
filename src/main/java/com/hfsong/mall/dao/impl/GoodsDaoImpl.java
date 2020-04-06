package com.hfsong.mall.dao.impl;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Goods.GoodsDetails;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.bean.Msg.ShowMsg;
import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.GoodsDao;
import com.hfsong.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    @Override
    public List<Good> getGoodsByType(int typeId) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<Good> goodsList = null;
        try {
            goodsList = runner.query("select * from goods where type = ? ",
                    new BeanListHandler<Good>(Good.class),
                    typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public int deleteGoods(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        try {
            update = runner.update("delete from good where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (update != 0) {
            return 200;
        }
        return 404;
    }

    @Override
    public int addGoods(Good goods) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        try {
            update =runner.update("insert into goods values (null, ?, ?, ?, ?, ?, ?)",
                    goods.getName(),
                    goods.getImg(),
                    goods.getDesc(),
                    goods.getPrice(),
                    goods.getTypeId(),
                    goods.getStockNum());
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        if (update != 0) {
            return 200;
        }
        return 404;
    }

    @Override
    public int deleteSpec(Spec spec) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        try {
            runner.update("delete from spec where specName = ?",
            spec.getSpecName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public int updateGoods(Good goods) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        try {
            runner.update("update goods set name = ?, typeId = ?, img = ?, `desc` = ?, price = ?, stockNum = ? where id = ?",
                    goods.getName(),
                    goods.getTypeId(),
                    goods.getImg(),
                    goods.getDesc(),
                    goods.getPrice(),
                    goods.getStockNum(),
                    goods.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return 500;
        }
        return 200;
    }

    @Override
    public int addSpec(Spec spec) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        try {
            int update = runner.update("insert into spec values (null, ?, ?, ?, ?)",
                    spec.getSpecName(),
                    spec.getStockNum(),
                    spec.getUnitPrice(),
                    spec.getGoodsId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public Good getGoodsInfo(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        Good goods = null;
        try {
            goods = runner.query("select * from goods where id =?",
                    new BeanHandler<>(Good.class),
                    id);
            return goods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Spec> getGoodSpecListInfo(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<Spec> specList = null;
        try {
            specList = runner.query("select * from spec where goodsId = ?",
                    new BeanListHandler<>(Spec.class),
                    id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specList;
    }

    @Override
    public GoodsDetails goodsDetails(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        GoodsDetails goodsDetails = null;
        try {
            goodsDetails = runner.query("select * from goods where id =?",
                    new BeanHandler<>(GoodsDetails.class),
                    id);
            return goodsDetails;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsDetails;
    }

    @Override
    public List<ShowMsg> showMsg(int id) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<ShowMsg> msgList = null;
        try {
            msgList = runner.query("select * from msg where goodsId = ?",
                    new BeanListHandler<>(ShowMsg.class),
                    id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msgList;
    }

    @Override
    public User getUserInfo(Integer userId) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        User user = null;
        try {
            user = runner.query("select * from user where id = ?",
                    new BeanHandler<>(User.class),
                    userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Spec getSpecInfo(String price) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        Spec spec = null;
        try {
            spec = runner.query("select * from spec where unitPrice = ?",
                    new BeanHandler<>(Spec.class),
                    price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spec;
    }


    /**
     * 获取最近一次插入的列项
     * @return
     */
    @Override
    public int queryLastId() {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        BigInteger query = null;
        try {
            query = (BigInteger) runner.query("select last_insert_id()",
                    new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query.intValue();
    }


    @Override
    public void addSpeces(List<Spec> specList, int goodsId) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        for (Spec spec : specList) {
            try {
                runner.update("insert into spec values (null, ?, ?, ?, ?)",
                        spec.getSpecName(),
                        spec.getStockNum(),
                        spec.getUnitPrice(),
                        goodsId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int updateSpeces(List<Spec> specList) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        for (Spec spec : specList) {
            try {
                runner.update("update spec set specName = ?, stockNum = ?, unitPrice = ? where id = ?",
                        spec.getSpecName(),
                        spec.getStockNum(),
                        spec.getUnitPrice(),
                        spec.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 200;
    }
}

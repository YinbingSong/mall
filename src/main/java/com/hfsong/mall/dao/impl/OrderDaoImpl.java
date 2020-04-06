package com.hfsong.mall.dao.impl;

import com.hfsong.mall.bean.Cart;
import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.bean.Order.AddOrder;
import com.hfsong.mall.bean.Order.Order;
import com.hfsong.mall.bean.Order.OrderDetails;
import com.hfsong.mall.bean.Order.States;
import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.OrderDao;
import com.hfsong.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());

    /**
     * 查询订单0,1,2,3状态下的订单总数
     * @param sql
     * @param params
     * @return
     */
    @Override
    public Integer queryTotalCount(String sql, List<Object> params) {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        Long count = null;
        try {
            count = (Long) runner.query(sql, new ScalarHandler<>(),
                    params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count.intValue();
    }

    /**
     * 分页查询的订单
     * @param sql
     * @param params
     * @return
     */
    @Override
    public List<Order> queryPageOrders(String sql, List<Object> params) {
        List<Order> orders = null;

        try {
            orders = runner.query(sql, new BeanListHandler<>(Order.class),
                    params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * 查询订单中的用户信息
     * @param
     * @return
     */
    @Override
    public User queryUserInfo(Integer userId) {
        User user = null;
        try {
            user = runner.query("select * from orders where Id = ?",
                    new BeanHandler<>(User.class),
                    userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 逻辑删除订单往数据库中设置该订单survive状态为0（隐藏）
     * @param id
     * @return
     */
    @Override
    public int deleteOrder(String id) {
        try {
            runner.update("update orders set survive = 0 where id = ? ", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    @Override
    public OrderDetails queryOrderInfo(String id) {
        OrderDetails orderDetails = null;
        try {
            orderDetails = runner.query("select id, goodsDetailId, goods, goodsNum, amount, stateId from orders where id = ?",
                    new BeanHandler<>(OrderDetails.class),
                    id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
    /**
     * 根据订单获取商品详情ID
     * @param id
     */
    @Override
    public List<Spec> queryGoodSpec(int id) {
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

    /**
     * 获取到所有可能订单的状态
     * @return
     */
    @Override
    public List<States> queryAllStates() {
        List<States> statesList = null;
        try {
            statesList = runner.query("select * from states",
                    new BeanListHandler<>(States.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statesList;
    }

    /**
     * 根据商品号返回具体规格号
     * @param specName
     * @return
     */
    @Override
    public int getSpecId(String specName) {
        int specId = 0;
        try {
            specId = (int) runner.query("select id from spec where specName = ?", new ScalarHandler<>(),
                    specName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specId;
    }

    /**
     * 根据单条订单号查询order中规格信息
     * @param id
     * @return
     */
    @Override
    public Order queryOrder(String id) {
        Order order = null;
        try {
            order = runner.query("select spec from orders where id =?",
                    new BeanHandler<>(Order.class),
                    id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public int changeOrder(Order order) {
        try {
            runner.update("update orders set stateId = ? where id = ?",
                    order.getState(),
                    order.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    /**
     * 根据用户名和状态字查询当前订单信息
     * @param token
     * @param state
     * @return
     */
    @Override
    public List<Cart> getOrderByState(String token, String state) {
        List<Cart> cartList = null;
        if (!"-1".equals(state)){
            try {
                cartList = runner.query("select * from orders where nickname = ? and stateId = ?",
                        new BeanListHandler<>(Cart.class),
                        token, state);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                cartList = runner.query("select * from orders where nickname = ?",
                        new BeanListHandler<>(Cart.class),
                        token, state);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cartList;
    }

    /**
     * 获取购物车中商品的详情
     * @param goodsDetailId
     * @return
     */
    @Override
    public Good queryGoodsInfo(Integer goodsDetailId) {
        Good goods = null;
        try {
            goods = runner.query("select * from goods where id = ?",
                    new BeanHandler<>(Good.class),
                    goodsDetailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    /**
     * 一键下单
     * @param order
     * @param user
     * @param goods
     * @param spec
     * @return
     */
    @Override
    public int addOrder(AddOrder order, User user, Good goods, Spec spec) {
        try {
            int update = runner.update("insert into orders values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)",
                    user.getId(), goods.getId(), goods.getName(), spec.getSpecName(),
                    order.getNum(), order.getAmount(), order.getState(),
                    user.getNickname(), user.getReceiver(), user.getReceivingAddress(), user.getTelephone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    /**
     * 根据订单获得用户信息 -- 以便于保存订单
     * @param nickName
     * @return
     */
    @Override
    public User getUserInfo(String nickName) {
        User user = null;
        try {
            user = runner.query("select * from user where nickname = ?",
                    new BeanHandler<>(User.class),
                    nickName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 根据订单中的商品ID获得库存信息 -- 以便于保存订单
     * @param goodsDetailId
     * @return
     */
    @Override
    public Spec getSpecInfo(Integer goodsDetailId) {
        Spec spec = null;
        try {
            spec = runner.query("select * from spec where id = ?",
                    new BeanHandler<>(Spec.class),
                    goodsDetailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spec;
    }
    /**
     * 根据订单获得商品信息 -- 以便于保存订单
     * @param goodsId
     * @return
     */
    @Override
    public Good getGoodsInfo(Integer goodsId) {
        Good goods = null;
        try {
            goods = runner.query("select * from goods where id = ?",
                    new BeanHandler<>(Good.class),
                    goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
}

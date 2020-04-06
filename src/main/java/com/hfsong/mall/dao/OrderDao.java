package com.hfsong.mall.dao;

import com.hfsong.mall.bean.*;
import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.bean.Order.AddOrder;
import com.hfsong.mall.bean.Order.Order;
import com.hfsong.mall.bean.Order.OrderDetails;
import com.hfsong.mall.bean.Order.States;

import java.util.List;

public interface OrderDao {

    Integer queryTotalCount(String s, List<Object> params);

    List<Order> queryPageOrders(String s, List<Object> param);

    User queryUserInfo(Integer userId);

    int deleteOrder(String id);

    OrderDetails queryOrderInfo(String id);

    List<Spec> queryGoodSpec(int id);

    List<States> queryAllStates();

    int getSpecId(String specName);

    Order queryOrder(String id);

    int changeOrder(Order order);

    List<Cart> getOrderByState(String token, String state);

    Good queryGoodsInfo(Integer goodsDetailId);

    int addOrder(AddOrder order, User user, Good goods, Spec spec);

    User getUserInfo(String nickName);

    Spec getSpecInfo(Integer goodsDetailId);

    Good getGoodsInfo(Integer goodsId);
}

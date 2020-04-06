package com.hfsong.mall.service;

import com.hfsong.mall.bean.Cart;
import com.hfsong.mall.bean.Order.AddOrder;
import com.hfsong.mall.bean.Order.Order;
import com.hfsong.mall.bean.Order.OrderDetails;
import com.hfsong.mall.bean.Order.OrderParam;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String, Object> ordersByPage(OrderParam orderParam);

    int deleteOrder(String id);

    OrderDetails order(String id);

    int changeOrder(Order order);

    List<Cart> getOrderByState(String token, String state);

    int AddOrder(AddOrder addOrder);
}

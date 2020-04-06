package com.hfsong.mall.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.hfsong.mall.bean.Cart;
import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.bean.Order.*;
import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.OrderDao;
import com.hfsong.mall.dao.impl.OrderDaoImpl;
import com.hfsong.mall.service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    Map<String,Object> map = new HashMap<>();

    /**
     * 订单页面分页显示，及模糊查询功能
     * @param orderParam
     * @return
     */
    @Override
    public Map<String, Object> ordersByPage(OrderParam orderParam) {
        //需要返回total orders
        //模糊查询的sql语句以及参数准备
        String suffix = "";
        List<Object> params = new ArrayList<>();
        // 不是显示全部的 -- 订单状态ID
        if (orderParam.getState() != -1){
            suffix += " and stateId = ?";
            params.add(orderParam.getState());
        }
        // 上限值
        if (!StringUtils.isEmpty(orderParam.getMoneyLimit1())){
            suffix += " and amount <= ?";
            params.add(orderParam.getMoneyLimit1());
        }
        // 下限值
        if (!StringUtils.isEmpty(orderParam.getMoneyLimit2())){
            suffix += " and amount >= ?";
            params.add(orderParam.getMoneyLimit2());
        }
        // 商品名称 -- 模糊查询
        if (!StringUtils.isEmpty(orderParam.getGoods())){
            suffix += " and goods like ?";
            params.add("%" + orderParam.getGoods() + "%");
        }
        // 收货地址 -- 模糊查询
        if (!StringUtils.isEmpty(orderParam.getAddress())){
            suffix += " and address like ?";
            params.add("%" + orderParam.getAddress() + "%");
        }
        // 收件人 -- 模糊查询
        if (!StringUtils.isEmpty(orderParam.getName())){
            suffix += " and name like ?";
            params.add("%" + orderParam.getName() + "%");
        }
        // 订单号
        if (!StringUtils.isEmpty(orderParam.getId())){
            suffix += " and id like ?";
            params.add(orderParam.getId());
        }

        String totalSql = "select count(id) from orders where 1 = 1 and survive = 1";
        // System.out.println(totalSql + suffix);
        Integer count = orderDao.queryTotalCount(totalSql + suffix, params);

        // 查询total
        // System.out.println(count);
        map.put("total", count);


        //全部处理完毕，后面suffix加上分页显示功能的SQL语句
        String pageSql = " limit ? offset ?";
        params.add(orderParam.getPagesize());
        params.add((orderParam.getCurrentPage() - 1) * orderParam.getPagesize());

        //查询orders
        String orderSql = "select * from orders where 1 = 1 and survive = 1";
        // System.out.println(orderSql + suffix + pageSql);
        List<Order> orders = orderDao.queryPageOrders(orderSql + suffix + pageSql, params);
        // 查询订单中的用户信息并封装成user对象
        for (Order order : orders) {
            User user = orderDao.queryUserInfo(order.getUserId());
            order.setUser(user);
        }
        map.put("orders",orders);
        // 分页功能无法完成，不知是为何
        return map;
    }

    @Override
    public int deleteOrder(String id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public OrderDetails order(String id) {
        // 根据订单号封装两类不同的order类
        OrderDetails orderDetails  = orderDao.queryOrderInfo(id);
        Order order = orderDao.queryOrder(id);
        // 根据规格名称获得规格id
        String specName = order.getSpec();
        Integer specId = orderDao.getSpecId(specName);
        //获取全状态集合
        List<States> states = orderDao.queryAllStates();
        orderDetails.setStates(states);
        // 根据订单获取商品详情ID
        Integer num = orderDao.queryOrderInfo(id).getgoodsNum();
        orderDetails.setgoodsNum(num);
        // 获取订单状态
        Integer state = orderDetails.getStateId();
        orderDetails.setStateId(state);
        // 获取规格集合
        Integer goodsDetailId = orderDetails.getGoodsDetailId();
        List<Spec> spec = orderDao.queryGoodSpec(goodsDetailId);
        orderDetails.setSpec(spec);
        // 赋值当前状态和当前规格号
        orderDetails.setCurState(new CurState(state));
        orderDetails.setCurSpec(new CurSpec(specId));
        return orderDetails;
    }

    @Override
    public int changeOrder(Order order) {
        return orderDao.changeOrder(order);
    }

    /**
     * 购物车中订单的各个状态
     * @param token
     * @param state
     * @return
     */
    @Override
    public List<Cart> getOrderByState(String token , String state) {
        //获取购物车详情
        List<Cart> cartList = orderDao.getOrderByState(token, state);
        //获取商品详情
        for (Cart cart : cartList) {
            Integer goodsDetailId = cart.getGoodsDetailId();
            Good goodsInfo = orderDao.queryGoodsInfo(goodsDetailId);
            cart.setGoods(goodsInfo);
        }
        return cartList;
    }

    @Override
    public int AddOrder(AddOrder order) {
        //先获取用户信息
        String nickName = order.getToken();
        User user = orderDao.getUserInfo(nickName);
        //再获取库存信息
        Integer goodsDetailId = order.getGoodsDetailId();
        Spec spec = orderDao.getSpecInfo(goodsDetailId);
        // 商品详情
        Integer goodsId = spec.getGoodsId();
        Good goods = orderDao.getGoodsInfo(goodsId);
        // 将订单插入order表中去
        int result = orderDao.addOrder(order, user, goods, spec);
        return result;
    }
}

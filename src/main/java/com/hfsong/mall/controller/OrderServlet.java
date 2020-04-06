package com.hfsong.mall.controller;

import com.google.gson.Gson;
import com.hfsong.mall.bean.Order.Order;
import com.hfsong.mall.bean.Order.OrderDetails;
import com.hfsong.mall.bean.Order.OrderParam;
import com.hfsong.mall.bean.Result;
import com.hfsong.mall.service.OrderService;
import com.hfsong.mall.service.impl.OrderServiceImpl;
import com.hfsong.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/admin/order/*")
public class OrderServlet extends HttpServlet {
    OrderService orderservice = new OrderServiceImpl();
    Gson gson = new Gson();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/order/", "");
        if ("ordersByPage".equals(action)){
            ordersByPage(request,response);
        }
        if("changeOrder".equals(action)){
            changeOrder(request,response);
        }
    }
        /**
         * 订单分页显示的具体业务逻辑
         * 1.发送了一个请求体参数，解析
         * 2.封装到orderParam对象中
         * 3.构建出一个模糊查询的sql语句，进行查询
         * 4.按照响应体的格式，组织对应的数据结构
         * @param request
         * @param response
         */
        private void ordersByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            OrderParam orderParam = gson.fromJson(requestBody, OrderParam.class);
            // 校验一下 金额上下限 可以为空但是如果不为空的话，那么一定要是数字 如果异常 直接返回 -- (待添加)
            Map<String,Object> orderResult = orderservice.ordersByPage(orderParam);
            Result res = new Result();
            res.setCode(0);
            res.setData(orderResult);
            response.getWriter().println(gson.toJson(res));
        }

        /**
         * 修改订单的状态 -- 从简出发（仅修改订单状态）
         * @param request
         * @param response
         */
        private void changeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Order order = gson.fromJson(requestBody, Order.class);
            int result = orderservice.changeOrder(order);
            Result res = new Result();
            if (result == 200){
                res.setCode(0);
            }
            response.getWriter().println(gson.toJson(res));
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/order/", "");
        if ("deleteOrder".equals(action)){
            deleteOrder(request,response);
        }
        if ("order".equals(action)){
            order(request,response);
        }
    }


        /**
         * 根据订单号获取该条订单具体信息（单号，品名，总金额，状态）
         * @param request
         * @param response
         */
        private void order(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String id = request.getParameter("id");
            OrderDetails orderDetails = orderservice.order(id);
            Result res = new Result();
            res.setCode(0);
            res.setData(orderDetails);
            response.getWriter().println(gson.toJson(res));
        }

        /**
         * 删除订单 -- 并非物理删除，只是前端看不见，数据依旧保存在数据库中
         * @param request
         * @param response
         */
        private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String id = request.getParameter("id");
            int result = orderservice.deleteOrder(id);
            Result res = new Result();
            if (result == 200){
                res.setCode(0);
            }else{
                res.setCode(10000);
                res.setMessage("删除订单异常，请稍后重试");
            }
            response.getWriter().println(gson.toJson(res));
        }
}

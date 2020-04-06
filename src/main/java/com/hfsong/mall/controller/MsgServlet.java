package com.hfsong.mall.controller;

import com.google.gson.Gson;
import com.hfsong.mall.bean.Msg.Msg;
import com.hfsong.mall.bean.Result;
import com.hfsong.mall.service.Msgservice;
import com.hfsong.mall.service.impl.MsgServiceImpl;
import com.hfsong.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/msg/*")
public class MsgServlet extends HttpServlet {

    Msgservice msgService = new MsgServiceImpl();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/msg/", "");
        if ("reply".equals(action)){
            reply(request,response);
        }
    }


    /**
     * 进行回复
     * @param request
     * @param response
     */
    private void reply(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        Msg msg = gson.fromJson(requestBody, Msg.class);
        int result = msgService.reply(msg);
        Result res = new Result();
        if (result == 200){
            res.setCode(0);
        }
        response.getWriter().println(gson.toJson(res));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

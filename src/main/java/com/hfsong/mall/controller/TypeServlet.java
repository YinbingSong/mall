package com.hfsong.mall.controller;

import com.google.gson.Gson;
import com.hfsong.mall.bean.Result;
import com.hfsong.mall.bean.Type.Type;
import com.hfsong.mall.service.TypeService;
import com.hfsong.mall.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/admin/type/*")
public class TypeServlet extends HttpServlet {

    private TypeService typeService = new TypeServiceImpl();

    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/type/", "");
        System.out.println(action);

        if ("addType".equals(action)){
            addType(request,response);
        }

    }


    private void addType(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            String requestBody = HttpUtils.getRequestBody(request);
        int name = Integer.parseInt(request.getParameter("name"));
//            调用service层
        int result= typeService.addType(name);
        Result res = new Result();
        if (result == 200){
            res.setCode(0);
            res.setMessage("添加成功");
        } else if(result == 404){
            res.setCode(10000);
            res.setMessage("该种类已经存在!");
        }else{
            res.setCode(10000);
            res.setMessage("当前访问异常，稍后重试");
        }
        response.getWriter().println(gson.toJson(res));

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/type/", "");
        System.out.println(action);

        if ("getType".equals(action)){
            getType(request,response);
        }
    }

    private void getType (HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Type> typeList = typeService.queryAllType();
        Result result = new Result();
        result.setCode(0);
        result.setData(typeList);
        response.getWriter().println(gson.toJson(result));
    }

}

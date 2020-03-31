package com.hfsong.mall.controller;

import com.hfsong.mall.bean.Admin;
import com.hfsong.mall.bean.AdminChangePwd;
import com.hfsong.mall.bean.Result;
import com.hfsong.mall.bean.User;
import com.hfsong.mall.service.AdminService;
import com.hfsong.mall.service.impl.AdminServiceImpl;
import com.hfsong.mall.utils.HttpUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/api/admin/admin/*")
public class AdminServlet extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();

    Gson gson = new Gson();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");
        System.out.println(action);
        if("login".equals(action)){
            login(request, response);
        }

        if("addAdminss".equals(action)){
            addAdminss(request, response);
        }

        if ("updateAdminss".equals(action)){
            updateAdminss(request,response);
        }

        if ("getSearchAdmins".equals(action)){
            getSearchAdmins(request,response);
        }

        if ("changePwd".equals(action)){
            changePwd(request,response);
        }
    }

        private void changePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        AdminChangePwd adminChangePwd= gson.fromJson(requestBody, AdminChangePwd.class);

        adminService.changePwd(adminChangePwd);
    }


        private void addAdminss(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Admin admin = gson.fromJson(requestBody, Admin.class);
            //调用service层
            int result = adminService.addAdminss(admin);
            Result res = new Result();
            if(result == 200){
                res.setCode(0);
                Map<String, String> map = new HashMap<>();
                map.put("token", admin.getEmail());
                map.put("name", admin.getNickname());
                res.setData(map);
            }else if(result == 404){
                res.setCode(10000);
                res.setMessage("用户名或者密码错误");
            }else{
                res.setCode(10000);
                res.setMessage("当前访问异常，稍后重试");
            }
            response.getWriter().println(gson.toJson(res));

        }


        private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Admin admin = gson.fromJson(requestBody, Admin.class);
            //调用service层
            int result = adminService.login(admin);
            Result res = new Result();
            if(result == 200){
                res.setCode(0);
                Map<String, String> map = new HashMap<>();
                map.put("token", admin.getEmail());
                map.put("name", admin.getNickname());
                res.setData(map);
            }else if(result == 404){
                res.setCode(10000);
                res.setMessage("用户名或者密码错误");
            }else{
                res.setCode(10000);
                res.setMessage("当前访问异常，稍后重试");
            }
            response.getWriter().println(gson.toJson(res));
        }

        private void updateAdminss(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Admin admin = gson.fromJson(requestBody, Admin.class);
            //调用service层
            int result = adminService.updateAdminss(admin);
            Result res = new Result();
            if(result == 200){
                res.setCode(0);
                res.setMessage("修改成功");
            }else if(result == 404){
                res.setCode(10000);
                res.setMessage("用户名或者密码错误");
            }else{
                res.setCode(10000);
                res.setMessage("当前访问异常，稍后重试");
            }
            response.getWriter().println(gson.toJson(res));

        }

        private void getSearchAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {

            String requestBody = HttpUtils.getRequestBody(request);
            Admin admin = gson.fromJson(requestBody, Admin.class);
            //调用service层
            List<Admin> adminList= adminService.getSearchAdmins(admin);
            Result res = new Result();
            if(adminList != null){
                res.setCode(0);
                res.setData(adminList);
            }else{
                res.setCode(10000);
                res.setMessage("当前访问异常，稍后重试");
            }
            response.getWriter().println(gson.toJson(res));
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");
        if("allAdmins".equals(action)){
            allAdmins(request, response);
        }
        if("deleteAdmins".equals(action)){
            deleteAdmins(request, response);
        }
        if ("getAdminsInfo".equals(action)){
            getAdminsInfo(request,response);
        }
        if ("allUser()".equals(action)){
            allUser(request,response);
        }
    }

        private void allUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
            List<User> userList = adminService.allUser();
            Result result = new Result();
            result.setCode(0);
            result.setData(userList);
            response.getWriter().println(gson.toJson(result));
        }


        private void allAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
            List<Admin> adminList = adminService.queryAllAdmins();
            Result result = new Result();
            result.setCode(0);
            result.setData(adminList);
            response.getWriter().println(gson.toJson(result));
        }

        private void deleteAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            int id = Integer.parseInt(request.getParameter("id"));
//            调用service层
            int result= adminService.deleteAdmins(id);
            Result res = new Result();
            if (result == 200){
                res.setCode(0);
                res.setMessage("删除成功");
            } else if(result == 404){
                res.setCode(10000);
                res.setMessage("没有当前用户");
            }else{
                res.setCode(10000);
                res.setMessage("当前访问异常，稍后重试");
            }
            response.getWriter().println(gson.toJson(res));

        }

        private void getAdminsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Admin adminsInfo = adminService.getAdminsInfo(id);
            Result result = new Result();
            result.setCode(0);
            result.setData(adminsInfo);
            response.getWriter().println(gson.toJson(result));
        }
}

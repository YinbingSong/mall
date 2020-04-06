package com.hfsong.mall.controller;

import com.google.gson.Gson;
import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Result;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.service.GoodsService;
import com.hfsong.mall.service.impl.GoodsServiceImpl;
import com.hfsong.mall.utils.FileUploadUtils;
import com.hfsong.mall.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/admin/goods/*")
public class GoodsServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsServiceImpl();

    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/goods/", "");
        System.out.println(action);

        if ("addGoods".equals(action)) {
            addGoods(request, response);
        }

        if ("imgUpload".equals(action)) {
            imgUpload(request, response);
        }

        if ("deleteSpec".equals(action)) {
            deleteSpec(request, response);
        }

        if ("updateGoods".equals(action)) {
            updateGoods(request, response);
        }

        if ("addSpec".equals(action)) {
            addSpec(request, response);
        }


    }

        private void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Good goods = gson.fromJson(requestBody, Good.class);
            // 另一种方法 -- 百分百获取到goods对象
            // JsonElement jsonElement = new JsonParser().parse(requestBody);
            // JsonObject jsonObject = jsonElement.getAsJsonObject();
            // JsonArray specList = jsonObject.getAsJsonArray("specList");
            // jsonElement -- jsonObject -- specList(for遍历出所需要的对象)
            // for (JsonElement element : specList) {
            //     Spec spec = gson.fromJson(element, Spec.class);
            //     System.out.println(spec);
            // }
            // 保存goods spec
            int result = goodsService.addGoods(goods);
            Result res = new Result();
            if (result == 200) {
                res.setCode(0);
            }
            response.getWriter().println(gson.toJson(res));
        }

        private void imgUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
            // 输出的既是配置文件中的内容：localhost：8084
            // String domain = (String) request.getServletContext().getAttribute("domain");
            String domain = "localhost:8084";
            Map<String, Object> map = FileUploadUtils.parseRequest(request);
            Result res = new Result();
            res.setCode(0);
            // 拼接完成整的图片地址 -- localhost:8084/upload/......jpeg
            res.setData(domain + map.get("file"));
            response.getWriter().println(gson.toJson(res));
        }

        private void deleteSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Spec spec = gson.fromJson(requestBody, Spec.class);
            int result = goodsService.deleteSpec(spec);
            Result res = new Result();
            if (result == 200) {
                res.setCode(0);
                res.setData(spec);
            }
            response.getWriter().println(gson.toJson(res));
        }

        private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Good goods = gson.fromJson(requestBody, Good.class);
            // 另一种方法 -- 百分百获取到goods对象
            // JsonElement jsonElement = new JsonParser().parse(requestBody);
            // JsonObject jsonObject = jsonElement.getAsJsonObject();
            // JsonArray specList = jsonObject.getAsJsonArray("specList");
            // jsonElement -- jsonObject -- specList(for遍历出所需要的对象)
            // for (JsonElement element : specList) {
            //     Spec spec = gson.fromJson(element, Spec.class);
            //     System.out.println(spec);
            // }
            // 保存goods spec
            int result = goodsService.updateGoods(goods);
            Result res = new Result();
            if (result == 200) {
                res.setCode(0);
            }
            response.getWriter().println(gson.toJson(res));
        }

        private void addSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String requestBody = HttpUtils.getRequestBody(request);
            Spec spec = gson.fromJson(requestBody, Spec.class);
            int result = goodsService.addSpec(spec);
            Result res = new Result();
            if (result == 200) {
                res.setCode(0);
            }
            response.getWriter().println(gson.toJson(res));
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/type/", "");
        System.out.println(action);

        if ("getGoodsByType".equals(action)) {
            getGoodsByType(request, response);
        }
        if ("deleteGoods".equals(action)) {
            deleteGoods(request, response);
        }
        if ("getGoodsInfo".equals(action)) {
            getGoodsInfo(request, response);
        }
    }

        private void getGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Good goods = goodsService.getGoodsInfo(id);
            List<Spec> specList = goodsService.getGoodSpecListInfo(id);
            Map<String,Object> map = new HashMap<>(2);
            map.put("specs",specList);
            map.put("goods",goods);
            Result res = new Result();
            res.setCode(0);
            res.setData(map);
            response.getWriter().println(gson.toJson(res));
        }

        private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            //            调用service层
            List<Good> goodsList = goodsService.getGoodsByType(typeId);
            Result res = new Result();
            if (goodsList != null) {
                res.setCode(0);
                res.setData(goodsList);
            } else {
                res.setCode(10000);
                res.setMessage("当前访问异常，稍后重试");
            }
            response.getWriter().println(gson.toJson(res));
        }

        private void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            //            调用service层
            int result = goodsService.deleteGoods(id);
            Result res = new Result();
            if (result == 200) {
                res.setCode(0);
                res.setMessage("删除成功");
            } else if (result == 404) {
                res.setCode(10000);
                res.setMessage("没有当前用户");
            } else {
                res.setCode(10000);
                res.setMessage("当前访问异常，稍后重试");
            }
            response.getWriter().println(gson.toJson(res));
        }
}



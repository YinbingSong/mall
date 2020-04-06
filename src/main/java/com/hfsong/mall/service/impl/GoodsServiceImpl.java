package com.hfsong.mall.service.impl;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Goods.GoodsDetails;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.bean.Msg.Reply;
import com.hfsong.mall.bean.Msg.ShowMsg;
import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.GoodsDao;
import com.hfsong.mall.dao.impl.GoodsDaoImpl;
import com.hfsong.mall.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public int addGoods(Good goods) {
        //在service层，先做一件事，先从规格中算出一个价格赋值给price
        //一般取一个最低价格 -- 用来显示诱惑购买
        List<Spec> specList = goods.getSpecList();
        //获取最低价逻辑如下 -- 用[0]位置参照对比
        Double price = specList.get(0).getUnitPrice();
        // 0位置获取过了
        for (int i = 1; i < specList.size(); i++) {
            double newPrice = specList.get(i).getUnitPrice();
            if (newPrice < price){
                price = newPrice;
            }
        }
        String s = price.toString();
        Spec specInfo = goodsDao.getSpecInfo(s);
        Integer stockNum = specInfo.getStockNum();
        goods.setStockNum(stockNum);
        goods.setPrice(price);
        // 调用Dao层
        int result = goodsDao.addGoods(goods);
        if (result == 200){
            // ok
            int goodsId = goodsDao.queryLastId();
            // 保存spec信息
            goodsDao.addSpeces(goods.getSpecList(), goodsId);
            return 200;
        }
        return 500;
    }

    @Override
    public int updateGoods(Good goods) {
        List<Spec> specList = goods.getSpecList();
        Double price = specList.get(0).getUnitPrice();
        for (int i = 1; i < specList.size(); i++) {
            double newPrice = specList.get(i).getUnitPrice();
            if (newPrice < price){
                price = newPrice;
            }
        }
        String s = price.toString();
        Spec specInfo = goodsDao.getSpecInfo(s);
        Integer stockNum = specInfo.getStockNum();
        goods.setStockNum(stockNum);
        goods.setPrice(price);
        //以上都是在显示更新后的价格
        int result = goodsDao.updateSpeces(goods.getSpecList());
        if (result == 200){
            // 保存goods信息
            goodsDao.updateGoods(goods);
            return 200;
        }
        return 500;
    }

    @Override
    public int addSpec(Spec spec) {
        return goodsDao.addSpec(spec);
    }

    @Override
    public int deleteSpec(Spec spec) {
        return goodsDao.deleteSpec(spec);
    }

    @Override
    public int deleteGoods(int id) {
        return goodsDao.deleteGoods(id);
    }

    @Override
    public List<Good> getGoodsByType(int typeId) {
        return goodsDao.getGoodsByType(typeId);
    }

    @Override
    public Good getGoodsInfo(int id) {
        return goodsDao.getGoodsInfo(id);
    }

    @Override
    public List<Spec> getGoodSpecListInfo(int id) {
        return goodsDao.getGoodSpecListInfo(id);
    }

    @Override
    public GoodsDetails goodsDetails(int id) {
        Good goodsInfo = goodsDao.getGoodsInfo(id);
        Integer goodsInfoId = goodsInfo.getId();
        List<Spec> spec = goodsDao.getGoodSpecListInfo(goodsInfoId);
        GoodsDetails goodsDetails = goodsDao.goodsDetails(id);
        goodsDetails.setSpecs(spec);
        return goodsDetails;
    }

    @Override
    public List<ShowMsg> showMsg(int id) {
        List<ShowMsg> showMsg = goodsDao.showMsg(id);
        for (ShowMsg msg : showMsg) {
            //根据数据库中存储的msg表获得到id去查nickname
            Integer userId = msg.getUserId();
            User userInfo = goodsDao.getUserInfo(userId);
            String nickname = userInfo.getNickname();
            msg.setAsker(nickname);
            //复制留言创建时间
            String createtime = msg.getCreatetime();
            msg.setTime(createtime);

            // 回复类
            Reply reply = new Reply();
            //回复内容
            String replyContent = msg.getReplyContent();
            reply.setReplyContent(replyContent);
            // 回复时间
            String replytime = msg.getReplytime();
            reply.setCreatetime(replytime);
            msg.setReply(reply);
        }
        return showMsg;
    }


}

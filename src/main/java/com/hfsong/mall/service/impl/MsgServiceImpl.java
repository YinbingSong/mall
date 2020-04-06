package com.hfsong.mall.service.impl;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Msg.CommentList;
import com.hfsong.mall.bean.Msg.Msg;
import com.hfsong.mall.bean.Msg.Question;
import com.hfsong.mall.bean.Msg.Rate;
import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.MsgDao;
import com.hfsong.mall.dao.impl.MsgDaoImpl;
import com.hfsong.mall.service.Msgservice;

import java.util.List;

public class MsgServiceImpl implements Msgservice {
    MsgDao msgDao = new MsgDaoImpl();
    /**
     * 获取所有留言
     */
    Msg msg = msgDao.getMsg();

    @Override
    public List<Msg> noReplyMsg() {

        List<Msg> msgList = msgDao.noReplyMsg();
        for (Msg mg : msgList) {
            // 根据用户id获取用户nickName
            Integer userId = mg.getUserId();
            User user = msgDao.getUserName(userId);

            // 根据商品ID号获得具体商品名称
            Integer goodsId = mg.getGoodsId();
            Good goods = msgDao.getGoods(goodsId);

            //更改时间显示格式
            mg.setGoods(goods);
            mg.setUser(user);
        }
        return msgList;
    }

    @Override
    public List<Msg> repliedMsg() {

        List<Msg> msgList = msgDao.repliedMsg();
        for (Msg mg : msgList) {
            // 根据用户id获取用户nickName
            Integer userId = mg.getUserId();
            User user = msgDao.getUserName(userId);

            // 根据商品ID号获得具体商品名称
            Integer goodsId = mg.getGoodsId();
            Good goods = msgDao.getGoods(goodsId);

            //更改时间显示格式
            mg.setGoods(goods);
            mg.setUser(user);
        }
        return msgList;
    }

    @Override
    public int reply (Msg msg){
        return msgDao.reply(msg);
    }

    @Override
    public int askGoodsMsg(Question question) {
        String nickname = question.getToken();
        User user = msgDao.getUserId(nickname);
        Integer userId = user.getId();
        msgDao.AskGoodsMsg(question,userId);
        return 200;
    }

    /**
     * 用来封装评论类
     * @param goodsId
     * @return
     */
    @Override
    public Rate getGoodsComment(String goodsId) {
        Rate rate = new Rate();
        List<CommentList>commentLists = msgDao.getComment(goodsId);
        for (CommentList comment : commentLists) {
            Integer userId = comment.getUserId();
            User userName = msgDao.getUserName(userId);
            comment.setUser(userName);
        }
        rate.setCommentList(commentLists);
        rate.setRate(50.0);
        return rate;
    }
}

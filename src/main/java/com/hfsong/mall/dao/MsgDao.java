package com.hfsong.mall.dao;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Msg.CommentList;
import com.hfsong.mall.bean.Msg.Msg;
import com.hfsong.mall.bean.Msg.Question;
import com.hfsong.mall.bean.User;

import java.util.List;

public interface MsgDao {

    List<Msg> noReplyMsg();

    User getUserName(Integer userId);

    Good getGoods(Integer goodsId);

    List<Msg> repliedMsg();

    Msg getMsg();

    int reply(Msg msg);

    int AskGoodsMsg(Question question, Integer userId);

    User getUserId(String nickname);

    List<CommentList> getComment(String goodsId);
}

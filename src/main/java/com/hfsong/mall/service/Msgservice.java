package com.hfsong.mall.service;

import com.hfsong.mall.bean.Msg.Msg;
import com.hfsong.mall.bean.Msg.Question;
import com.hfsong.mall.bean.Msg.Rate;

import java.util.List;

public interface Msgservice {
    List<Msg> noReplyMsg();

    List<Msg> repliedMsg();

    int reply(Msg msg);

    int askGoodsMsg(Question question);

    Rate getGoodsComment(String goodsId);
}

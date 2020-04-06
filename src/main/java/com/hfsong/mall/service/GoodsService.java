package com.hfsong.mall.service;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Goods.GoodsDetails;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.bean.Msg.ShowMsg;

import java.util.List;

public interface GoodsService {
    int addGoods(Good goods);

    int updateGoods(Good goods);

    List<Good> getGoodsByType(int typeId);

    Good getGoodsInfo(int id);

    List<Spec> getGoodSpecListInfo(int id);

    int addSpec(Spec spec);

    int deleteSpec(Spec spec);

    int deleteGoods(int id);

    GoodsDetails goodsDetails(int id);

    List<ShowMsg> showMsg(int id);

}

package com.hfsong.mall.dao;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Goods.GoodsDetails;
import com.hfsong.mall.bean.Goods.Spec;
import com.hfsong.mall.bean.Msg.ShowMsg;
import com.hfsong.mall.bean.User;

import java.util.List;

public interface GoodsDao {

    List<Good> getGoodsByType(int typeId);

    int deleteGoods(int id);

    int addGoods(Good goods);

    int deleteSpec(Spec spec);

    int updateGoods(Good goods);

    int addSpec(Spec spec);

    Good getGoodsInfo(int id);

    List<Spec> getGoodSpecListInfo(int id);

    GoodsDetails goodsDetails(int id);

    List<ShowMsg> showMsg(int id);

    User getUserInfo(Integer userId);

    Spec getSpecInfo(String s);

    int queryLastId();

    void addSpeces(List<Spec> specList, int goodsId);

    int updateSpeces(List<Spec> specList);
}

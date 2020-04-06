package com.hfsong.mall.bean;

import com.hfsong.mall.bean.Goods.Good;

public class Cart {

    private Integer id;

    private Integer state;

    private Integer goodsNum;

    private Integer amount;

    private Integer goodsDetailId;

    private String createtime;

    private Boolean hasComment;

    private Good goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public boolean isHasComment() {
        return hasComment;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }

    public Good getGoods() {
        return goods;
    }

    public void setGoods(Good goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", state=" + state +
                ", goodsNum=" + goodsNum +
                ", amount=" + amount +
                ", goodsDetailId=" + goodsDetailId +
                ", createtime='" + createtime + '\'' +
                ", hasComment=" + hasComment +
                ", goods=" + goods +
                '}';
    }
}

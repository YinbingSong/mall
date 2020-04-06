package com.hfsong.mall.bean.Order;

/**
 * 立即下单类
 */
public class AddOrder {

    private String token;

    private Integer goodsDetailId;

    private Integer num;

    private Integer state;

    private Double amount;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AddOrder{" +
                "token='" + token + '\'' +
                ", goodsDetailId=" + goodsDetailId +
                ", num=" + num +
                ", state=" + state +
                ", amount=" + amount +
                '}';
    }
}

package com.hfsong.mall.bean.Order;

import com.hfsong.mall.bean.User;

public class Order {
    private Integer id;

    private Integer userId;

    private Integer goodsDetailId;

    private String goods;

    private String spec;

    private Integer goodsNum;

    private Double amount;

    private Integer stateId;

    private String state;

    private User user;
    /**
     * 订单的存活状态属性（针对逻辑删除，1表示存活，0表示"被删了"）
     */
    private String survive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        //dbutils给stateId赋值，调用该方法
        this.stateId = stateId;
        switch (this.stateId) {
            case 0:
                setState("未付款");
                break;
            case 1:
                setState("未发货");
                break;
            case 2:
                setState("已发货");
                break;
            case 3:
                setState("已到货");
                break;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSurvive() {
        return survive;
    }

    public void setSurvive(String survive) {
        this.survive = survive;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", goodsDetailId=").append(goodsDetailId);
        sb.append(", goods='").append(goods).append('\'');
        sb.append(", spec='").append(spec).append('\'');
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", amount=").append(amount);
        sb.append(", stateId=").append(stateId);
        sb.append(", state='").append(state).append('\'');
        sb.append(", user=").append(user);
        sb.append(", survive='").append(survive).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

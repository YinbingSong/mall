package com.hfsong.mall.bean.Order;

import com.hfsong.mall.bean.Goods.Spec;

import java.util.List;

/**
 * 用于显示订单详情类
 */
public class OrderDetails {
    private Integer id;

    private Double amount;

    private Integer num;

    private Integer goodsDetailId;

    private Integer state;

    private String goods;

    private List<Spec> spec;

    private List<States> states;
    /**
     * 当前订单状态 -- 用于修改
     */
    private CurState curState;

    private CurSpec curSpec;

    public CurState getCurState() {
        return curState;
    }

    public void setCurState(CurState curState) {
        this.curState = curState;
    }

    public CurSpec getCurSpec() {
        return curSpec;
    }

    public void setCurSpec(CurSpec curSpec) {
        this.curSpec = curSpec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getgoodsNum() {
        return num;
    }

    public void setgoodsNum(Integer num) {
        this.num = num;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getStateId() {
        return state;
    }

    public void setStateId(Integer state) {
        this.state = state;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public List<Spec> getSpec() {
        return spec;
    }

    public void setSpec(List<Spec> spec) {
        this.spec = spec;
    }

    public List<States> getStates() {
        return states;
    }

    public void setStates(List<States> states) {
        this.states = states;
    }


    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", amount=" + amount +
                ", num=" + num +
                ", goodsDetailId=" + goodsDetailId +
                ", state=" + state +
                ", goods='" + goods + '\'' +
                ", spec=" + spec +
                ", states=" + states +
                ", curState=" + curState +
                ", curSpec=" + curSpec +
                '}';
    }
}

package com.hfsong.mall.bean.Order;

/**
 * 显示当前订单状态类
 */
public class CurState {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CurState{" +
                "id=" + id +
                '}';
    }

    public CurState(Integer id) {
        this.id = id;
    }

    public CurState() {
    }
}

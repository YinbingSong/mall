package com.hfsong.mall.bean.Order;

/**
 * 用户当前显示订单中商品所在的编号类
 */
public class CurSpec {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CurSpec{" +
                "id=" + id +
                '}';
    }

    public CurSpec(Integer id) {
        this.id = id;
    }

    public CurSpec() {
    }
}

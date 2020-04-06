package com.hfsong.mall.bean.Goods;


import java.util.List;

/**
 * 显示在tmall中的商品详情类
 */
public class GoodsDetails {

    private String img;

    private String name;

    private Integer goodsDetailId;

    private String desc;

    private Integer typeId;

    private List<Spec> specs;

    private Integer unitPrice;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "GoodsDetails{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", goodsDetailId=" + goodsDetailId +
                ", desc='" + desc + '\'' +
                ", typeId=" + typeId +
                ", specs=" + specs +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

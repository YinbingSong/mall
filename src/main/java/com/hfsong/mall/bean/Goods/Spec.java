package com.hfsong.mall.bean.Goods;

public class Spec {
    private Integer id;
    private String specName;
    private Integer stockNum;
    private Double unitPrice;
    private Integer goodsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spec{");
        sb.append("id=").append(id);
        sb.append(", specName='").append(specName).append('\'');
        sb.append(", stockNum=").append(stockNum);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", goodsId=").append(goodsId);
        sb.append('}');
        return sb.toString();
    }
}

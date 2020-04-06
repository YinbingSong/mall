package com.hfsong.mall.bean.Goods;

import java.util.List;

public class Good {
    private Integer id;
    private String  img;
    private String  name;
    private Double price;
    private Integer typeId;
    private Integer stockNum;
    private String desc;
    private List<Spec> specList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Spec> getSpecList() {
        return specList;
    }

    public void setSpecList(List<Spec> specList) {
        this.specList = specList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Good{");
        sb.append("id=").append(id);
        sb.append(", img='").append(img).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", typeId=").append(typeId);
        sb.append(", stockNum=").append(stockNum);
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", specList=").append(specList);
        sb.append('}');
        return sb.toString();
    }
}

package com.hfsong.mall.bean.Msg;

public class Question {

    private String token;

    private String msg;

    private String goodsId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "token='" + token + '\'' +
                ", msg='" + msg + '\'' +
                ", goodsId='" + goodsId + '\'' +
                '}';
    }
}

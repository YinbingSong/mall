package com.hfsong.mall.bean.Msg;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.User;

public class Msg {
    private Integer id;

    private Integer userId;

    private Integer goodsId;

    private String content;

    private String replyContent;

    private Integer state;

    private String createtime;

    private Good goods;

    private User user;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Msg{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", content='").append(content).append('\'');
        sb.append(", replyContent='").append(replyContent).append('\'');
        sb.append(", state=").append(state);
        sb.append(", createtime='").append(createtime).append('\'');
        sb.append(", goods=").append(goods);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Good getGoods() {
        return goods;
    }

    public void setGoods(Good goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

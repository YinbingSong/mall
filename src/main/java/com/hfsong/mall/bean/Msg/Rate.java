package com.hfsong.mall.bean.Msg;

import java.util.List;

    /**
     * 好评率
     */
public class Rate {
    private List<CommentList> commentList;
    private Double rate;

    public List<CommentList> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentList> commentList) {
        this.commentList = commentList;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "commentList=" + commentList +
                ", rate=" + rate +
                '}';
    }
}

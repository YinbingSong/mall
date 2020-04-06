package com.hfsong.mall.bean.Msg;

import com.hfsong.mall.bean.User;

/**
 * 评论列表 + 单条评论
 */
public class CommentList {

    private User user;

    private Integer score;

    private Integer id;

    private String specName;

    private String comment;

    private String time;

    private Integer userId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CommentList{" +
                "user=" + user +
                ", score=" + score +
                ", id=" + id +
                ", specName='" + specName + '\'' +
                ", comment='" + comment + '\'' +
                ", time='" + time + '\'' +
                ", userId=" + userId +
                '}';
    }
}

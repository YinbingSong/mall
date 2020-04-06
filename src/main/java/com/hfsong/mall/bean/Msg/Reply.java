package com.hfsong.mall.bean.Msg;

/**
 * 回复留言类
 */
public class Reply {
    private String content;
    private String time;

    /**
     * 对哪个用户ID进行回复
     * @return
     */
    private Integer userId;

    /**
     * 回复状态 0为已回复，1为未回复
     * @return
     */
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReplyContent() {
        return content;
    }

    public void setReplyContent(String replyContent) {
        this.content = replyContent;
    }

    public String getCreatetime() {
        return time;
    }

    public void setCreatetime(String createtime) {
        this.time = createtime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", userId=" + userId +
                ", state=" + state +
                '}';
    }
}

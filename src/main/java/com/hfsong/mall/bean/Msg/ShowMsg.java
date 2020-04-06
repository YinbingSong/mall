package com.hfsong.mall.bean.Msg;
/**
 * 前端展示留言板类
 */
public class ShowMsg {

    private Integer id;

    private String content;

    private Integer userId;

    private String asker;
    /**
     * 用来前端显示时间
     */
    private String time;
    /**
     * 从数据库获取发起疑问的创建时间
     */
    private String createtime;
    /**
     * 从数据库中获取回复的时间
     */
    private String replytime;

    private Reply reply;

    private String replyContent;

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "ShowMsg{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", asker='" + asker + '\'' +
                ", time='" + time + '\'' +
                ", createtime='" + createtime + '\'' +
                ", replytime='" + replytime + '\'' +
                ", reply=" + reply +
                ", replyContent='" + replyContent + '\'' +
                '}';
    }
}

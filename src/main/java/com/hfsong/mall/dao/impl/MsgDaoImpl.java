package com.hfsong.mall.dao.impl;

import com.hfsong.mall.bean.Goods.Good;
import com.hfsong.mall.bean.Msg.CommentList;
import com.hfsong.mall.bean.Msg.Msg;
import com.hfsong.mall.bean.Msg.Question;
import com.hfsong.mall.bean.User;
import com.hfsong.mall.dao.MsgDao;
import com.hfsong.mall.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MsgDaoImpl implements MsgDao {
    QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());

    //插入数据库的时间撮
    Date currentTime = new Date();
    SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String createtime = DateFormat.format(currentTime);

    /**
     * 查询状态等于1的留言
     * @return
     */
    @Override
    public List<Msg> noReplyMsg() {
        List<Msg> msgList = null;
        try {
            msgList = runner.query("select * from msg where stateId = 1",
                    new BeanListHandler<>(Msg.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msgList;
    }

    /**
     * 根据用户id获取用户nickName
     * @return
     * @param userId
     */
    @Override
    public User getUserName(Integer userId) {
        User user = null;
        try {
            user = runner.query("select nickname from user where id = ?",
                    new BeanHandler<>(User.class),
                    userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 根据商品ID号获得具体商品名称
     * @param goodsId
     * @return
     */
    @Override
    public Good getGoods(Integer goodsId) {
        Good goods = null;
        try {
            goods = runner.query("select name from goods where id = ?",
                    new BeanHandler<>(Good.class),
                    goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public List<Msg> repliedMsg() {
        List<Msg> msgList = null;
        try {
            msgList = runner.query("select * from msg where stateId = 0",
                    new BeanListHandler<>(Msg.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msgList;
    }

    @Override
    public Msg getMsg() {
        Msg msg = null;
        try {
            msg = runner.query("select * from msg",
                    new BeanHandler<>(Msg.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 后台回复留言
     * @param msg
     * @return
     */
    @Override
    public int reply(Msg msg) {
        try {
            runner.update("update msg set stateId = 0, replyContent = ?, replytime = ? where id = ?",
                    msg.getContent(),
                    createtime,
                    msg.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    /**
     * 前台用户留言更新
     * @param question
     * @param userId
     * @return
     */
    @Override
    public int AskGoodsMsg(Question question, Integer userId) {
        try {
            runner.update("insert into msg values (null, ?, ?, ?, ?, 1, null, null)",
                    userId,
                    question.getGoodsId(),
                    question.getMsg(),
                    createtime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public User getUserId (String nickname) {
        User user = null;
        try {
            user = runner.query("select * from user where nickname = ?",
                    new BeanHandler<>(User.class),
                    nickname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 获取全体评论
     * @param goodsId
     * @return
     */
    @Override
    public List<CommentList> getComment(String goodsId) {
        List<CommentList> commentLists = null;
        try {
            commentLists = runner.query("select * from comment where goodsId = ?",
                    new BeanListHandler<>(CommentList.class),
                    goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentLists;
    }


}

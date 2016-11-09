package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.Message;
import com.springapp.mvc.bean.mapper.MessageRowMapper;
import com.springapp.mvc.dao.MessageDao;
import com.springapp.mvc.service.MessageService;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */

@Repository("messageDao")
public class MessageDaoImpl extends JdbcDaoSupport implements MessageDao{
    @Override
    public List<Message> findMessagesByUser(long userId) {
        String sql = "select * from messages where status = 1 and userId = " + userId  ;
        List messages =  this.getJdbcTemplate().query(sql,new MessageRowMapper());
        return messages;
    }

    @Override
    @Transactional
    public void deleteMessageById(int mId) {
        String sql = "update messages set status = 0 where id=?";
        this.getJdbcTemplate().update(sql,mId);
    }

    @Override
    @Transactional
    public void deleteMessageByUser(long userId) {
        String sql = "update messages set status = 0 where userId=?";
        this.getJdbcTemplate().update(sql,userId);
    }
}

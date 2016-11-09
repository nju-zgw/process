package com.springapp.mvc.dao;

import com.springapp.mvc.bean.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
public interface MessageDao {

    public List<Message> findMessagesByUser(long userId) throws SQLException;
    public void       deleteMessageById(int id) throws SQLException;
    public void       deleteMessageByUser(long userId) throws SQLException;
}

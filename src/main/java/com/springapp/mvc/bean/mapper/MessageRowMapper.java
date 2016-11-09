package com.springapp.mvc.bean.mapper;

import com.springapp.mvc.bean.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
public class MessageRowMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet resultSet, int i) throws SQLException {
        Message message = new Message(resultSet.getInt("id"),
                                      resultSet.getInt("riskId"),
                                      resultSet.getInt("userId"),
                                      resultSet.getInt("status"),
                                      resultSet.getDate("createAt")
                                      );
        return message;
    }
}

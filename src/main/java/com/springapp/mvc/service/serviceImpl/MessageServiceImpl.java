package com.springapp.mvc.service.serviceImpl;

import com.springapp.mvc.bean.Message;
import com.springapp.mvc.dao.MessageDao;
import com.springapp.mvc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */

@Service("messageService")
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageDao messageDao;

    @Override
    public List<Message> getMessages(long userId) {

        List<Message> ret = new ArrayList<Message>();
        try {
            ret =  messageDao.findMessagesByUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return ret;
        }
    }

    @Override
    public void readMessage(int mId) {

        try {
            messageDao.deleteMessageById(mId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readAllMessages(long userId) {

        try {
            messageDao.deleteMessageByUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

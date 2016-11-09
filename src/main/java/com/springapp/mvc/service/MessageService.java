package com.springapp.mvc.service;

import com.springapp.mvc.bean.Message;

import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
public interface MessageService {

    public List<Message> getMessages(long userId);
    public void       readMessage(int mId);
    public void       readAllMessages(long userId);
}

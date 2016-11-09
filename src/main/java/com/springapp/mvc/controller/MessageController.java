package com.springapp.mvc.controller;

import com.springapp.mvc.bean.Message;
import com.springapp.mvc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/getMessages",method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getMessage(@RequestParam("userId") int  userId){

        System.out.println("user" + userId + " getting Message");
        List<Message> ret = messageService.getMessages(userId);
        return ret;
    }

    @RequestMapping(value = "/readMessage",method = RequestMethod.POST)
    @ResponseBody
    public void readMessage(@RequestParam(value = "mid") int  mid){

        System.out.println( " read Message " + mid);
        messageService.readMessage(mid);

    }

    @RequestMapping(value = "/readAllMessage",method = RequestMethod.POST)
    @ResponseBody
    public void readAllMessage(@RequestParam("userId") int  userId){

        System.out.println(userId + " read all Message ");
        messageService.readAllMessages(userId);

    }



}

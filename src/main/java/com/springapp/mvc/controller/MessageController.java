package com.springapp.mvc.controller;

import com.springapp.mvc.bean.Message;
import com.springapp.mvc.bean.MessageView;
import com.springapp.mvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @Autowired
    UserService userService;

    @Autowired
    RiskService riskService;

    @RequestMapping(value = "/getMessages",method = RequestMethod.GET)
    @ResponseBody
    public List<MessageView> getMessage(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String  name = auth.getName();
        int userId = userService.getUserId(name);
        System.out.println("user" + userId + " getting Message");
        List<Message> ret = messageService.getMessages(userId);

        List<MessageView> res = new ArrayList<MessageView>();
        for(Message mes : ret){
           MessageView mv = new MessageView();
           mv.setRisk(riskService.getRiskName(mes.getRiskId()));
           mv.setTime(mes.getCreateAt().toLocaleString());
           res.add(mv);
        }
        return res;
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

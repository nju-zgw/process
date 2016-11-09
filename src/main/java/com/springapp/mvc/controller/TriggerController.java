package com.springapp.mvc.controller;

import com.springapp.mvc.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

/**
 * Created by NJUYuanRui on 2016/11/9.
 */

@Controller
public class TriggerController {

    @Autowired
    TriggerService triggerService;

    @RequestMapping(value = "addTrigger",method = RequestMethod.POST)
    @ResponseBody
    public void readAllMessage(@RequestParam("type")        int  type,
                               @RequestParam("event")       int  event,
                               @RequestParam("riskId")      int  riskId,
                               @RequestParam("projectId")   int  projectId,
                               @RequestParam("deadline")    Date  deadline,
                               @RequestParam("threshold")   int  threshold,
                               @RequestParam("operator")    int  operator
                               ){

        System.out.println("risk "+ riskId + " add trigger ");
        triggerService.addTrigger(type,event,riskId,projectId,deadline,threshold,operator);

    }

}

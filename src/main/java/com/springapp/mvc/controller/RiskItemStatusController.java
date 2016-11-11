package com.springapp.mvc.controller;

import com.springapp.mvc.bean.RiskStatusItem;
import com.springapp.mvc.bean.RiskStatusItemView;
import com.springapp.mvc.service.RiskItemStatusService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by WH on 2016/11/10.
 */
@Controller
public class RiskItemStatusController {

    @Autowired
    RiskItemStatusService riskItemStatusService;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/getRiskStatusByTracer", method = RequestMethod.GET)
    public @ResponseBody
    List<RiskStatusItem> getRiskStatusByTracer() {
        //get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return riskItemStatusService.getStatusItems(username);
    }


    //得到与风险相关的所有风险状态
    @RequestMapping(value = "/getRiskStatusByRiskId", method = RequestMethod.GET)
    public @ResponseBody
    List<RiskStatusItemView> getRiskStatusByRiskId( @RequestParam(value = "riskId", required = true) int riskId) {
        //get username
        List<RiskStatusItem> items = riskItemStatusService.getStatusItemsByriskId(riskId);

        List<RiskStatusItemView> itemviews = new ArrayList<RiskStatusItemView>();
        for(RiskStatusItem item:items){
            RiskStatusItemView statusView = new RiskStatusItemView();
            statusView.setTime(item.getCreateTime().toLocaleString());
            statusView.setContent(item.getStatusDescript());
            statusView.setUsername(userService.getUserNameById(item.getTracerId()));
            statusView.setStatus(this.getStatus(item.getRiskStatusValue()));
            itemviews.add(statusView);
        }
        return itemviews;
    }
    //创建某风险 新的风险状态
    @RequestMapping(value = "/createRiskStatus", method = RequestMethod.GET)
    public String  createRiskStatus(@RequestParam(value = "riskId", required = true) int riskId,
                                    @RequestParam(value = "user", required = true) String name,
                                    @RequestParam(value = "status", required = true) int status,
                                    @RequestParam(value = "content", required = true) String content ){

        //新建一个状态
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        RiskStatusItem  statusItem = new RiskStatusItem();
        statusItem.setAcceptorId(userService.getUserId(name));
        statusItem.setTracerId(userService.getUserId(username));
        statusItem.setCreateTime(new Date());
        statusItem.setStatusDescript(content);
        statusItem.setRiskStatusValue(status);
        statusItem.setRiskId(riskId);
        riskItemStatusService.createRiskStatusItem(statusItem);
        return "createrisk";
    }


    private String getStatus(int type){
        switch (type){
            case 1:
                return "准备跟踪";
            case 2:
                return "跟踪中";
            case 3:
                return "已解决";
        }
        return "准备跟踪";
    }

}

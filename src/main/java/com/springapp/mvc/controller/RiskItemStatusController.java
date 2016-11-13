package com.springapp.mvc.controller;

import com.springapp.mvc.bean.RiskStatusItem;
import com.springapp.mvc.bean.RiskStatusItemView;
import com.springapp.mvc.bean.ValidInfo;
import com.springapp.mvc.service.RiskItemStatusService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
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
    @RequestMapping(value = "/createRiskStatus", method = RequestMethod.POST)
    public @ResponseBody ValidInfo  createRiskStatus(@RequestParam(value = "riskId", required = true) int riskId,
                                    @RequestParam(value = "userid", required = true)  int userid,
                                    @RequestParam(value = "status", required = true) int status,
                                    @RequestParam(value = "content", required = true) String content
                                    ){

        //新建一个状态
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        RiskStatusItem  statusItem = new RiskStatusItem();
        statusItem.setAcceptorId(userid);
        statusItem.setTracerId(userService.getUserId(username));
        statusItem.setCreateTime(new Date());
        statusItem.setStatusDescript(content);
        statusItem.setRiskStatusValue(status);
        statusItem.setRiskId(riskId);

        ValidInfo  valid = new ValidInfo();
        if(status == 3) {
            if (hasRole("ROLE_MANAGER")) {
                riskItemStatusService.createRiskStatusItem(statusItem);
                valid.setStatusCode(100);
                valid.setInfo("状态创建成功");
            }else{
                valid.setStatusCode(200);
                valid.setInfo("你没有足够的权限");
            }
        }else {
            if(userid !=0) {
                riskItemStatusService.createRiskStatusItem(statusItem);
                valid.setStatusCode(100);
                valid.setInfo("状态创建成功");
            }else{
                valid.setStatusCode(200);
                valid.setInfo("你不能把风险分配给系统");
            }
        }
        return valid;

    }


    public static boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        if(hasRole) {
            System.out.println("当前用户是: "+ role);
        }
        return hasRole;
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

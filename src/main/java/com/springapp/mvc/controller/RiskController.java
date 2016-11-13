package com.springapp.mvc.controller;

import com.springapp.mvc.bean.*;
import com.springapp.mvc.bean.vo.RiskItemVO;
import com.springapp.mvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by WH on 2016/11/9.
 */
@Controller
public class RiskController {

    @RequestMapping(value = "/riskPage", method = RequestMethod.GET)
    public String transToRiskPage() {
        return "addRiskForTest";
    }

    @RequestMapping(value = "/allRisks", method = RequestMethod.GET)
    public String transToAllRisksPage(ModelMap model) {
        //get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();


        List<List<RiskItemVO>> risksList = new ArrayList<List<RiskItemVO>>();


        if(hasRole("ROLE_MANAGER")||hasRole("ROLE_USER")||hasRole("ROLE_DEV")){
            risksList = riskService.getRisks(username);
        }else if(hasRole("ROLE_SYS_ADMIN")){
            // 管理员获得所有风险
            risksList = riskService.getRisksForAdmin(username);
            //risksList.add(riskService.);
        }

        List<List<RiskView>>  riskItemsList = new ArrayList<List<RiskView>>();

        for(List<RiskItemVO> list : risksList){
            List<RiskView> riskItems =new ArrayList<RiskView>();
            for(RiskItemVO riskview : list){
                RiskView view =new RiskView();
                view.setRiskId(riskview.getRiskItemId());
                view.setProject(projectService.getProjectNanmeById(riskview.getProjectId()));
                view.setRiskAffect(this.getType(riskview.getRiskAffect()));
                view.setRiskType(this.getriskType(riskview.getRiskTypeId()));
                //查 这个风险跟踪的人   风险状态
                List<RiskStatusItem>  riskStatus = riskItemStatusService.getStatusItemsByriskId(riskview.getRiskItemId());
                view.setPeopleNum(riskStatus.size());
                if(riskStatus.size()>0) { //至少有一个风险状态
                    RiskStatusItem status = riskStatus.get(riskStatus.size() - 1);
                    view.setStatus(this.getStatus(status.getRiskStatusValue()));
                }
                riskItems.add(view);
            }
            riskItemsList.add(riskItems);
        }


        System.out.println(risksList);
        model.addAttribute("riskviewList",riskItemsList);
        model.addAttribute("risksList",risksList);
        return "index";
    }


    @RequestMapping(value = "/createRisk", method = RequestMethod.GET)
    public String transToCreateRisk(ModelMap model) {
        List<?> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "createrisk";
    }


    @RequestMapping(value = "/lookRisk/{riskId}", method = RequestMethod.GET)
    public String ToRiskView( @PathVariable("riskId") int riskId,ModelMap model) {


        RiskItem risk = riskService.getRisk(riskId);
        Trigger  trigger = triggerService.findTrigger(riskId);

        RiskView view =new RiskView();  //这些是风险 创建时 原有的信息
        view.setRiskId(riskId);
        view.setRiskName(risk.getRiskName());
        view.setProject(risk.getProjectName());
        view.setProvider(userService.getUserNameById(risk.getCreaterId()));
        view.setTime(risk.getTime().toLocaleString());
        view.setRiskType(this.getriskType(risk.getTypeId()));
        view.setRiskPro(this.getType(risk.getProb()));
        view.setRiskAffect(this.getType(risk.getAffect()));


        //风险描述
        view.setContent(risk.getDescript());

        //查 这个风险跟踪的人   风险状态
        List<RiskStatusItem>  riskStatus = riskItemStatusService.getStatusItemsByriskId(riskId);
        view.setPeopleNum(riskStatus.size());
        if(riskStatus.size()>0) { //至少有一个风险状态
            RiskStatusItem status = riskStatus.get(riskStatus.size() - 1);
            view.setStatus(this.getStatus(status.getRiskStatusValue()));
            view.setFollowName(userService.getUserNameById(status.getTracerId()));
         }


        //触发器内容
        view.setType(this.getTriggerType(trigger.getType()));
        view.setEvent(this.getEvent(trigger.getEvent()));
        view.setValue(this.getOperator(trigger.getOperator())+"  "+trigger.getThreshold());
        view.setDeadline(trigger.getDeadline().toLocaleString());

        //需要判断这个风险条目  状态 是否现在能由他跟踪

        List<RiskStatusItem> statusItems = riskItemStatusService.getStatusItemsByriskId(riskId);

        RiskStatusItem status = statusItems.get(statusItems.size()-1);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        if(status.getAcceptorId() == userService.getUserId(username)){
             view.setFollower(true);
        }

        model.addAttribute("riskView",view);
        return "lookrisk";
    }

    @Autowired
    RiskService riskService;

    @Autowired
    TriggerService triggerService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    RiskItemStatusService riskItemStatusService;

    /**
     *
     * @param request
     * @return
     * 创建新的风险条目，返回RiskItemVO 的json表示
     */

    @RequestMapping(value = "/addRisk", method = RequestMethod.POST)
    public @ResponseBody
    RiskItemVO createRisk(HttpServletRequest request,
                          @RequestParam(value = "riskName", required = true) String riskName,
                          @RequestParam(value = "projectId", required = true) int projectId,
                          @RequestParam(value = "riskTypeId", required = true) int riskTypeId,
                          @RequestParam(value = "descript", required = true) String riskDescript,
                          @RequestParam(value = "riskProb", required = true) int riskProb,
                          @RequestParam(value = "riskAffect", required = true) int riskAffect,
                          @RequestParam(value = "triggerType", required = true) int triggerType,
                          @RequestParam(value = "valueType", required = true) int valueType,
                          @RequestParam(value = "value", required = true) int value,
                          @RequestParam(value = "eventType", required = true) int eventType,
                          @RequestParam(value = "time", required = true) Date time
    ) {

        RiskItemVO vo = new RiskItemVO();
        vo.setRiskName(riskName);
        vo.setProjectId(projectId);
        vo.setRiskTypeId(riskTypeId);
        vo.setDescript(riskDescript);
        vo.setRiskProb(riskProb);
        vo.setRiskAffect(riskAffect);

        //触发器相关,使用TriggerCreateInfo作为载体
        //在set之前应该做数据的范围检查,此处暂时先不写
        TriggerCreateInfo triggerInfo = new TriggerCreateInfo();
        triggerInfo.setTriggerType(triggerType);
        triggerInfo.setValueType(valueType);
        triggerInfo.setValue(value);
        triggerInfo.setEventType(eventType);
        triggerInfo.setTime(time); //这个注意一下 可能有问题
        //creater Name
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String createrName = auth.getName();
        vo.setCreaterName(createrName);

        if(!isLegalInfo(vo)) {
            vo.setOperateSuccess(false);
            vo.setOperateInfo("数据格式不合法");
            return vo;
        }

        //在service add之后，vo的id字段已经设置好了，可以直接拿来用
        if(hasRole("ROLE_MANAGER")) {
            System.out.println(createrName + " 增加一条RiskItem....");
            riskService.addRiskItem(vo);
        }else if(hasRole("ROLE_DEV")){
            System.out.println(createrName + " 增加一条RiskItem....");
            riskService.addRiskItem(vo);
        }else{
            System.out.println("创建RiskItem失败，权限不足....");
        }

        //默认创建风险条目的那个人第一个被分配去跟踪风险
        RiskStatusItem  statusItem = new RiskStatusItem();
        statusItem.setRiskId(vo.getRiskItemId());
        statusItem.setAcceptorId(userService.getUserId(createrName));
        statusItem.setStatusDescript(riskDescript);
        statusItem.setTracerId(0);
        statusItem.setRiskStatusValue(1);
        statusItem.setCreateTime(time);
        riskItemStatusService.createRiskStatusItem(statusItem);


        System.out.println(vo);
        triggerService.addTrigger(triggerInfo.getTriggerType(),
                triggerInfo.getEventType(), vo.getRiskItemId(), projectId, triggerInfo.getTime(),
                triggerInfo.getValue(),triggerInfo.getValueType());
        return vo;
    }

    /**
     *
     * @param request
     * @return
     * 获得当前和该用户项目相关的所有风险条目
     */
    @RequestMapping(value = "/getRisks", method = RequestMethod.GET)
    public @ResponseBody
    List<List<RiskItemVO>> getRisks(HttpServletRequest request) {
        //get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if(username == null || username.length() == 0)
            return new ArrayList<>();
        List<List<RiskItemVO>> results = riskService.getRisks(username);
        return results;
    }

    /**
     *
     * @param request
     * @return
     * 跟进处理某一风险条目
     */
    @RequestMapping(value = "/processRisk", method = RequestMethod.POST)
    public @ResponseBody RiskItemVO processRisk(HttpServletRequest request) {


        return null;
    }

    /**
     *
     * @param request
     * @return
     * 结束某一风险
     */
    @RequestMapping(value = "/endRisk", method = RequestMethod.POST)
    public @ResponseBody RiskItemVO endRisk(HttpServletRequest request) {
        return null;
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

    /**
     *
     * @param vo
     * @return
     * 验证RiskItemVO输入的值是否在合法范围
     */
    private boolean isLegalInfo(RiskItemVO vo) {
        boolean result = true;
        return result;
    }

    private String getriskType(int type){
        switch (type){
            case 1:
                return "性能风险";
            case 2:
                return "进度风险";
            case 3:
                return "成本风险";
        }
        return "性能风险";
    }


    private  String  getType(int type){
       switch (type) {
           case 1:
               return "低";
           case 2:
               return "中";
           case 3:
                return "高";
       }
        return "低";
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

    private String getTriggerType(int type){
        switch (type){
            case 0:
                return "进度";
            case 1:
                return "缺陷";
        }
        return "进度";
    }

    private String getEvent(int event){
        switch (event){
            case 0:
                return "通知项目所有成员";
            case 1:
                return "通知风险追踪者";
            case 2:
                return "通知项目经理";
        }
        return "通知项目所有成员";
    }

    private String getOperator(int type){
        switch (type){
            case 0:
                return "<";
            case 1:
                return "=";
            case 2:
                return ">";
        }
        return "<";
    }


}

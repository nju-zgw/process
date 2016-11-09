package com.springapp.mvc.controller;

import com.springapp.mvc.bean.vo.RiskItemVO;
import com.springapp.mvc.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
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
    public String transToAllRisksPage() {
        return "showRiskForTest";
    }

    @Autowired
    RiskService riskService;
    /**
     *
     * @param request
     * @return
     * 创建新的风险条目，返回RiskItemVO 的json表示
     */
    @RequestMapping(value = "/addRisk", method = RequestMethod.POST)
    public @ResponseBody
    RiskItemVO createRisk(HttpServletRequest request,
                          @RequestParam(value = "projectId", required = true) int projectId,
                          @RequestParam(value = "riskTypeId", required = true) int riskTypeId,
                          @RequestParam(value = "descript", required = true) String riskDescript,
                          @RequestParam(value = "riskProb", required = true) int riskProb,
                          @RequestParam(value = "riskAffect", required = true) int riskAffect
                          ) {

        RiskItemVO vo = new RiskItemVO();
        vo.setProjectId(projectId);
        vo.setRiskTypeId(riskTypeId);
        vo.setDescript(riskDescript);
        vo.setRiskProb(riskProb);
        vo.setRiskAffect(riskAffect);
        //creater Name
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String createrName = auth.getName();
        vo.setCreaterName(createrName);

        if(!isLegalInfo(vo)) {
            vo.setOperateSuccess(false);
            vo.setOperateInfo("数据格式不合法");
            return vo;
        }

        if(hasRole("ROLE_MANAGER")) {
            System.out.println(createrName + " 增加一条RiskItem....");
            riskService.addRiskItem(vo);
        }else if(hasRole("ROLE_DEV")){
            System.out.println(createrName + " 增加一条RiskItem....");
            riskService.addRiskItem(vo);
        }else{
            System.out.println("创建RiskItem失败，权限不足....");
        }
        System.out.println(vo);
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
    List<RiskItemVO> getRisks(HttpServletRequest request) {
        //get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if(username == null || username.length() == 0)
            return new ArrayList<>();
        List<RiskItemVO> results = riskService.getRisks(username);
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

    private boolean hasRole(String role) {
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
}

package com.springapp.mvc.controller;

import com.springapp.mvc.bean.ValidInfo;
import com.springapp.mvc.service.UserService;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WH on 2016/11/8.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String transToLoginPage() {
        System.out.println("Head to Login Page...");
        return "login";
    }

    /**
     *
     * @param name 用户名
     * @param pwd 密码
     *
     * @return
     * modelandview,modelAndView包含以下key
     * statusCode,info
     * (-1,"用户不存在或用户名/密码未填写")
     * (0,"用户名密码错误")
     * (1,"验证成功")
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ValidInfo processLoginRequest(@RequestParam(value = "username", required = false)
                                            String name, @RequestParam(value = "password", required = false)
                                                    String pwd) {
        System.out.println("username: "+name +" password: "+pwd);
        ValidInfo vi = new ValidInfo();
        if(name == null || pwd == null || name.length() == 0 || pwd.length() == 0) {
            vi.setStatusCode(-1);
            vi.setInfo("用户不存在或用户名/密码未填写");
            return vi;
        }
        boolean existed = userService.checkUserExisted(name);
        if(!existed) {
            vi.setStatusCode(-1);
            vi.setInfo("用户不存在或用户名/密码未填写");
            return vi;
        }

        boolean correct = userService.checkCorrect(name, pwd);
        if(!correct) {
            vi.setStatusCode(0);
            vi.setInfo("用户名密码错误");
            return vi;
        }else{
            vi.setStatusCode(1);
            vi.setInfo("验证成功");
            return vi;
        }

    }

}

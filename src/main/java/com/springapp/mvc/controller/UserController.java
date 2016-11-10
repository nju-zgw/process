package com.springapp.mvc.controller;

import com.springapp.mvc.bean.User;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by WH on 2016/11/10.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getRisks(HttpServletRequest request) {
        List<User> results = userService.getAllUsers();
        return results;
    }
}

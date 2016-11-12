package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WH on 2016/11/8.
 */
@Controller
@RequestMapping("/")
public class IndexContoller {

    @RequestMapping(value = "/loginSuccess",method = RequestMethod.GET)
    public void transToIndexPage(HttpServletRequest request,
                                         HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/allRisks");
    }
}

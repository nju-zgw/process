package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by WH on 2016/11/8.
 */
@Controller
@RequestMapping("/")
public class IndexContoller {

    @RequestMapping(value = "/loginSuccess",method = RequestMethod.GET)
    public ModelAndView transToIndexPage(){
        ModelAndView model = new ModelAndView();
//        model.addObject("title", "spring security helloworld");
        model.setViewName("index");
        return model;
    }
}

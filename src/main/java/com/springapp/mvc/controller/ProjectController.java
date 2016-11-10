package com.springapp.mvc.controller;

import com.springapp.mvc.bean.Message;
import com.springapp.mvc.bean.Project;
import com.springapp.mvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by NJUYuanRui on 2016/11/10.
 */

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/getProjects",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getMessage(){

        List<Project> projects = projectService.getAllProjects();
        return projects;
    }


}

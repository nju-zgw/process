package com.springapp.mvc.service;

import com.springapp.mvc.bean.Project;

import java.util.List;

/**
 * Created by NJUYuanRui on 2016/11/10.
 */
public interface ProjectService {

    public List<Project> getAllProjects();

    public String  getProjectNanmeById(long pid);
}

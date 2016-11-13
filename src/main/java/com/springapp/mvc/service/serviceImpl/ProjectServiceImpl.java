package com.springapp.mvc.service.serviceImpl;

import com.springapp.mvc.bean.Project;
import com.springapp.mvc.dao.ProjectDao;
import com.springapp.mvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NJUYuanRui on 2016/11/10.
 */

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao;

    @Override
    public List<Project> getAllProjects() {
        try {
            return projectDao.findAllProjects();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public String getProjectNanmeById(long pid) {
        Project  p = new Project(1);
        try {
               p = projectDao.findProject(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p.getName();
    }
}

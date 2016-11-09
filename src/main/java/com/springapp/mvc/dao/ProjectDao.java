package com.springapp.mvc.dao;

import com.springapp.mvc.bean.Project;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface ProjectDao {
    public void insert(Project project) throws SQLException;

    public void delete(Project project) throws SQLException;

    public void modify(Project project) throws SQLException;

    public Project findProject(long pid) throws SQLException;

    public List<Project> findProjectsByProvider(long uid) throws  SQLException;

    public List<Integer> findAllMembersByProject(long projectId) throws  SQLException;
}

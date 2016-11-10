package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.Project;
import com.springapp.mvc.bean.mapper.ProjectRowMapper;
import com.springapp.mvc.dao.ProjectDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */

@Repository("projectDao")
public class ProjectDaoImpl extends JdbcDaoSupport implements ProjectDao {
    @Override
    public void insert(Project project) throws SQLException {

    }

    @Override
    public void delete(Project project) throws SQLException {

    }

    @Override
    public void modify(Project project) throws SQLException {

    }

    @Override
    public Project findProject(long pid) throws SQLException {
        String sql = "select * from projects where project_id=?";
        return this.getJdbcTemplate().queryForObject(sql, new ProjectRowMapper(),pid);
    }

    @Override
    public List<Project> findProjectsByProvider(long uid) throws SQLException {
        return null;
    }

    @Override
    public List<Integer> findAllMembersByProject(long projectId) throws SQLException {
        String sql = "select user_id from prject_user_rel where project_id = " + projectId ;
        List users =  this.getJdbcTemplate().queryForList(sql,Integer.class);
        return users;
    }

    @Override
    public List<Project> findAllProjects() throws SQLException {
        String sql = "select * from projects " ;
        return this.getJdbcTemplate().query(sql, new ProjectRowMapper());
    }


}

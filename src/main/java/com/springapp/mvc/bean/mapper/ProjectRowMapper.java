package com.springapp.mvc.bean.mapper;

import com.springapp.mvc.bean.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Project(resultSet.getInt("project_id"),
                           resultSet.getInt("manager_id"),
                           resultSet.getString("name"),
                           resultSet.getString("content"),
                            resultSet.getString("status"),
                           resultSet.getDate("startTime"),
                           resultSet.getInt("progress"),
                           resultSet.getInt("bugnum")
                );
    }
}

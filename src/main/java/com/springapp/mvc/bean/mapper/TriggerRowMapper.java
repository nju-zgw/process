package com.springapp.mvc.bean.mapper;

import com.springapp.mvc.bean.Trigger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by NJUYuanRui on 2016/11/9.
 */
public class TriggerRowMapper implements RowMapper<Trigger> {
    @Override
    public Trigger mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Trigger(resultSet.getInt("id"),
                           resultSet.getInt("type"),
                           resultSet.getInt("event"),
                           resultSet.getInt("riskId"),
                           resultSet.getInt("riskId"),
                           resultSet.getInt("status"),
                           resultSet.getDate("deadline"),
                           resultSet.getInt("threshold"),
                           resultSet.getInt("operator")
                    );
    }
}

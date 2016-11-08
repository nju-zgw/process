package com.springapp.mvc.bean.mapper;

import com.springapp.mvc.bean.RiskDescript;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WH on 2016/11/8.
 */
public class RiskDescriptsRowMapper implements RowMapper<RiskDescript> {

    @Override
    public RiskDescript mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}

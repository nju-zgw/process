package com.springapp.mvc.bean.mapper;

import com.springapp.mvc.bean.RiskItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WH on 2016/11/8.
 */
public class RiskItemsRowMapper implements RowMapper<RiskItem>{
    @Override
    public RiskItem mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}

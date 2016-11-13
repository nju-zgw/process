package com.springapp.mvc.bean.mapper;

import com.springapp.mvc.bean.RiskStatusItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WH on 2016/11/10.
 */
public class RiskStatusItemRowMapper implements RowMapper<RiskStatusItem> {
    @Override
    public RiskStatusItem mapRow(ResultSet resultSet, int i) throws SQLException {
        RiskStatusItem item = new RiskStatusItem();
        item.setStatusId(resultSet.getInt("status_id"));
        item.setRiskId(resultSet.getInt("risk_item_id"));
        item.setTracerId(resultSet.getInt("tracer_id"));
        item.setAcceptorId(resultSet.getInt("acceptor_id"));
        item.setStatusDescriptId(resultSet.getInt("risk_status_descript_id"));
        item.setStatusDescript(resultSet.getString("status_descript"));
        item.setCreateTime(resultSet.getTime("create_time"));
        item.setRiskStatusValue(resultSet.getInt("status_value"));
        return item;
    }
}

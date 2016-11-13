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
        RiskItem item = new RiskItem();
        item.setRid(resultSet.getInt("risk_item_id"));
        item.setProjectId(resultSet.getInt("projectId"));
        item.setCreaterId(resultSet.getInt("creater_id"));
        item.setTypeId(resultSet.getInt("risk_type_id"));
        item.setDescriptId(resultSet.getInt("descript_id"));
        item.setDescript(resultSet.getString("risk_descript"));
        item.setProb(resultSet.getInt("risk_prob"));
        item.setAffect(resultSet.getInt("risk_affect"));
        item.setProjectName(resultSet.getString("pname"));
        item.setProcessed(resultSet.getInt("processed"));
        item.setRiskName(resultSet.getString("risk_name"));
        item.setTime(resultSet.getTimestamp("create_time"));
        return item;
    }
}

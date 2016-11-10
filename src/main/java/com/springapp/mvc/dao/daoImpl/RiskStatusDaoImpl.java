package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.RiskStatusItem;
import com.springapp.mvc.bean.mapper.RiskStatusItemRowMapper;
import com.springapp.mvc.dao.RiskStatusDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WH on 2016/11/9.
 */
@Repository("riskStatusDao")
public class RiskStatusDaoImpl extends JdbcDaoSupport implements RiskStatusDao{
    @Override
    public List<RiskStatusItem> getStatusList(int riskId) {
        final String querySql = "SELECT status_id, risk_item_id, tracer_id, risk_status_descript_id, " +
                "  status_descript, create_time from risk_status rs " +
                "JOIN risk_status_descripts rsd on rs.risk_status_descript_id = rsd.status_descript_id " +
                "WHERE rs.risk_item_id = ?";
        return this.getJdbcTemplate().query(querySql, new RiskStatusItemRowMapper(), riskId);
    }
}

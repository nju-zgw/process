package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.RiskStatusItem;
import com.springapp.mvc.bean.mapper.RiskStatusItemRowMapper;
import com.springapp.mvc.dao.RiskStatusDao;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override
    public List<RiskStatusItem> getStatusByTracer(int tracerId) {
        final String querySql = "SELECT status_id, risk_item_id, tracer_id, risk_status_descript_id, " +
                "  status_descript, create_time from risk_status rs " +
                "JOIN risk_status_descripts rsd on rs.risk_status_descript_id = rsd.status_descript_id " +
                "WHERE rs.tracer_id = ?";
        return this.getJdbcTemplate().query(querySql, new RiskStatusItemRowMapper(), tracerId);
    }

    @Override
    @Transactional
    public RiskStatusItem addStatusForRisk(final RiskStatusItem item) {
        final String insertDescriptSql = "INSERT INTO risk_status_descripts " +
                "(status_descript) " +
                " VALUES " +
                "  (?) ";
        final KeyHolder desKeyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(insertDescriptSql,
                                new String[]{"status_descript_id"});
                        ps.setString(1, item.getStatusDescript());
                        return ps;
                    }
                },
                desKeyHolder
        );
        final String insertRiskStatusSql = "INSERT INTO risk_status " +
                "(risk_item_id, tracer_id, risk_status_descript_id, acceptor_id) " +
                " VALUES " +
                "  (?,?,?, ?) ";
        final KeyHolder riskStatusKey = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(insertRiskStatusSql,
                                new String[]{"risk_item_id, tracer_id , risk_status_descript_id"});
                        ps.setInt(1, item.getRiskId());
                        ps.setInt(2, item.getTracerId());
                        ps.setInt(3, desKeyHolder.getKey().intValue());
                        ps.setInt(4, item.getAcceptorId());
                        return ps;
                    }
                },
                riskStatusKey
        );
        item.setStatusId(riskStatusKey.getKey().intValue());
        item.setStatusDescriptId(desKeyHolder.getKey().intValue());
        return item;
    }
}

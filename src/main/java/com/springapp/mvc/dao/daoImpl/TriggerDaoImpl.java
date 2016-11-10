package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.Trigger;
import com.springapp.mvc.bean.mapper.TriggerRowMapper;
import com.springapp.mvc.bean.mapper.UserRowMapper;
import com.springapp.mvc.dao.TriggerDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */

@Repository("triggerDao")
public class TriggerDaoImpl extends JdbcDaoSupport implements TriggerDao {

    @Override
    public List<Trigger> findAllActiveTriggers(Date date) {

        String sql = "select * from triggers where status = 0 and deadline = '" + date.toString()+"'"  ;
        List triggers =  this.getJdbcTemplate().query(sql,new TriggerRowMapper());
        return triggers;

    }

    @Override
    public void updateTriggers(Date date) {
        String sql = "update triggers set status = 1 where deadline = ?";
        this.getJdbcTemplate().update(sql,date);
    }

    @Override
    public void insertTrigger(int type, int event, int riskId, int projectId, Date deadline, int threshold, int operator) {
        String sql = "INSERT INTO triggers(type,event,riskId,projectId,deadline, threshold,operator,status) VALUES ("+
                     type + ", " + event +  ", " + riskId + ", " + projectId + ", '" + deadline + "', " + threshold + ", " + operator + ",0)" ;
        this.getJdbcTemplate().execute(sql);
    }

    @Override
    public Trigger findTrigger(int riskId) {
        String sql = "select * from triggers where riskId =?" ;
        Trigger trigger =  this.getJdbcTemplate().queryForObject(sql,new TriggerRowMapper(),riskId);
        return trigger;

    }


}

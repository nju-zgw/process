package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.Trigger;
import com.springapp.mvc.bean.mapper.TriggerRowMapper;
import com.springapp.mvc.dao.TriggerDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

        String sql = "select * from triggers where status = 0 and deadline = " + date  ;
        List triggers =  this.getJdbcTemplate().query(sql,new TriggerRowMapper());
        return triggers;

    }

    @Override
    public void updateTriggers(Date date) {
        String sql = "update triggers set status = 1 where deadline = ?";
        this.getJdbcTemplate().update(sql,date);
    }
}

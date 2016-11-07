package com.springapp.mvc.dao;

import com.springapp.mvc.bean.RiskStatusItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface riskStatusDao {

    public void insert(RiskStatusItem status) throws SQLException;

    public void delete(RiskStatusItem status) throws SQLException;

    public void modify(RiskStatusItem status) throws SQLException;

    public RiskStatusItem findRiskStatusItemByPid(long rid) throws SQLException;

    public List<RiskStatusItem> findRiskStatusItemByRid(long sid) throws SQLException;

    public List<RiskStatusItem> findRiskStatusItemByUid(long uid) throws SQLException;

}

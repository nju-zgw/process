package com.springapp.mvc.dao;

import com.springapp.mvc.bean.RiskItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface RiskItemDao {
    public void insert(RiskItem project) throws SQLException;

    public void delete(RiskItem project) throws SQLException;

    public void modify(RiskItem project) throws SQLException;

    public RiskItem findRiskItemByRid(long rid) throws SQLException;

    public RiskItem findRiskItemByPid(long pid) throws SQLException;

}

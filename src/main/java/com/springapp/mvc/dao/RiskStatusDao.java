package com.springapp.mvc.dao;

import com.springapp.mvc.bean.RiskStatusItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface RiskStatusDao {
    public List<RiskStatusItem> getStatusList(int riskId);

    public List<RiskStatusItem> getStatusByTracer(int tracerId);

    public RiskStatusItem addStatusForRisk(RiskStatusItem item);

    public List<RiskStatusItem> getStatusByAcceptor(int acceptorId);

}

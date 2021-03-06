package com.springapp.mvc.dao;

import com.springapp.mvc.bean.RiskItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface RiskItemDao {
    public void insert(RiskItem project);

    public void delete(RiskItem project);

    public void modify(RiskItem project);

    public List<RiskItem> getRisks(int userId);//全部风险列表

    public List<RiskItem> getAllRisks(); // 管理员能够获得全部风险
    public List<RiskItem> getRisksCreated(int createrId);

    public List<RiskItem> getRisksAccepted(int acceptorId);

    public RiskItem getRisk(int riskId);

    public String getRiskNameById(int riskId);


}

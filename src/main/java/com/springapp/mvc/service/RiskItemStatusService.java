package com.springapp.mvc.service;

import com.springapp.mvc.bean.RiskStatusItem;

import java.util.List;

/**
 * Created by WH on 2016/11/10.
 */
public interface RiskItemStatusService {
    public List<RiskStatusItem> getStatusItems(String username);

    public List<RiskStatusItem> getStatusByAcceptorName(String acceptor);

    public List<RiskStatusItem> getStatusItemsByriskId(int riskId);

    public RiskStatusItem createRiskStatusItem(
            int riskId,
            String createrName ,
            String acceptorName,
            String statusDescript);

}

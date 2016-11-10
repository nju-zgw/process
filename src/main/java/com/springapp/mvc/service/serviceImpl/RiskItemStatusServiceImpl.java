package com.springapp.mvc.service.serviceImpl;

import com.springapp.mvc.bean.RiskStatusItem;
import com.springapp.mvc.bean.User;
import com.springapp.mvc.dao.RiskStatusDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.service.RiskItemStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WH on 2016/11/10.
 */
@Service("riskItemStatusService")
public class RiskItemStatusServiceImpl implements RiskItemStatusService{
    @Autowired
    RiskStatusDao riskStatusDao;
    @Autowired
    UserDao userDao;
    @Override
    public List<RiskStatusItem> getStatusItems(String username) {
        User user = userDao.getUserByName(username);
        return riskStatusDao.getStatusByTracer(user.getId());
    }

    @Override
    public List<RiskStatusItem> getStatusItemsByriskId(int riskId) {
        return riskStatusDao.getStatusList(riskId);
    }


    @Override
    public RiskStatusItem createRiskStatusItem(
            int riskId,
            String createrName ,
            String acceptorName,
            String statusDescript) {
        User creater = userDao.getUserByName(createrName);
        User acceptor = userDao.getUserByName(acceptorName);
        RiskStatusItem statusItem = new RiskStatusItem();
        statusItem.setRiskId(riskId);
        statusItem.setTracerId(creater.getId());
        statusItem.setAcceptorId(acceptor.getId());
        statusItem.setStatusDescript(statusDescript);

        statusItem = riskStatusDao.addStatusForRisk(statusItem);
        return statusItem;
    }


}

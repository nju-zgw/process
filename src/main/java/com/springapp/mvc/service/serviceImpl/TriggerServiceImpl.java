package com.springapp.mvc.service.serviceImpl;

import com.springapp.mvc.bean.Project;
import com.springapp.mvc.bean.Trigger;
import com.springapp.mvc.dao.MessageDao;
import com.springapp.mvc.dao.ProjectDao;
import com.springapp.mvc.dao.TriggerDao;
import com.springapp.mvc.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */

@Service("triggerService")
public class TriggerServiceImpl implements TriggerService {
    @Autowired
    TriggerDao triggerDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    ProjectDao projectDao;

    @Override
    public void trigger(Date date) {
        try {
            List<Trigger> triggers = triggerDao.findAllActiveTriggers(date);
            for(Trigger trigger : triggers){
                Project prj = projectDao.findProject(trigger.getProjectId());
                if(needNotify(trigger,prj)){
                    List<Integer> users;
                    switch (trigger.getEvent()){
                        case 0 : users = projectDao.findAllMembersByProject(prj.getPid()); break;
                        case 1 : users = Arrays.asList(prj.getUid());break;
                        case 2 :
                        default: users = Arrays.asList(prj.getUid()); //没有接口 暂时用经理代替
                    }
                    messageDao.insertMessages(users,trigger.getRiskId(),date);
                }

            }
            triggerDao.updateTriggers(date);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public boolean needNotify(Trigger trigger,Project prj){

        int threshold = trigger.getThreshold();
        int actualValue = trigger.getType() == 0? prj.getProgress():prj.getBugNum();

        switch ( trigger.getOperator() ){
            case 0:
                return actualValue<threshold;
            case 1:
                return actualValue==threshold;
            case 2:
            default:
                return actualValue>threshold;
        }

    }

    @Override
    public void addTrigger(int type, int event, int riskId, int projectId, Date deadline, int threshold, int operator) {
        triggerDao.insertTrigger(type,event,riskId,projectId,deadline,threshold,operator);
    }

    @Override
    public Trigger findTrigger(int riskId) {
        return triggerDao.findTrigger(riskId);
    }

}

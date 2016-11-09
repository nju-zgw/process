package com.springapp.mvc.service;

import java.sql.Date;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
public interface TriggerService {
    public void trigger(Date date);
    public void addTrigger(int  type, int  event, int  riskId, int  projectId, Date deadline, int  threshold,int  operator);

}

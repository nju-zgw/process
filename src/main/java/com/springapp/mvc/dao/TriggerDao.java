package com.springapp.mvc.dao;

import com.springapp.mvc.bean.Trigger;

import java.sql.Date;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
public interface TriggerDao {

    /**
     * 获取所有触发器
     *
     * @param date
     */
    public List<Trigger> findAllActiveTriggers(Date date);

    /**
     * 将处理过的触发器设为失效
     *
     * @param date
     */
    public void updateTriggers(Date date);

    /**
     * 新增一条触发器
     *
     * @param type
     * @param event
     * @param riskId
     * @param projectId
     * @param deadline
     * @param threshold
     * @param operator
     */
    public void insertTrigger(int type, int event, int riskId, int projectId, Date deadline, int threshold, int operator);


    public Trigger findTrigger(int riskId);

}

package com.springapp.mvc.dao;

import com.springapp.mvc.bean.Trigger;

import java.util.Date;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
public interface TriggerDao {

    /**
     * 获取所有触发器
     * @param date
     */
    public List<Trigger> findAllActiveTriggers(Date date);

    /**
     * 将处理过的触发器设为失效
     * @param date
     */
    public void          updateTriggers(Date date);
}

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
     * ��ȡ���д�����
     * @param date
     */
    public List<Trigger> findAllActiveTriggers(Date date);

    /**
     * ��������Ĵ�������ΪʧЧ
     * @param date
     */
    public void          updateTriggers(Date date);
}

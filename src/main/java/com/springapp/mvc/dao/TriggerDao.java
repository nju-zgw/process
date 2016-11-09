package com.springapp.mvc.dao;

import com.springapp.mvc.bean.Trigger;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
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

    /**
     * ����һ��������
     * @param type
     * @param event
     * @param riskId
     * @param projectId
     * @param deadline
     * @param threshold
     * @param operator
     */
    public void          insertTrigger(int  type, int  event, int  riskId, int  projectId,Date deadline, int  threshold,int  operator);

}

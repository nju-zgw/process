package com.springapp.mvc.bean;

import java.sql.Date;

/**
 * ������
 * Created by NJUYuanRui
 * Created  2016/11/8
 * Modufied 2016/11/8
 *
 * �����ݶ�Ϊ���֣��ֱ��ע���Ⱥ�ȱ��
 * �¼����ͷ�Ϊ���֣����ھ���֪ͨ��Щ��
 * ����������ʱ�ж��Ƿ񵽴���ֵ���Ծ����Ƿ񴥷��¼�����������Ժ�ʧЧ�����߻��������ж�ʧЧ�ķ�ʽ��
 * ��ֵ�� �ڹ�ע����ʱ��ʾ������ֵ����λ�ǰٷֵ�
 *       �ڹ�עȱ��ʱ��ʾȱ����ֵ����λ�Ǹ���
 * �ȽϷ���ʵ��ֵ����ֵ�ıȽϷ�ʽ
 */
public class Trigger {

    private int  id;
    private int  type;      //0 ���� �� 1 ȱ��
    private int  event;     //0 ֪ͨ��Ŀ���г�Ա �� 1 ֪ͨ����׷���� �� 2 ֪ͨ��Ŀ����
    private int  riskId;
    private long projectId;
    private int  status;    //0 ������ �� 1 ʧЧ
    private Date deadline;  //��������
    private int  threshold; //��ֵ
    private int  operator ; //�ȽϷ�  0��С�� 1������ 2������

    public Trigger(int id, int type, int event, int riskId, long projectId, int status, Date deadline, int threshold, int operator) {
        this.id = id;
        this.type = type;
        this.event = event;
        this.riskId = riskId;
        this.projectId = projectId;
        this.status = status;
        this.deadline = deadline;
        this.threshold = threshold;
        this.operator = operator;
    }

    public Trigger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getRiskId() {
        return riskId;
    }

    public void setRiskId(int riskId) {
        this.riskId = riskId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}

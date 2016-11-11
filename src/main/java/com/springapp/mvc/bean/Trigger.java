package com.springapp.mvc.bean;

import java.sql.Date;

/**
 * 触发器
 * Created by NJUYuanRui
 * Created  2016/11/8
 * Modufied 2016/11/8
 *
 * 类型暂定为两种，分别关注进度和缺陷
 * 事件类型分为三种，用于决定通知哪些人
 * 当到达期限时判定是否到达阈值，以决定是否触发事件，触发完毕以后失效（或者还有其他判定失效的方式）
 * 阈值： 在关注进度时表示进度阈值，单位是百分点
 *       在关注缺陷时表示缺陷阈值，单位是个数
 * 比较符：实际值和阈值的比较方式
 */
public class Trigger {

    private int  id;
    private int  type;      //0 进度 ， 1 缺陷
    private int  event;     //0 通知项目所有成员 ， 1 通知风险追踪者 ， 2 通知项目经理
    private int  riskId;
    private long projectId;
    private int  status;    //0 进行中 ， 1 失效
    private Date deadline;  //触发期限
    private int  threshold; //阈值
    private int  operator ; //比较符  0：小于 1：等于 2：大于

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

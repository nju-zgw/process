package com.springapp.mvc.bean;

import java.util.Date;

/**
 * ÏûÏ¢
 * Created by NJUYuanRui
 * Created  2016/11/8
 * Modufied 2016/11/8
 */
public class Message {

    private int  id;
    private int  riskId;
    private long userId;
    private int  status;    //0 ÒÑ¶Á£¬1 Î´¶Á
    private Date createAt;


    public Message(int id, int riskId, long userId, int status, Date createAt) {
        this.id = id;
        this.riskId = riskId;
        this.userId = userId;
        this.status = status;
        this.createAt = createAt;
    }

    public Message(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRiskId() {
        return riskId;
    }

    public void setRiskId(int riskId) {
        this.riskId = riskId;
    }

    public long getUserid() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}

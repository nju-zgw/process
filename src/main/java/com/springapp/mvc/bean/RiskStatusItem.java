package com.springapp.mvc.bean;

import java.util.Date;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public class RiskStatusItem {
    //风险状态：状态编号（主键）、风险编号、跟踪者编号、状态描述（风险、问题）、文本描述、跟进时间
    private int statusId;
    private int riskId;
    private int tracerId ;
    private int statusDescriptId;
    private String statusDescript;
    private Date createTime;

    public RiskStatusItem() {
    }

    public RiskStatusItem(int statusId, int riskId, int tracerId, int statusDescriptId, String statusDescript, Date createTime) {
        this.statusId = statusId;
        this.riskId = riskId;
        this.tracerId = tracerId;
        this.statusDescriptId = statusDescriptId;
        this.statusDescript = statusDescript;
        this.createTime = createTime;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getRiskId() {
        return riskId;
    }

    public void setRiskId(int riskId) {
        this.riskId = riskId;
    }

    public int getTracerId() {
        return tracerId;
    }

    public void setTracerId(int tracerId) {
        this.tracerId = tracerId;
    }

    public int getStatusDescriptId() {
        return statusDescriptId;
    }

    public void setStatusDescriptId(int statusDescriptId) {
        this.statusDescriptId = statusDescriptId;
    }

    public String getStatusDescript() {
        return statusDescript;
    }

    public void setStatusDescript(String statusDescript) {
        this.statusDescript = statusDescript;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RiskStatusItem{" +
                "statusId=" + statusId +
                ", riskId=" + riskId +
                ", tracerId=" + tracerId +
                ", statusDescriptId=" + statusDescriptId +
                ", statusDescript='" + statusDescript + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

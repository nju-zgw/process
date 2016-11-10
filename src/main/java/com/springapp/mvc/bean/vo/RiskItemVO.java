package com.springapp.mvc.bean.vo;

import com.springapp.mvc.bean.RiskStatusItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WH on 2016/11/8.
 */
public class RiskItemVO {
    int riskItemId;
    String riskName;
    int projectId;
    int createrId;
    String createrName;
    int riskTypeId;
    int descriptId;
    String descript;
    int riskProb;
    int riskAffect;

    List<RiskStatusItem> riskStatusList = new ArrayList<>();

    boolean operateSuccess = true;//操作状态结果
    String operateInfo;//操作结果信息


    public int getRiskItemId() {
        return riskItemId;
    }

    public void setRiskItemId(int riskItemId) {
        this.riskItemId = riskItemId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getCreaterId() {
        return createrId;
    }

    public void setCreaterId(int createrId) {
        this.createrId = createrId;
    }

    public int getRiskTypeId() {
        return riskTypeId;
    }

    public void setRiskTypeId(int riskTypeId) {
        this.riskTypeId = riskTypeId;
    }

    public int getDescriptId() {
        return descriptId;
    }

    public void setDescriptId(int descriptId) {
        this.descriptId = descriptId;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getRiskProb() {
        return riskProb;
    }

    public void setRiskProb(int riskProb) {
        this.riskProb = riskProb;
    }

    public int getRiskAffect() {
        return riskAffect;
    }

    public void setRiskAffect(int riskAffect) {
        this.riskAffect = riskAffect;
    }

    public boolean isOperateSuccess() {
        return operateSuccess;
    }

    public void setOperateSuccess(boolean operateSuccess) {
        this.operateSuccess = operateSuccess;
    }

    public String getOperateInfo() {
        return operateInfo;
    }

    public void setOperateInfo(String operateInfo) {
        this.operateInfo = operateInfo;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public List<RiskStatusItem> getRiskStatusList() {
        return riskStatusList;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    @Override
    public String toString() {
        return "RiskItemVO{" +
                "operateSuccess=" + operateSuccess +
                ", operateInfo='" + operateInfo + '\'' +
                ", riskItemId=" + riskItemId +
                ", riskName='" + riskName + '\'' +
                ", projectId=" + projectId +
                ", createrId=" + createrId +
                ", createrName='" + createrName + '\'' +
                ", riskTypeId=" + riskTypeId +
                ", descriptId=" + descriptId +
                ", descript='" + descript + '\'' +
                ", riskProb=" + riskProb +
                ", riskAffect=" + riskAffect +
                '}';
    }
}

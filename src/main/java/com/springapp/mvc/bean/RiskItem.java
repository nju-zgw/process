package com.springapp.mvc.bean;

import java.util.Date;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public class RiskItem {
    //4.风险条目：风险编号（主键）、项目编号、风险提出者编号、风险内容、风险类别（性能风险、进度风险、成本风险.......）
    // 风险概率（高、中、低）、风险影响程度（高、中、低）、建立时间
    private int rid;
    private int projectId;
    private String riskName;
    private String projectName;
    private int createrId;
    private int descriptId;
    private String descript;
    private int typeId;
    private int prob;
    private int affect;
    private Date time;
    private int processed;

    public RiskItem() {
    }

    public RiskItem(int rid, int projectId, int createrId,
                    String descript, int typeId, int prob, int affect) {
        this.rid = rid;
        this.projectId = projectId;
        this.createrId = createrId;
        this.descript = descript;
        this.typeId = typeId;
        this.prob = prob;
        this.affect = affect;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDescriptId() {
        return descriptId;
    }

    public void setDescriptId(int descriptId) {
        this.descriptId = descriptId;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getProb() {
        return prob;
    }

    public void setProb(int prob) {
        this.prob = prob;
    }

    public int getAffect() {
        return affect;
    }

    public void setAffect(int affect) {
        this.affect = affect;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getProcessed() {
        return processed;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "RiskItem{" +
                "rid=" + rid +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", createrId=" + createrId +
                ", descriptId=" + descriptId +
                ", descript='" + descript + '\'' +
                ", typeId=" + typeId +
                ", prob=" + prob +
                ", affect=" + affect +
                ", time=" + time +
                '}';
    }
}

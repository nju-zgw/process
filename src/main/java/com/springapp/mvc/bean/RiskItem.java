package com.springapp.mvc.bean;

import java.util.Date;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public class RiskItem {
    //4.风险条目：风险编号（主键）、项目编号、风险提出者编号、风险内容、风险类别（性能风险、进度风险、成本风险.......）
    // 风险概率（高、中、低）、风险影响程度（高、中、低）、建立时间
    private long rid;
    private long pid;
    private long uid;
    private String content;
    private String type;
    private String probability;
    private String influence;
    private Date time;
    public RiskItem(long rid, long pid, long uid, String content, String type, String probability, String influence, Date time) {
        this.rid = rid;
        this.pid = pid;
        this.uid = uid;
        this.content = content;
        this.type = type;
        this.probability = probability;
        this.influence = influence;
        this.time = time;
    }

    public  long   getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }



}

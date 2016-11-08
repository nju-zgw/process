package com.springapp.mvc.bean;

import java.util.Date;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public class RiskStatusItem {
    //风险状态：状态编号（主键）、风险编号、跟踪者编号、状态描述（风险、问题）、文本描述、跟进时间
    private int id;
    private long rid;
    private long uid;
    private String status;
    private String content;
    private Date time;

    /**
     *
     * @param id
     * @param rid
     * @param uid
     * @param status
     * @param content
     * @param time
     */
    public RiskStatusItem(int id, long rid, long uid, String status, String content, Date time) {
        this.id = id;
        this.rid = rid;
        this.uid = uid;
        this.status = status;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }





}

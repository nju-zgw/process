package com.springapp.mvc.bean;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class RiskStatusItemView {
    private String time;
    private String content;
    private String status;
    private String username;
    private String acceptname;


    public RiskStatusItemView() {


    }

    public RiskStatusItemView(String time, String content, String status, String username) {
        this.time = time;
        this.content = content;
        this.status = status;
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getAcceptname() {
        return acceptname;
    }

    public void setAcceptname(String acceptname) {
        this.acceptname = acceptname;
    }
}

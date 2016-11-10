package com.springapp.mvc.bean;

/**
 * Created by H77 on 2016/11/10 0010.
 */
public class MessageView {



    String risk;
    String user;
    String status;
    String time;

    public MessageView(){

    }
    public MessageView(String risk, String user, String status, String time) {
        this.risk = risk;
        this.user = user;
        this.status = status;
        this.time = time;
    }
    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

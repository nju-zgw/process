package com.springapp.mvc.bean;

import java.sql.Date;

/**
 * Created by H77 on 2016/11/7 0007.
 * Modified bu njuyuanrui on 2016/11/9
 */
public class Project {
     //项目： 项目编号（主键）、项目名、项目描述、项目主管id、项目状态
     //项目开始时间
     //用户__项目：项目编号、用户编号、加入时间
     private long pid;
     private int uid;
     private String name;
     private String content;
     private String status;
     private Date startTime;
     private int progress;
     private int bugNum;

     public Project(long pid, int uid, String name, String content, String status, Date startTime,int progress, int bugnum) {
          this.pid = pid;
          this.uid = uid;
          this.name = name;
          this.content = content;
          this.status = status;
          this.startTime = startTime;
          this.progress = progress;
          this.bugNum = bugnum;
     }

     public Project(long pid) {
          this.pid = pid;
     }

     public long getPid() {
          return pid;
     }

     public void setPid(long pid) {
          this.pid = pid;
     }

     public int getUid() {
          return uid;
     }

     public void setUid(int uid) {
          this.uid = uid;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
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

     public Date getStartTime() {
          return startTime;
     }

     public void setStartTime(Date startTime) {
          this.startTime = startTime;
     }

     public int getProgress() {
          return progress;
     }

     public void setProgress(int progress) {
          this.progress = progress;
     }

     public int getBugNum() {
          return bugNum;
     }

     public void setBugNum(int bugNum) {
          this.bugNum = bugNum;
     }
}

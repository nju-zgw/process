package com.springapp.mvc.bean;

import java.util.Date;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public class Project {
     //项目： 项目编号（主键）、项目名、项目描述、项目主管id、项目状态
     //项目开始时间
     //用户__项目：项目编号、用户编号、加入时间
     private long pid;
     private long uid;
     private String name;
     private String content;
     private String status;
     private Date startTime;

     public Project(long pid, long uid, String name, String content, String status, Date startTime) {
          this.pid = pid;
          this.uid = uid;
          this.name = name;
          this.content = content;
          this.status = status;
          this.startTime = startTime;
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

     public long getUid() {
          return uid;
     }

     public void setUid(long uid) {
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

}

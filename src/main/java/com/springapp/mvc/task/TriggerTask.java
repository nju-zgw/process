package com.springapp.mvc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.sql.Date;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */
@Component
public class TriggerTask {


    @Scheduled(cron="* * * * * ?")
    public void trigger() throws ServletException {
        System.out.println("test schdule"+new Date(new java.util.Date().getTime()));
    }
}

package com.springapp.mvc.task;

import com.springapp.mvc.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TriggerService triggerService;

    @Scheduled(cron="*/10 * * * * ?")
    public void trigger() throws ServletException {
        System.out.println("test schdule"+new Date(new java.util.Date().getTime()));
        triggerService.trigger(new Date(new java.util.Date().getTime()));
    }
}

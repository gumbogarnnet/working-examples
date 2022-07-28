/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.quart81.controller;

import com.example.quart81.dto.EmailRequest;
import com.example.quart81.dto.EmailResponse;
import com.example.quart81.quartz.EmailJob;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author G Gumbo
 */
@Slf4j
@RestController
public class EmailSchedulerController {
    
    @Autowired
    private Scheduler scheduler;
    
    @PostMapping("schedule/email")
    public ResponseEntity<EmailResponse> scheduleEmail(@Valid @RequestBody EmailRequest emailRequest) {
        try {
            ZonedDateTime dateTime = ZonedDateTime.of(emailRequest.getDateTime(), emailRequest.getTimeZone());
            if (dateTime.isBefore(ZonedDateTime.now())) {
                EmailResponse emailResponse = new EmailResponse(false, "Error while scheduling email.please try again later!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
                
            }
            JobDetail jobDetail = buildjobDetail(emailRequest);
            Trigger trigger = buildTrigger(jobDetail, dateTime);
            scheduler.scheduleJob(jobDetail, trigger);
            
            EmailResponse emailResponse = new EmailResponse(true, jobDetail.getKey().getName(), jobDetail.getKey().getGroup(), "Email scheduled successfully");
            log.info("Response{}", emailResponse);
            return ResponseEntity.ok(emailResponse);
            
        } catch (SchedulerException schedulerException) {
            log.error("Error while scheduling email", schedulerException);
            EmailResponse emailResponse = new EmailResponse(false, "Error while scheduling email.please try again later!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
        }
    }
    
    private JobDetail buildjobDetail(EmailRequest emailRequest) {
        JobDataMap jobDataMap = new JobDataMap();
        
        jobDataMap.put("email", emailRequest.getEmail());
        jobDataMap.put("subject", emailRequest.getSubject());
        jobDataMap.put("body", emailRequest.getBody());
        
        return JobBuilder.newJob(EmailJob.class)
                .withDescription("Send Email Job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .withIdentity(UUID.randomUUID().toString(), "email-jods")
                .storeDurably()
                .build();
        
    }
    
    private Trigger buildTrigger(JobDetail detail, ZonedDateTime startAt) {
        return TriggerBuilder.newTrigger()
                .forJob(detail)
                .withIdentity(detail.getKey().getName(), "email-triggers")
                .withDescription("Send Email Trigger")
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }
    
}

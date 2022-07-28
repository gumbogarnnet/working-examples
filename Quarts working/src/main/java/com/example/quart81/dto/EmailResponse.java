/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.quart81.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author G Gumbo
 */

public class EmailResponse {

    private boolean success;
    private String jobid;
    private String jobgroup;
    private String message;

    public EmailResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public EmailResponse(boolean success, String jobid, String jobgroup, String message) {
        this.success = success;
        this.jobid = jobid;
        this.jobgroup = jobgroup;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "EmailResponse{" + "success=" + success + ", jobid=" + jobid + ", jobgroup=" + jobgroup + ", message=" + message + '}';
    }
    

}

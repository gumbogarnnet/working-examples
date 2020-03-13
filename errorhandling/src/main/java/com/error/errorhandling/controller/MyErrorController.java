/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.error.errorhandling.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author garnnet
 */
@Controller
public class MyErrorController implements ErrorController{
    
    @RequestMapping("/error")
    public String handleError() {
        
        return "error";
    }
    @RequestMapping("/")
    public String noError() {
        
        return "noerror";
    }

    @Override
    public String getErrorPath() {
         return "/error";
    }
  
}

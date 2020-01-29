/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author garnnet
 */
@org.springframework.stereotype.Controller
public class Controller {
    
   @RequestMapping("/")
    public String home(){
        
        return "home";
    
    }
     @RequestMapping("/home")
    public String homepage(){
        
        return "home";
    
    }
     @RequestMapping("/hello")
    public String hello(){
        
        return "hello";
    
    }
     @RequestMapping("/login")
    public String login(){
        
        return "login";
    
    }
    
    
    
}

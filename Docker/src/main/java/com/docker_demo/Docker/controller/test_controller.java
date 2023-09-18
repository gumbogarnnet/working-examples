/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker_demo.Docker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hp
 */
@Controller 
public class test_controller {
    
    @RequestMapping("/")
    @ResponseBody
    public String mytest(){
    return "Hello to Docker app";
    }
    
}

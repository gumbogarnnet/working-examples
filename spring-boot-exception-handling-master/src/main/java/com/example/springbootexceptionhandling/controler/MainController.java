/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springbootexceptionhandling.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author garnnet
 */
@Controller
public class MainController {
    
    @RequestMapping("/")
    public String testthymeleaf(){
    return "home";
    }
    
}

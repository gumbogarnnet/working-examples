/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.traing.starting.code.controller;

import com.traing.starting.code.model.Image;
import com.traing.starting.code.repository.ImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author garnnet
 */
@Controller
public class Con {
    
    @Autowired
    ImageRepository imageRepository;
    
    @RequestMapping("/")
    public String inpage(){
    return "index";
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Image> all(){
    return imageRepository.findAll();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.LibraryController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gumbo
 */
@Controller
public class PageController {
    
    @RequestMapping("/")
    public String homePage(){
    return "library-home";
    }
    @RequestMapping("/member-page")
    public String memberPage(){
    return "member-page";
    }
    @RequestMapping("/book")
    public String bookPage(){
    return "book";
    }
    @RequestMapping("/book-lending")
    public String lendingPage(){
    return "book-lending";
    }
     @RequestMapping("/parallax-template")
    public String About(){
    return "parallax-template";
    }
    @RequestMapping("/library-home")
    public String Library(){
    return "library-home";
    }
    
    
    
}

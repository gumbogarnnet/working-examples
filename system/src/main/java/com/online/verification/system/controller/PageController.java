/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.verification.system.controller;

import com.online.verification.system.entity.User;
import com.online.verification.system.service.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ggumbo
 */
@Controller
@Slf4j
public class PageController {

    @Autowired
    UserDao userDao;

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("profile")
    public String profile(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userDao.findByUserName(username);

        log.error("Principal" + username);
        model.addAttribute("name", user.getFirstName());
        model.addAttribute("username", username);
        return "profile";
    }

    @GetMapping("preliminary_examination")
    public String preliminary_examination() {
        return "preliminary_examination";
    }

    @GetMapping("final_examination")
    public String final_examination() {
        return "final_examination";
    }

    @GetMapping("diagram")
    public String diagram() {
        return "diagram";
    }

    @GetMapping("field_notes")
    public String fieldNotes() {
        return "field_notes";
    }

    @GetMapping("working_plan")
    public String workingPlan() {
        return "working_plan";
    }

    @GetMapping("survey_records_manager")
    public String surveyRecordsManager() {
        return "survey_records_manager";
    }

    @GetMapping("edit-project")
    public String editProject() {
        return "edit-project";
    }

    @GetMapping("examine_survey_records")
    public String examineSurveyRecords() {
        return "examine_survey_records";
    }

    @GetMapping("")
    public String dashboard1() {
        return "dashboard";
    }

    @GetMapping("home")
    public String dashboard2() {
        return "dashboard";
    }

    @GetMapping("/")
    public String dashboard3() {
        return "dashboard";
    }

    @GetMapping("/create-project")
    public String createProject() {
        return "create-project";
    }

    @GetMapping("/create-project_1")
    public String createProject1() {
        return "create-project_1";
    }

    @GetMapping("/sign-up.html")
    public String signUp1() {
        return "sign-up";
    }

    @GetMapping("/user-management")
    public String user_management() {
        return "user_management";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/sign-up")
    public String signUp() {
        return "sign-up";
    }

}

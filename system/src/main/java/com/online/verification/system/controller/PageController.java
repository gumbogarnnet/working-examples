/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.verification.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ggumbo
 */
@Controller
public class PageController {

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
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

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/sign-up")
    public String signUp() {
        return "sign-up";
    }

}

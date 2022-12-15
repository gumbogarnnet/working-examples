/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastore.lesley_gumbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ggumbo
 */
@Controller
public class PageController {

    @RequestMapping("/home")
    public String homePage() {
        return "index";
    }
    @RequestMapping("/Field_Book")
    public String FieldBook() {
        return "Field_Book";
    }
    @RequestMapping("/Verify_details")
    public String Verify_details() {
        return "Verify_details";
    }
    @RequestMapping("/view_record")
    public String viewRecord() {
        return "view_record";
    }

    @RequestMapping("/")
    public String imdex1() {
        return "index";
    }

    @RequestMapping("")
    public String imdex2() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/upload_records")
    public String uploadRcords() {
        return "upload_records";
    }
//    @RequestMapping("/login.html")
//    public String loginhtml() {
//        return "login";
//    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }

    @RequestMapping("/track_survey_record")
    public String trackSurveyRecords() {
        return "track_survey_record";

    }

    @RequestMapping("/add_map_data")
    public String addMapData() {
        return "add_map_data";

    }

    @RequestMapping("/download_reports")
    public String downloadReports() {
        return "download_reports";
    }

    @RequestMapping("/manage_record")
    public String manageRecord() {
        return "manage_record";
    }
    @RequestMapping("/adddistrictpage")
    public String addDistrictpage() {
        return "add_district";
    }

    @RequestMapping("/edit_record")
    public String editRecord(@RequestParam Integer id) {
        return "edit_record";
    }

}

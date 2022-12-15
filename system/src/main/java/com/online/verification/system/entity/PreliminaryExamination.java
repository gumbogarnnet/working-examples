/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.verification.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author ggumbo
 */
@Entity
@Data
public class PreliminaryExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = 0;
    private Long recordId = 0l;
    private String pe1;
    private String pe2;
    private String pe3;
    private String pe4;
    private String pe5;
    private String pe6;
    private String pe7;
    private String pe8;
    private String pe9;
    private String pe10;
    private String pe11;
    private String pe12;
    private String pe13;
    private String pe14;
    private String pe15;
    private String pe16;
    private String pe17;
    private String pe18;
    private String pe19;
    private String pe20;
    private String pe22;
    private String pe21;
    private String district;
    private String purposeOfSurvey;
    private String remarks;
}

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
public class FinalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = 0;
    private Long recordId = 0l;
    private String fe1 ;
    private String fe2 ;
    private String fe3 ;
    private String fe4 ;
    private String fe5 ;
    private String fe6 ;
    private String fe7 ;
    private String fe8 ;
    private String fe9 ;
    private String fe10 ;
    private String fe11 ;
    private String fe12 ;
    private String fe13 ;
    private String fe14;
    private String fe15 ;
    private String fe16 ;
  
}

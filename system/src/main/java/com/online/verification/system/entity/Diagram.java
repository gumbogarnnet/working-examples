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
public class Diagram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long recordId;
    private Boolean d1;
    private Boolean d2;
    private Boolean d3;
    private Boolean d4;
    private Boolean d5;
    private Boolean d6;
    private Boolean d8;
    private Boolean d7;
    private Boolean d9;
    private Boolean d10;

}

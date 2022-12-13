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
public class WorkPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long recordId;
    private Boolean wp1;
    private Boolean wp2;
    private Boolean wp3;
    private Boolean wp4;
    private Boolean wp5;
    private Boolean wp6;
    private Boolean wp8;
    private Boolean wp7;
    private Boolean wp9;
    private Boolean wp10;

}

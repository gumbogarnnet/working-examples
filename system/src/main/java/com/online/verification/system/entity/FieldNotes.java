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
public class FieldNotes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = 0;
    private Long recordId = 0l;
    private Boolean fn1 = Boolean.FALSE;
    private Boolean fn2 = Boolean.FALSE;
    private Boolean fn3 = Boolean.FALSE;
    private Boolean fn4 = Boolean.FALSE;
    private Boolean fn5 = Boolean.FALSE;
    private Boolean fn6 = Boolean.FALSE;
    private Boolean fn8 = Boolean.FALSE;
    private Boolean fn7 = Boolean.FALSE;
    private Boolean fn9 = Boolean.FALSE;
    private Boolean fn10 = Boolean.FALSE;

}

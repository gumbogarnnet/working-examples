/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastore.lesley_gumbo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ggumbo
 */
@Entity
@Data
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User landSurveyor;
    private String assistant;
    private String secondAssistant;
       private String comments;
    private String surveyOf;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;
    private String purpose;
 
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateUploaded;
    private Integer diagramNumber;
    @Lob
    private byte[] beacon;

    private String beaconName;

    private String beaconType;

    @Lob
    private byte[] permit;
    private String permitName;

    private String permitType;
    @Lob
    private byte[] certificate;
    private String certificateName;

    private String certificateType;
    @Lob
    private byte[] Instruments;
    private String InstrumentsName;

    private String InstrumentsType;

}

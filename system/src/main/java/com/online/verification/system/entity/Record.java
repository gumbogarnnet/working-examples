package com.online.verification.system.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.online.verification.system.service.DDao;
import com.online.verification.system.service.FnDao;
import com.online.verification.system.service.WkDao;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ggumbo
 */
@Entity
@Data
@Slf4j
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String landSurveyor;
    private String assistant;
    private String secondAssistant;
    private String comments;
    private String surveyOf;
    private String district;
    private String purpose;
    private String status = "PENDING";

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateUploaded;

    private Integer diagramNumber;

    @Transient
    private Integer percentage = 0;

    public Record() {
        log.error("constructor");
    }

    public Record(Diagram diagram, Record record, FieldNotes fieldNotes,WorkPlan workPlan) {
        int counter = 0;
        log.error("We are here");

        this.id = record.getId();
        this.landSurveyor = record.getLandSurveyor();
        this.assistant = record.getAssistant();
        this.secondAssistant = record.getSecondAssistant();
        this.comments = record.getComments();
        this.surveyOf = record.getSurveyOf();
        this.district = record.getDistrict();
        this.purpose = record.getPurpose();
        this.dateUploaded = record.getDateUploaded();
        this.diagramNumber = record.getDiagramNumber();
        if (diagram == null || fieldNotes == null || workPlan == null) {
            return;
        }
        if (diagram.getD1() != null && diagram.getD1()) {
            counter++;
        }
        if (diagram.getD2() != null && diagram.getD2()) {
            counter++;
        }
        if (diagram.getD3() != null && diagram.getD3()) {
            counter++;
        }
        if (diagram.getD4() != null && diagram.getD4()) {
            counter++;
        }
        if (diagram.getD5() != null && diagram.getD5()) {
            counter++;
        }
        if (diagram.getD6() != null && diagram.getD6()) {
            counter++;
        }
        if (diagram.getD7() != null && diagram.getD7()) {
            counter++;
        }
        if (diagram.getD8() != null && diagram.getD8()) {
            counter++;
        }
        if (diagram.getD9() != null && diagram.getD9()) {
            counter++;
        }
        if (diagram.getD10() != null && diagram.getD10()) {
            counter++;
        }
        if (fieldNotes.getFn1() != null && fieldNotes.getFn1()) {
            counter++;
        }
        if (fieldNotes.getFn2() != null && fieldNotes.getFn2()) {
            counter++;
        }
        if (fieldNotes.getFn3() != null && fieldNotes.getFn3()) {
            counter++;
        }
        if (fieldNotes.getFn4() != null && fieldNotes.getFn4()) {
            counter++;
        }
        if (fieldNotes.getFn5() != null && fieldNotes.getFn5()) {
            counter++;
        }
        if (fieldNotes.getFn6() != null && fieldNotes.getFn6()) {
            counter++;
        }
        if (fieldNotes.getFn7() != null && fieldNotes.getFn7()) {
            counter++;
        }
        if (fieldNotes.getFn8() != null && fieldNotes.getFn8()) {
            counter++;
        }
        if (fieldNotes.getFn9() != null && fieldNotes.getFn9()) {
            counter++;
        }
        if (fieldNotes.getFn10() != null && fieldNotes.getFn10()) {
            counter++;
        }
        if (workPlan.getWp1() != null && workPlan.getWp1()) {
            counter++;
        }
        if (workPlan.getWp2() != null && workPlan.getWp2()) {
            counter++;
        }
        if (workPlan.getWp3() != null && workPlan.getWp3()) {
            counter++;
        }
        if (workPlan.getWp4() != null && workPlan.getWp4()) {
            counter++;
        }
        if (workPlan.getWp5() != null && workPlan.getWp5()) {
            counter++;
        }
        if (workPlan.getWp6() != null && workPlan.getWp6()) {
            counter++;
        }
        if (workPlan.getWp7() != null && workPlan.getWp7()) {
            counter++;
        }
        if (workPlan.getWp8() != null && workPlan.getWp8()) {
            counter++;
        }
        if (workPlan.getWp9() != null && workPlan.getWp9()) {
            counter++;
        }
        if (workPlan.getWp10() != null && workPlan.getWp10()) {
            counter++;
        }
        this.percentage = (counter * 100) / 30;

        this.percentage = Math.round(this.percentage / 10) * 10;
        if (percentage < 100) {
            this.status = "Looks Good";
        }
        if (percentage < 70) {
            this.status = " Good";
        }
        if (percentage < 50) {
            this.status = "Average";
        }
        if (percentage < 50) {
            this.status = "Bad";
        }
        

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Gumbo
 */
@Entity
@Data
public class Member  {
    
    @Id    
    private String idNumber;
   @ManyToMany(mappedBy = "member")
    @JsonBackReference
    private List<BookIssue> bookIssue;
    private String name;
    private String address;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date membershipIssueDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfExpiry;
    private String status;
    private String membershipType;
    private Integer amount;
//    @OneToOne(mappedBy = "member")
//    private BookIssue bookIssue;
    
    
}

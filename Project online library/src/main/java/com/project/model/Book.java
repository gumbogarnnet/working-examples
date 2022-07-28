/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Book {
   
    @Id
    private String bookCode;
    private String bookName;
    @ManyToMany(mappedBy = "book")
    @JsonBackReference
    private List<BookIssue> bookIssue;
   
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfArrival;
    private Integer price;
    private String rackNumber;
    private Integer quantity;
    private String subject_code;
 @ManyToMany(fetch = FetchType.LAZY,
            cascade={CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH}
               )
    @JoinTable(name="author_book",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="author_id"))
  
  
    private List<Author> authors;
    public void addAuthor(Author author) {
        if (authors == null){
               authors= new ArrayList<>();
               
        }
        authors.add(author);
    }
    
    
    
}

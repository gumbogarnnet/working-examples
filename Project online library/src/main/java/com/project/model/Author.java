/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 *
 * @author Gumbo
 */
@Data
@Entity
public class Author {
    
      @Id
    private String idNumber;
    private String name;
    private String qualifications;
    @ManyToMany(fetch=FetchType.LAZY,
            cascade={CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH}
               )
    @JoinTable(name="author_book",
            joinColumns=@JoinColumn(name="author_id"),
            inverseJoinColumns=@JoinColumn(name="book_id"))
      @JsonBackReference
     
    private List<Book> books;
    
     public void addBook(Book book) {
        if (books == null){
               books= new ArrayList<>();
               
        }
        books.add(book);
    }

    
}

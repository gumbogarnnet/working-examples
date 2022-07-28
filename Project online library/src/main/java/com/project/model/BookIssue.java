/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 *
 * @author Gumbo
 */
@Entity
@Data
public class BookIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
  
    @ManyToMany( fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "issue_member", 
            joinColumns = @JoinColumn(name = "book_issue_id"), 
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private List<Member> member;
    
    
    @ManyToMany( fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "issue_book", 
            joinColumns = @JoinColumn(name = "book_issue_id"), 
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> book;
    
    public void addBook(Book books) {
        if (book == null){
               book= new ArrayList<>();
               
        }
        book.add(books);
    }
    public void addMember(Member members) {
        if (member == null){
               member= new ArrayList<>();
               
        }
        member.add(members);
    }
    
    public void removeBook(Book books){
        book.remove(books);
        books.setBookIssue(null);
    }

}

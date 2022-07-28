/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.LibraryController;

import com.project.model.Author;
import com.project.model.Book;
import com.project.repository.AuthorRepository;
import com.project.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Gumbo
 */
@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    
    @GetMapping("/getallbooks")
    @ResponseBody
    public List<Book> getAllBooks(){      
    return bookRepository.findAll();
    }
     @RequestMapping("/viewbook")
    public String viewBook(@RequestParam String bookCode){
    return "viewbook";
    }
    @PostMapping("/savebook")
    public void createBook(@RequestBody Book book){
    bookRepository.save(book);
    }
     @RequestMapping("/searchbook/{bookCode}")
     @ResponseBody
    public Book searchBook(@PathVariable String bookCode){
    return bookRepository.findOne(bookCode);
    }
    @RequestMapping("/bookAuthors/{bookCode}")
     @ResponseBody
    public List<Author> bookAuthors(@PathVariable String bookCode){
    Book book =bookRepository.findOne(bookCode);
    return book.getAuthors();
    }
    @PostMapping("/addAuthor/{bookCode}")
    public void addAuthors(@PathVariable String bookCode, @RequestBody Author author){
        Book book = bookRepository.findOne(bookCode);
        book.getAuthors().add(author);
        bookRepository.save(book);
       
        
    }
    
}

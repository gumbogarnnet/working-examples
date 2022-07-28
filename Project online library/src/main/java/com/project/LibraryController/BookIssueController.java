/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.LibraryController;

import com.project.dto.SaveBookIssueDTO;
import com.project.model.BookIssue;
import com.project.repository.BookIssueRepository;
import com.project.repository.BookRepository;
import com.project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Gumbo
 */
@Controller
@Slf4j
public class BookIssueController {

    @Autowired
    BookIssueRepository bookIssueRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;

//    @PostMapping("/savebookissue")
//    public void saveBookIssue(@RequestBody BookIssue bookIssue) {
//       
//        BookIssue bookissue = new BookIssue();
//        bookissue.setMember(bookIssue.getMember());
//       List<Book> book1 = bookIssue.getBook().stream().map(p -> {
//           return insertRows(p);
//       }).collect(Collectors.toList());
//        
//        log.info("this is our book object" +book1);
//         log.info("this is our bookissue object" +bookIssue);
//
//    }
//     private Book insertRows(Book r) {
//        Book book = new Book();
//        book.setBookCode(r.getBookCode());
//        return book;
//    }
    @PostMapping("/savebookissue")
    public void testsaveBookIssue(@RequestBody SaveBookIssueDTO bookIssueDTO) {
        log.info("this is our book object" + bookIssueDTO);
        String member = bookIssueDTO.getMemberId();
        String book = bookIssueDTO.getBookCode();
        log.info("this is our book object" + member);
        log.info("this is our book object" + book);
        BookIssue bookIssue = new BookIssue();
        bookIssue.addMember(memberRepository.findOne(member));
        bookIssue.addBook(bookRepository.findOne(book));
        bookIssueRepository.save(bookIssue);

    }

    @GetMapping("/getallbookissue")
    @ResponseBody
    public List<BookIssue> getAllBookIssue() {

        return bookIssueRepository.findAll();
    }
    
    @RequestMapping("/testdel")
    public void del(){
   bookIssueRepository.delete(1);
    }

   

}

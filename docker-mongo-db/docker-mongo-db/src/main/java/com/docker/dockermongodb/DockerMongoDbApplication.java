package com.docker.dockermongodb;

import com.docker.dockermongodb.book.Book;
import com.docker.dockermongodb.repo.BookRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class DockerMongoDbApplication {

    @Autowired
    BookRepo bookRepo;
    
    @PostMapping("savebook")
    @ResponseBody
    public Book postBook(@RequestBody Book book ){
    return bookRepo.save(book);
    }
    @GetMapping("getall")
    @ResponseBody
    public List<Book> postBook( ){
    return bookRepo.findAll();
    }
	public static void main(String[] args) {
		SpringApplication.run(DockerMongoDbApplication.class, args);
	}

}

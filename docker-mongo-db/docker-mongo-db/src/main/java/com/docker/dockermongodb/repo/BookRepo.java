/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker.dockermongodb.repo;

import com.docker.dockermongodb.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hp
 */
public interface BookRepo extends MongoRepository<Book, Integer> {
    
}

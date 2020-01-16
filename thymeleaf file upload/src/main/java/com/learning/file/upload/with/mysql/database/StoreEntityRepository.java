/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.file.upload.with.mysql.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author garnnet
 */
@Repository
public interface StoreEntityRepository extends JpaRepository<StoreEntity, Long> {
    
    
}

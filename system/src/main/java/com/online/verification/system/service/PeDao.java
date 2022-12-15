/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.verification.system.service;


import com.online.verification.system.entity.PreliminaryExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ggumbo
 */
@Repository
public interface PeDao extends JpaRepository<PreliminaryExamination, Integer>{

    public PreliminaryExamination findByRecordId(Long m);
    
}

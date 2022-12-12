/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastore.lesley_gumbo.service;

import com.cadastore.lesley_gumbo.entity.District;
import com.cadastore.lesley_gumbo.entity.Record;
import com.cadastore.lesley_gumbo.entity.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ggumbo
 */
@Repository

public interface RecordDao extends JpaRepository<Record, Integer> {

    @Transactional
    public List<Record> findBySurveyOfAndDistrictAndLandSurveyor(String surveyOf, District district, User user);
    public static final String FIND_PROJECTS = "select id,beacon from record where id=2";

    @Query(value = FIND_PROJECTS, nativeQuery = true)
    public List<Object[]> findProjects();

}

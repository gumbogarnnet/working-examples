package com.online.verification.system.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.online.verification.system.entity.Record;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ggumbo
 */
@Repository

public interface RecordDao extends JpaRepository<Record, Integer> {

    public List<Record> findByLandSurveyorAndSurveyOfAndDistrict(String landSurveyor, String surveyOf, String district);

//    @Transactional
//    public List<Record> findBySurveyOfAndDistrictAndLandSurveyor(String surveyOf, District district, User user);
//    public static final String FIND_PROJECTS = "select id,beacon from record where id=2";
//
//    @Query(value = FIND_PROJECTS, nativeQuery = true)
//    public List<Object[]> findProjects();

    public List<Record> findByLandSurveyorAndDateUploadedAndDistrict(String landSurveyor, Date dateUploaded, String district);

}

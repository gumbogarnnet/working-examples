/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.verification.system.controller;

import com.online.verification.system.entity.Diagram;
import com.online.verification.system.entity.FieldNotes;
import com.online.verification.system.entity.Files;
import com.online.verification.system.entity.Record;
import com.online.verification.system.entity.WorkPlan;
import com.online.verification.system.service.DDao;
import com.online.verification.system.service.FilesDao;
import com.online.verification.system.service.FnDao;
import com.online.verification.system.service.RecordDao;
import com.online.verification.system.service.WkDao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ggumbo
 */
@RestController
@Slf4j
public class RecordController {

    @Autowired
    RecordDao recordDao;
    @Autowired
    FilesDao filesDao;
    @Autowired
    DDao dDao;
    @Autowired
    FnDao fnDao;
    @Autowired
    WkDao wkDao;

    @GetMapping("/download/{id}")
    @Transactional
    public ResponseEntity<Resource> download(@PathVariable Integer id) {

        Files files = filesDao.getOne(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(files.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + files.getFileName() + "\"")
                .body(new ByteArrayResource(files.getFile()));

    }

    @GetMapping("/getfilesbyrecordid/{recordid}")
    public List<Files> getFilesByRecordId(
            @PathVariable Long recordid
    ) {

        List<Files> files = filesDao.findByRecordId(recordid);
        for (Files file : files) {
            file.setFile(null);
        }
        return files;

    }

    @GetMapping("/deletefile/{fileid}")
    public void deletefile(
            @PathVariable Integer fileid
    ) {

        filesDao.deleteById(fileid);

    }

    @GetMapping("/deleteproject/{projectid}")
    public void deleteproject(
            @PathVariable Integer projectid
    ) {

        recordDao.deleteById(projectid);

    }

    @GetMapping("/getrecordsbysearch")
    public List<Record> getRecordsBySearch(
            @RequestParam(required = false) String landSurveyor,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateUploaded,
            @RequestParam(required = false) String district
    ) {

        return recordDao.findByLandSurveyorAndDateUploadedAndDistrict(landSurveyor, dateUploaded, district);

    }

    @GetMapping("/getrecordsbyid/{id}")
    public Record getrecordsbyid(
            @PathVariable Integer id
    ) {
        Optional<Record> record = recordDao.findById(id);
        return record.get();

    }

    @PostMapping("/postrecord")
    public Integer postRecord(
            @RequestParam(required = false) String landSurveyor,
            @RequestParam(required = false) String surveyOf,
            @RequestParam(required = false) String district,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateUploaded
    ) {

        log.info("landSurveyor" + landSurveyor);
        log.info("surveyOf" + surveyOf);
        log.info("district" + district);
        log.info("dateUploaded" + dateUploaded);

        Record record = new Record();
        record.setLandSurveyor(landSurveyor);
        record.setSurveyOf(surveyOf);
        record.setDistrict(district);
        record.setDateUploaded(dateUploaded);
        log.info("record" + record);
        recordDao.save(record);

        return record.getId();
    }

    @PostMapping("/posteditrecord")
    public Integer posteditrecord(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String landSurveyor,
            @RequestParam(required = false) String surveyOf,
            @RequestParam(required = false) String district,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateUploaded
    ) {

        Record record = new Record();
        record.setId(id);
        record.setLandSurveyor(landSurveyor);
        record.setSurveyOf(surveyOf);
        record.setDistrict(district);
        record.setDateUploaded(dateUploaded);
        log.info("record" + record);
        recordDao.save(record);

        return record.getId();
    }

    @PostMapping("/create-project/{id}")
    public String createProject(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
        Files files = new Files();
        files.setFile(file.getBytes());
        files.setFileName(file.getOriginalFilename());
        files.setFileType(file.getContentType());
        files.setRecordId(id);
        filesDao.save(files);
        return file.getOriginalFilename();
    }

    @GetMapping("getallrecords")
    public List<Record> getAllRecords() {
        List<Record> records = recordDao.findAll();
        if (records == null) {
            return null;
        }
        return records.stream().map(r -> new Record(dDao.findByRecordId(r.getId()), r, fnDao.findByRecordId(r.getId().longValue()),wkDao.findByRecordId(r.getId()))).collect(Collectors.toList());

    }

    @GetMapping("getfieldnotes/{recordid}")
    public FieldNotes getfieldnotes(@PathVariable Integer recordid) {
        FieldNotes fieldNotes = fnDao.findByRecordId(recordid.longValue());
        return fieldNotes == null ? new FieldNotes() : fieldNotes;
    }

    @PostMapping("postfieldnotes")
    public FieldNotes postfieldnotes(@RequestBody FieldNotes fn) {
        return fnDao.save(fn);
    }

    @GetMapping("getdiagram/{recordid}")
    public Diagram getdiagram(@PathVariable Integer recordid) {
        Diagram diagram = dDao.findByRecordId(recordid.longValue());
        return diagram == null ? new Diagram() : diagram;
    }

    @PostMapping("postdiagram")
    public Diagram postdiagram(@RequestBody Diagram d) {
        return dDao.save(d);
    }

    @GetMapping("getworkplan/{recordid}")
    public WorkPlan getworkplan(@PathVariable Integer recordid) {
        WorkPlan wp = wkDao.findByRecordId(recordid.longValue());
        return wp == null ? new WorkPlan() : wp;
    }

    @PostMapping("postworkplan")
    public WorkPlan postworkplan(@RequestBody WorkPlan wp) {
        return wkDao.save(wp);
    }

}

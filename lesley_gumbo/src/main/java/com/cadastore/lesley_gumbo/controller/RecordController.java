/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastore.lesley_gumbo.controller;

import com.cadastore.lesley_gumbo.entity.District;
import com.cadastore.lesley_gumbo.entity.Record;
import com.cadastore.lesley_gumbo.entity.User;
import com.cadastore.lesley_gumbo.service.DistrictDao;
import com.cadastore.lesley_gumbo.service.RecordDao;
import com.cadastore.lesley_gumbo.service.UserDao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    UserDao userDao;
    @Autowired
    DistrictDao districtDao;

    @PostMapping("/postrecord")
    public String postRecord(@RequestParam("file") MultipartFile[] file,
            @RequestParam(required = false) Integer landSurveyorId,
            @RequestParam(required = false) String assistant,
            @RequestParam(required = false) String secondAssistant,
            @RequestParam(required = false) String surveyOf,
            @RequestParam(required = false) Integer districtId,
            @RequestParam(required = false) String purpose,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateUploaded,
            @RequestParam(required = false) Integer diagramNumber
    //            @RequestParam byte[] beacon,
    //            @RequestParam byte[] permit,
    //            @RequestParam byte[] certificate,
    //            @RequestParam byte[] Instruments
    ) throws IOException {

        Record record = new Record();
        record.setLandSurveyor(userDao.getById(landSurveyorId));
        record.setAssistant(assistant);
        record.setSurveyOf(surveyOf);
        record.setSecondAssistant(secondAssistant);
        record.setDistrict(districtDao.getById(districtId));
        record.setPurpose(purpose);
        record.setComments(comments);
        record.setDateUploaded(dateUploaded);
        record.setDiagramNumber(diagramNumber);

        for (int i = 0; i < file.length; i++) {
            if (i == 0) {
                record.setBeacon(file[i].getBytes());
                record.setBeaconName(file[i].getOriginalFilename());
                record.setBeaconType(file[i].getContentType());

            }
            if (i == 1) {
                record.setPermit(file[i].getBytes());
                record.setPermitName(file[i].getOriginalFilename());
                record.setPermitType(file[i].getContentType());

            }
            if (i == 2) {
                record.setInstruments(file[i].getBytes());
                record.setInstrumentsName(file[i].getOriginalFilename());
                record.setInstrumentsType(file[i].getContentType());

            }
            if (i == 3) {
                record.setCertificate(file[i].getBytes());
                record.setCertificateName(file[i].getOriginalFilename());
                record.setCertificateType(file[i].getContentType());
            }

        }

        recordDao.save(record);

        return "saved";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = false) Integer id) {
        recordDao.deleteById(id);
        return "Record Deleted";
    }

    @GetMapping("/editrecord")
    @Transactional
    public String editRecord(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) Integer landSurveyorId,
            @RequestParam(required = false) String assistant,
            @RequestParam(required = false) String secondAssistant,
            @RequestParam(required = false) String surveyOf,
            @RequestParam(required = false) Integer districtId,
            @RequestParam(required = false) String purpose,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateUploaded,
            @RequestParam(required = false) Integer diagramNumber
    ) throws IOException {

        log.error("=================" + assistant);
        Record record = recordDao.getById(id);
        record.setId(id);
        record.setLandSurveyor(userDao.getById(landSurveyorId));
        record.setAssistant(assistant);
        record.setSurveyOf(surveyOf);
        record.setSecondAssistant(secondAssistant);
        record.setDistrict(districtDao.getById(districtId));
        record.setPurpose(purpose);
        record.setComments(comments);
        record.setDateUploaded(dateUploaded);
        record.setDiagramNumber(diagramNumber);

        recordDao.save(record);

        return "saved";
    }

    @GetMapping("/getallrecords")
    public List<RecordDto> getAllRecords() {
        List<Record> records = recordDao.findAll();
        return records.stream().map(l -> new RecordDto(l.getId(), l.getSurveyOf(), l.getLandSurveyor() == null ? null : l.getLandSurveyor().getFirstName(), l.getDistrict() == null ? null : l.getDistrict().getName(), l.getDateUploaded(), l.getDiagramNumber())).collect(Collectors.toList());

    }

    @GetMapping("/searchrecord")
    public List<RecordDto> searchRecords(@RequestParam(required = false) String surveyOf,
            @RequestParam(required = false) Integer districtId,
            @RequestParam(required = false) Integer landSurveyorId) {
        District district = districtDao.getById(districtId);
        User user = userDao.getById(landSurveyorId);
//       findByEmailAddressAndLastname 
        List<Record> records = recordDao.findBySurveyOfAndDistrictAndLandSurveyor(surveyOf, district, user);
        if (records.isEmpty()) {
            return null;
        }
        return records.stream().map(l -> new RecordDto(l.getId(), l.getSurveyOf(), l.getLandSurveyor() == null ? null : l.getLandSurveyor().getFirstName(), l.getDistrict() == null ? null : l.getDistrict().getName(), l.getDateUploaded(), l.getDiagramNumber())).collect(Collectors.toList());

    }

    @GetMapping("/download")
    @Transactional
    public ResponseEntity<Resource> download(@RequestParam Integer id, @RequestParam String type) {

        Record record = recordDao.getOne(id);
        if (type.equals("Permit")) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(record.getPermitType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + record.getPermitName()+ "\"")
                    .body(new ByteArrayResource(record.getBeacon()));
        }
        if (type.equals("Beacon")) {

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(record.getBeaconType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + record.getBeaconName() + "\"")
                    .body(new ByteArrayResource(record.getBeacon()));
        }
        if (type.equals("Certificate")) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(record.getCertificateType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + record.getCertificateName()+ "\"")
                    .body(new ByteArrayResource(record.getBeacon()));
        }
        if (type.equals("Instruments")) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(record.getInstrumentsType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + record.getInstrumentsName()+ "\"")
                    .body(new ByteArrayResource(record.getBeacon()));
        }
        return null;
    }

    @GetMapping("/getrecordbyid")
    @Transactional
    public RecordDto getRecordById(@RequestParam(required = false) Integer id) {
        Record record = recordDao.getById(id);
        if (record == null) {
            return null;
        }
        return new RecordDto(record.getId(), record.getSurveyOf(), record.getLandSurveyor().getId(), record.getLandSurveyor().getFirstName(), record.getDistrict().getId(), record.getDistrict().getName(), record.getDateUploaded(), record.getDiagramNumber(), record.getBeaconName(), record.getPermitName(), record.getCertificateName(), record.getInstrumentsName(), record.getAssistant(), record.getSecondAssistant(), record.getComments(), record.getPurpose());

    }

    static class RecordDto {

        public int id;
        public String surveyOf;
        public Integer landSurveyorId;
        public String landSurveyor;
        public Integer districtId;
        public String district;
        public Date dateUploaded;
        public Integer diagramNumber;
        public String beaconName;
        public String permitName;
        public String certificateName;
        public String InstrumentsName;
        public String assistant;
        public String secondAssistant;
        public String comments;
        public String purpose;

        public RecordDto(String surveyOf, String landSurveyor, String district, Date dateUploaded, Integer diagramNumber) {
            this.surveyOf = surveyOf;
            this.landSurveyor = landSurveyor;
            this.district = district;
            this.dateUploaded = dateUploaded;
            this.diagramNumber = diagramNumber;
        }

        public RecordDto(int id, String surveyOf, String landSurveyor, String district, Date dateUploaded, Integer diagramNumber) {
            this.id = id;
            this.surveyOf = surveyOf;
            this.landSurveyor = landSurveyor;
            this.district = district;
            this.dateUploaded = dateUploaded;
            this.diagramNumber = diagramNumber;
        }

        public RecordDto(int id, String surveyOf, Integer landSurveyorId, String landSurveyor, Integer districtId, String district, Date dateUploaded, Integer diagramNumber, String beaconName, String permitName, String certificateName, String InstrumentsName, String assistant, String secondAssistant, String comments, String purpose) {
            this.id = id;
            this.surveyOf = surveyOf;
            this.landSurveyorId = landSurveyorId;
            this.landSurveyor = landSurveyor;
            this.districtId = districtId;
            this.district = district;
            this.dateUploaded = dateUploaded;
            this.diagramNumber = diagramNumber;
            this.beaconName = beaconName;
            this.permitName = permitName;
            this.certificateName = certificateName;
            this.InstrumentsName = InstrumentsName;
            this.assistant = assistant;
            this.secondAssistant = secondAssistant;
            this.comments = comments;
            this.purpose = purpose;
        }

    }

}

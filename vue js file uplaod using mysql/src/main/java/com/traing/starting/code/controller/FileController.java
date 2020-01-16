package com.traing.starting.code.controller;


import com.traing.starting.code.dto.ImageUploadResponseDto;
import com.traing.starting.code.model.Image;
import com.traing.starting.code.service.ImageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private ImageService imageService;

    @PostMapping("/uploadFile")
    public ImageUploadResponseDto uploadFile(@RequestParam("file") MultipartFile file) {
        Image dbFile = imageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new ImageUploadResponseDto(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
    
     @PostMapping("/test")
    public void test(@RequestParam("file") MultipartFile file) {
       
        imageService.storeFile(file);

        
    }
    

    @PostMapping("/uploadMultipleFiles")
    public List<ImageUploadResponseDto> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Image dbFile = imageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
    

}

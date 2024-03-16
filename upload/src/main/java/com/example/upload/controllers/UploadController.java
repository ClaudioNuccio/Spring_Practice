package com.example.upload.controllers;

import java.io.IOException;

import com.example.upload.entities.UploadEntity;
import com.example.upload.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class UploadController {

    @Autowired
    private UploadRepository uploadRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        UploadEntity newFile = new UploadEntity();
        newFile.setFilename(file.getOriginalFilename());
        newFile.setContentType(file.getContentType());
        newFile.setData(file.getBytes());
        uploadRepository.save(newFile);
        return ResponseEntity.ok("File uploaded successfully!");
    }
}
package com.example.upload.controllers;

import java.io.IOException;

import com.example.upload.entities.UploadEntity;
import com.example.upload.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class DownloadController {

    @Autowired
    private UploadRepository uploadRepository;

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {
        UploadEntity file = uploadRepository.findById(id).orElseThrow();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .header("Content-Disposition", "attachment; filename=\"" + file.getFilename() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }
}
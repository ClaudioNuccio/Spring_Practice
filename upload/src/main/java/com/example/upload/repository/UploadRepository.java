package com.example.upload.repository;

import com.example.upload.entities.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<UploadEntity, Long>{

}
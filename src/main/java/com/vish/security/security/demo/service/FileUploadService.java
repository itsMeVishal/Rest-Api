package com.vish.security.security.demo.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	ResponseEntity<Object> uploadFile(MultipartFile file) throws IOException;

}

package com.vish.security.security.demo.service;

import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.FilterChainProxy.FilterChainValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.vish.security.security.demo.builders.FileModelBuilder;
import com.vish.security.security.demo.entity.FileModel;
import com.vish.security.security.demo.repository.FileRepository;
import com.vish.security.security.demo.validators.FileValidator;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	Logger logger = LogManager.getLogger(FileUploadServiceImpl.class);
	@Autowired
	FileRepository fileRepository;
	
	@Override
	public ResponseEntity<Object> uploadFile(MultipartFile file) throws IOException {
		
		FileModel fileModel = new FileModelBuilder()
							  .setContent(file.getBytes())
							  .setDateUploaded(new Date())
							  .setFileName(file.getOriginalFilename())
							  .setFileSize(file.getSize())
							  .setFileType(file.getContentType())
							  .build();
		//FileValidator.validate(fileModel);
		fileRepository.save(fileModel);		
				//new FileModel(file.getOriginalFilename(),file.getBytes(),file.getSize(),file.getContentType(),new Date());
		
		
		return null;
	}

	
}

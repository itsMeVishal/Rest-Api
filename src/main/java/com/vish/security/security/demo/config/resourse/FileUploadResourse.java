package com.vish.security.security.demo.config.resourse;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vish.security.security.demo.exceptions.FileExceptions;
import com.vish.security.security.demo.service.FileUploadService;
import com.vish.security.security.demo.validators.FileValidator;


@RestController
@RequestMapping(value = "/rest")
public class FileUploadResourse {

	private static String TEMP_SOURSE = "C:\\VISHAL\\Temp Files\\";
	Logger logger = LogManager.getLogger(FileUploadResourse.class);

	@Autowired
	FileUploadService fileUploadService;
	//@Autowired
	FileValidator fileValidator = new FileValidator();
	
	@PostMapping("/upload/")
	private ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file, MultipartHttpServletRequest request,
			HttpServletResponse response) throws IOException, FileExceptions {
		
		if (file.isEmpty() || !fileValidator.validate(file)) {
			logger.error("File content not found or uploaded file is not valid");
			throw new FileExceptions("File content not found or uploaded file is not valid");
		}
		
		logger.info("Uploading file [ " + file.getOriginalFilename() + " ]");
		fileUploadService.uploadFile(file);
		//This is to copy file.
		/*try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(TEMP_SOURSE + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			logger.error("Invalid file content");
		}
		 */
		return new ResponseEntity("File uploaded successfully",HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
}

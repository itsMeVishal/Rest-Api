package com.vish.security.security.demo.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator extends AbstractBaseValidator{

	Logger logger = LogManager.getLogger(FileValidator.class.getName());
	@Override
	public Boolean validate(Object object, RegexRequestMatcher matcher) {
		
		logger.info("Nothing to validate with regEx!!");
		return null;
	}

	@Override
	public Boolean validate(Object object) {
		MultipartFile file = (MultipartFile) object;
		if(file.getContentType().equals("text/plain")
				|| file.getContentType().equals("Application/msword")
				|| file.getContentType().equals("Application/x-msexcel")
				||file.getContentType().equals("application/pdf")
				) {
			logger.info("Data validation successful.");
			return true;
		}
		logger.info("Data validation failed.");
		return false;
	}
}

package com.vish.security.security.demo.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractBaseValidator implements Validator{

	Logger logger = LogManager.getLogger(AbstractBaseValidator.class);
	
	/*@Override
	public Boolean validate(Object object, RegexRequestMatcher matcher) {
		
		return null;
	}

	@Override
	public Boolean validate(Object object) {
		// TODO Auto-generated method stub
		return null;
	}*/

	

	

}

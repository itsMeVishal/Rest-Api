package com.vish.security.security.demo.validators;

import org.springframework.security.web.util.matcher.RegexRequestMatcher;

public interface Validator {

	Boolean validate(Object object,RegexRequestMatcher matcher);
	Boolean validate(Object object);
	
}

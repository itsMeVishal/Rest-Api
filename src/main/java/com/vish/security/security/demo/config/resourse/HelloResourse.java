package com.vish.security.security.demo.config.resourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vish.security.security.demo.service.UserDetailService;

@RestController
@RequestMapping("/rest/hello")
public class HelloResourse {
	@Autowired
	UserDetailService userDetail;
	
    @GetMapping("/")
    public String index() {
    	
        return "Greetings from Spring Boot!" +userDetail.getUserByUsername("George");
    }
    @GetMapping(value = "/json",produces= MediaType.APPLICATION_JSON_VALUE)
    public Hello getJson() {
    	
    	return new Hello("Name","Vishal");
    }
    private class Hello{
    	String title;
    	String value;
    	
		public Hello(String title, String value) {
			super();
			this.title = title;
			this.value = value;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
    	 
    }
}

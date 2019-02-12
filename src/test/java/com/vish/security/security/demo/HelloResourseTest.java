package com.vish.security.security.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.vish.security.security.demo.config.resourse.HelloResourse;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloResourseTest {

	private static Logger logger = LogManager.getLogger(HelloResourse.class.getName());
	private MockMvc mockMvc;
	@InjectMocks
	private HelloResourse helloResourse;
	
	@org.junit.Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(helloResourse).build();
	}
	@Test
	public void testHelloWorld(){
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/rest/hello/"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("Greetings from Spring Boot!"));
		} catch (Exception e) {
			
			logger.error("Error while testing HelloWorld!!"+e);
		}
		
	}
	@Test
	public void testHelloJson() {
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/rest/hello/json").accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Name")))
			.andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("Vishal")))
			.andExpect(MockMvcResultMatchers.jsonPath("$.",Matchers.hasSize(2)))
			
			.andReturn();
			
		} catch (Exception e) {
			
			logger.error("Error while testing testing HelloJson"+e);
		}
	}

}

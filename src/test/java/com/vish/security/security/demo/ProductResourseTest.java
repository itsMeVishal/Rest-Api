package com.vish.security.security.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vish.security.security.demo.config.resourse.ProductResource;
import com.vish.security.security.demo.entity.Product;
import com.vish.security.security.demo.repository.ProductRepository;
import com.vish.security.security.demo.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@Transactional
public class ProductResourseTest {

	
	
	@Autowired
	ProductRepository productRepository;
	@InjectMocks
	ProductResource productResource;
	@Mock
	ProductService productService;
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;

	@Before
	
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		List<Product> products = new ArrayList<>();
		//products.add(new Product(10, "Swift", "Blue"));
		//products.add(new Product(12, "Swift2", "Blue"));
		//Mockito.when(productService.findAll()).thenReturn(products);
	//	Mockito.when(productRepository.findAll()).thenReturn(products).thenCallRealMethod();
		
		productRepository.saveAll(products);
		Product test = productRepository.getOne(10);
		System.out.println("******"+test.getName());
		Assert.assertEquals("Swift", test.getName());
	}
	
	@Test
	public void retriveAllProductsTest() {
		
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/rest/products/").accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$",org.hamcrest.Matchers.hasSize(2)))
			.andDo(MockMvcResultHandlers.print());
			System.out.println(productRepository.findAll().size());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
	}
	@Test
	public void getProductTest() {
		
		List<Product> products = new ArrayList<>();
		//products.add(new Product(10, "Swift", "Blue"));
		//products.add(new Product(12, "Swift2", "Blue"));
		//Mockito.when(productService.findAll()).thenReturn(products);
	//	Mockito.when(productRepository.findAll()).thenReturn(products).thenCallRealMethod();
		productRepository.saveAll(products);
		
		//Product product = new Product(10, "Swift", "Blue");
		//Mockito.when(productService.getProductById(10)).thenReturn((Optional<Product>) Optional.of(product));
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/rest/products/10").accept(MediaType.APPLICATION_JSON_VALUE))
			//.andExpect(MockMvcResultMatchers.jsonPath("$",org.hamcrest.Matchers.hasSize(1)))
			.andExpect(MockMvcResultMatchers.status().isOk());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void  deleteProductTest() {
		Product product= new Product();
	}
}

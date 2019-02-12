package com.vish.security.security.demo.config.resourse;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.vish.security.security.demo.entity.Product;
import com.vish.security.security.demo.exceptions.ProductException;
import com.vish.security.security.demo.exceptions.model.ErrorDetails;
import com.vish.security.security.demo.service.ProductService;

@RestController
@ControllerAdvice
@RequestMapping("/rest")
@CrossOrigin(origins = "*")
public class ProductResource {

	Logger logger = LogManager.getLogger(ProductResource.class);
	@Autowired
	ProductService productService;

	
	@GetMapping(value="/products")
	public ResponseEntity<List<Product>> getProduct(@QueryParam("name") String name){
		
		if(name!=null) {
			List<Product> list = new ArrayList<>();
			list.add(productService.getProductByName(name));
		 return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
				
		}else {
			if (productService.findAll().isEmpty()) {
				try {
					throw new ProductException("No products available");
				} catch (ProductException e) {

					logger.error("No products available");
				}
			}
			
			return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
		}
		
	}
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Integer id, HttpServletRequest request,
			HttpServletResponse response) throws ProductException {
		 HttpSession sesseionValue = request.getSession();
	
		System.out.println(sesseionValue);
		if (!productService.getProductById(id).isPresent()) {

			throw new ProductException("No product available for this id [" + id + "]", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Product>(productService.getProductById(id).get(), HttpStatus.OK);
	}
	

	@PostMapping(value ="/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product, HttpServletRequest request,
			HttpServletResponse response) {

		if (!productService.validateProduct(product)) {
			try {
				throw new ProductException("Invalid product", HttpStatus.BAD_REQUEST);
			} catch (ProductException e) {

				logger.error("Invalid product");
			}
		}
		productService.saveProduct(product);
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {

		if (!productService.getProductById(id).isPresent()) {
			try {
				throw new ProductException("No product found to delete with id [" + id + "]", HttpStatus.NOT_FOUND);
			} catch (ProductException e) {

				logger.error("No product found to delete with id [" + id + "]");
			}
		}

		productService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}

	@PatchMapping(value = "/products/{id}", consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable(name = "id") Integer id,
			HttpServletRequest request, HttpServletResponse response) {

		Optional<Product> updatingProduct = productService.getProductById(id);
		if (!updatingProduct.isPresent()) {
			try {
				throw new ProductException("Record not found updation with id [" + id + "]", HttpStatus.NO_CONTENT);
			} catch (ProductException e) {

				logger.error("Record not found updation with id [" + id + "]");
			}
		}
		updatingProduct.get().setColor(product.getColor());
		updatingProduct.get().setName(product.getName());
		productService.saveProduct(updatingProduct.get());

		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);

	}
	/*@ExceptionHandler(ProductException.class)
	public ResponseEntity<Object> localHandler(ProductException ex,WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true));
		logger.info("Handled local exception successfully!!!!");
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
				
	}*/

}

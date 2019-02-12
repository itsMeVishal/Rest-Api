package com.vish.security.security.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vish.security.security.demo.entity.Product;
import com.vish.security.security.demo.repository.UserRepository;


public interface ProductService {
	
	Optional<Product> getProductById(Integer id);

	Product getProductByName(String name);

	Product saveProduct(Product product);

	Product updateProduct(Product product, Integer id);

	void deleteProduct(Integer id);

	List<Product> findAll();

	boolean validateProduct(Product product);
}

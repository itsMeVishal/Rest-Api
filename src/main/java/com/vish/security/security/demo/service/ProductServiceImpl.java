package com.vish.security.security.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Service;

import com.vish.security.security.demo.entity.Product;
import com.vish.security.security.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	HttpSessionEventPublisher httpSessionEventPublisher;

	@Override
	public Optional<Product> getProductById(Integer id) {

		return productRepository.findById(id);
	}

	@Override
	public Product getProductByName(String name) {
		
		return productRepository.getProductByName(name);
	}

	@Override
	public Product saveProduct(Product product) {
		
		Product addProduct = new Product();
		addProduct.setColor(product.getColor());
		addProduct.setName(product.getName());
		addProduct.setUser(product.getUser());
		return productRepository.save(addProduct);
	} 

	@Override
	public Product updateProduct(Product product, Integer id) {
		
		Optional<Product> tempProduct = productRepository.findById(id);
		if(tempProduct.isPresent()) {
			
			tempProduct.get().setColor(product.getName());
			tempProduct.get().setName(product.getName());
			productRepository.save(tempProduct.get());
		}
		return null;
	}

	@Override
	public void deleteProduct(Integer id) {
			productRepository.deleteById(id);
		}

	@Override
	//@PreAuthorize("hasRole('USER')")
	//@Secured("SYSTEM")
	public List<Product> findAll() {
		
		List<Product> list = productRepository.findAll();
		
		//Collections.sort(list);
		Collections.sort(list,(Product p1, Product p2)->p1.getColor().compareTo(p2.getColor()));//productRepository.findAll();
		/*Collections.sort(list, new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				
				return p1.getColor().compareTo(p2.getColor());
			}
		});*/
		
		return list;
	}

	@Override
	public boolean validateProduct(Product product) {
		
		return true;
	}
	

}

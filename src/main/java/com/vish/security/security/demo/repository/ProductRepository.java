package com.vish.security.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vish.security.security.demo.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product getProductByName(String name);

	
}

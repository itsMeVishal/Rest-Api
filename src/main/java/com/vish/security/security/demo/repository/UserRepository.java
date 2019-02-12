package com.vish.security.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vish.security.security.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String username);

}

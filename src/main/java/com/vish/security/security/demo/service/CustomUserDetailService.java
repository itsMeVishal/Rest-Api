package com.vish.security.security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vish.security.security.demo.entity.User;
import com.vish.security.security.demo.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) {
		
		return  userRepository.findByName(username);
		//return null;
	}

}

package com.six.chunfeng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.six.chunfeng.domain.User;
import com.six.chunfeng.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public User selectUser(int id){
		return userRepository.selectUser(id);
	}
}

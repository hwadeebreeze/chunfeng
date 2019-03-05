package com.six.chunfeng.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.User;
import com.six.chunfeng.service.LoginService;


@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping("/login")
	public boolean login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		log.info("Gotten phone: " + user.getPhone() + " gotten password: " + user.getPassword());
		return loginService.login(user);
	}
}

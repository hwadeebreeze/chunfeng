package com.six.chunfeng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.User;
import com.six.chunfeng.service.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	private Logger log = LoggerFactory.getLogger(RegisterController.class);
	
	@PostMapping("/register")
	public boolean register(User user){
		log.info("Gotten user: " + user);
		return registerService.register(user);
	}
	
	@PostMapping("/checkPhone")
	public boolean checkPhone(@ModelAttribute("phone") String phone){
		log.info("Gotten phone: " + phone);
		return registerService.countPhone(phone);
	}
	

}

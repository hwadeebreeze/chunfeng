package com.six.chunfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.six.chunfeng.domain.User;

@Controller
public class RegisterController {
	
	@RequestMapping("/register")
	public void register(User user ,BindingResult bindingResult){
		System.out.println(user);
	}
}

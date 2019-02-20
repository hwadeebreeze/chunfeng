package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.six.chunfeng.domain.User;
import com.six.chunfeng.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/test")
	@ResponseBody
	public User test(@ModelAttribute("id") int id){
		return userService.selectUser(id);
	}
}

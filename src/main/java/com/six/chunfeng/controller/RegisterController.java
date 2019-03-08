package com.six.chunfeng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.User;
import com.six.chunfeng.service.RegisterService;
import com.six.chunfeng.util.CookieUtil;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	private Logger log = LoggerFactory.getLogger(RegisterController.class);
	
	@PostMapping("/register")
	public Map<String, Boolean> register(User user, HttpServletResponse response){
		log.info("Gotten user: " + user);
		Map<String,Boolean> result = new HashMap<String,Boolean>();
		result.put("result", registerService.register(user));
		if(result.get("result")==true){
			CookieUtil.setCookie(response, "phone", user.getPhone());
		}
		return result;
	}
	
	@PostMapping("/checkPhone")
	public Map<String, Boolean> checkPhone(@ModelAttribute("phone") String phone){
		log.info("Gotten phone: " + phone);
		Map<String,Boolean> result = new HashMap<String,Boolean>();
		result.put("resultPhone", registerService.countPhone(phone));
		return result;
	}
	

}

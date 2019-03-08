package com.six.chunfeng.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.six.chunfeng.domain.User;
import com.six.chunfeng.service.LoginService;
import com.six.chunfeng.util.CookieUtil;


@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping("/login")
	public Map<String,Boolean> login(User user, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		log.info("Gotten phone: " + user.getPhone() + " gotten password: " + user.getPassword());
		Map<String,Boolean> result = new HashMap<String,Boolean>();
		result.put("result", loginService.login(user));
		if(result.get("result")==true){
			CookieUtil.setCookie(response, "phone", user.getPhone());
		}
		return result;
	}
}

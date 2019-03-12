package com.six.chunfeng.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.User;
import com.six.chunfeng.mapper.LoginMapper;
import com.six.chunfeng.util.CookieUtil;
import com.six.chunfeng.util.MD5Utils;

@Service
public class LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	private Logger log = LoggerFactory.getLogger(LoginService.class);
	
	public boolean login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		String password = loginMapper.getPassworkByphone(user.getPhone());
		log.debug("Existed phone " + user.getPhone() + " password: " + password);
		boolean result = password==null?false:password.equals(MD5Utils.md5(user.getPassword(), "utf-8"));
		return result;
	}
	
	public Integer getIdByPhone(String phone){
		return loginMapper.getIdByPhone(phone);
	}

	
}

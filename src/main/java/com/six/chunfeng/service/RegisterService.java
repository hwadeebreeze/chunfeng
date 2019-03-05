package com.six.chunfeng.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.User;
import com.six.chunfeng.mapper.RegisterMapper;
import com.six.chunfeng.util.MD5Utils;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterMapper registerMapper;
	
	private Logger log = LoggerFactory.getLogger(RegisterService.class);
	
	public boolean countPhone(String phone){
		int count = registerMapper.countPhone(phone);
		log.debug("Existed " + phone + " count " + count);
		return count==0;
	}
	
	public boolean register(User user){
		if(countPhone(user.getPhone())){
			try {
				user.setPassword(MD5Utils.md5(user.getPassword(), "utf-8"));
			} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			registerMapper.insertUser(user);
			log.debug("insert user: " + user);
			return true;
		}else{
			log.debug(user.getPhone() + "has already existed!");
			return false;
		}
	}
}

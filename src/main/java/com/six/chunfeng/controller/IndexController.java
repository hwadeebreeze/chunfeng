package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.IndexService;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@GetMapping("/")
	public String index(){
		return "Home.html";
	}
	
	


}

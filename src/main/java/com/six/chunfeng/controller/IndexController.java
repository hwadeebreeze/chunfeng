package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.IndexService;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@GetMapping("/index")
	public String index(){
		return "Home.html";
	}
}

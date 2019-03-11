package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.IndexService;
import com.six.chunfeng.service.RecommendService;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@Autowired
	private RecommendService recommendService;
	
	@GetMapping("/test")
	@ResponseBody
	public String test(){
		recommendService.recommend(5);
		return "sucess";
	}


}

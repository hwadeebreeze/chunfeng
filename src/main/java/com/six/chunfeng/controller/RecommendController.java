package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.RecommendService;

@RestController
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	@RequestMapping("/recommend")
	public Object test(@RequestParam("id") int id){
		recommendService.recommend(id);
		return recommendService.changePage(1);
	}
}

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
	public Object test(@RequestParam(value = "id", defaultValue = "1") int id,
				@RequestParam(value = "page", defaultValue = "1") int page)
	{
		recommendService.recommend(id);
		return recommendService.changePage(page);
	}
}

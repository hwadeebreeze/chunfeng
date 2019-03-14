package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.RecommendService;
import com.six.chunfeng.service.SearchService;

@RestController
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/recommend")
	public Object test(@RequestParam(value = "id", defaultValue = "1") int id,
				@RequestParam(value = "page", defaultValue = "1") int page)
	{
		recommendService.recommend(id);
		return recommendService.changePage(page);
	}
	
	@RequestMapping("/search")
	public Object test(@RequestParam(value = "position", defaultValue = "2") Integer position,
				@RequestParam(value = "city", defaultValue = "成都") String city,
				@RequestParam(value = "salary_least", defaultValue = "20") Integer salaryLeast,
				@RequestParam(value = "salary_most", defaultValue = "50") Integer salaryMost	
	)
	{
		searchService.search(position, city, salaryLeast,salaryMost );		
		return searchService.changePage(1);
	}
	
}

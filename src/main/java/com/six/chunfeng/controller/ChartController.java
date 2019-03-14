package com.six.chunfeng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.ChartService;

@RestController
public class ChartController {
	@Autowired
	private ChartService service;
	
	private Map<String,Integer> map = new HashMap<String,Integer>();
	@PostMapping("/chart")
	public Map<String,Integer> test(@ModelAttribute("id") int id){
		map = service.getChartData(id);
		return map;
	}
}

package com.six.chunfeng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.service.ChartService;

@Controller
public class ChartController {
	@Autowired
	private ChartService service;
	private Map<String,Integer> map = new HashMap<String,Integer>();
	
	@GetMapping("/chart")
	public String getData(){
		return "Jobinfo.html";
	}
	
	@ResponseBody
	@PostMapping("/chart")
	public Map<String,Integer> test(@RequestParam(value = "id") int id){
		System.out.println(id);
		map = service.getChartData(id);
//		map.put("id",id);
//		map.put("name", 250);
		return map;
	}
}

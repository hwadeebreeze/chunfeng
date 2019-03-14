package com.six.chunfeng.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.service.IndexService;
import com.six.chunfeng.service.RecommendService;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@Autowired
	private RecommendService recommendService;
	
	@GetMapping("/")
	public String test(){
		return "Home.html";
	}
	
	@PostMapping("/getPosition")
	@ResponseBody
	public List<Map<String,Object>> getPositionDic(){
		return indexService.getPositionDic();
	}
	
	
	@PostMapping("/getCompanyList")
	@ResponseBody
	public List<CompanyInfo> getCompanyList(@ModelAttribute("jobId") List<Integer> jobId){
		return indexService.getCompanyInfo(jobId);
	}

}

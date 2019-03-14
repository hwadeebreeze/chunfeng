package com.six.chunfeng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.service.IndexService;
import com.six.chunfeng.service.RecommendService;
import com.six.chunfeng.service.SearchService;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@Autowired
	private RecommendService recommendService;
	
	@Autowired
	private SearchService searchService;
	
	private Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@GetMapping("/")
	public String test(){
		return "Home.html";
	}
	
	@PostMapping("/getPosition")
	@ResponseBody
	public List<Map<String,Object>> getPositionDic(){
		return indexService.getPositionDic();
	}
	
	@PostMapping("/searchJobList")
	@ResponseBody
	public List<JobInfo> getJobList(@ModelAttribute("position") String position,
			@ModelAttribute("city") String city,
			@ModelAttribute("salaryLeast") String salaryLeast,
			@ModelAttribute("salaryMost") String salaryMost, 
			@ModelAttribute("curPage") String curPage){
		log.info("Gotten message: position="+position+",city="+city+",salary="+salaryLeast+"-"+salaryMost+",curPage="+curPage);
		searchService.search(position.equals("")?null:Integer.valueOf(position),
						city.equals("")?null:city, 
						salaryLeast.equals("")?null:Integer.valueOf(salaryLeast),
						salaryMost.equals("")?null:Integer.valueOf(salaryMost));
		return searchService.changePage(curPage.equals("")?0:Integer.valueOf(curPage));
	}

	
	@PostMapping("/recommendJobList")
	@ResponseBody
	public List<JobInfo> recommendJobList(@ModelAttribute("userId") int userId, @ModelAttribute("curPage") String curPage){
		recommendService.recommend(userId);
		return recommendService.changePage(curPage.equals("")?0:Integer.valueOf(curPage));
	}
	 
	@PostMapping("/getSearchCompanyList")
	@ResponseBody
	public List<CompanyInfo> getSearchCompanyList(@ModelAttribute("curPage") String curPage){
		List<JobInfo> list = searchService.changePage(curPage.equals("")?0:Integer.valueOf(curPage));
		List<Integer> userId = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			userId.add(list.get(i).getId());
		}
		return indexService.getCompanyInfo(userId);
	}
	
	@PostMapping("/getRecommendCompanyList")
	@ResponseBody
	public List<CompanyInfo> getRecommendCompanyList(@ModelAttribute("curPage") String curPage){
		List<JobInfo> list = recommendService.changePage(curPage.equals("")?0:Integer.valueOf(curPage));
		List<Integer> userId = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			userId.add(list.get(i).getId());
		}
		return indexService.getCompanyInfo(userId);
	}
	
	@PostMapping("/searchChangePage")
	@ResponseBody
	public List<JobInfo> searchChangePage(@ModelAttribute("curPage") String curPage){
		return searchService.changePage(curPage.equals("")?0:Integer.valueOf(curPage));
	}
	
	@PostMapping("/recommendChangePage")
	@ResponseBody
	public List<JobInfo> recommendChangePage(@ModelAttribute("curPage") String curPage){
		return recommendService.changePage(curPage.equals("")?0:Integer.valueOf(curPage));
	}
}
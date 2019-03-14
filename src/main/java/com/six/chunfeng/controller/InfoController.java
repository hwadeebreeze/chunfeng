package com.six.chunfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.service.InfoService;

@RestController
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/jobInfo")
	public JobInfo getJobInfo(@ModelAttribute("jobId") int jobId){
		return infoService.getJobInfo(jobId);
	}
	
	@GetMapping("/companyInfo")
	public CompanyInfo getCompanyInfo(@ModelAttribute("jobId") int jobId){
		return infoService.getCompanyInfo(jobId);
	}
		
	@PostMapping("/educationName")
	public String getEducationName(@ModelAttribute("educationId") String educationId){
		return infoService.getEducationName(Integer.valueOf(educationId));
	}
	
	
}

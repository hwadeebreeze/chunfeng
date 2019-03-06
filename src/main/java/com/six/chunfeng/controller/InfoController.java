package com.six.chunfeng.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.service.InfoService;

@RestController
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	private Logger log = LoggerFactory.getLogger(InfoController.class);
	
	@GetMapping("/jobInfo")
	public JobInfo getJobInfo(@ModelAttribute("id") int id){
		return infoService.getJobInfo(id);
	}
}

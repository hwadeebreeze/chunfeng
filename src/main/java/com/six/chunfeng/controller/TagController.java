package com.six.chunfeng.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.TagInfo;

@RestController
public class TagController {
	
	@PostMapping("/getTagInfo")
	public void getTagInfo(TagInfo tagInfo){
		
	}
	
	@PostMapping("/setTagInfo")
	public void setTagInfo(TagInfo tagInfo){
		
	}
}

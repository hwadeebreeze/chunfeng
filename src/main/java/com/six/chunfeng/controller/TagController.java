package com.six.chunfeng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.service.TagService;

@RestController
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	private Logger log = LoggerFactory.getLogger(TagController.class);
	
	@GetMapping("/tagInfo")
	public TagInfo getTagInfo(@ModelAttribute("id") int userId){
		log.info("Gotten userId: " + userId);
		return tagService.getTagInfo(userId);
	}
	
	@PostMapping("/setTagInfo")
	public void setTagInfo(TagInfo tagInfo, @ModelAttribute("id") int userId){
		log.info("Gotten tagInfo: " + tagInfo + " userId: " + userId);
		tagService.setTagInfo(tagInfo, userId);
	}
}

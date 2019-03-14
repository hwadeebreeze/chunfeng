package com.six.chunfeng.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	@GetMapping("/capacityDic")
	public Iterator<Map<Integer,String>> getCapacityDic(){
		return tagService.getCapacityDic().iterator();
	}
	
	@GetMapping("/industryDic")
	public Iterator<Map<Integer,String>> getIndustryDic(){
		return tagService.getIndustryDic().iterator();
	}
	
	@GetMapping("/positionDic")
	public Iterator<Map<Integer,String>> getPositionDic(){
		return tagService.getPositionDic().iterator();
	}
	
	@GetMapping("/welfareDic")
	public Iterator<Map<Integer,String>> getwelfareDic(){
		return tagService.getwelfareDic().iterator();
	}
	
	@PostMapping("/setTagInfo")
	public void setTagInfo(TagInfo tagInfo){
		System.out.println(tagInfo);
		log.info("Gotten tagInfo: " + tagInfo);
		tagService.setTagInfo(tagInfo);
	}
}

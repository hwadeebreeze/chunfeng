package com.six.chunfeng.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.mapper.LoginMapper;
import com.six.chunfeng.mapper.TagMapper;

@Service
public class TagService {
	@Autowired
	private TagMapper tagMapper;

	private Logger log = LoggerFactory.getLogger(TagService.class);
	
	public TagInfo getTagInfo(int userId){
		TagInfo info = tagMapper.getTagInfoById(userId);
		log.debug("userId: " + userId + " tagInfo: " + info);
		return info;
	}
	
	public void setTagInfo(TagInfo tagInfo, int userId){
		int tagInfoCount = tagMapper.getTagInfoCountById(userId);
		log.debug("TagInfo count: " + tagInfoCount);
		if(tagInfoCount==0){
			tagMapper.insertTagInfo(tagInfo, userId);
		}else{
			tagMapper.setTagInfoById(tagInfo, userId);
		}
	}
}

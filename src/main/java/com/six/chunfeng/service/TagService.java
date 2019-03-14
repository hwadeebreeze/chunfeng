package com.six.chunfeng.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.TagInfo;
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

	public void setTagInfo(TagInfo tagInfo){

		int tagInfoCount = tagMapper.getTagInfoCountById(tagInfo.getUserId());
		log.debug("TagInfo count: " + tagInfoCount);
		if(tagInfoCount==0){
			tagMapper.insertTagInfo(tagInfo);
		}else{
			tagMapper.setTagInfoById(tagInfo);
		}
	}

	public List<Map<Integer,String>> getCapacityDic(){
		return tagMapper.getCapacityDic();
	}

	public List<Map<Integer,String>> getIndustryDic(){
		return tagMapper.getIndustryDic();
	}

	public List<Map<Integer,String>> getPositionDic(){
		return tagMapper.getPositionDic();
	}

	public List<Map<Integer,String>> getwelfareDic(){
		return tagMapper.getwelfareDic();
	}
}

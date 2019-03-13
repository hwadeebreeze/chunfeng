package com.six.chunfeng.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.mapper.IndexMapper;

@Service
public class IndexService {
	
	@Autowired
	private IndexMapper indexMapper;
	
	private Logger log = LoggerFactory.getLogger(IndexService.class);
	
	public List<Map<String,String>> getPositionDic(){
		return indexMapper.getPositionDic();
	}
	
}

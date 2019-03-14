package com.six.chunfeng.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.mapper.IndexMapper;
import com.six.chunfeng.mapper.InfoMapper;

@Service
public class IndexService {
	
	@Autowired
	private IndexMapper indexMapper;
	
	@Autowired
	private InfoMapper infoMapper;
	
	private Logger log = LoggerFactory.getLogger(IndexService.class);
	
	public List<Map<String,Object>> getPositionDic(){
		return indexMapper.getPositionDic();
	}
	
	public List<CompanyInfo> getCompanyInfo(List<Integer> jobId){
		List<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>();
		for(int i=0;i<jobId.size();i++){
			companyInfoList.add(infoMapper.getCompanyInfoByJobId(jobId.get(i)));
		}
		return companyInfoList;
	}
	
}

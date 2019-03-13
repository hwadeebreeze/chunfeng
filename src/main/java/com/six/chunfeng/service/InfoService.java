package com.six.chunfeng.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.mapper.InfoMapper;
import com.six.chunfeng.mapper.LoginMapper;

@Service
public class InfoService {
	@Autowired
	private InfoMapper infoMapper;
	
	private Logger log = LoggerFactory.getLogger(InfoService.class);
	
	public JobInfo getJobInfo(int jobId){
		JobInfo info = infoMapper.getJobInfoById(jobId);
		if(info!=null){
			log.debug("JobInfo: " + info);
			return info;
		}else{
			log.debug("Can't find JobInfo by id: " + jobId);
			return null;
		}
	}
	
	public CompanyInfo getCompanyInfo(int jobId){
		CompanyInfo info = infoMapper.getCompanyInfoByJobId(jobId);
		if(info!=null){
			log.debug("CompanyInfo: " + info);
			return info;
		}else{
			log.debug("Can't find CompanyInfo in JobInfo: " + jobId);
			return null;
		}
	}
}

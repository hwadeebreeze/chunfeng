package com.six.chunfeng.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
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
		info.setCapacity(infoMapper.getCapacityName("("+info.getCapacity()+")").toString().split("\\[")[1].split("\\]")[0]);
		info.setWelfare(infoMapper.getWelfareName("("+info.getWelfare()+")").toString().split("\\[")[1].split("\\]")[0]);
		log.debug("JobInfo: " + info);
		return info;
	}

	public CompanyInfo getCompanyInfo(int jobId){
		CompanyInfo info = infoMapper.getCompanyInfoByJobId(jobId);
		info.setIndustry(infoMapper.getIndustryName("("+info.getIndustry()+")").toString().split("\\[")[1].split("\\]")[0]);
		log.debug("CompanyInfo: " + info);
		return info;
	}

	public String getEducationName(int educationId){
		return infoMapper.getEducationName(educationId);
	}
}

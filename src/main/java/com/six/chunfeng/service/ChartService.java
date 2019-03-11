package com.six.chunfeng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;
import com.six.chunfeng.mapper.ChartMapper;
import com.six.chunfeng.mapper.LoginMapper;

@Service
public class ChartService {

	private ChartMapper mapper;
	private LoginMapper mapper1;
	
	public void getChartData(int id){
		TagInfo info = mapper.getTagInfoByUserId(id);
		User user = mapper1.getUserById(id);
		int work_year = info.getWorkYear();
		String city = info.getCity();
		int age = user.getAge();
		List<JobInfo> jobList = mapper.getJobInfoByInfo(city, age, work_year);
		
	}

}

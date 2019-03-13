package com.six.chunfeng.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;

@Service
public class SearchService {
	
	private List<JobInfo> list;
	
	public void search(Integer position, String city, Integer salaryLeast, Integer salartMost ){
		
	}
	
	public List<JobInfo> changePage(int page){
		return null;
	}
}

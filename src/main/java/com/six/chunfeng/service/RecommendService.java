package com.six.chunfeng.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.mapper.InfoMapper;

@Service
public class RecommendService {
	
	List<JobInfo> list;
	
	@Autowired
	private InfoMapper infoMapper;
	public void recommend(int id)
	{
		JobInfo info = infoMapper.getJobInfoById(id);
		System.out.println(info);
	}

	public List<JobInfo> changePage(Integer curPage)
	{
		return null;
	}
	

}

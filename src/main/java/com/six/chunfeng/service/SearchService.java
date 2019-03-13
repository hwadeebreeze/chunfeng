package com.six.chunfeng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.mapper.SearchMapper;

@Service
public class SearchService 
{
	private static final int itemsPerPage = 7;
	
	@Autowired
	private SearchMapper mapper;
	
	private List<Integer> list;
	
	private void filterPosition(List<JobInfo> tmpList, Integer position)
	{
		String userPosition = String.valueOf(position); 
		list = new ArrayList<Integer>();
		for(JobInfo job : tmpList)
		{
			String[] jobPositions = (job.getPosition()==null)? null : job.getPosition().split(",");
			for(String jobPosition : jobPositions)
			{
				if(jobPosition.equals(userPosition))
					list.add(job.getId());
			}
		}
	}
	
	public void search(Integer position, String city, Integer salaryLeast, Integer salaryMost )
	{
		if(city==null) city = "%";
		if(salaryLeast==null) salaryLeast = 0;
		if(salaryMost==null) salaryMost = 20000;
		
		if(position==null)
		{
			list = mapper.selectJobInfoIdWithOption(city,salaryLeast,salaryMost);
		}
		else
		{
			List<JobInfo> tmpList = mapper.selectJobInfoWithOption(city,salaryLeast,salaryMost);
			filterPosition(tmpList,position);
		}
	}
	
	public List<JobInfo> changePage(int curPage)
	{
		int first = (curPage-1)*itemsPerPage, last = Math.min(first+itemsPerPage, list.size());
		List<JobInfo> res = new ArrayList<JobInfo>();
		for(int i=first;i<last;++i)
		{
			res.add(mapper.selectJobInfoById(list.get(i)));
		}
		return res;
	}
	
	public int getPages()
	{
		return (list.size()+itemsPerPage-1)/itemsPerPage;
	}
}

package com.six.chunfeng.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;
import com.six.chunfeng.mapper.InfoMapper;
import com.six.chunfeng.mapper.RecommendMapper;

@Service
public class RecommendService 
{
	@Autowired
	private RecommendMapper mapper;
	@Autowired
	private InfoMapper infoMapper;
	
	static final int itemsPerPage = 7;
	TagInfo tag; User user;
	List<JobInfo> list;
	static HashMap<Integer,String> industryList = new HashMap<Integer,String>();
	String resString=""; 
	int[][] fit;
	
	private String getIndustry(int companyId)
	{
		//Singleton
		if(industryList==null)
		{
			log("读取公司行业表");
			Long startTime =  System.currentTimeMillis();
			List<CompanyInfo> companyList = mapper.selectAllIndustryFromCompanyInfo();
			for(CompanyInfo company : companyList)
			{
				industryList.put(company.getId(), company.getIndustry());
			}
			Long endTime =  System.currentTimeMillis();
			log("公司行业读取完成,耗时: "+String.valueOf((endTime-startTime))+"ms");
		}
		return industryList.get(companyId);
	}
	private double calOffset(String string1, String string2)
	{
		if(string1==null) string1="";
		if(string2==null) string2="";
		//log("1 "+string1);
		//log("2 "+string2);
		String[] arr1=string1.split(","), arr2=string2.split(",");
		Arrays.sort(arr1); Arrays.sort(arr2);
		// 双指针求交集, 并集 = A+B-交集 
		double intersect = 0;
		for(int i=0,j=0;i<arr1.length&&j<arr2.length;)
		{
			int comp = arr1[i].compareTo(arr2[j]);
			//log("1:"+arr1[i]+" 2:"+arr2[j]+" comp:"+comp);
			if(comp==0)
			{
				++intersect;
				++i;
				++j;
			}
			else if(comp<0)
				++i;
			else
				++j;
		}
		double union = arr1.length+arr2.length-intersect;
		//log("交: "+intersect+" 并: "+union);
		return (union-intersect)/union;
	}
	private int calFitValue(JobInfo job)
	{
		int res = 0;
		if(tag.getCity()!=job.getCity()) res += 1000;
		if(tag.getSalaryMost()!=0 && job.getSalaryMost()!=0 &&
			(tag.getSalaryMost()<job.getSalaryLeast() || tag.getSalaryLeast()>job.getSalaryMost())
		) res += 1000;
		res += 1000*calOffset(tag.getWelfare(),  job.getWelfare());
		res += 1000*calOffset(tag.getCapacity(), job.getCapacity());
		res += 1000*calOffset(tag.getIndustry(), getIndustry(job.getCompanyId()));
		res += 1000*calOffset(tag.getPosition(), job.getPosition());
		return res;
	}
	private void calFit()
	{
		log("计算匹配度中");
		Long startTime =  System.currentTimeMillis();
		fit = new int[list.size()][2];
		for(int i=0;i<list.size();++i)
		{
			fit[i][0] = list.get(i).getId();
			fit[i][1] = calFitValue(list.get(i));
		}
		Long endTime =  System.currentTimeMillis();
		log("匹配度计算完成,耗时: "+String.valueOf((endTime-startTime))+"ms");
		
		
	}
	private void sortFit()
	{
		log("对匹配度排序中");
		Long startTime =  System.currentTimeMillis();
		Arrays.sort(fit,(int[]a,int[]b)->a[1]-b[1]);
		Long endTime =  System.currentTimeMillis();
		
		log("排序完成,耗时: "+String.valueOf((endTime-startTime))+"ms");
	}
	 
	private void log(String str)
	{
		resString += str+"<br>";
		System.out.println(str);
	}
	
	public void recommend(int userId)
	{
		log("-- recommend call Step 1: init --"); 
		user = mapper.selectUserInfoById(userId);
		tag = mapper.selectTagInfoByUserId(userId);
		
		log(user+"<br>"+tag);

		Long startTime =  System.currentTimeMillis();
		list = mapper.selectJobInfoWithOption(tag.getWorkYear(), user.getAge(), user.getEducation());
		Long endTime =  System.currentTimeMillis();
		log("读取职位信息成功,耗时: "+String.valueOf((endTime-startTime))+"ms");
		
		log("---正在从 "+list.size()+" 条记录中进行匹配---");
		calFit();
		sortFit();
	}	

	public List<JobInfo> changePage(Integer curPage)
	{
		log("-- recommend call Step 2: page --");
		
		int first = (curPage)*itemsPerPage, last = Math.min(first+itemsPerPage, fit.length);
		log("匹配成功,最适合您的职位是:");
		List<JobInfo> res = new ArrayList<JobInfo>();
		for(int i=first;i<last;++i)
		{
			JobInfo info = mapper.selectJobInfoById(fit[i][0]);
			info.setCapacity(infoMapper.getCapacityName("("+info.getCapacity()+")").toString().split("\\[")[1].split("\\]")[0]);
			info.setWelfare(infoMapper.getWelfareName("("+info.getWelfare()+")").toString().split("\\[")[1].split("\\]")[0]);
			res.add(info);
		}
		//log(res.toString());
		log("具体信息是:");
		log(res.toString());
		log("当前显示第 "+curPage+" 页的数据,即前["+first+","+last+")条.");
		return res;
	}
	public int getPages()
	{
		return (fit.length+itemsPerPage-1)/itemsPerPage;
	}
	
	
}

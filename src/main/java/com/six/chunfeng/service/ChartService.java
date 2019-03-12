package com.six.chunfeng.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;
import com.six.chunfeng.mapper.ChartMapper;

@Service
public class ChartService {
	@Autowired
	private ChartMapper mapper;
	
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static List<String> welfareDic = new ArrayList<String>();
	
	public Map<String,Integer> getChartData(int id){
		TagInfo info = new TagInfo();
		if(mapper.getTagInfoByUserId(id)==null)return null;
		info = mapper.getTagInfoByUserId(id);
		System.out.println(info);
		User user = new User();
		if(mapper.getUserById(id)==null)return null;
		user = mapper.getUserById(id);
		System.out.println(user);
		welfareDic = mapper.getWelfareName();
		int[] salaryCount = new int[6];
		int work_year = info.getWorkYear();
		String city = info.getCity();
		int age = user.getAge();
		String education = user.getEducation();
		ArrayList<String> userCapacity = new ArrayList<String>();
		userCapacity = getCapList(userCapacity,info.getCapacity());
		System.out.println("done");
		List<JobInfo> jobList = mapper.getJobInfoByInfo(city, age, work_year,education);
		System.out.println(jobList.size());
		ArrayList<String> jobCapcity = new ArrayList<String>();
		int[] welfareCount = new int[33];
//		for(JobInfo job: jobList){
//			jobCapcity = getCapList(jobCapcity, job.getCapacity());
//			if(userCapacity.containsAll(jobCapcity));
//			else jobList.remove(job);
//		}
		 Iterator<JobInfo> iterator = jobList.iterator();
	        while(iterator.hasNext()){
	            JobInfo job = iterator.next();
	            jobCapcity = getCapList(jobCapcity, job.getCapacity());
			    if(!userCapacity.containsAll(jobCapcity)){
//			    	System.out.println(jobCapcity+" "+userCapacity);
			    	iterator.remove();
			    }//注意这个地方
	        }
//	        System.out.println(jobList);
		for(JobInfo job: jobList){
//			System.out.println(job.getId());
			getSalaryNum(job.getSalaryMost(),salaryCount);
//			System.out.println(job.getWelfare());
			getWelfareMax(job.getWelfare(),welfareCount);
//			for(int i=0;i<welfareCount.length;i++){
//				System.out.print(welfareCount[i]+"a");
//			}
//			System.out.println();
		}
		map.put("LessTen",salaryCount[0]);map.put("TenToFif",salaryCount[1]);
		map.put("FifToThir",salaryCount[2]);map.put("ThirToFif",salaryCount[3]);
		map.put("FifToHun",salaryCount[4]);map.put("MoreHun",salaryCount[5]);
		for(int i=0;i<5;i++){
			int index = getMaxIndex(welfareCount);
			if(index==-1)break;
			String wel = welfareDic.get(index);
			map.put(wel, welfareCount[index]);
			welfareCount[index] = -1;
		}
		return map;
	}
	
	
	private static void getSalaryNum(int salary,int[] salaryCount){ 
		if(salary<=10)salaryCount[0]++;
		else{
			if(salary<=15)salaryCount[1]++;
			else{
				if(salary<=30)salaryCount[2]++;
				else{
					if(salary<=50)salaryCount[3]++;
					else{
						if(salary<=100)salaryCount[4]++;
						else salaryCount[5]++;
					}
				}
			}
		}	
	}
	
	
	private static void getWelfareMax(String welfare,int[] welfareCount){
//		System.out.println(welfare);
		if(welfare.equals(""))return;
		else{
			Map<String, Integer> map = new HashMap<String, Integer>();
			String[] welfareList = welfare.split(",");
//			for(int i=0;i<welfareList.length;i++){
//				System.out.print(welfareList[i]+"a");
//			}
//			System.out.println();
			for(String s: welfareList){
				welfareCount[Integer.parseInt(s)-1]++;
			}
		}	
	}
	
	
	
	private static int getMaxIndex(int[] array){
		if(array.length > 0){
			int index = 0;
			int a = array[0];
			for(int i=0; i<array.length; i++){
			if(array[i] > a){
			a = array[i];
			index = i;
			}
			}
			if(a<=0)return -1;
			else
				return index;
			}
		return -1;
	}
	
	
	private static ArrayList<String> getCapList(ArrayList<String> list,String capacity){
		if(capacity==null){
			list.clear();
			return list;
		}
		else{
			list.clear();
			for(String s:capacity.split(","))
				list.add(s);
			return list;
		}
	}
	
	public static void main(String[] args){
//		System.out.println(Scholar.UNL.getIndex());
//		ArrayList<String> ex =new ArrayList<String>();
//		ex.add("1");ex.add("2");ex.add("3");
//		ArrayList<String> ex1 =new ArrayList<String>();
//		ex1.add("1");ex1.add("2");ex1.add("4");
//		System.out.println(ex1);
//		ex1.remove("4");
//		System.out.println(ex1);
//		System.out.println(ex.containsAll(ex1));
//		ex1.clear();
//		System.out.println(ex1);
//		ChartService chart = new ChartService();
//		chart.getChartData(1);
	}
	
}



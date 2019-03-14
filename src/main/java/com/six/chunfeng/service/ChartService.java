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
	private ChartMapper chartMapper;
	
	//返回的键值对存入map
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	//从数据库中读出的福利字典
	private static List<String> welfareDic = new ArrayList<String>();
	
	public Map<String,Integer> getChartData(int id){
		TagInfo info = new TagInfo();
		if(chartMapper.getTagInfoByUserId(id)==null)return null;
		//通过userid从job_aim中读取TagInfo
		info = chartMapper.getTagInfoByUserId(id);
		System.out.println(info);
		User user = new User();
		if(chartMapper.getUserById(id)==null)return null;
		//通过id读取user
		user = chartMapper.getUserById(id);
		System.out.println(user);
		//读出福利字典
		welfareDic = chartMapper.getWelfareName();
		int[] salaryCount = new int[6];
		//工作经验
		int work_year = info.getWorkYear();
		//目标工作地
		String city = info.getCity();
		//年龄
		int age = user.getAge();
		//学历
		String education = user.getEducation();
		ArrayList<String> userCapacity = new ArrayList<String>();
		//获取用户技能list
		userCapacity = getCapList(userCapacity,info.getCapacity());
		System.out.println("done");
		//获取第一次筛选得出的招聘信息
		List<JobInfo> jobList = chartMapper.getJobInfoByInfo(city, age, work_year,education);
		System.out.println(jobList.size());
		ArrayList<String> jobCapcity = new ArrayList<String>();
		int[] welfareCount = new int[33];
//		for(JobInfo job: jobList){
//			jobCapcity = getCapList(jobCapcity, job.getCapacity());
//			if(userCapacity.containsAll(jobCapcity));
//			else jobList.remove(job);
//		}
		//循环招聘信息
		 Iterator<JobInfo> iterator = jobList.iterator();
	        while(iterator.hasNext()){
	            JobInfo job = iterator.next();
	            //获取招聘信息技能
	            jobCapcity = getCapList(jobCapcity, job.getCapacity());
			    if(!userCapacity.containsAll(jobCapcity)){
//			    	System.out.println(jobCapcity+" "+userCapacity);
			    	iterator.remove();
			    }
	        }
//	        System.out.println(jobList);
		for(JobInfo job: jobList){
//			System.out.println(job.getId());
			//获取薪资统计
			getSalaryNum(job.getSalaryMost(),salaryCount);
//			System.out.println(job.getWelfare());
			//获取福利最大值
			getWelfareMax(job.getWelfare(),welfareCount);
//			for(int i=0;i<welfareCount.length;i++){
//				System.out.print(welfareCount[i]+"a");
//			}
//			System.out.println();
		}
		//薪资统计放入map
		map.put("LessTen",salaryCount[0]);map.put("TenToFif",salaryCount[1]);
		map.put("FifToThir",salaryCount[2]);map.put("ThirToFif",salaryCount[3]);
		map.put("FifToHun",salaryCount[4]);map.put("MoreHun",salaryCount[5]);
		//福利统计放入map
		for(int i=0;i<5;i++){
			int index = getMaxIndex(welfareCount);
			if(index==-1)break;
			String wel = welfareDic.get(index);
			map.put(wel, welfareCount[index]);
			welfareCount[index] = -1;
		}
		return map;
	}
	
	//得到薪资统计
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
	
	//获取福利最大值
	private static void getWelfareMax(String welfare,int[] welfareCount){
//		System.out.println(welfare);
		if(welfare.equals(""))return;
		else{
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
	
	
	//获取数组最大值下标
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
	
	//输入存放技能的list，读出的技能字符串，输出技能list
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



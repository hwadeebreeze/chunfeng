package com.six.chunfeng.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;
import com.six.chunfeng.mapper.ChartMapper;

@Service
public class ChartService {
	private ChartMapper mapper;
	private static int LessTen;
	private static int TenToFif;
	private static int FifToThir;
	private static int ThirToFif;
	private static int FifToHun;
	private static int MoreHun;
	
	public void getChartData(int id){
		TagInfo info = mapper.getTagInfoByUserId(id);
		System.out.println(info);
		User user = mapper.getUserById(id);
		System.out.println(user);
		int work_year = info.getWorkYear();
		String city = info.getCity();
		int age = user.getAge();
		ArrayList<String> userCapacity = new ArrayList<String>();
		List<Integer> data = new ArrayList<Integer>();
		userCapacity = getCapList(userCapacity,info.getCapacity());
		List<JobInfo> jobList = mapper.getJobInfoByInfo(city, age, work_year);
		System.out.println(jobList);
		for(JobInfo job: jobList){
			if(Scholar.getIndex(job.getEducation())>Scholar.getIndex(user.getEducation()))
				jobList.remove(job);
		}
		ArrayList<String> jobCapcity = new ArrayList<String>();
		for(JobInfo job: jobList){
			jobCapcity = getCapList(jobCapcity, job.getCapacity());
			if(userCapacity.containsAll(jobCapcity));
			else jobList.remove(job);
		}
		for(JobInfo job: jobList){
			getSalaryNum(job.getSalaryMost());
		}
		data.add(LessTen);data.add(TenToFif);
		data.add(FifToThir);data.add(ThirToFif);
		data.add(FifToHun);data.add(MoreHun);
		
	}
	
	
	private static void getSalaryNum(int salary){ 
		if(salary<=10)LessTen++;
		else{
			if(salary<=15)TenToFif++;
			else{
				if(salary<=30)FifToThir++;
				else{
					if(salary<=50)ThirToFif++;
					else{
						if(salary<=100)FifToHun++;
						else MoreHun++;
					}
				}
			}
		}	
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
		ChartService chart = new ChartService();
		chart.getChartData(1);
	}
	
}
enum Scholar {
    UNL("不限",1), SEC("中专",2), COL("大专",3), BAC("本科", 4), MAS("硕士", 5), DOC("博士",6);

    private String name;
    private int index;


    Scholar(String name,int index){
    	this.name = name;
    	this.index = index;
    }

    public static int getIndex(String name) {
        for (Scholar c : Scholar.values()) {
        if (c.getName() == name) {
            return c.index;
        }
        }
        return -1;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    }



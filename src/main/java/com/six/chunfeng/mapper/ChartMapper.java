package com.six.chunfeng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;

public interface ChartMapper {
    @Select("select * from job_aim where user_id=#{user_id}")
    public TagInfo getTagInfoByUserId(@Param("user_id") int id);
	
	@Select("select * from job_info where city=#{city} and #{age}>=age_least and #{age}<=age_most and work_year<={work_year}")
	public List<JobInfo> getJobInfoByInfo(@Param("city") String city,@Param("age") int age,@Param("work_year") int work_year);
	
}

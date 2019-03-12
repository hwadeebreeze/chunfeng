package com.six.chunfeng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;

public interface ChartMapper {
	
	@Select("select * from user_info where id=#{id}")
	public User getUserById(int id);
	
    @Select("select * from job_aim where user_id=#{user_id}")
    public TagInfo getTagInfoByUserId(@Param("user_id") int id);
	
	@Select("select id, salary_most, welfare, capacity from job_info where city=#{city} and #{age}>=age_least and #{age}<=age_most "
			+ "and work_year<=#{work_year} and education<=#{edu} ")
	public List<JobInfo> getJobInfoByInfo(@Param("city") String city,@Param("age") int age,@Param("work_year") int work_year,@Param("edu") String edu);
	
	@Select("select name from welfare_dic ")
	public List<String> getWelfareName();

}

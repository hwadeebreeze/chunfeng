package com.six.chunfeng.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;

public interface TagMapper {
	
	@Select("select * from job_aim where user_id=#{id}")
	public TagInfo getTagInfoById(@Param("id") int id);
	
	@Update(value="update job_aim set work_year=#{info.workYear},salary_least=#{info.salaryLeast},salary_most=#{info.salaryMost},"
			+ "city=#{info.city},capacity=#{info.capacity},position=#{info.position},welfare=#{info.welfare},industry=#{info.industry} "
			+ "where user_id=#{id}")
	public void setTagInfoById(@Param("info") TagInfo info, @Param("id") int id);
	
	@Select("select count(*) from job_aim where user_id=#{id}")
	public Integer getTagInfoCountById(@Param("id") int id);
	
	@Insert("insert into job_aim(work_year,salary_least,salary_most,city,capacity,position,welfare,industry,"
			+ "user_id) values(#{info.workYear},#{info.salaryLeast},#{info.salaryMost},#{info.city},#{info.capacity},#{info.position},"
			+ "#{info.welfare},#{info.industry},#{id})")
	public void insertTagInfo(@Param("info") TagInfo info, @Param("id") int id);
	
	@Select("select * from capacity_dic")
	public List<Map<Integer,String>> getCapacityDic();
	
	@Select("select id,name from industry_dic")
	public List<Map<Integer,String>> getIndustryDic();
	
	@Select("select id,name from position_dic")
	public List<Map<Integer,String>> getPositionDic();
	
	@Select("select id,name from welfare_dic")
	public List<Map<Integer,String>> getwelfareDic();
}

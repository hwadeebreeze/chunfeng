package com.six.chunfeng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;

public interface RecommendMapper {

	@Select("SELECT * FROM job_aim WHERE id=#{id}")
	public TagInfo selectTagInfoById(int id);
	
	@Select("SELECT * FROM job_aim WHERE user_id=#{userId}")
	public TagInfo selectTagInfoByUserId(int userId);
	
	@Select("SELECT * FROM user_info WHERE id=#{id}")
	public User selectUserInfoById(int id);
	
	@Select("SELECT * FROM job_info WHERE id=#{id}")
	public JobInfo selectJobInfoById(int id);
	
	@Select("SELECT id, city, salary_least,salary_most,welfare,capacity,company_id FROM job_info "
			+ "WHERE #{work_year}>=work_year AND #{age}>=age_least AND #{age}<=age_most AND #{education}>=education "
			+ "")
	public List<JobInfo> selectJobInfoWithOption(
			@Param("work_year")int workYear, 
			@Param("age") int age,
			@Param("education")String education
	);
	
	@Select("SELECT id,industry FROM company_info")
	public List<CompanyInfo> selectAllIndustryFromCompanyInfo();

}

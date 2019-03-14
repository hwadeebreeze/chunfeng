package com.six.chunfeng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;

public interface InfoMapper {

	@Select("select * from job_info where id=#{id}")
	public JobInfo getJobInfoById(@Param("id") int id);
	
	@Select("select company_info.* from company_info,job_info where job_info.id=#{jobId} and job_info.company_id=company_info.id")
	public CompanyInfo getCompanyInfoByJobId(@Param("jobId") int jobId);
	
	@Select("select name from education_dic where id=#{id}")
	public String getEducationName(@Param("id") int educationId);
	
	@Select("select name from capacity_dic where id in ${id}")
	public List<String> getCapacityName(@Param("id") String capacityId);
	
	@Select("select name from welfare_dic where id in ${id}")
	public List<String> getWelfareName(@Param("id") String welfareId);
	
	@Select("select name from industry_dic where id in ${id}")
	public List<String> getIndustryName(@Param("id") String industryId);
}

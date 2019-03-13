package com.six.chunfeng.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.CompanyInfo;
import com.six.chunfeng.domain.JobInfo;

public interface InfoMapper {

	@Select("select * from job_info where id=#{id}")
	public JobInfo getJobInfoById(@Param("id") int id);
	
	@Select("select company_info.* from company_info,job_info where job_info.id=#{jobId} and job_info.company_id=company_info.id")
	public CompanyInfo getCompanyInfoByJobId(@Param("jobId") int jobId);
}

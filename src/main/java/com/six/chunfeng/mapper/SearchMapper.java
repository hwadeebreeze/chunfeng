package com.six.chunfeng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.JobInfo;

public interface SearchMapper 
{
	@Select("SELECT id,position FROM job_info "
			+ "WHERE #{salaryMost}>=salary_least AND salary_most>=#{salaryLeast} AND city LIKE #{city}")
	public List<JobInfo> selectJobInfoWithOption(
			@Param("city") String city,
			@Param("salaryLeast") int salaryLeast,
			@Param("salaryMost") int salaryMost
	);
	
	@Select("SELECT id FROM job_info "
			+ "WHERE #{salaryMost}>=salary_least AND salary_most>=#{salaryLeast} AND city LIKE #{city}")
	public List<Integer> selectJobInfoIdWithOption(
			@Param("city") String city,
			@Param("salaryLeast") int salaryLeast,
			@Param("salaryMost") int salaryMost
	);
	
	@Select("SELECT * FROM job_info WHERE id=#{id}")
	public JobInfo selectJobInfoById(int id);
}

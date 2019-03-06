package com.six.chunfeng.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.JobInfo;

public interface InfoMapper {

	@Select("select * from job_info where id=#{id}")
	public JobInfo getJobInfoById(@Param("id") int id);
}

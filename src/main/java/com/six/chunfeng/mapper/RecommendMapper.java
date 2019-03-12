package com.six.chunfeng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;

public interface RecommendMapper {

	@Select("SELECT * FROM job_aim WHERE id=#{id}")
	public TagInfo selectTagInfoById(int id);
	
	@Select("SELECT * FROM user_info WHERE id=#{id}")
	public User selectUserInfoById(int id);
	
	@Select("SELECT id FROM job_info ORDER BY id LIMIT 0,#{limit}")
	public List<JobInfo> selectJobInfoWithLimit(int limit);
}

package com.six.chunfeng.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.six.chunfeng.domain.User;


public interface RegisterMapper {
	
	@Select("select count(*) from user_info where tel=#{phone}")
	public Integer countPhone(@Param("phone") String phone);
	
	@Insert("")
	public void insertUser(User user);
}

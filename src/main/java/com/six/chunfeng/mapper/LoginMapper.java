package com.six.chunfeng.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.User;

public interface LoginMapper {

	@Select("select pswd from user_info where tel=#{phone}")
	public String getPassworkByphone(@Param("phone") String phone);
	
	@Select("select * from user_info where user_id=#{id}")
	public User getUserById(int id);
	
	@Select("select id from user_info where tel=#{phone}")
	public Integer getIdByPhone(String phone);
}

package com.six.chunfeng.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.six.chunfeng.domain.User;

public interface LoginMapper {

	@Select("select password from user_info where phone=#{phone}")
	public String getPassworkByphone(@Param("phone") String phone);
	
	@Select("select * from user_info where id=#{id}")
	public User getUserById(int id);
	
	@Select("select id from user_info where phone=#{phone}")
	public Integer getIdByPhone(String phone);
}

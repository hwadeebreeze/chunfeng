package com.six.chunfeng.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.six.chunfeng.domain.User;

@Repository
public interface UserRepository {
	
	@Select("select * from users where id=#{id}")
	public User selectUser(int id);
}

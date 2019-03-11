package com.six.chunfeng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.chunfeng.domain.JobInfo;
import com.six.chunfeng.domain.TagInfo;
import com.six.chunfeng.domain.User;
import com.six.chunfeng.mapper.LoginMapper;
import com.six.chunfeng.mapper.RecommendMapper;

@Service
public class RecommendService 
{
	static final int itemsPerPage = 5;
	int tagId, userId;
	TagInfo tag; User user;
	
	List<?> list;
	String resString=""; 
	
	@Autowired
	private RecommendMapper mapper;
	@Autowired
	private LoginMapper loginMapper;
	 
	private void log(String str)
	{
		resString += str+"<br>";
	}
	
	public void recommend(int id)
	{
		log("-- recommend call 1 init --"); 
		tagId = id; tag = mapper.selectTagInfoById(tagId);
		userId = tag.getUserId(); user = mapper.selectUserInfoById(userId);
		
		log(tag+"<br>"+user);
		list = mapper.selectJobInfoWithLimit(1);
		
	}

	public Object changePage(Integer curPage)
	{
		log("");log("-- recommend call 2 page --");
		//log(list.subList(curPage*itemsPerPage, (curPage+1)*itemsPerPage).toString());
		User t = loginMapper.getUserById(1);
		return t;
	}
}

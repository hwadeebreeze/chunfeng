package com.six.chunfeng.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface IndexMapper {
	
	@Select("select * from position_dic")
	public List<Map<String,Object>> getPositionDic();
}

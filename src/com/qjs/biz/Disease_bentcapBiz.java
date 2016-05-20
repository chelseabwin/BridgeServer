package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_bentcap;

public interface Disease_bentcapBiz {
	
	public Object addDisease_bentcap(Disease_bentcap disease_bentcap);
	
	public List<?> getAllDisease_bentcap();
	
	public boolean updateDisease_bentcap(Disease_bentcap disease_bentcap);
	
	public boolean deleteDisease_bentcapById(int id);
	
	public Map<?, ?> getAllDetailDisease_bentcap(QueryItems qi);
	
	public Disease_bentcap getDisease_bentcapById(int id);
	
	public Disease_bentcap getDisease_bentcapByBridgeCode(String bridgeCode);
	
	public int getDisease_bentcapCodeByBridgeCode(String bridgeCode);
}

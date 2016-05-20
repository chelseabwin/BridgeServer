package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_bed;

public interface Disease_bedBiz {
	
	public Object addDisease_bed(Disease_bed disease_bed);
	
	public List<?> getAllDisease_bed();
	
	public boolean updateDisease_bed(Disease_bed disease_bed);
	
	public boolean deleteDisease_bedById(int id);
	
	public Map<?, ?> getAllDetailDisease_bed(QueryItems qi);
	
	public Disease_bed getDisease_bedById(int id);
	
	public Disease_bed getDisease_bedByBridgeCode(String bridgeCode);
	
	public int getDisease_bedCodeByBridgeCode(String bridgeCode);
}

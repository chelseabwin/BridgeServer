package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_fence;

public interface Disease_fenceBiz {
	
	public Object addDisease_fence(Disease_fence disease_fence);
	
	public List<?> getAllDisease_fence();
	
	public boolean updateDisease_fence(Disease_fence disease_fence);
	
	public boolean deleteDisease_fenceById(int id);
	
	public Map<?, ?> getAllDetailDisease_fence(QueryItems qi);
	
	public Disease_fence getDisease_fenceById(int id);
	
	public Disease_fence getDisease_fenceByBridgeCode(String bridgeCode);
	
	public int getDisease_fenceCodeByBridgeCode(String bridgeCode);
	
	public List<Map<String, Object>> getAllDisease_fenceByBridgeCode(String bridgeCode);
}

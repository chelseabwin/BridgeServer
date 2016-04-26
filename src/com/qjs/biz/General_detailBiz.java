package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.General_detail;

public interface General_detailBiz {
	
	public Object addGeneral_detail(General_detail general_detail);
	
	public List<?> getAllGeneral_detail();
	
	public boolean updateGeneral_detail(General_detail general_detail);
	
	public boolean deleteGeneral_detailById(int id);
	
	public Map<?, ?> getAllDetailGeneral_detail(QueryItems qi);
	
	public General_detail getGeneral_detailById(int id);
	
	public General_detail getGeneral_detailByBridgeCode(String bridgeCode);
}

package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Support_detail;

public interface Support_detailBiz {
	
	public Object addSupport_detail(Support_detail support_detail);
	
	public List<?> getAllSupport_detail();
	
	public boolean updateSupport_detail(Support_detail support_detail);
	
	public boolean deleteSupport_detailById(int id);
	
	public Map<?, ?> getAllDetailSupport_detail(QueryItems qi);
	
	public Support_detail getSupport_detailById(int id);
	
	public Support_detail getSupport_detailByBridgeCode(String bridgeCode);
}

package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Load_detail;

public interface Load_detailBiz {
	
	public Object addLoad_detail(Load_detail load_detail);
	
	public List<?> getAllLoad_detail();
	
	public boolean updateLoad_detail(Load_detail load_detail);
	
	public boolean deleteLoad_detailById(int id);
	
	public Map<?, ?> getAllDetailLoad_detail(QueryItems qi);
	
	public Load_detail getLoad_detailById(int id);
	
	public Load_detail getLoad_detailByBridgeCode(String bridgeCode);
}

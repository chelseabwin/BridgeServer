package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Disease_pier;

public interface Disease_pierBiz {
	
	public Object addDisease_pier(Disease_pier disease_pier);
	
	public List<?> getAllDisease_pier();
	
	public boolean updateDisease_pier(Disease_pier disease_pier);
	
	public boolean deleteDisease_pierById(int id);
	
	public Map<?, ?> getAllDetailDisease_pier(QueryItems qi);
	
	public Disease_pier getDisease_pierById(int id);
	
	public Disease_pier getDisease_pierByBridgeCode(String bridgeCode);
	
	public int getDisease_pierCodeByBridgeCode(String bridgeCode);
}

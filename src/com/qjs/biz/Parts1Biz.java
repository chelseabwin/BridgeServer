package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Parts1;

public interface Parts1Biz {
	
	public Object addParts1(Parts1 parts1);
	
	public List<?> getAllParts1();
	
	public boolean updateParts1(Parts1 parts1);
	
	public boolean deleteParts1ById(int id);
	
	public Map<?, ?> getAllDetailParts1(QueryItems qi);
	
	public Parts1 getParts1ById(int id);
	
	public Parts1 getParts1ByBridgeCode(String bridgeCode);
}

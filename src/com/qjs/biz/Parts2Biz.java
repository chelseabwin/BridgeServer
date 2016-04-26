package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Parts2;

public interface Parts2Biz {
	
	public Object addParts2(Parts2 parts2);
	
	public List<?> getAllParts2();
	
	public boolean updateParts2(Parts2 parts2);
	
	public boolean deleteParts2ById(int id);
	
	public Map<?, ?> getAllDetailParts2(QueryItems qi);
	
	public Parts2 getParts2ById(int id);
	
	public Parts2 getParts2ByBridgeCode(String bridgeCode);
}

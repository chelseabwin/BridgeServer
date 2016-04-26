package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Structure;

public interface StructureBiz {
	
	public Object addStructure(Structure structure);
	
	public List<?> getAllStructure();
	
	public boolean updateStructure(Structure structure);
	
	public boolean deleteStructureById(int id);
	
	public Map<?, ?> getAllDetailStructure(QueryItems qi);
	
	public Structure getStructureById(int id);
	
	public Structure getStructureByBridgeCode(String bridgeCode);
}

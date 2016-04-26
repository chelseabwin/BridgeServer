package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Pier_add;

public interface Pier_addBiz {
	
	public Object addPier_add(Pier_add pier_add);
	
	public List<?> getAllPier_add();
	
	public boolean updatePier_add(Pier_add pier_add);
	
	public boolean deletePier_addById(int id);
	
	public Map<?, ?> getAllDetailPier_add(QueryItems qi);
	
	public Map<?, ?> getDetailPier_addByBridgeCode(String bridgeCode);
	
	public Pier_add getPier_addById(int id);
	
	public Pier_add getPier_addByBridgeCode(String bridgeCode);
}

package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Pier_detail;

public interface Pier_detailBiz {
	
	public Object addPier_detail(Pier_detail pier_detail);
	
	public List<?> getAllPier_detail();
	
	public boolean updatePier_detail(Pier_detail pier_detail);
	
	public boolean deletePier_detailById(int id);
	
	public Map<?, ?> getAllDetailPier_detail(QueryItems qi);
	
	public Pier_detail getPier_detailById(int id);
	
	public Pier_detail getPier_detailByBridgeCode(String bridgeCode);
}

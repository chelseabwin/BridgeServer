package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Base3;

public interface Base3Biz {
	
	public Object addBase3(Base3 base3);
	
	public List<?> getAllBase3();
	
	public boolean updateBase3(Base3 base3);
	
	public boolean deleteBase3ById(int id);
	
	public Map<?, ?> getAllDetailBase3(QueryItems qi);
	
	public Base3 getBase3ById(int id);
	
	public Base3 getBase3ByBridgeCode(String bridgeCode);
}

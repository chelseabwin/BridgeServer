package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Base2;

public interface Base2Biz {
	
	public Object addBase2(Base2 base2);
	
	public List<?> getAllBase2();
	
	public boolean updateBase2(Base2 base2);
	
	public boolean deleteBase2ById(int id);
	
	public Map<?, ?> getAllDetailBase2(QueryItems qi);
	
	public Base2 getBase2ById(int id);
	
	public Base2 getBase2ByBridgeCode(String bridgeCode);
}

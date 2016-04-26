package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Base1;

public interface Base1Biz {
	
	public Object addBase1(Base1 base1);
	
	public List<?> getAllBase1();
	
	public boolean updateBase1(Base1 base1);
	
	public boolean deleteBase1ById(int id);
	
	public Map<?, ?> getAllDetailBase1(QueryItems qi);
	
	public Base1 getBase1ById(int id);
	
	public Base1 getBase1ByBridgeCode(String bridgeCode);
}

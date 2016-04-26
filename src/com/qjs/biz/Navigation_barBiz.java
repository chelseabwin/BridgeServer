package com.qjs.biz;

import global.tool.QueryItems;

import java.util.Map;

import com.qjs.entity.Navigation_bar;

public interface Navigation_barBiz {
	
	public boolean addNavigation_bar(Navigation_bar navigation_bar);
	
	public Map<?, ?> getAllNavigation_bar(QueryItems qi);
	
	public boolean updateNavigation_bar(Navigation_bar navigation_bar);
	
	public boolean deleteNavigation_barById(int id);

}

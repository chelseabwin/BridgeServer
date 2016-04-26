package com.qjs.biz.impl;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.Navigation_barBiz;
import com.qjs.dao.Navigation_barDAO;
import com.qjs.entity.Navigation_bar;


public class Navigation_barBizImpl implements Navigation_barBiz {
	
	private Navigation_barDAO navigation_barDAO;

	public Navigation_barDAO getNavigation_barDAO() {
		return navigation_barDAO;
	}

	public void setNavigation_barDAO(Navigation_barDAO navigation_barDAO) {
		this.navigation_barDAO = navigation_barDAO;
	}

	@Override
	public boolean addNavigation_bar(Navigation_bar navigation_bar) {
		@SuppressWarnings("unchecked")
		List<Navigation_bar> navigation_barList = (List<Navigation_bar>) navigation_barDAO.findEntityListByProperty("name", navigation_bar.getName(), StringType.INSTANCE);
		if (navigation_barList.size() != 0) {
			return false;
		}
		navigation_barDAO.addEntity(navigation_bar);
		return true;
	}

	@Override
	public boolean updateNavigation_bar(Navigation_bar navigation_bar) {
		@SuppressWarnings("unchecked")
		List<Navigation_bar> navigation_barList = (List<Navigation_bar>) navigation_barDAO.findEntityListByProperty("name", navigation_bar.getName(), StringType.INSTANCE);
		if(navigation_barList.size()!=1){
			return false;
		}
		navigation_barDAO.updateEntity(navigation_bar);
		return true;
	}

	@Override
	public boolean deleteNavigation_barById(int id) {
		int count = navigation_barDAO.deleteEntityByProperty("navigation_bar_id", Integer.valueOf(id), StandardBasicTypes.INTEGER);
		if(count!=1) return false;
		return true;
	}

	@Override
	public Map<?,?> getAllNavigation_bar(QueryItems qi) {
		return navigation_barDAO.findEntityListByPropertiesInOrder(qi);
	}

}

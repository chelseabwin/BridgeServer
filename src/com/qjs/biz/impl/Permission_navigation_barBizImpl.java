package com.qjs.biz.impl;

import java.util.List;

import org.hibernate.type.StandardBasicTypes;

import com.qjs.biz.Permission_navigation_barBiz;
import com.qjs.dao.Permission_navigation_barDAO;
import com.qjs.entity.Permission_navigation_bar;

public class Permission_navigation_barBizImpl implements
		Permission_navigation_barBiz {
	
	private Permission_navigation_barDAO permission_navigation_barDAO;

	public Permission_navigation_barDAO getPermission_navigation_barDAO() {
		return permission_navigation_barDAO;
	}

	public void setPermission_navigation_barDAO(
			Permission_navigation_barDAO permission_navigation_barDAO) {
		this.permission_navigation_barDAO = permission_navigation_barDAO;
	}

	@Override
	public boolean addPermission_navigation_bar(Permission_navigation_bar permission_navigation_bar) {
		permission_navigation_barDAO.addEntity(permission_navigation_bar);
		return true;
	}

	@Override
	public boolean deletePermission_navigation_barById(int id) {
		int count = permission_navigation_barDAO.deleteEntityByProperty("permission_navigation_bar_id", String.valueOf(id), StandardBasicTypes.INTEGER);
		if(count!=1) return false;
		return true;
	}

	@Override
	public List<Permission_navigation_bar> getPermission_navigation_barByPermissionId(
			int permissionId) {
		@SuppressWarnings("unchecked")
		List<Permission_navigation_bar> permission_navigation_barList = (List<Permission_navigation_bar>) permission_navigation_barDAO.findEntityListByProperty("permission_id", String.valueOf(permissionId), StandardBasicTypes.INTEGER);
		return permission_navigation_barList;
	}

	@Override
	public List<Permission_navigation_bar> getPermission_navigation_barByNavigation_barId(
			int navigation_barId) {
		@SuppressWarnings("unchecked")
		List<Permission_navigation_bar> permission_navigation_barList = (List<Permission_navigation_bar>) permission_navigation_barDAO.findEntityListByProperty("navigation_bar_id", String.valueOf(navigation_barId), StandardBasicTypes.INTEGER);
		return permission_navigation_barList;
	}

}

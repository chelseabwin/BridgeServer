package com.qjs.biz;

import java.util.List;

import com.qjs.entity.Permission_navigation_bar;

public interface Permission_navigation_barBiz {
	
	public boolean addPermission_navigation_bar(Permission_navigation_bar permission_navigation_bar);
	
	public boolean deletePermission_navigation_barById(int id);
	
	public List<Permission_navigation_bar> getPermission_navigation_barByPermissionId(int permissionId);
	
	public List<Permission_navigation_bar> getPermission_navigation_barByNavigation_barId(int navigation_barId);

}

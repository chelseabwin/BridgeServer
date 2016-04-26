package com.qjs.biz;

import java.util.List;

import com.qjs.entity.Role_permission;


public interface Role_permissionBiz {
	
	public boolean addRole_permission(Role_permission role_permission);
	
	public boolean deleteRole_permissionById(int id);
	
	public List<Role_permission> getRole_permissionByPermissionId(int permissionId);
	
	public List<Role_permission> getRole_permissionByRoleId(int roleId);

}

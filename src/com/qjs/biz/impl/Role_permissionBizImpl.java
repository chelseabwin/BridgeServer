package com.qjs.biz.impl;

import java.util.List;

import org.hibernate.type.StandardBasicTypes;

import com.qjs.biz.Role_permissionBiz;
import com.qjs.dao.Role_permissionDAO;
import com.qjs.entity.Role_permission;

public class Role_permissionBizImpl implements Role_permissionBiz {
	
	private Role_permissionDAO role_permissionDAO;

	public Role_permissionDAO getRole_permissionDAO() {
		return role_permissionDAO;
	}

	public void setRole_permissionDAO(Role_permissionDAO role_permissionDAO) {
		this.role_permissionDAO = role_permissionDAO;
	}

	@Override
	public boolean addRole_permission(Role_permission role_permission) {
		role_permissionDAO.addEntity(role_permission);
		return true;
	}

	@Override
	public boolean deleteRole_permissionById(int id) {
		int count = role_permissionDAO.deleteEntityByProperty("role_permission_id", String.valueOf(id),StandardBasicTypes.INTEGER);
		if(count!=1) return false;
		return true;
	}

	@Override
	public List<Role_permission> getRole_permissionByPermissionId(
			int permissionId) {
		@SuppressWarnings("unchecked")
		List<Role_permission> role_permissionList = (List<Role_permission>) role_permissionDAO.findEntityListByProperty("permission_id", String.valueOf(permissionId),StandardBasicTypes.INTEGER);
		return role_permissionList;
	}

	@Override
	public List<Role_permission> getRole_permissionByRoleId(int roleId) {
		@SuppressWarnings("unchecked")
		List<Role_permission> role_permissionList = (List<Role_permission>) role_permissionDAO.findEntityListByProperty("role_id", roleId,StandardBasicTypes.INTEGER);
		return role_permissionList;
	}

}

package com.qjs.biz.impl;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.PermissionBiz;
import com.qjs.dao.PermissionDAO;
import com.qjs.entity.Permission;

public class PermissionBizImpl implements PermissionBiz {
	
	private PermissionDAO permissionDAO;

	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}

	@Override
	public Object addPermission(Permission permission) {
		@SuppressWarnings("unchecked")
		List<Permission> permissionList = (List<Permission>) permissionDAO.findEntityListByProperty("permission_name",permission.getPermission_name(), StringType.INSTANCE);
		if(permissionList.size()!=0){
			return -1;
		}
		
		return permissionDAO.addEntity(permission);
	}

	@Override
	public boolean updatePermission(Permission permission) {
		@SuppressWarnings("unchecked")
		List<Permission> permissionList = (List<Permission>) permissionDAO.findEntityListByProperty("permission_name",permission.getPermission_name(), StringType.INSTANCE);
		if(permissionList.size()!=1){
			return false;
		}
		permissionDAO.updateEntity(permission);
		return true;
	}

	@Override
	public boolean deletePermissionById(int id) {
		int count = permissionDAO.deleteEntityByProperty("permission_id", Integer.valueOf(id), StandardBasicTypes.INTEGER);
		if(count!=1) return false;
		return true;
	}

	@Override
	public Map<?,?> getAllPermission(QueryItems qi) {
		return permissionDAO.findEntityListByProperties(qi);
	}

	@Override
	public List<?> getAll() {
		return permissionDAO.getAll();
	}

	@Override
	public Permission getPermissionById(int id) {
		List<?> l = permissionDAO.findEntityListByProperty("permission_id", id, StandardBasicTypes.INTEGER);
		if(l==null||l.size()==0) return null;
		return (Permission) l.get(0);
	}

}

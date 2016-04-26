package com.qjs.biz.impl;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.RoleBiz;
import com.qjs.dao.RoleDAO;
import com.qjs.entity.Role;

public class RoleBizImpl implements RoleBiz {
	
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	public Object addRole(Role role) {
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>) roleDAO.findEntityListByProperty("role_name",role.getRole_name(), StringType.INSTANCE);
		if(roleList.size()!=0){
			return -1;
		}
		return roleDAO.addEntity(role);
	}

	@Override
	public boolean updateRole(Role role) {
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>) roleDAO.findEntityListByProperty("role_name",role.getRole_name(), StringType.INSTANCE);
		if(roleList.size()!=1){
			return false;
		}
		roleDAO.updateEntity(role);
		return true;
	}

	@Override
	public boolean deleteRoleById(int id) {
		int count = roleDAO.deleteEntityByProperty("role_id", Integer.valueOf(id), StandardBasicTypes.INTEGER);
		if(count!=1) return false;
		return true;
	}

	@Override
	public Map<?,?> getAllRole(QueryItems qi) {
		return roleDAO.findEntityListByProperties(qi);
	}

	@Override
	public List<?> getAll() {
		return roleDAO.getAll();
	}

	@Override
	public Role getRoleById(int id) {
		@SuppressWarnings("unchecked")
		List<Role> rl = (List<Role>) roleDAO.findEntityListByProperty("role_id", id, StandardBasicTypes.INTEGER);
		if(rl==null||rl.size()==0) return null;
		return rl.get(0);
	}

}

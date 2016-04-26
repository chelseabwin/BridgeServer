package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Role;

public interface RoleBiz {
	
	public Object addRole(Role role);
	
	public Map<?, ?> getAllRole(QueryItems qi);
	
	public boolean updateRole(Role role);
	
	public boolean deleteRoleById(int id);
	
	public List<?> getAll();
	
	public Role getRoleById(int id);

}

package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.Permission;

public interface PermissionBiz {
	
	public Object addPermission(Permission permission);
	
	public Map<?, ?> getAllPermission(QueryItems qi);
	
	public boolean updatePermission(Permission permission);
	
	public boolean deletePermissionById(int id);
	
	public List<?> getAll();
	
	public Permission getPermissionById(int id);
}

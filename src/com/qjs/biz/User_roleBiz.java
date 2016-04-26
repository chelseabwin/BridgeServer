package com.qjs.biz;

import java.util.List;

import com.qjs.entity.User_role;

public interface User_roleBiz {
	
	public boolean addUser_role(User_role user_role);
	
	public boolean deleteUser_roleById(int id);
	
	public boolean deleteUser_roleByUserId(int userId);
	
	public List<User_role> getUser_roleByUserId(int userId);
	
	public List<User_role> getUser_roleByRoleId(int roleId);

}

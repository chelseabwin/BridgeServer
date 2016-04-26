package com.qjs.biz.impl;

import java.util.List;

import org.hibernate.type.StandardBasicTypes;

import com.qjs.biz.User_roleBiz;
import com.qjs.dao.User_roleDAO;
import com.qjs.entity.User_role;

public class User_roleBizImpl implements User_roleBiz {
	
	private User_roleDAO user_roleDAO;

	public User_roleDAO getUser_roleDAO() {
		return user_roleDAO;
	}

	public void setUser_roleDAO(User_roleDAO user_roleDAO) {
		this.user_roleDAO = user_roleDAO;
	}

	@Override
	public boolean addUser_role(User_role user_role) {
		user_roleDAO.addEntity(user_role);
		return true;
	}

	@Override
	public boolean deleteUser_roleById(int id) {
		int count = user_roleDAO.deleteEntityByProperty("user_role_id", Integer.valueOf(id),StandardBasicTypes.INTEGER);
		if(count!=1) return false;
		return true;
	}

	@Override
	public List<User_role> getUser_roleByUserId(int userId) {
		@SuppressWarnings("unchecked")
		List<User_role> user_roleList = (List<User_role>) user_roleDAO.findEntityListByProperty("user_id", Integer.valueOf(userId),StandardBasicTypes.INTEGER);
		return user_roleList;
	}

	@Override
	public List<User_role> getUser_roleByRoleId(int roleId) {
		@SuppressWarnings("unchecked")
		List<User_role> user_roleList = (List<User_role>) user_roleDAO.findEntityListByProperty("role_id", Integer.valueOf(roleId),StandardBasicTypes.INTEGER);
		return user_roleList;
	}

	@Override
	public boolean deleteUser_roleByUserId(int userId) {
		user_roleDAO.deleteEntityByProperty("user_id", Integer.valueOf(userId),StandardBasicTypes.INTEGER);
		return true;
	}

}

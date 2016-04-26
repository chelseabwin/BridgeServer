package com.qjs.biz.impl;

import global.tool.MD5Util;
import global.tool.QueryItems;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

import com.qjs.biz.UserBiz;
import com.qjs.dao.*;
import com.qjs.entity.*;

public class UserBizImpl implements UserBiz {
	
	private UserDAO userDAO;
	private User_roleDAO user_roleDAO;
	private Role_permissionDAO role_permissionDAO;
	private Permission_navigation_barDAO permission_navigation_barDAO;
	private Navigation_barDAO navigation_barDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User_roleDAO getUser_roleDAO() {
		return user_roleDAO;
	}

	public void setUser_roleDAO(User_roleDAO user_roleDAO) {
		this.user_roleDAO = user_roleDAO;
	}

	public Role_permissionDAO getRole_permissionDAO() {
		return role_permissionDAO;
	}

	public void setRole_permissionDAO(Role_permissionDAO role_permissionDAO) {
		this.role_permissionDAO = role_permissionDAO;
	}

	public Permission_navigation_barDAO getPermission_navigation_barDAO() {
		return permission_navigation_barDAO;
	}

	public void setPermission_navigation_barDAO(
			Permission_navigation_barDAO permission_navigation_barDAO) {
		this.permission_navigation_barDAO = permission_navigation_barDAO;
	}

	public Navigation_barDAO getNavigation_barDAO() {
		return navigation_barDAO;
	}

	public void setNavigation_barDAO(Navigation_barDAO navigation_barDAO) {
		this.navigation_barDAO = navigation_barDAO;
	}

	@Override
	public Object addUser(User user) {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userDAO.findEntityListByProperty("loginname", user.getLoginname(), StringType.INSTANCE);
		if(userList.size()!=0){
			return -1;
		}
		
		return userDAO.addEntity(user);
	}

	@Override
	public User getUserByLoginName(String loginName) {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userDAO.findEntityListByProperty("loginname", loginName, StringType.INSTANCE);
		if(userList.size()!=1){
			return null;
		}
		return userList.get(0);
	}

	@Override
	public boolean updateUser(User user) {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userDAO.findEntityListByProperty("loginname", user.getLoginname(), StringType.INSTANCE);
		if(userList.size()!=1){
			return false;
		}
		userDAO.updateEntity(user);
		return true;
	}

	@Override
	public boolean deleteUserById(int id) {
		int count = userDAO.deleteEntityByProperty("user_id", id,StandardBasicTypes.INTEGER);
		if(count!=1) return false;
		return true;
	}

	@Override
	public String loginVerify(String loginName, String password) {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userDAO.findEntityListByProperty("loginname", loginName, StringType.INSTANCE);
		if(userList.size()!=1){
			return "false";
		}
		User user = userList.get(0);
		String pwd = MD5Util.MD5(loginName+password);
		if(userList.get(0).getPassword().equals(pwd)){
			Date now = new Date();
			Timestamp timestamp = new Timestamp(now.getTime());
			user.setLogintime(timestamp);
			user.setIdentity(MD5Util.MD5(now.toString()));
			userDAO.updateEntity(user);
			return user.getIdentity();
		}
		return "false";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<?> getNavigationList(String loginName) {
		List<User_role> user_roleList = new ArrayList<User_role>();
		List<Role_permission> role_permissionList = new ArrayList<Role_permission>();
		List<Permission_navigation_bar> permission_navigation_barList = new ArrayList<Permission_navigation_bar>();
		List<Navigation_bar> navigation_barList = new ArrayList<Navigation_bar>();
		User user  = this.getUserByLoginName(loginName);
		user_roleList = (List<User_role>) user_roleDAO.findEntityListByProperty("user_id", user.getUser_id(), StandardBasicTypes.INTEGER);
		if(user_roleList == null) return null;
		Set<Integer> roleIdSet = new HashSet<Integer>();
		for(User_role ur:user_roleList){
			roleIdSet.add(ur.getRole_id());
		}
		role_permissionList = (List<Role_permission>) role_permissionDAO.findEntityListByPropertyArray("role_id", roleIdSet);
		if(role_permissionList == null) return null;
		Set<Integer> permissionIdSet = new HashSet<Integer>();
		for(Role_permission rp:role_permissionList){
			permissionIdSet.add(rp.getPermission_id());
		}
		permission_navigation_barList = (List<Permission_navigation_bar>) permission_navigation_barDAO.findEntityListByPropertyArray("permission_id", permissionIdSet);
		if(permission_navigation_barList == null) return null;
		Set<Integer> navigation_barIdSet = new HashSet<Integer>();
		for(Permission_navigation_bar pnb:permission_navigation_barList){
			navigation_barIdSet.add(pnb.getNavigation_bar_id());
		}
		navigation_barList = (List<Navigation_bar>) navigation_barDAO.findEntityListByPropertyArray("navigation_bar_id", navigation_barIdSet);
		return navigation_barList;
	}

	@Override
	public List<?> getUserListByDepartmentIds(List<Integer> departmentList,User user) {
		@SuppressWarnings("unchecked")
		List<User> ulist = (List<User>) userDAO.findEntityListByPropertyArray("department_id", departmentList);
		int flag = 0;
		for(User u:ulist){
			if(u.getUser_id().equals(user.getUser_id())){
				flag = 1;
				break;
			}
		}
		if(flag==0){
			ulist.add(user);
		}
		return ulist;
	}

	@Override
	public boolean identityVerify(String loginName, String identify) {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userDAO.findEntityListByProperty("loginname", loginName, StringType.INSTANCE);
		if(userList.size()!=1){
			return false;
		}
		User user = userList.get(0);
		if(!user.getIdentity().equals(identify)){
			user.setIdentity("");
			userDAO.updateEntity(user);
			return false;
		}
		Date date = new Date();
		long diff = date.getTime()-user.getLogintime().getTime();
		if(diff / (1000 * 60)>30){
			user.setIdentity("");
			userDAO.updateEntity(user);
			return false;
		}
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		user.setLogintime(timestamp);
		userDAO.updateEntity(user);
		return true;
	}

	@Override
	public Map<?, ?> getAllUser(QueryItems qi) {
		return userDAO.findEntityListByProperties(qi);
	}

	@Override
	public boolean changePwd(String loginName, String password) {
		@SuppressWarnings("unchecked")
		List<User> ulist = (List<User>) userDAO.findEntityListByProperty("loginname", loginName, StringType.INSTANCE);
		if(ulist!=null&&ulist.size()==1){
			User u = ulist.get(0);
			String pwd = MD5Util.MD5(loginName+password);
			u.setPassword(pwd);
			userDAO.updateEntity(u);
		}
		return false;
	}

	@Override
	public List<?> getALLUsers() {
		return userDAO.getAll();
	}
}

package com.qjs.biz;

import global.tool.QueryItems;

import java.util.List;
import java.util.Map;

import com.qjs.entity.User;

public interface UserBiz {
	
	public Object addUser(User user);
	
	public Map<?, ?> getAllUser(QueryItems qi);
	
	public User getUserByLoginName(String loginName);
	
	public boolean updateUser(User user);
	
	public boolean deleteUserById(int id);
	
	public String loginVerify(String loginName, String password);
	
	public List<?> getNavigationList(String loginName);
	
	public List<?> getUserListByDepartmentIds(List<Integer> departmentList,User user);
	
	public boolean identityVerify(String loginName, String identify);
	
	public boolean changePwd(String loginName,String password);
	
	public List<?> getALLUsers();

}

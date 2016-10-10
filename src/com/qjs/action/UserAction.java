package com.qjs.action;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.RoleBizImpl;
import com.qjs.biz.impl.UserBizImpl;
import com.qjs.biz.impl.User_roleBizImpl;
import com.qjs.entity.Navigation_bar;
import com.qjs.entity.User;
import com.qjs.entity.User_role;

public class UserAction extends ActionSupport implements RequestAware,SessionAware {
	
	private static final long serialVersionUID = 1L;
	private String loginName;
	private String password;
	private UserBizImpl userBiz;
	private String name;
	private Integer pageNo;
	private Integer pageSize;
	private RoleBizImpl roleBiz;
	private String roleList;
	private User_roleBizImpl user_roleBiz;
	private Integer user_id;
	private String newPassword;
	private String newPassword2;
	
	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public User_roleBizImpl getUser_roleBiz() {
		return user_roleBiz;
	}

	public void setUser_roleBiz(User_roleBizImpl user_roleBiz) {
		this.user_roleBiz = user_roleBiz;
	}

	public String getRoleList() {
		return roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}

	public RoleBizImpl getRoleBiz() {
		return roleBiz;
	}

	public void setRoleBiz(RoleBizImpl roleBiz) {
		this.roleBiz = roleBiz;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserBizImpl getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBizImpl userBiz) {
		this.userBiz = userBiz;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	Map<String, Object> request;
	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String login(){
		String status = userBiz.loginVerify(loginName, password);
		User u = userBiz.getUserByLoginName(loginName);
		if (!status.equals("false")) {			
			@SuppressWarnings("unchecked")
			List<Navigation_bar> navigation_barList= (List<Navigation_bar>) userBiz.getNavigationList(loginName);
			List<Navigation_bar> navigationLevel1 = new ArrayList<Navigation_bar>();
			List<Navigation_bar> navigationLevel2 = new ArrayList<Navigation_bar>();
			for(Navigation_bar nb:navigation_barList){
				if(nb.getLevel()==1){
					navigationLevel1.add(nb);
				}else if(nb.getLevel()==2){
					navigationLevel2.add(nb);
				}
			}
			request.put("navigationLevel1", navigationLevel1);
			request.put("navigationLevel2", navigationLevel2);
			session.put("userName", loginName);
			session.put("user", u);
			return "success";
		}
		String result="用户名或密码错误！";
		ServletActionContext.getRequest().setAttribute("result", result);
		return "failed";
	}
	
	public String getBaseList(){
		return "list";
	}
	
	public String getlist(){
		List<QueryObject> qo = new ArrayList<QueryObject>();
		if(this.getLoginName()!=null&&!this.getLoginName().equals("")){
			qo.add(new QueryObject("loginname",this.getLoginName(),null));
		}
		if(this.getName()!=null&&!this.getName().equals("")){
			qo.add(new QueryObject("name",this.getName(),null));
		}
		QueryItems qi = new QueryItems(qo, null, null, this.getPageNo(), this.getPageSize());
		Map<?,?> result = userBiz.getAllUser(qi);
		
		@SuppressWarnings("unchecked")
		List<User> dataList = (List<User>) result.get("result");
		int count = (Integer) result.get("count");
		List<Map<String, Object>> finalList = new ArrayList<Map<String, Object>>();
		for(User u:dataList){
			Map<String, Object> tpResult = new HashMap<String, Object>();
			tpResult.put("user_id", u.getUser_id());
			tpResult.put("loginname", u.getLoginname());
			tpResult.put("name", u.getName());
			String time = "";
			if(u.getLogintime()!=null){
				time = u.getLogintime().toString();
			}
			tpResult.put("logintime", time);
			finalList.add(tpResult);
		}
		request.put("datalist", finalList);
		request.put("count", count);
		int totalPageNumber=0;
		int tmpPageSize=Constant.PAGE_SIZE;
		if(this.getPageSize()!=null&&this.getPageSize()>0){
			tmpPageSize = this.getPageSize();
		}
		totalPageNumber = (int) Math.ceil(count*1.0/tmpPageSize);
		request.put("totalPageNumber", totalPageNumber);
		if(this.getPageNo()==null||this.getPageNo()<1){
			request.put("pageCur", 1);
		}else{
			request.put("pageCur", this.getPageNo());
		}
		return "table_data";
	}
	
	public String addUser(){
		if(this.getLoginName()==null){
			List<?> roleList = roleBiz.getAll();
			request.put("roleList", roleList);
			return "addpage";
		}
		User u = new User();
		u.setPassword(" ");
		u.setLoginname(this.getLoginName());
		u.setName(this.getName());
		Integer id = (Integer) userBiz.addUser(u);
		userBiz.changePwd(this.getLoginName(), this.getLoginName());
		String [] rlist = this.getRoleList().trim().split(" ");
		for(String n:rlist){
			User_role u_r = new User_role();
			u_r.setUser_id(id);
			if(n.equals("")) break;
			u_r.setRole_id(Integer.valueOf(n));
			user_roleBiz.addUser_role(u_r);
		}
		return "list";
	}
	
	public String deleteUser(){
		userBiz.deleteUserById(this.getUser_id());
		return "list";
	}
	
	public String changePwd(){
		if(this.getLoginName()==null){
			return "list";
		}
		User u = userBiz.getUserByLoginName(this.getLoginName());
		request.put("username", u.getLoginname());
		request.put("name", u.getName());
		if(this.getNewPassword()==null){
			return "changepwd";
		}
		userBiz.changePwd(u.getLoginname(), this.getNewPassword());
		request.put("msg", "更改密码成功");
		return "changepwd";
	}
	
	public String logout(){
		session.clear();
		return "logout";
	}
	
	public String changeMyPwd(){
		User u = (User) session.get("user");
		request.put("username", u.getLoginname());
		request.put("name", u.getName());
		if(this.getNewPassword()==null||this.getPassword()==null||this.getNewPassword2()==null){
			return "changeMyPwd";
		}
		String res = userBiz.loginVerify(u.getLoginname(), this.getPassword());
		if(res.equals("false")){
			request.put("msg", "旧密码不正确");
			return "changeMyPwd";
		}
		if(!this.getNewPassword().equals(this.getNewPassword2())){
			request.put("msg", "两次密码不相同");
			return "changeMyPwd";
		}
		if(this.getPassword().equals(this.getNewPassword())){
			request.put("msg", "新密码与旧密码相同");
			return "changeMyPwd";
		}
		userBiz.changePwd(u.getLoginname(), this.getNewPassword());
		request.put("msg", "更改成功");
		return "changeMyPwd";
	}
	
	public String update(){
		if(this.getLoginName()==null||this.getLoginName().equals("")){
			return "list";
		}
		if(this.getUser_id()!=null){
			User u = new User();
			u.setUser_id(this.getUser_id());
			u.setLoginname(this.getLoginName());
			u.setName(this.getName());
			userBiz.updateUser(u);
			System.out.println("already updated");
			String [] rlist = this.getRoleList().trim().split(" ");
			user_roleBiz.deleteUser_roleByUserId(u.getUser_id());
			for(String n:rlist){
				User_role u_r = new User_role();
				u_r.setUser_id(u.getUser_id());
				if(n.equals("")) break;
				u_r.setRole_id(Integer.valueOf(n));
				user_roleBiz.addUser_role(u_r);
			}
			return "list";
		}
		List<?> roleList = roleBiz.getAll();
		request.put("roleList", roleList);
		User u = userBiz.getUserByLoginName(this.getLoginName());
		request.put("user_id", u.getUser_id());
		request.put("loginname", u.getLoginname());
		request.put("name", u.getName());
		List<User_role> urlist = user_roleBiz.getUser_roleByUserId(u.getUser_id());
		List<Integer> ints = new ArrayList<Integer>();
		for(User_role ur: urlist){
			ints.add(ur.getRole_id());
		}
		request.put("authIdList", ints);
		return "update";
	}
}

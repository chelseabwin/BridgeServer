package com.qjs.action;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.PermissionBizImpl;
import com.qjs.biz.impl.RoleBizImpl;
import com.qjs.biz.impl.Role_permissionBizImpl;
import com.qjs.entity.Permission;
import com.qjs.entity.Role;
import com.qjs.entity.Role_permission;

public class RoleAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private RoleBizImpl roleBiz;
	private String role_name;
	private String role_note;
	private Integer pageNo;
	private Integer pageSize;
	private PermissionBizImpl permissionBiz;
	private Role_permissionBizImpl role_permissionBiz;
	private String permissionList;
	private Integer role_id;	
	
	
	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(String permissionList) {
		this.permissionList = permissionList;
	}

	public Role_permissionBizImpl getRole_permissionBiz() {
		return role_permissionBiz;
	}

	public void setRole_permissionBiz(Role_permissionBizImpl role_permissionBiz) {
		this.role_permissionBiz = role_permissionBiz;
	}

	public PermissionBizImpl getPermissionBiz() {
		return permissionBiz;
	}

	public void setPermissionBiz(PermissionBizImpl permissionBiz) {
		this.permissionBiz = permissionBiz;
	}

	public RoleBizImpl getRoleBiz() {
		return roleBiz;
	}

	public void setRoleBiz(RoleBizImpl roleBiz) {
		this.roleBiz = roleBiz;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_note() {
		return role_note;
	}

	public void setRole_note(String role_note) {
		this.role_note = role_note;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String getBaseList(){
		return "list";
	}
	
	public String getlist(){
		List<QueryObject> qo = new ArrayList<QueryObject>();
		if(this.getRole_name()!=null&&!this.getRole_name().equals("")){
			qo.add(new QueryObject("role_name",this.getRole_name(),null));
		}
		if(this.getRole_note()!=null&&!this.getRole_note().equals("")){
			qo.add(new QueryObject("role_note",this.getRole_note(),null));
		}
		QueryItems qi = new QueryItems(qo, null, null, this.getPageNo(), this.getPageSize());
		Map<?,?> result = roleBiz.getAllRole(qi);
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> dataList = (List<Map<String, Object>>) result.get("result");
		int count = (Integer) result.get("count");
		request.put("datalist", dataList);
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
	
	public String addRole(){
		if(this.getRole_name()==null||this.getRole_note()==null){
			List<?> permissionList = permissionBiz.getAll();
			request.put("permissionList", permissionList);
			return "addpage";
		}
		Role r = new Role();
		r.setRole_name(this.getRole_name());
		r.setRole_note(this.getRole_note());
		Integer id = (Integer) roleBiz.addRole(r);
		String [] plist = this.getPermissionList().trim().split(" ");
		for(String n:plist){
			Role_permission rp = new Role_permission();
			rp.setRole_id(id);
			if(n.equals("")) break;
			rp.setPermission_id(Integer.valueOf(n));
			role_permissionBiz.addRole_permission(rp);
		}
		return "list";
	}
	
	public String deleteRole(){
		roleBiz.deleteRoleById(this.getRole_id());
		return "list";
	}
	
	public String viewRole(){
		List<Role_permission> rpl = role_permissionBiz.getRole_permissionByRoleId(this.getRole_id());
		List<Map<String, String>> res_rpl = new ArrayList<Map<String, String>>();
		for(Role_permission rp:rpl){
			Map<String, String> rpMap = new HashMap<String, String>();
			Permission d = permissionBiz.getPermissionById(rp.getPermission_id());
			rpMap.put("name", d.getPermission_name());
			res_rpl.add(rpMap);
		}
		request.put("res_rpl", res_rpl);
		
		Role r = roleBiz.getRoleById(this.getRole_id());
		request.put("role", r);
		return "view";
	}
	
	public void validate(){
		if(session.get("userName")==null){
			session.clear();
			this.addActionError("error");
		}
	}

}

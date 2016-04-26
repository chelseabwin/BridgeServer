package com.qjs.action;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.Navigation_barBizImpl;
import com.qjs.biz.impl.PermissionBizImpl;
import com.qjs.biz.impl.Permission_navigation_barBizImpl;
import com.qjs.entity.Permission;
import com.qjs.entity.Permission_navigation_bar;

public class PermissionAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private PermissionBizImpl permissionBiz;
	private String permission_name;
	private String permission_note;
	private Integer pageNo;
	private Integer pageSize;
	private Permission_navigation_barBizImpl permission_navigation_barBiz;
	private Navigation_barBizImpl navigation_barBiz;
	private String navigation_barList;
	private Integer permission_id;
	
	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public String getNavigation_barList() {
		return navigation_barList;
	}

	public void setNavigation_barList(String navigation_barList) {
		this.navigation_barList = navigation_barList;
	}

	public Navigation_barBizImpl getNavigation_barBiz() {
		return navigation_barBiz;
	}

	public void setNavigation_barBiz(Navigation_barBizImpl navigation_barBiz) {
		this.navigation_barBiz = navigation_barBiz;
	}

	public Permission_navigation_barBizImpl getPermission_navigation_barBiz() {
		return permission_navigation_barBiz;
	}

	public void setPermission_navigation_barBiz(
			Permission_navigation_barBizImpl permission_navigation_barBiz) {
		this.permission_navigation_barBiz = permission_navigation_barBiz;
	}

	public PermissionBizImpl getPermissionBiz() {
		return permissionBiz;
	}

	public void setPermissionBiz(PermissionBizImpl permissionBiz) {
		this.permissionBiz = permissionBiz;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

	public String getPermission_note() {
		return permission_note;
	}

	public void setPermission_note(String permission_note) {
		this.permission_note = permission_note;
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
		if(this.getPermission_name()!=null&&!this.getPermission_name().equals("")){
			qo.add(new QueryObject("permission_name",this.getPermission_name(),null));
		}
		if(this.getPermission_note()!=null&&!this.getPermission_note().equals("")){
			qo.add(new QueryObject("permission_note",this.getPermission_note(),null));
		}
		QueryItems qi = new QueryItems(qo, null, null, this.getPageNo(), this.getPageSize());
		Map<?, ?> result = permissionBiz.getAllPermission(qi);
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
	
	public String addPermission(){
		if(this.getPermission_name()==null||this.getPermission_note()==null){
			Map<?, ?> res=navigation_barBiz.getAllNavigation_bar(null);
			@SuppressWarnings("unchecked")
			List<Map<String,Object>> dataList = (List<Map<String, Object>>) res.get("result");
			request.put("datalist", dataList);
			return "addpage";
		}
		Permission p = new Permission();
		p.setPermission_name(this.getPermission_name());
		p.setPermission_note(this.getPermission_note());
		
		Integer id = (Integer) permissionBiz.addPermission(p);
		String [] nlist = this.getNavigation_barList().trim().split(" ");
		for(String n:nlist){
			if(n.equals("")) break;
			Permission_navigation_bar pnb = new Permission_navigation_bar();
			pnb.setNavigation_bar_id(Integer.valueOf(n));
			pnb.setPermission_id(id);
			permission_navigation_barBiz.addPermission_navigation_bar(pnb);
		}
		return "list";
	}
	
	public String deletePermission(){
		permissionBiz.deletePermissionById(this.getPermission_id());
		return "list";
	}
	
	public void validate(){
		if(session.get("userName")==null){
			session.clear();
			this.addActionError("error");
		}
	}

}

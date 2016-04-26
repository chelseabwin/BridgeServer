package com.qjs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.Navigation_barBizImpl;

public class Navigation_barAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private Navigation_barBizImpl navigation_barBiz;
	private String name;
	private Integer level;
	private Integer up;
	private String url;
	private Integer priority;
	private Integer pageNo;
	private Integer pageSize;
	private Integer navigation_bar_id;
	
	public Integer getNavigation_bar_id() {
		return navigation_bar_id;
	}

	public void setNavigation_bar_id(Integer navigation_bar_id) {
		this.navigation_bar_id = navigation_bar_id;
	}

	public Navigation_barBizImpl getNavigation_barBiz() {
		return navigation_barBiz;
	}

	public void setNavigation_barBiz(Navigation_barBizImpl navigation_barBiz) {
		this.navigation_barBiz = navigation_barBiz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getUp() {
		return up;
	}

	public void setUp(Integer up) {
		this.up = up;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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
		Map<?,?> result = navigation_barBiz.getAllNavigation_bar(null);
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> dataList = (List<Map<String, Object>>) result.get("result");
		int count = (Integer) result.get("count");
		request.put("datalist", dataList);
		request.put("count", count);
		return "table_data";
	}
	
	public String deleteNavigation_bar(){
		navigation_barBiz.deleteNavigation_barById(this.getNavigation_bar_id());
		return "list";
	}
	
	public void validate(){
		if(session.get("userName")==null){
			session.clear();
			this.addActionError("error");
		}
	}

}

package com.qjs.entity;

public class Permission_navigation_bar implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer permission_navigation_bar_id;
	private Integer permission_id;
	private Integer navigation_bar_id;
	
	public Permission_navigation_bar(){
		
	}

	public Permission_navigation_bar(Integer permission_navigation_bar_id,
			Integer permission_id, Integer navigation_bar_id) {
		super();
		this.permission_navigation_bar_id = permission_navigation_bar_id;
		this.permission_id = permission_id;
		this.navigation_bar_id = navigation_bar_id;
	}

	public Integer getPermission_navigation_bar_id() {
		return permission_navigation_bar_id;
	}

	public void setPermission_navigation_bar_id(Integer permission_navigation_bar_id) {
		this.permission_navigation_bar_id = permission_navigation_bar_id;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public Integer getNavigation_bar_id() {
		return navigation_bar_id;
	}

	public void setNavigation_bar_id(Integer navigation_bar_id) {
		this.navigation_bar_id = navigation_bar_id;
	}

}

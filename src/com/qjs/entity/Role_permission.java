package com.qjs.entity;

public class Role_permission implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer role_permission_id;
	private Integer role_id;
	private Integer permission_id;
	
	public Role_permission(){
		
	}

	public Role_permission(Integer role_permission_id, Integer role_id,
			Integer permission_id) {
		super();
		this.role_permission_id = role_permission_id;
		this.role_id = role_id;
		this.permission_id = permission_id;
	}

	public Integer getRole_permission_id() {
		return role_permission_id;
	}

	public void setRole_permission_id(Integer role_permission_id) {
		this.role_permission_id = role_permission_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

}

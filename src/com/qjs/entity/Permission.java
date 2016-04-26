package com.qjs.entity;

public class Permission implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer permission_id;
	private String permission_name;
	private String permission_note;
	
	public Permission(){
		
	}
	
	public Permission(Integer permission_id, String permission_name,
			String permission_note) {
		super();
		this.permission_id = permission_id;
		this.permission_name = permission_name;
		this.permission_note = permission_note;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
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
	

}

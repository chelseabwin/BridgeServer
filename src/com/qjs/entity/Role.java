package com.qjs.entity;

public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer role_id;
	private String role_name;
	private String role_note;
	
	public Role(){
		
	}

	public Role(Integer role_id, String role_name, String role_note) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_note = role_note;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
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
}

package com.qjs.entity;

import java.sql.Timestamp;

public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String loginname;
	private String password;
	private String name;
	private Timestamp logintime;
	private String identity;
	
	public User(){
		
	}

	public User(Integer user_id, String loginname, String password,
			String name, Timestamp logintime, String identity) {
		super();
		this.user_id = user_id;
		this.loginname = loginname;
		this.password = password;
		this.name = name;
		this.logintime = logintime;
		this.identity = identity;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Timestamp getLogintime() {
		return logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
}

package com.qjs.entity;

public class Navigation_bar implements java.io.Serializable {
		
	private static final long serialVersionUID = 1L;
	private Integer navigation_bar_id;
	private Integer level;
	private Integer up;
	private String name;
	private String url;
	private Integer priority;
	
	public Navigation_bar(){
		
	}

	public Navigation_bar(Integer navigation_bar_id, Integer level, Integer up,
			String name, String url) {
		super();
		this.navigation_bar_id = navigation_bar_id;
		this.level = level;
		this.up = up;
		this.name = name;
		this.url = url;
	}

	public Integer getNavigation_bar_id() {
		return navigation_bar_id;
	}

	public void setNavigation_bar_id(Integer navigation_bar_id) {
		this.navigation_bar_id = navigation_bar_id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}

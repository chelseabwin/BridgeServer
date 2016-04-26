package com.qjs.entity;

public class Base1 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bridge_code;
	private String bridge_name;
	private String path_num;
	private String path_name;
	private String path_type;
	private String rode_grade;
	private String order_num;
	private String location;
	private String center_stake;	
	private String custody_unit;
	private String across_name;
	private String across_type;
	private String bridge_nature;
	private String flag;
	
	public Base1() {
		
	}
	
	public Base1(Integer id, String bridge_code, String bridge_name, String path_num, 
			String path_name, String path_type, String rode_grade, String order_num, String location, 
			String center_stake, String custody_unit, String across_name, String across_type, 
			String bridge_nature, String flag) {
		super();
		this.id = id;
		this.bridge_code = bridge_code;
		this.bridge_name = bridge_name;
		this.path_num = path_num;
		this.path_name = path_name;
		this.path_type = path_type;		
		this.rode_grade = rode_grade;
		this.order_num = order_num;
		this.location = location;
		this.center_stake = center_stake;
		this.custody_unit = custody_unit;
		this.across_name = across_name;		
		this.across_type = across_type;
		this.bridge_nature = bridge_nature;
		this.flag = flag;
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBridge_code() {
		return bridge_code;
	}

	public void setBridge_code(String bridge_code) {
		this.bridge_code = bridge_code;
	}
	
	public String getBridge_name() {
		return bridge_name;
	}

	public void setBridge_name(String bridge_name) {
		this.bridge_name = bridge_name;
	}
	
	public String getPath_num() {
		return path_num;
	}

	public void setPath_num(String path_num) {
		this.path_num = path_num;
	}
	
	public String getPath_name() {
		return path_name;
	}

	public void setPath_name(String path_name) {
		this.path_name = path_name;
	}
	
	public String getPath_type() {
		return path_type;
	}

	public void setPath_type(String path_type) {
		this.path_type = path_type;
	}
	
	public String getRode_grade() {
		return rode_grade;
	}

	public void setRode_grade(String rode_grade) {
		this.rode_grade = rode_grade;
	}
	
	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCenter_stake() {
		return center_stake;
	}

	public void setCenter_stake(String center_stake) {
		this.center_stake = center_stake;
	}
	
	public String getCustody_unit() {
		return custody_unit;
	}

	public void setCustody_unit(String custody_unit) {
		this.custody_unit = custody_unit;
	}
	
	public String getAcross_name() {
		return across_name;
	}

	public void setAcross_name(String across_name) {
		this.across_name = across_name;
	}
	
	public String getAcross_type() {
		return across_type;
	}

	public void setAcross_type(String across_type) {
		this.across_type = across_type;
	}
	
	public String getBridge_nature() {
		return bridge_nature;
	}

	public void setBridge_nature(String bridge_nature) {
		this.bridge_nature = bridge_nature;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

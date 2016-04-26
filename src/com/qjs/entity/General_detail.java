package com.qjs.entity;

public class General_detail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String general_details;
	private String general_nums;
	private String flag;
	
	public General_detail() {
		
	}
	
	public General_detail(Integer id, String bg_id, String general_details, 
			String general_nums, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.general_details = general_details;
		this.general_nums = general_nums;
		this.flag = flag;
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBg_id() {
		return bg_id;
	}

	public void setBg_id(String bg_id) {
		this.bg_id = bg_id;
	}
	
	public String getGeneral_details() {
		return general_details;
	}

	public void setGeneral_details(String general_details) {
		this.general_details = general_details;
	}
	
	public String getGeneral_nums() {
		return general_nums;
	}

	public void setGeneral_nums(String general_nums) {
		this.general_nums = general_nums;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

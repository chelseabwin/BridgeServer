package com.qjs.entity;

public class Support_detail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String support_details;
	private String support_nums;
	private String flag;
	
	public Support_detail() {
		
	}
	
	public Support_detail(Integer id, String bg_id, String support_details,
			String support_nums, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.support_details = support_details;
		this.support_nums = support_nums;
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
	
	public String getSupport_details() {
		return support_details;
	}

	public void setSupport_details(String support_details) {
		this.support_details = support_details;
	}
	
	public String getSupport_nums() {
		return support_nums;
	}

	public void setSupport_nums(String support_nums) {
		this.support_nums = support_nums;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

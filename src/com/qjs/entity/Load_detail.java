package com.qjs.entity;

public class Load_detail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String load_details;
	private String load_nums;
	private String flag;
	
	public Load_detail() {
		
	}
	
	public Load_detail(Integer id, String bg_id, String load_details,
			String load_nums, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.load_details = load_details;
		this.load_nums = load_nums;
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
	
	public String getLoad_details() {
		return load_details;
	}

	public void setLoad_details(String load_details) {
		this.load_details = load_details;
	}
	
	public String getLoad_nums() {
		return load_nums;
	}

	public void setLoad_nums(String load_nums) {
		this.load_nums = load_nums;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

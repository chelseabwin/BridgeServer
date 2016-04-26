package com.qjs.entity;

public class Pier_detail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String pier_details;
	private String pier_nums;
	private String bent_cap_nums;
	private String tie_beam_nums;
	private String flag;
	
	public Pier_detail() {
		
	}
	
	public Pier_detail(Integer id, String bg_id, String pier_details, String pier_nums, 
			String bent_cap_nums, String tie_beam_nums, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.pier_details = pier_details;
		this.pier_nums = pier_nums;
		this.bent_cap_nums = bent_cap_nums;
		this.tie_beam_nums = tie_beam_nums;
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
	
	public String getPier_details() {
		return pier_details;
	}

	public void setPier_details(String pier_details) {
		this.pier_details = pier_details;
	}
	
	public String getPier_nums() {
		return pier_nums;
	}

	public void setPier_nums(String pier_nums) {
		this.pier_nums = pier_nums;
	}
	
	public String getBent_cap_nums() {
		return bent_cap_nums;
	}

	public void setBent_cap_nums(String bent_cap_nums) {
		this.bent_cap_nums = bent_cap_nums;
	}
	
	public String getTie_beam_nums() {
		return tie_beam_nums;
	}

	public void setTie_beam_nums(String tie_beam_nums) {
		this.tie_beam_nums = tie_beam_nums;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

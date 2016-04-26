package com.qjs.entity;

public class Parts1 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String wing_wall;
	private String conical_slope;
	private String protection_slope;
	private String pier_detail;
	private String abutment_num;
	private String pa_num;
	private String bed_num;
	private String reg_structure;
	private String flag;
	
	public Parts1() {
		
	}
	
	public Parts1(Integer id, String bg_id, String wing_wall, String conical_slope, 
			String protection_slope, String pier_detail, String abutment_num, String pa_num,
			String bed_num, String reg_structure, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.wing_wall = wing_wall;
		this.conical_slope = conical_slope;
		this.protection_slope = protection_slope;
		this.pier_detail = pier_detail;		
		this.abutment_num = abutment_num;
		this.pa_num = pa_num;
		this.bed_num = bed_num;
		this.reg_structure = reg_structure;
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
	
	public String getWing_wall() {
		return wing_wall;
	}

	public void setWing_wall(String wing_wall) {
		this.wing_wall = wing_wall;
	}
	
	public String getConical_slope() {
		return conical_slope;
	}

	public void setConical_slope(String conical_slope) {
		this.conical_slope = conical_slope;
	}
	
	public String getProtection_slope() {
		return protection_slope;
	}

	public void setProtection_slope(String protection_slope) {
		this.protection_slope = protection_slope;
	}
	
	public String getPier_detail() {
		return pier_detail;
	}

	public void setPier_detail(String pier_detail) {
		this.pier_detail = pier_detail;
	}
	
	public String getAbutment_num() {
		return abutment_num;
	}

	public void setAbutment_num(String abutment_num) {
		this.abutment_num = abutment_num;
	}
	
	public String getPa_num() {
		return pa_num;
	}

	public void setPa_num(String pa_num) {
		this.pa_num = pa_num;
	}
	
	public String getBed_num() {
		return bed_num;
	}

	public void setBed_num(String bed_num) {
		this.bed_num = bed_num;
	}
	
	public String getReg_structure() {
		return reg_structure;
	}

	public void setReg_structure(String reg_structure) {
		this.reg_structure = reg_structure;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

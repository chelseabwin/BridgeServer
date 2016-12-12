package com.qjs.entity;

public class Disease_wetjoint implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String parts_id;
	private String item_name;
	private String rg_feature;
	private String rg_fissure;
	private String sp_otherDisease;
	private String l1_start;
	private String l1_end;
	private String l1_area;	
	private String l2_start;
	private String l2_length;
	private String l2_width;
	private String add_content;
	private String disease_image;
	private String image_type;
	private String evaluation;
	private String score;
	private String flag;
	
	public Disease_wetjoint() {
		
	}
	
	public Disease_wetjoint(Integer id, String bg_id, String parts_id, String item_name, String rg_feature, 
			String rg_fissure, String sp_otherDisease, String l1_start, String l1_end, String l1_area, 
			String l2_start, String l2_length, String l2_width, String add_content, String disease_image,
			String image_type, String evaluation, String score, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.parts_id = parts_id;
		this.item_name = item_name;
		this.rg_feature = rg_feature;
		this.rg_fissure = rg_fissure;		
		this.sp_otherDisease = sp_otherDisease;
		this.l1_start = l1_start;
		this.l1_end = l1_end;
		this.l1_area = l1_area;
		this.l2_start = l2_start;
		this.l2_length = l2_length;		
		this.l2_width = l2_width;
		this.add_content = add_content;
		this.disease_image = disease_image;
		this.image_type = image_type;
		this.evaluation = evaluation;
		this.score = score;
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
	
	public String getParts_id() {
		return parts_id;
	}

	public void setParts_id(String parts_id) {
		this.parts_id = parts_id;
	}
	
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	public String getRg_feature() {
		return rg_feature;
	}

	public void setRg_feature(String rg_feature) {
		this.rg_feature = rg_feature;
	}
	
	public String getRg_fissure() {
		return rg_fissure;
	}

	public void setRg_fissure(String rg_fissure) {
		this.rg_fissure = rg_fissure;
	}
	
	public String getSp_otherDisease() {
		return sp_otherDisease;
	}

	public void setSp_otherDisease(String sp_otherDisease) {
		this.sp_otherDisease = sp_otherDisease;
	}
	
	public String getL1_start() {
		return l1_start;
	}

	public void setL1_start(String l1_start) {
		this.l1_start = l1_start;
	}
	
	public String getL1_end() {
		return l1_end;
	}

	public void setL1_end(String l1_end) {
		this.l1_end = l1_end;
	}
	
	public String getL1_area() {
		return l1_area;
	}

	public void setL1_area(String l1_area) {
		this.l1_area = l1_area;
	}
	
	public String getL2_start() {
		return l2_start;
	}

	public void setL2_start(String l2_start) {
		this.l2_start = l2_start;
	}
	
	public String getL2_length() {
		return l2_length;
	}

	public void setL2_length(String l2_length) {
		this.l2_length = l2_length;
	}
	
	public String getL2_width() {
		return l2_width;
	}

	public void setL2_width(String l2_width) {
		this.l2_width = l2_width;
	}
	
	public String getAdd_content() {
		return add_content;
	}

	public void setAdd_content(String add_content) {
		this.add_content = add_content;
	}
	
	public String getDisease_image() {
		return disease_image;
	}

	public void setDisease_image(String disease_image) {
		this.disease_image = disease_image;
	}
	
	public String getImage_type() {
		return image_type;
	}

	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}
	
	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

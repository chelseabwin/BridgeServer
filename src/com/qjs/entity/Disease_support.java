package com.qjs.entity;

public class Disease_support implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String parts_id;
	private String item_name;
	private String rg_feature;
	private String add_content;
	private String disease_image;
	private String image_type;
	private String evaluation;
	private String score;
	private String detect_time;
	private String flag;
	
	public Disease_support() {
		
	}
	
	public Disease_support(Integer id, String bg_id, String parts_id, String item_name, String rg_feature, 
			String add_content, String disease_image, String image_type, String evaluation, String score, 
			String detect_time, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.parts_id = parts_id;
		this.item_name = item_name;
		this.rg_feature = rg_feature;
		this.add_content = add_content;
		this.disease_image = disease_image;
		this.image_type = image_type;
		this.evaluation = evaluation;
		this.score = score;
		this.detect_time = detect_time;
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
	
	public String getDetect_time() {
		return detect_time;
	}

	public void setDetect_time(String detect_time) {
		this.detect_time = detect_time;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

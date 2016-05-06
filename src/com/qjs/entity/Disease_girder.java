package com.qjs.entity;

public class Disease_girder implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String parts_id;
	private String item_name;
	private String rg_feature;
	private String rg_fissure;
	private String sp_otherDisease;
	private String start;
	private String end;
	private String area;	
	private String length;
	private String width;
	private String side_start;
	private String side_end;
	private String side_length;
	private String side_width;
	private String rg_location;
	private String add_content;
	private String disease_image;
	private String flag;
	
	public Disease_girder() {
		
	}
	
	public Disease_girder(Integer id, String bg_id, String parts_id, String item_name, String rg_feature, 
			String rg_fissure, String sp_otherDisease, String start, String end, String area, 
			String length, String width, String side_start, String side_end, String side_length, 
			String side_width, String rg_location, String add_content, String disease_image, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.parts_id = parts_id;
		this.item_name = item_name;
		this.rg_feature = rg_feature;
		this.rg_fissure = rg_fissure;		
		this.sp_otherDisease = sp_otherDisease;
		this.start = start;
		this.end = end;
		this.area = area;
		this.length = length;
		this.width = width;		
		this.side_start = side_start;
		this.side_end = side_end;
		this.side_length = side_length;
		this.side_width = side_width;
		this.rg_location = rg_location;
		this.add_content = add_content;
		this.disease_image = disease_image;
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
	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
	
	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	public String getSide_start() {
		return side_start;
	}

	public void setSide_start(String side_start) {
		this.side_start = side_start;
	}
	
	public String getSide_end() {
		return side_end;
	}

	public void setSide_end(String side_end) {
		this.side_end = side_end;
	}
	
	public String getSide_length() {
		return side_length;
	}

	public void setSide_length(String side_length) {
		this.side_length = side_length;
	}
	
	public String getSide_width() {
		return side_width;
	}

	public void setSide_width(String side_width) {
		this.side_width = side_width;
	}
	
	public String getRg_location() {
		return rg_location;
	}

	public void setRg_location(String rg_location) {
		this.rg_location = rg_location;
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
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

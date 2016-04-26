package com.qjs.entity;

public class Base3 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String pier_material;
	private String section_form;
	private String pier_type;
	private String section_shape;
	private String abutment_material;
	private String abutment_type;
	private String pier_abutment_material;
	private String pier_abutment_base;	
	private String deck_type;
	private String joint_type;
	private String flag;
	
	public Base3() {
		
	}
	
	public Base3(Integer id, String bg_id, String pier_material, String section_form, 
			String pier_type, String section_shape, String abutment_material, String abutment_type,
			String pier_abutment_material, String pier_abutment_base, String deck_type,
			String joint_type, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.pier_material = pier_material;
		this.section_form = section_form;
		this.pier_type = pier_type;
		this.section_shape = section_shape;	
		this.abutment_material = abutment_material;
		this.abutment_type = abutment_type;
		this.pier_abutment_material = pier_abutment_material;
		this.pier_abutment_base = pier_abutment_base;
		this.deck_type = deck_type;
		this.joint_type = joint_type;
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
	
	public String getPier_material() {
		return pier_material;
	}

	public void setPier_material(String pier_material) {
		this.pier_material = pier_material;
	}
	
	public String getSection_form() {
		return section_form;
	}

	public void setSection_form(String section_form) {
		this.section_form = section_form;
	}
	
	public String getPier_type() {
		return pier_type;
	}

	public void setPier_type(String pier_type) {
		this.pier_type = pier_type;
	}
	
	public String getSection_shape() {
		return section_shape;
	}

	public void setSection_shape(String section_shape) {
		this.section_shape = section_shape;
	}
	
	public String getAbutment_material() {
		return abutment_material;
	}

	public void setAbutment_material(String abutment_material) {
		this.abutment_material = abutment_material;
	}
	
	public String getAbutment_type() {
		return abutment_type;
	}

	public void setAbutment_type(String abutment_type) {
		this.abutment_type = abutment_type;
	}
	
	public String getPier_abutment_material() {
		return pier_abutment_material;
	}

	public void setPier_abutment_material(String pier_abutment_material) {
		this.pier_abutment_material = pier_abutment_material;
	}
	
	public String getPier_abutment_base() {
		return pier_abutment_base;
	}

	public void setPier_abutment_base(String pier_abutment_base) {
		this.pier_abutment_base = pier_abutment_base;
	}
	
	public String getDeck_type() {
		return deck_type;
	}

	public void setDeck_type(String deck_type) {
		this.deck_type = deck_type;
	}
	
	public String getJoint_type() {
		return joint_type;
	}

	public void setJoint_type(String joint_type) {
		this.joint_type = joint_type;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

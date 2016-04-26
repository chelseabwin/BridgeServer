package com.qjs.entity;

public class Base2 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String bridge_classify;
	private String design_load;
	private String bridge_use;
	private String bridge_status;
	private String material_code;
	private String bridge_panel;
	private String stress_pattern;
	private String support_type;	
	private String bridge_type;
	private String flag;
	
	public Base2() {
		
	}
	
	public Base2(Integer id, String bg_id, String bridge_classify, String design_load, 
			String bridge_use, String bridge_status, String material_code, String bridge_panel,
			String stress_pattern, String support_type, String bridge_type, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.bridge_classify = bridge_classify;
		this.design_load = design_load;
		this.bridge_use = bridge_use;
		this.bridge_status = bridge_status;		
		this.material_code = material_code;
		this.bridge_panel = bridge_panel;
		this.stress_pattern = stress_pattern;
		this.support_type = support_type;
		this.bridge_type = bridge_type;
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
	
	public String getBridge_classify() {
		return bridge_classify;
	}

	public void setBridge_classify(String bridge_classify) {
		this.bridge_classify = bridge_classify;
	}
	
	public String getDesign_load() {
		return design_load;
	}

	public void setDesign_load(String design_load) {
		this.design_load = design_load;
	}
	
	public String getBridge_use() {
		return bridge_use;
	}

	public void setBridge_use(String bridge_use) {
		this.bridge_use = bridge_use;
	}
	
	public String getBridge_status() {
		return bridge_status;
	}

	public void setBridge_status(String bridge_status) {
		this.bridge_status = bridge_status;
	}
	
	public String getMaterial_code() {
		return material_code;
	}

	public void setMaterial_code(String material_code) {
		this.material_code = material_code;
	}
	
	public String getBridge_panel() {
		return bridge_panel;
	}

	public void setBridge_panel(String bridge_panel) {
		this.bridge_panel = bridge_panel;
	}
	
	public String getStress_pattern() {
		return stress_pattern;
	}

	public void setStress_pattern(String stress_pattern) {
		this.stress_pattern = stress_pattern;
	}
	
	public String getSupport_type() {
		return support_type;
	}

	public void setSupport_type(String support_type) {
		this.support_type = support_type;
	}
	
	public String getBridge_type() {
		return bridge_type;
	}

	public void setBridge_type(String bridge_type) {
		this.bridge_type = bridge_type;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

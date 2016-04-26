package com.qjs.entity;

public class Parts2 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String load_detail;
	private String general_detail;
	private String support_detail;
	private String deck_num;
	private String joint_num;
	private String sidewalk;
	private String guardrail;
	private String drainage_system;	
	private String illuminated_sign;
	private String flag;
	
	public Parts2() {
		
	}
	
	public Parts2(Integer id, String bg_id, String load_detail, String general_detail, 
			String support_detail, String deck_num, String joint_num, String sidewalk,
			String guardrail, String drainage_system, String illuminated_sign, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.load_detail = load_detail;
		this.general_detail = general_detail;
		this.support_detail = support_detail;
		this.deck_num = deck_num;		
		this.joint_num = joint_num;
		this.sidewalk = sidewalk;
		this.guardrail = guardrail;
		this.drainage_system = drainage_system;
		this.illuminated_sign = illuminated_sign;
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
	
	public String getLoad_detail() {
		return load_detail;
	}

	public void setLoad_detail(String load_detail) {
		this.load_detail = load_detail;
	}
	
	public String getGeneral_detail() {
		return general_detail;
	}

	public void setGeneral_detail(String general_detail) {
		this.general_detail = general_detail;
	}
	
	public String getSupport_detail() {
		return support_detail;
	}

	public void setSupport_detail(String support_detail) {
		this.support_detail = support_detail;
	}
	
	public String getDeck_num() {
		return deck_num;
	}

	public void setDeck_num(String deck_num) {
		this.deck_num = deck_num;
	}
	
	public String getJoint_num() {
		return joint_num;
	}

	public void setJoint_num(String joint_num) {
		this.joint_num = joint_num;
	}
	
	public String getSidewalk() {
		return sidewalk;
	}

	public void setSidewalk(String sidewalk) {
		this.sidewalk = sidewalk;
	}
	
	public String getGuardrail() {
		return guardrail;
	}

	public void setGuardrail(String guardrail) {
		this.guardrail = guardrail;
	}
	
	public String getDrainage_system() {
		return drainage_system;
	}

	public void setDrainage_system(String drainage_system) {
		this.drainage_system = drainage_system;
	}
	
	public String getIlluminated_sign() {
		return illuminated_sign;
	}

	public void setIlluminated_sign(String illuminated_sign) {
		this.illuminated_sign = illuminated_sign;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

package com.qjs.entity;

public class Structure implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String bridge_span;
	private String longest_span;
	private String total_len;
	private String bridge_wide;
	private String full_wide;
	private String clear_wide;
	private String bridge_high;
	private String high_limit;	
	private String building_time;
	private String navigation_level;
	private String section_high;
	private String deck_profile_grade;
	private String flag;
	
	public Structure() {
		
	}
	
	public Structure(Integer id, String bg_id, String bridge_span, String longest_span, 
			String total_len, String bridge_wide, String full_wide, String clear_wide,
			String bridge_high, String high_limit, String building_time, String navigation_level,
			String section_high, String deck_profile_grade, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.bridge_span = bridge_span;
		this.longest_span = longest_span;
		this.total_len = total_len;
		this.bridge_wide = bridge_wide;		
		this.full_wide = full_wide;
		this.clear_wide = clear_wide;
		this.bridge_high = bridge_high;
		this.high_limit = high_limit;
		this.building_time = building_time;
		this.navigation_level = navigation_level;
		this.section_high = section_high;
		this.deck_profile_grade = deck_profile_grade;
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
	
	public String getBridge_span() {
		return bridge_span;
	}

	public void setBridge_span(String bridge_span) {
		this.bridge_span = bridge_span;
	}
	
	public String getLongest_span() {
		return longest_span;
	}

	public void setLongest_span(String longest_span) {
		this.longest_span = longest_span;
	}
	
	public String getTotal_len() {
		return total_len;
	}

	public void setTotal_len(String total_len) {
		this.total_len = total_len;
	}
	
	public String getBridge_wide() {
		return bridge_wide;
	}

	public void setBridge_wide(String bridge_wide) {
		this.bridge_wide = bridge_wide;
	}
	
	public String getFull_wide() {
		return full_wide;
	}

	public void setFull_wide(String full_wide) {
		this.full_wide = full_wide;
	}
	
	public String getClear_wide() {
		return clear_wide;
	}

	public void setClear_wide(String clear_wide) {
		this.clear_wide = clear_wide;
	}
	
	public String getBridge_high() {
		return bridge_high;
	}

	public void setBridge_high(String bridge_high) {
		this.bridge_high = bridge_high;
	}
	
	public String getHigh_limit() {
		return high_limit;
	}

	public void setHigh_limit(String high_limit) {
		this.high_limit = high_limit;
	}
	
	public String getBuilding_time() {
		return building_time;
	}

	public void setBuilding_time(String building_time) {
		this.building_time = building_time;
	}
	
	public String getNavigation_level() {
		return navigation_level;
	}

	public void setNavigation_level(String navigation_level) {
		this.navigation_level = navigation_level;
	}
	
	public String getSection_high() {
		return section_high;
	}

	public void setSection_high(String section_high) {
		this.section_high = section_high;
	}
	
	public String getDeck_profile_grade() {
		return deck_profile_grade;
	}

	public void setDeck_profile_grade(String deck_profile_grade) {
		this.deck_profile_grade = deck_profile_grade;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

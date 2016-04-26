package com.qjs.entity;

public class Pier_add implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String bg_id;
	private String start_pier;
	private String end_pier;
	private String per_pier;
	private String bent_cap;
	private String tie_beam;
	private String tap;
	private String flag;
	
	public Pier_add() {
		
	}
	
	public Pier_add(Integer id, String bg_id, String start_pier, String end_pier, 
			String per_pier, String bent_cap, String tie_beam, String tap, String flag) {
		super();
		this.id = id;
		this.bg_id = bg_id;
		this.start_pier = start_pier;
		this.end_pier = end_pier;
		this.per_pier = per_pier;
		this.bent_cap = bent_cap;
		this.tie_beam = tie_beam;
		this.tap = tap;
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
	
	public String getStart_pier() {
		return start_pier;
	}

	public void setStart_pier(String start_pier) {
		this.start_pier = start_pier;
	}
	
	public String getEnd_pier() {
		return end_pier;
	}

	public void setEnd_pier(String end_pier) {
		this.end_pier = end_pier;
	}
	
	public String getPer_pier() {
		return per_pier;
	}

	public void setPer_pier(String per_pier) {
		this.per_pier = per_pier;
	}
	
	public String getBent_cap() {
		return bent_cap;
	}

	public void setBent_cap(String bent_cap) {
		this.bent_cap = bent_cap;
	}
	
	public String getTie_beam() {
		return tie_beam;
	}

	public void setTie_beam(String tie_beam) {
		this.tie_beam = tie_beam;
	}
	
	public String getTap() {
		return tap;
	}

	public void setTap(String tap) {
		this.tap = tap;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}

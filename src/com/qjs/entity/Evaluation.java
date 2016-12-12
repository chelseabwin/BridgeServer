package com.qjs.entity;

public class Evaluation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String table_name;
	private String bg_id;
	private String parts_id;
	private String dis_id;
	private String evaluation;
	private String score;
	
	public Evaluation() {
		
	}
	
	public Evaluation(Integer id, String table_name, String bg_id, String parts_id,
			String dis_id, String evaluation, String score) {
		super();
		this.id = id;
		this.table_name = table_name;
		this.bg_id = bg_id;
		this.parts_id = parts_id;
		this.dis_id = dis_id;
		this.evaluation = evaluation;
		this.score = score;
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
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
	
	public String getDis_id() {
		return dis_id;
	}

	public void setDis_id(String dis_id) {
		this.dis_id = dis_id;
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
}

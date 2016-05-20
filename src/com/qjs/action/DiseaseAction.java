package com.qjs.action;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.Base1BizImpl;
import com.qjs.biz.impl.Disease_atbodyBizImpl;
import com.qjs.biz.impl.Disease_atcappingBizImpl;
import com.qjs.biz.impl.Disease_bedBizImpl;
import com.qjs.biz.impl.Disease_bentcapBizImpl;
import com.qjs.biz.impl.Disease_conslopeBizImpl;
import com.qjs.biz.impl.Disease_deckBizImpl;
import com.qjs.biz.impl.Disease_fenceBizImpl;
import com.qjs.biz.impl.Disease_girderBizImpl;
import com.qjs.biz.impl.Disease_jointBizImpl;
import com.qjs.biz.impl.Disease_lightingBizImpl;
import com.qjs.biz.impl.Disease_paBizImpl;
import com.qjs.biz.impl.Disease_pierBizImpl;
import com.qjs.biz.impl.Disease_proslopeBizImpl;
import com.qjs.biz.impl.Disease_regstrucBizImpl;
import com.qjs.biz.impl.Disease_sidewalkBizImpl;
import com.qjs.biz.impl.Disease_supportBizImpl;
import com.qjs.biz.impl.Disease_tiebeamBizImpl;
import com.qjs.biz.impl.Disease_watertightBizImpl;
import com.qjs.biz.impl.Disease_wetjointBizImpl;
import com.qjs.biz.impl.Disease_wingwallBizImpl;
import com.qjs.entity.Disease_atbody;
import com.qjs.entity.Disease_atcapping;
import com.qjs.entity.Disease_bed;
import com.qjs.entity.Disease_bentcap;
import com.qjs.entity.Disease_conslope;
import com.qjs.entity.Disease_deck;
import com.qjs.entity.Disease_fence;
import com.qjs.entity.Disease_girder;
import com.qjs.entity.Disease_joint;
import com.qjs.entity.Disease_lighting;
import com.qjs.entity.Disease_pa;
import com.qjs.entity.Disease_pier;
import com.qjs.entity.Disease_proslope;
import com.qjs.entity.Disease_regstruc;
import com.qjs.entity.Disease_sidewalk;
import com.qjs.entity.Disease_support;
import com.qjs.entity.Disease_tiebeam;
import com.qjs.entity.Disease_watertight;
import com.qjs.entity.Disease_wetjoint;
import com.qjs.entity.Disease_wingwall;

public class DiseaseAction extends ActionSupport implements RequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	
	private String bg_name;
	private String table_name;
	
	// Disease_girder
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
	
	// Disease_wetjoint
	private String l1_start;
	private String l1_end;
	private String l1_area;	
	private String l2_start;
	private String l2_length;
	private String l2_width;
	
	private Integer pageNo;
	private Integer pageSize;

	private Base1BizImpl base1Biz;
	private Disease_girderBizImpl disease_girderBiz;
	private Disease_wetjointBizImpl disease_wetjointBiz;
	private Disease_supportBizImpl disease_supportBiz;
	private Disease_pierBizImpl disease_pierBiz;
	private Disease_bentcapBizImpl disease_bentcapBiz;
	private Disease_tiebeamBizImpl disease_tiebeamBiz;
	private Disease_atbodyBizImpl disease_atbodyBiz;
	private Disease_atcappingBizImpl disease_atcappingBiz;
	private Disease_paBizImpl disease_paBiz;
	private Disease_bedBizImpl disease_bedBiz;
	private Disease_regstrucBizImpl disease_regstrucBiz;
	private Disease_wingwallBizImpl disease_wingwallBiz;
	private Disease_conslopeBizImpl disease_conslopeBiz;
	private Disease_proslopeBizImpl disease_proslopeBiz;
	private Disease_deckBizImpl disease_deckBiz;
	private Disease_jointBizImpl disease_jointBiz;
	private Disease_sidewalkBizImpl disease_sidewalkBiz;
	private Disease_fenceBizImpl disease_fenceBiz;
	private Disease_watertightBizImpl disease_watertightBiz;
	private Disease_lightingBizImpl disease_lightingBiz;
	
	
	public String getBg_name() {
		return bg_name;
	}

	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}
	
	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	
	// base1
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
	
	public String getSpOtherDisease() {
		return sp_otherDisease;
	}

	public void setSpOtherDisease(String sp_otherDisease) {
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
	
	
	
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	public Base1BizImpl getBase1Biz() {
		return base1Biz;
	}

	public void setBase1Biz(Base1BizImpl base1Biz) {
		this.base1Biz = base1Biz;
	}
	
	public Disease_girderBizImpl getDisease_girderBiz() {
		return disease_girderBiz;
	}

	public void setDisease_girderBiz(Disease_girderBizImpl disease_girderBiz) {
		this.disease_girderBiz = disease_girderBiz;
	}
	
	public Disease_wetjointBizImpl getDisease_wetjointBiz() {
		return disease_wetjointBiz;
	}

	public void setDisease_wetjointBiz(Disease_wetjointBizImpl disease_wetjointBiz) {
		this.disease_wetjointBiz = disease_wetjointBiz;
	}
	
	public Disease_supportBizImpl getDisease_supportBiz() {
		return disease_supportBiz;
	}
	
	public void setDisease_supportBiz(Disease_supportBizImpl disease_supportBiz) {
		this.disease_supportBiz = disease_supportBiz;
	}
	
	public Disease_pierBizImpl getDisease_pierBiz() {
		return disease_pierBiz;
	}
	
	public void setDisease_pierBiz(Disease_pierBizImpl disease_pierBiz) {
		this.disease_pierBiz = disease_pierBiz;
	}
	
	public Disease_bentcapBizImpl getDisease_bentcapBiz() {
		return disease_bentcapBiz;
	}
	
	public void setDisease_bentcapBiz(Disease_bentcapBizImpl disease_bentcapBiz) {
		this.disease_bentcapBiz = disease_bentcapBiz;
	}
	
	public Disease_tiebeamBizImpl getDisease_tiebeamBiz() {
		return disease_tiebeamBiz;
	}
	
	public void setDisease_tiebeamBiz(Disease_tiebeamBizImpl disease_tiebeamBiz) {
		this.disease_tiebeamBiz = disease_tiebeamBiz;
	}
	
	public Disease_atbodyBizImpl getDisease_atbodyBiz() {
		return disease_atbodyBiz;
	}
	
	public void setDisease_atbodyBiz(Disease_atbodyBizImpl disease_atbodyBiz) {
		this.disease_atbodyBiz = disease_atbodyBiz;
	}
	
	public Disease_atcappingBizImpl getDisease_atcappingBiz() {
		return disease_atcappingBiz;
	}
	
	public void setDisease_atcappingBiz(Disease_atcappingBizImpl disease_atcappingBiz) {
		this.disease_atcappingBiz = disease_atcappingBiz;
	}
	
	public Disease_paBizImpl getDisease_paBiz() {
		return disease_paBiz;
	}
	
	public void setDisease_paBiz(Disease_paBizImpl disease_paBiz) {
		this.disease_paBiz = disease_paBiz;
	}
	
	public Disease_bedBizImpl getDisease_bedBiz() {
		return disease_bedBiz;
	}
	
	public void setDisease_bedBiz(Disease_bedBizImpl disease_bedBiz) {
		this.disease_bedBiz = disease_bedBiz;
	}
	
	public Disease_regstrucBizImpl getDisease_regstrucBiz() {
		return disease_regstrucBiz;
	}
	
	public void setDisease_regstrucBiz(Disease_regstrucBizImpl disease_regstrucBiz) {
		this.disease_regstrucBiz = disease_regstrucBiz;
	}
	
	public Disease_wingwallBizImpl getDisease_wingwallBiz() {
		return disease_wingwallBiz;
	}
	
	public void setDisease_wingwallBiz(Disease_wingwallBizImpl disease_wingwallBiz) {
		this.disease_wingwallBiz = disease_wingwallBiz;
	}
	
	public Disease_conslopeBizImpl getDisease_conslopeBiz() {
		return disease_conslopeBiz;
	}
	
	public void setDisease_conslopeBiz(Disease_conslopeBizImpl disease_conslopeBiz) {
		this.disease_conslopeBiz = disease_conslopeBiz;
	}
	
	public Disease_proslopeBizImpl getDisease_proslopeBiz() {
		return disease_proslopeBiz;
	}
	
	public void setDisease_proslopeBiz(Disease_proslopeBizImpl disease_proslopeBiz) {
		this.disease_proslopeBiz = disease_proslopeBiz;
	}
	
	public Disease_deckBizImpl getDisease_deckBiz() {
		return disease_deckBiz;
	}
	
	public void setDisease_deckBiz(Disease_deckBizImpl disease_deckBiz) {
		this.disease_deckBiz = disease_deckBiz;
	}
	
	public Disease_jointBizImpl getDisease_jointBiz() {
		return disease_jointBiz;
	}
	
	public void setDisease_jointBiz(Disease_jointBizImpl disease_jointBiz) {
		this.disease_jointBiz = disease_jointBiz;
	}
	
	public Disease_sidewalkBizImpl getDisease_sidewalkBiz() {
		return disease_sidewalkBiz;
	}
	
	public void setDisease_sidewalkBiz(Disease_sidewalkBizImpl disease_sidewalkBiz) {
		this.disease_sidewalkBiz = disease_sidewalkBiz;
	}
	
	public Disease_fenceBizImpl getDisease_fenceBiz() {
		return disease_fenceBiz;
	}
	
	public void setDisease_fenceBiz(Disease_fenceBizImpl disease_fenceBiz) {
		this.disease_fenceBiz = disease_fenceBiz;
	}
	
	public Disease_watertightBizImpl getDisease_watertightBiz() {
		return disease_watertightBiz;
	}
	
	public void setDisease_watertightBiz(Disease_watertightBizImpl disease_watertightBiz) {
		this.disease_watertightBiz = disease_watertightBiz;
	}
	
	public Disease_lightingBizImpl getDisease_lightingBiz() {
		return disease_lightingBiz;
	}
	
	public void setDisease_lightingBiz(Disease_lightingBizImpl disease_lightingBiz) {
		this.disease_lightingBiz = disease_lightingBiz;
	}
	

	Map<String, Object> request;
	Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String getBaseList() {
		return "list";
	}
	
	@SuppressWarnings("unchecked")
	public String getlist(){
		List<QueryObject> qo = new ArrayList<QueryObject>();
		
		if (this.getBg_name() != null && !this.getBg_name().trim().equals("")) {
			qo.add(new QueryObject("bridge_name", this.getBg_name().trim(), null));
		}
		QueryItems qi = new QueryItems(qo, null, null, this.getPageNo(), Constant.PAGE_SIZE);
		Map<String, Object> result = (Map<String, Object>) base1Biz.getAllDetailBase1(qi);
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) result.get("result");
		int count = (Integer) result.get("count");
		
		int disease_count = 0;
		for(int i = 0; i < dataList.size(); i++) {
			disease_count += disease_girderBiz.getDisease_girderCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_wetjointBiz.getDisease_wetjointCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_supportBiz.getDisease_supportCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_pierBiz.getDisease_pierCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_bentcapBiz.getDisease_bentcapCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_tiebeamBiz.getDisease_tiebeamCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_atbodyBiz.getDisease_atbodyCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_atcappingBiz.getDisease_atcappingCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_paBiz.getDisease_paCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_bedBiz.getDisease_bedCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_regstrucBiz.getDisease_regstrucCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_wingwallBiz.getDisease_wingwallCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_conslopeBiz.getDisease_conslopeCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_proslopeBiz.getDisease_proslopeCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_deckBiz.getDisease_deckCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_jointBiz.getDisease_jointCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_sidewalkBiz.getDisease_sidewalkCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_fenceBiz.getDisease_fenceCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_watertightBiz.getDisease_watertightCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			disease_count += disease_lightingBiz.getDisease_lightingCodeByBridgeCode(dataList.get(i).get("bridge_code").toString());
			
			dataList.get(i).put("disease_count", disease_count);
			disease_count = 0;
		}
		
		request.put("datalist", dataList);
		request.put("count", count);
		
		int totalPageNumber = 0;
		int tmpPageSize = Constant.PAGE_SIZE;
		if (this.getPageSize() != null && this.getPageSize() > 0) {
			tmpPageSize = this.getPageSize();
		}
		totalPageNumber = (int) Math.ceil(count*1.0/tmpPageSize);
		request.put("totalPageNumber", totalPageNumber);
		if (this.getPageNo() == null || this.getPageNo() < 1) {
			request.put("pageCur", 1);
		} else {
			request.put("pageCur", this.getPageNo());
		}
		
		return "table_data";
	}
	
	public String showDisease() {
		int[] count = new int[20];
		String[] item_name = {"上部承重构件", "上部一般构件", "支座", "桥墩", "盖梁", "系梁", "桥台身", "桥台帽",
				"墩台基础", "河床", "调治构造物", "翼墙、耳墙", "锥坡", "护坡", "桥面铺装", "伸缩缝装置", "人行道",
				"栏杆、护栏", "防排水系统", "照明、标志"};
		String[] table_name = {"disease_girder", "disease_wetjoint", "disease_support", "disease_pier", 
				"disease_bentcap", "disease_tiebeam", "disease_atbody", "disease_atcapping",
				"disease_pa", "disease_bed", "disease_regstruc", "disease_wingwall", "disease_conslope",
				"disease_proslope", "disease_deck", "disease_joint", "disease_sidewalk",
				"disease_fence", "disease_watertight", "disease_lighting"};
		count[0] = disease_girderBiz.getDisease_girderCodeByBridgeCode(this.getBg_id());
		count[1] = disease_wetjointBiz.getDisease_wetjointCodeByBridgeCode(this.getBg_id());
		count[2] = disease_supportBiz.getDisease_supportCodeByBridgeCode(this.getBg_id());
		count[3] = disease_pierBiz.getDisease_pierCodeByBridgeCode(this.getBg_id());
		count[4] = disease_bentcapBiz.getDisease_bentcapCodeByBridgeCode(this.getBg_id());
		count[5] = disease_tiebeamBiz.getDisease_tiebeamCodeByBridgeCode(this.getBg_id());
		count[6] = disease_atbodyBiz.getDisease_atbodyCodeByBridgeCode(this.getBg_id());
		count[7] = disease_atcappingBiz.getDisease_atcappingCodeByBridgeCode(this.getBg_id());
		count[8] = disease_paBiz.getDisease_paCodeByBridgeCode(this.getBg_id());
		count[9] = disease_bedBiz.getDisease_bedCodeByBridgeCode(this.getBg_id());
		count[10] = disease_regstrucBiz.getDisease_regstrucCodeByBridgeCode(this.getBg_id());
		count[11] = disease_wingwallBiz.getDisease_wingwallCodeByBridgeCode(this.getBg_id());
		count[12] = disease_conslopeBiz.getDisease_conslopeCodeByBridgeCode(this.getBg_id());
		count[13] = disease_proslopeBiz.getDisease_proslopeCodeByBridgeCode(this.getBg_id());
		count[14] = disease_deckBiz.getDisease_deckCodeByBridgeCode(this.getBg_id());
		count[15] = disease_jointBiz.getDisease_jointCodeByBridgeCode(this.getBg_id());
		count[16] = disease_sidewalkBiz.getDisease_sidewalkCodeByBridgeCode(this.getBg_id());
		count[17] = disease_fenceBiz.getDisease_fenceCodeByBridgeCode(this.getBg_id());
		count[18] = disease_watertightBiz.getDisease_watertightCodeByBridgeCode(this.getBg_id());
		count[19] = disease_lightingBiz.getDisease_lightingCodeByBridgeCode(this.getBg_id());
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 20; i++) {
			Map<String, Object> obj = new HashMap<String, Object>();
			
			obj.put("item_name", item_name[i]);
			obj.put("disease_count", count[i]);
			obj.put("table_name", table_name[i]);
			dataList.add(obj);
		}
		
		request.put("datalist", dataList);
		request.put("bg_name", base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name());
		
		return "show_disease";		
	}
	
	public String getBaseDiseaseList() {
		request.put("table_name", this.getTable_name());
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		return "disease_list";
	}
	
	@SuppressWarnings("unchecked")
	public String getDiseaseList() {
		List<QueryObject> qo = new ArrayList<QueryObject>();
		
		if (this.getBg_id() != null && !this.getBg_id().trim().equals("")) {
			qo.add(new QueryObject("bg_id", this.getBg_id().trim(), null));
		}
		if (this.getRg_feature() != null && !this.getRg_feature().trim().equals("")) {
			qo.add(new QueryObject("rg_feature", this.getRg_feature().trim(), null));
		}
		
		QueryItems qi = new QueryItems(qo, null, null, this.getPageNo(), Constant.PAGE_SIZE);
		
		Map<String, Object> result = new HashMap<>();
		
		switch (this.getTable_name()) {
		case "disease_girder":
			result = (Map<String, Object>) disease_girderBiz.getAllDetailDisease_girder(qi);
			break;
			
		case "disease_wetjoint":
			result = (Map<String, Object>) disease_wetjointBiz.getAllDetailDisease_wetjoint(qi);
			break;
			
		case "disease_support":
			result = (Map<String, Object>) disease_supportBiz.getAllDetailDisease_support(qi);
			break;
			
		case "disease_pier":
			result = (Map<String, Object>) disease_pierBiz.getAllDetailDisease_pier(qi);
			break;
			
		case "disease_bentcap":
			result = (Map<String, Object>) disease_bentcapBiz.getAllDetailDisease_bentcap(qi);
			break;
			
		case "disease_tiebeam":
			result = (Map<String, Object>) disease_tiebeamBiz.getAllDetailDisease_tiebeam(qi);
			break;
			
		case "disease_atbody":
			result = (Map<String, Object>) disease_atbodyBiz.getAllDetailDisease_atbody(qi);
			break;
			
		case "disease_atcapping":
			result = (Map<String, Object>) disease_atcappingBiz.getAllDetailDisease_atcapping(qi);
			break;
			
		case "disease_pa":
			result = (Map<String, Object>) disease_paBiz.getAllDetailDisease_pa(qi);
			break;
			
		case "disease_bed":
			result = (Map<String, Object>) disease_bedBiz.getAllDetailDisease_bed(qi);
			break;
			
		case "disease_regstruc":
			result = (Map<String, Object>) disease_regstrucBiz.getAllDetailDisease_regstruc(qi);
			break;
			
		case "disease_wingwall":
			result = (Map<String, Object>) disease_wingwallBiz.getAllDetailDisease_wingwall(qi);
			break;
			
		case "disease_conslope":
			result = (Map<String, Object>) disease_conslopeBiz.getAllDetailDisease_conslope(qi);
			break;
			
		case "disease_proslope":
			result = (Map<String, Object>) disease_proslopeBiz.getAllDetailDisease_proslope(qi);
			break;
			
		case "disease_deck":
			result = (Map<String, Object>) disease_deckBiz.getAllDetailDisease_deck(qi);
			break;
			
		case "disease_joint":
			result = (Map<String, Object>) disease_jointBiz.getAllDetailDisease_joint(qi);
			break;
			
		case "disease_sidewalk":
			result = (Map<String, Object>) disease_sidewalkBiz.getAllDetailDisease_sidewalk(qi);
			break;
			
		case "disease_fence":
			result = (Map<String, Object>) disease_fenceBiz.getAllDetailDisease_fence(qi);
			break;
			
		case "disease_watertight":
			result = (Map<String, Object>) disease_watertightBiz.getAllDetailDisease_watertight(qi);
			break;
			
		case "disease_lighting":
			result = (Map<String, Object>) disease_lightingBiz.getAllDetailDisease_lighting(qi);
			break;

		default:
			break;
		}
		
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) result.get("result");
		int count = (Integer) result.get("count");
		request.put("datalist", dataList);
		request.put("count", count);
		
		int totalPageNumber = 0;
		int tmpPageSize = Constant.PAGE_SIZE;
		if (this.getPageSize() != null && this.getPageSize() > 0) {
			tmpPageSize = this.getPageSize();
		}
		totalPageNumber = (int) Math.ceil(count*1.0/tmpPageSize);
		request.put("totalPageNumber", totalPageNumber);
		if (this.getPageNo() == null || this.getPageNo() < 1) {
			request.put("pageCur", 1);
		} else {
			request.put("pageCur", this.getPageNo());
		}
		
		return "disease_table_data";
	}
	
	public String viewDisease() throws IOException {
		request.put("bg_name", this.getBg_name());
		request.put("bg_id", this.getBg_id());
		request.put("table_name", this.getTable_name());
		
		switch (this.getTable_name()) {
		case "disease_girder":
			Disease_girder disease_girder = disease_girderBiz.getDisease_girderById(this.getId());
			if (disease_girder != null)	{		
				request.put("disease_girder", disease_girder);
			}
			return "girder_view";
			
		case "disease_wetjoint":
			Disease_wetjoint disease_wetjoint = disease_wetjointBiz.getDisease_wetjointById(this.getId());
			if (disease_wetjoint != null) {
				request.put("disease_wetjoint", disease_wetjoint);
			}
			return "wetjoint_view";
			
		case "disease_support":
			Disease_support disease_support = disease_supportBiz.getDisease_supportById(this.getId());
			if (disease_support != null) {
				request.put("disease_support", disease_support);
			}
			return "support_view";
			
		case "disease_pier":
			Disease_pier disease_pier = disease_pierBiz.getDisease_pierById(this.getId());
			if (disease_pier != null) {
				request.put("disease_pier", disease_pier);
			}
			return "pier_view";
			
		case "disease_bentcap":
			Disease_bentcap disease_bentcap = disease_bentcapBiz.getDisease_bentcapById(this.getId());
			if (disease_bentcap != null) {
				request.put("disease_bentcap", disease_bentcap);
			}
			return "bentcap_view";
			
		case "disease_tiebeam":
			Disease_tiebeam disease_tiebeam = disease_tiebeamBiz.getDisease_tiebeamById(this.getId());
			if (disease_tiebeam != null) {
				request.put("disease_tiebeam", disease_tiebeam);
			}
			return "tiebeam_view";
			
		case "disease_atbody":
			Disease_atbody disease_atbody = disease_atbodyBiz.getDisease_atbodyById(this.getId());
			if (disease_atbody != null) {
				request.put("disease_atbody", disease_atbody);
			}
			return "atbody_view";
			
		case "disease_atcapping":
			Disease_atcapping disease_atcapping = disease_atcappingBiz.getDisease_atcappingById(this.getId());
			if (disease_atcapping != null) {
				request.put("disease_atcapping", disease_atcapping);
			}
			return "atcapping_view";
			
		case "disease_pa":
			Disease_pa disease_pa = disease_paBiz.getDisease_paById(this.getId());
			if (disease_pa != null) {
				request.put("disease_pa", disease_pa);
			}
			return "pa_view";
			
		case "disease_bed":
			Disease_bed disease_bed = disease_bedBiz.getDisease_bedById(this.getId());
			if (disease_bed != null) {
				request.put("disease_bed", disease_bed);
			}
			return "bed_view";
			
		case "disease_regstruc":
			Disease_regstruc disease_regstruc = disease_regstrucBiz.getDisease_regstrucById(this.getId());
			if (disease_regstruc != null) {
				request.put("disease_regstruc", disease_regstruc);
			}
			return "regstruc_view";
			
		case "disease_wingwall":
			Disease_wingwall disease_wingwall = disease_wingwallBiz.getDisease_wingwallById(this.getId());
			if (disease_wingwall != null) {
				request.put("disease_wingwall", disease_wingwall);
			}
			return "wingwall_view";
			
		case "disease_conslope":
			Disease_conslope disease_conslope = disease_conslopeBiz.getDisease_conslopeById(this.getId());
			if (disease_conslope != null) {
				request.put("disease_conslope", disease_conslope);
			}
			return "conslope_view";
			
		case "disease_proslope":
			Disease_proslope disease_proslope = disease_proslopeBiz.getDisease_proslopeById(this.getId());
			if (disease_proslope != null) {
				request.put("disease_proslope", disease_proslope);
			}
			return "proslope_view";
			
		case "disease_deck":
			Disease_deck disease_deck = disease_deckBiz.getDisease_deckById(this.getId());
			if (disease_deck != null) {
				request.put("disease_deck", disease_deck);
			}
			return "deck_view";
			
		case "disease_joint":
			Disease_joint disease_joint = disease_jointBiz.getDisease_jointById(this.getId());
			if (disease_joint != null) {
				request.put("disease_joint", disease_joint);
			}
			return "joint_view";
			
		case "disease_sidewalk":
			Disease_sidewalk disease_sidewalk = disease_sidewalkBiz.getDisease_sidewalkById(this.getId());
			if (disease_sidewalk != null) {
				request.put("disease_sidewalk", disease_sidewalk);
			}
			return "sidewalk_view";
			
		case "disease_fence":
			Disease_fence disease_fence = disease_fenceBiz.getDisease_fenceById(this.getId());
			if (disease_fence != null) {
				request.put("disease_fence", disease_fence);
			}
			return "fence_view";
			
		case "disease_watertight":
			Disease_watertight disease_watertight = disease_watertightBiz.getDisease_watertightById(this.getId());
			if (disease_watertight != null) {
				request.put("disease_watertight", disease_watertight);
			}
			return "watertight_view";
			
		case "disease_lighting":
			Disease_lighting disease_lighting = disease_lightingBiz.getDisease_lightingById(this.getId());
			if (disease_lighting != null) {
				request.put("disease_lighting", disease_lighting);
			}
			return "lighting_view";

		default:
			break;
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("disease!getBaseDiseaseList?table_name=" + this.getTable_name() + "&bg_id=" + this.getBg_id() + "&bg_name=" + this.getBg_name());
		return null;
	}
//	
//	public String deleteBridge() {
//		base1Biz.deleteBase1ById(this.getId());
//		return "list";
//	}
	
//	public String addBridge() throws IOException, ServletException {
//		Base1 b1 = new Base1();
//		
//		Date date = new Date();
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//		String[] bgCode = format.format(date).split(" ");
//		String bridge_code = bgCode[0] + "-" + bgCode[1]; // 用系统当前时间作为桥梁代码
//		
//		b1.setBridge_code(bridge_code);
//		b1.setBridge_name(this.getBridgeName());
//		b1.setPath_num(this.getPathNum());
//		b1.setPath_name(this.getPathName());
//		b1.setPath_type(this.getPathType());
//		b1.setRode_grade(this.getRodeGrade());
//		b1.setOrder_num(this.getOrderNum());
//		b1.setLocation(this.getLocation());
//		b1.setCenter_stake(this.getCenterStake());
//		b1.setCustody_unit(this.getCustodyUnit());
//		b1.setAcross_name(this.getAcrossName());
//		b1.setAcross_type(this.getAcrossType());
//		b1.setBridge_nature(this.getBridgeNature());
//		b1.setFlag("0");
//		base1Biz.addBase1(b1);
//		
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.sendRedirect("bridge!viewBridge?bridgeCode=" + bridge_code);
//		return null;
//	}
	
//	public String showBase1() {
//		Base1 base1 = base1Biz.getBase1ByBridgeCode(this.getBridgeCode());
//		if (base1 != null) {
//			request.put("id", base1.getId());
//			request.put("bridge_code", base1.getBridge_code());
//			request.put("bridge_name", base1.getBridge_name());
//			request.put("path_num", base1.getPath_num());
//			request.put("path_name", base1.getPath_name());
//			request.put("path_type", base1.getPath_type());
//			request.put("rode_grade", base1.getRode_grade());
//			request.put("order_num", base1.getOrder_num());
//			request.put("location", base1.getLocation());
//			request.put("center_stake", base1.getCenter_stake());
//			request.put("custody_unit", base1.getCustody_unit());
//			request.put("across_name", base1.getAcross_name());
//			request.put("across_type", base1.getAcross_type());
//			request.put("bridge_nature", base1.getBridge_nature());
//		}		
//		return "base1";
//	}
//	
//	public String changeBase1() throws IOException {
//		Base1 base1 = new Base1();
//		base1.setBridge_code(this.getBridgeCode());
//		base1.setBridge_name(this.getBridgeName());
//		base1.setPath_num(this.getPathNum());
//		base1.setPath_name(this.getPathName());
//		base1.setPath_type(this.getPathType());
//		base1.setRode_grade(this.getRodeGrade());
//		base1.setOrder_num(this.getOrderNum());
//		base1.setLocation(this.getLocation());
//		base1.setCenter_stake(this.getCenterStake());
//		base1.setCustody_unit(this.getCustodyUnit());
//		base1.setAcross_name(this.getAcrossName());
//		base1.setAcross_type(this.getAcrossType());
//		base1.setBridge_nature(this.getBridgeNature());
//
//		Base1 b1 = base1Biz.getBase1ByBridgeCode(this.getBridgeCode());
//		
//		if (b1 != null) { // 修改
//			base1.setId(b1.getId());
//			base1.setFlag(b1.getFlag());
//			
//			base1Biz.updateBase1(base1);
//		}
//		else { // 添加
//			base1.setFlag("0");
//			
//			base1Biz.addBase1(base1);
//		}
//		
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
//		return null;
//	}
	
	public void validate(){
		if(session.get("userName")==null){
			session.clear();
			this.addActionError("error");
		}
	}	
}

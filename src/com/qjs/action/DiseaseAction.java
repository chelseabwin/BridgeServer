package com.qjs.action;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.Base1BizImpl;
import com.qjs.biz.impl.Disease_girderBizImpl;
import com.qjs.biz.impl.Disease_supportBizImpl;
import com.qjs.biz.impl.Disease_wetjointBizImpl;
import com.qjs.entity.Disease_girder;
import com.qjs.entity.Disease_support;
import com.qjs.entity.Disease_wetjoint;

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
		
//		if (this.getBridgeName() != null && !this.getBridgeName().trim().equals("")) {
//			qo.add(new QueryObject("bridge_name", this.getBridgeName().trim(), null));
//		}
		
		QueryItems qi = new QueryItems(qo, null, null, this.getPageNo(), Constant.PAGE_SIZE);
		Map<String, Object> result_girder = (Map<String, Object>) disease_girderBiz.getAllDetailDisease_girder(qi);
		Map<String, Object> result_wetjoint = (Map<String, Object>) disease_wetjointBiz.getAllDetailDisease_wetjoint(qi);
		Map<String, Object> result_support = (Map<String, Object>) disease_supportBiz.getAllDetailDisease_support(qi);
		
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) result_girder.get("result");
		dataList.addAll((List<Map<String, Object>>) result_wetjoint.get("result"));
		dataList.addAll((List<Map<String, Object>>) result_support.get("result"));
		
		// 添加桥梁名称
		for(int i = 0; i < dataList.size(); i++) {
			dataList.get(i).put("bg_name", base1Biz.getBase1ByBridgeCode(dataList.get(i).get("bg_id").toString()).getBridge_name());
			if ("主梁".equals(dataList.get(i).get("item_name").toString())
					|| "空心板".equals(dataList.get(i).get("item_name").toString()) 
					|| "主拱圈".equals(dataList.get(i).get("item_name").toString())
					|| "钢、桁架拱片".equals(dataList.get(i).get("item_name").toString()) 
					|| "上部承重构件".equals(dataList.get(i).get("item_name").toString())) {
				dataList.get(i).put("table_name", "disease_girder");
			}
			
			if ("湿接缝".equals(dataList.get(i).get("item_name").toString()) 
					|| "横隔板".equals(dataList.get(i).get("item_name").toString()) 
					|| "铰缝".equals(dataList.get(i).get("item_name").toString()) 
					|| "拱上结构".equals(dataList.get(i).get("item_name").toString()) 
					|| "横向联结系".equals(dataList.get(i).get("item_name").toString()) 
					|| "上部一般构件".equals(dataList.get(i).get("item_name").toString())) {				
				dataList.get(i).put("table_name", "disease_wetjoint");
			}
			
			if ("支座".equals(dataList.get(i).get("item_name").toString())) {				
				dataList.get(i).put("table_name", "disease_support");
			}
		}
		
		int count_girder = (Integer) result_girder.get("count");
		int count_wetjoint = (Integer) result_wetjoint.get("count");
		int count_support = (Integer) result_support.get("count");
		int count = count_girder + count_wetjoint + count_support;
		
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
	
	public String viewDisease() {
		switch (this.getTable_name()) {
		case "disease_girder":
			Disease_girder disease_girder = disease_girderBiz.getDisease_girderById(this.getId());
			if (disease_girder != null)	{		
				request.put("disease_girder", disease_girder);
				request.put("bg_name", this.getBg_name());
			}
			return "girder_view";
		case "disease_wetjoint":
			Disease_wetjoint disease_wetjoint = disease_wetjointBiz.getDisease_wetjointById(this.getId());
			if (disease_wetjoint != null) {
				request.put("disease_wetjoint", disease_wetjoint);
				request.put("bg_name", this.getBg_name());
			}
			return "wetjoint_view";
		case "disease_support":
			Disease_support disease_support = disease_supportBiz.getDisease_supportById(this.getId());
			if (disease_support != null) {
				request.put("disease_support", disease_support);
				request.put("bg_name", this.getBg_name());
			}
			return "support_view";

		default:
			break;
		}
		
		return "list";
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

package com.qjs.action;

import global.tool.Constant;
import global.tool.QueryItems;
import global.tool.QueryObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.Base1BizImpl;
import com.qjs.biz.impl.Base2BizImpl;
import com.qjs.biz.impl.Base3BizImpl;
import com.qjs.biz.impl.General_detailBizImpl;
import com.qjs.biz.impl.Load_detailBizImpl;
import com.qjs.biz.impl.Parts1BizImpl;
import com.qjs.biz.impl.Parts2BizImpl;
import com.qjs.biz.impl.Pier_detailBizImpl;
import com.qjs.biz.impl.StructureBizImpl;
import com.qjs.biz.impl.Support_detailBizImpl;
import com.qjs.entity.Base1;
import com.qjs.entity.Base2;
import com.qjs.entity.Base3;
import com.qjs.entity.General_detail;
import com.qjs.entity.Load_detail;
import com.qjs.entity.Parts1;
import com.qjs.entity.Parts2;
import com.qjs.entity.Pier_detail;
import com.qjs.entity.Structure;
import com.qjs.entity.Support_detail;

public class BridgeAction extends ActionSupport implements RequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	
	// base1
	private Integer id;
	private String bridgeCode;
	private String bridgeName;
	private String pathNum;
	private String pathName;
	private String pathType;
	private String rodeGrade;
	private String orderNum;
	private String location;
	private String centerStake;	
	private String custodyUnit;
	private String acrossName;
	private String acrossType;
	private String bridgeNature;
	private String flag;
	
	// base2
	private String bgId;
	private String bridgeClassify;
	private String designLoad;
	private String bridgeUse;
	private String bridgeStatus;
	private String materialCode;
	private String bridgePanel;
	private String stressPattern;
	private String supportType;
	private String bridgeType;
	
	// base3
	private String pierMaterial;
	private String sectionForm;
	private String pierType;
	private String sectionShape;
	private String abutmentMaterial;
	private String abutmentType;
	private String pierAbutmentMaterial;
	private String pierAbutmentBase;	
	private String deckType;
	private String jointType;
	
	// structure
	private String bridgeSpan;
	private String longestSpan;
	private String totalLen;
	private String bridgeWide;
	private String fullWide;
	private String clearWide;
	private String bridgeHigh;
	private String highLimit;	
	private String buildingTime;
	private String navigationLevel;
	private String sectionHigh;
	private String deckProfileGrade;
	
	// parts1
	private String wingWall1;
	private String wingWall2;
	private String wingWall3;
	private String wingWall4;
	private String conicalSlope1;
	private String conicalSlope2;
	private String conicalSlope3;
	private String conicalSlope4;
	private String protectionSlope;
	private String pierDetail;
	private String abutmentNum;
	private String paNum;
	private String bedNum;
	private String regStructure;
	
	// parts2
	private String loadDetail;
	private String generalDetail;
	private String supportDetail;
	private String deckNum;
	private String jointNum;
	private String sidewalk1;
	private String sidewalk2;
	private String guardrail1;
	private String guardrail2;
	private String drainageSystem;	
	private String illuminatedSign;
	
	// pier_add
	private String startPier;
	private String endPier;
	private String perPier;
	private String bentCap;
	private String tieBeam;
	private String tap;
	
	// pier_detail
	private String pierDetails;
	private String pierNums;
	private String bentCapNums;
	private String tieBeamNums;
	
	// load_detail
	private String loadDetails;
	private String loadNums;
	
	// general_detail
	private String generalDetails;
	private String generalNums;
	
	// support_detail
	private String supportDetails;
	private String supportNums;
	
	private Integer pageNo;
	private Integer pageSize;
	
	private Base1BizImpl base1Biz;
	private Base2BizImpl base2Biz;
	private Base3BizImpl base3Biz;
	private StructureBizImpl structureBiz;
	private Parts1BizImpl parts1Biz;
	private Parts2BizImpl parts2Biz;
	private Pier_detailBizImpl pier_detailBiz;
	private Load_detailBizImpl load_detailBiz;
	private General_detailBizImpl general_detailBiz;
	private Support_detailBizImpl support_detailBiz;
	
//	private Pier_addBizImpl pier_addBiz;
//	private Load_addBizImpl load_addBiz;
//	private General_addBizImpl general_addBiz;
//	private Support_addBizImpl support_addBiz;
	
	// base1
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getBridgeCode() {
		return bridgeCode;
	}

	public void setBridgeCode(String bridgeCode) {
		this.bridgeCode = bridgeCode;
	}
	
	public String getBridgeName() {
		return bridgeName;
	}

	public void setBridgeName(String bridgeName) {
		this.bridgeName = bridgeName;
	}
	
	public String getPathNum() {
		return pathNum;
	}

	public void setPathNum(String pathNum) {
		this.pathNum = pathNum;
	}
	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	
	public String getPathType() {
		return pathType;
	}

	public void setPathType(String pathType) {
		this.pathType = pathType;
	}
	
	public String getRodeGrade() {
		return rodeGrade;
	}

	public void setRodeGrade(String rodeGrade) {
		this.rodeGrade = rodeGrade;
	}
	
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCenterStake() {
		return centerStake;
	}

	public void setCenterStake(String centerStake) {
		this.centerStake = centerStake;
	}
	
	public String getCustodyUnit() {
		return custodyUnit;
	}

	public void setCustodyUnit(String custodyUnit) {
		this.custodyUnit = custodyUnit;
	}
	
	public String getAcrossName() {
		return acrossName;
	}

	public void setAcrossName(String acrossName) {
		this.acrossName = acrossName;
	}
	
	public String getAcrossType() {
		return acrossType;
	}

	public void setAcrossType(String acrossType) {
		this.acrossType = acrossType;
	}
	
	public String getBridgeNature() {
		return bridgeNature;
	}

	public void setBridgeNature(String bridgeNature) {
		this.bridgeNature = bridgeNature;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getBgId() {
		return bgId;
	}

	public void setBgId(String bgId) {
		this.bgId = bgId;
	}
	
	public String getBridgeClassify() {
		return bridgeClassify;
	}

	public void setBridgeClassify(String bridgeClassify) {
		this.bridgeClassify = bridgeClassify;
	}
	
	public String getDesignLoad() {
		return designLoad;
	}

	public void setDesignLoad(String designLoad) {
		this.designLoad = designLoad;
	}
	
	public String getBridgeUse() {
		return bridgeUse;
	}

	public void setBridgeUse(String bridgeUse) {
		this.bridgeUse = bridgeUse;
	}
	
	public String getBridgeStatus() {
		return bridgeStatus;
	}

	public void setBridgeStatus(String bridgeStatus) {
		this.bridgeStatus = bridgeStatus;
	}
	
	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	
	public String getBridgePanel() {
		return bridgePanel;
	}

	public void setBridgePanel(String bridgePanel) {
		this.bridgePanel = bridgePanel;
	}
	
	public String getStressPattern() {
		return stressPattern;
	}

	public void setStressPattern(String stressPattern) {
		this.stressPattern = stressPattern;
	}
	
	public String getSupportType() {
		return supportType;
	}

	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}
	
	public String getBridgeType() {
		return bridgeType;
	}

	public void setBridgeType(String bridgeType) {
		this.bridgeType = bridgeType;
	}
	
	public String getPierMaterial() {
		return pierMaterial;
	}

	public void setPierMaterial(String pierMaterial) {
		this.pierMaterial = pierMaterial;
	}
	
	public String getSectionForm() {
		return sectionForm;
	}

	public void setSectionForm(String sectionForm) {
		this.sectionForm = sectionForm;
	}
	
	public String getPierType() {
		return pierType;
	}

	public void setPierType(String pierType) {
		this.pierType = pierType;
	}
	
	public String getSectionShape() {
		return sectionShape;
	}

	public void setSectionShape(String sectionShape) {
		this.sectionShape = sectionShape;
	}
	
	public String getAbutmentMaterial() {
		return abutmentMaterial;
	}

	public void setAbutmentMaterial(String abutmentMaterial) {
		this.abutmentMaterial = abutmentMaterial;
	}
	
	public String getAbutmentType() {
		return abutmentType;
	}

	public void setAbutmentType(String abutmentType) {
		this.abutmentType = abutmentType;
	}
	
	public String getPierAbutmentMaterial() {
		return pierAbutmentMaterial;
	}

	public void setPierAbutmentMaterial(String pierAbutmentMaterial) {
		this.pierAbutmentMaterial = pierAbutmentMaterial;
	}
	
	public String getPierAbutmentBase() {
		return pierAbutmentBase;
	}

	public void setPierAbutmentBase(String pierAbutmentBase) {
		this.pierAbutmentBase = pierAbutmentBase;
	}
	
	public String getDeckType() {
		return deckType;
	}

	public void setDeckType(String deckType) {
		this.deckType = deckType;
	}
	
	public String getJointType() {
		return jointType;
	}

	public void setJointType(String jointType) {
		this.jointType = jointType;
	}
	
	public String getBridgeSpan() {
		return bridgeSpan;
	}

	public void setBridgeSpan(String bridgeSpan) {
		this.bridgeSpan = bridgeSpan;
	}
	
	public String getLongestSpan() {
		return longestSpan;
	}

	public void setLongestSpan(String longestSpan) {
		this.longestSpan = longestSpan;
	}
	
	public String getTotalLen() {
		return totalLen;
	}

	public void setTotalLen(String totalLen) {
		this.totalLen = totalLen;
	}
	
	public String getBridgeWide() {
		return bridgeWide;
	}

	public void setBridgeWide(String bridgeWide) {
		this.bridgeWide = bridgeWide;
	}
	
	public String getFullWide() {
		return fullWide;
	}

	public void setFullWide(String fullWide) {
		this.fullWide = fullWide;
	}
	
	public String getClearWide() {
		return clearWide;
	}

	public void setClearWide(String clearWide) {
		this.clearWide = clearWide;
	}
	
	public String getBridgeHigh() {
		return bridgeHigh;
	}

	public void setBridgeHigh(String bridgeHigh) {
		this.bridgeHigh = bridgeHigh;
	}
	
	public String getHighLimit() {
		return highLimit;
	}

	public void setHighLimit(String highLimit) {
		this.highLimit = highLimit;
	}
	
	public String getBuildingTime() {
		return buildingTime;
	}

	public void setBuildingTime(String buildingTime) {
		this.buildingTime = buildingTime;
	}
	
	public String getNavigationLevel() {
		return navigationLevel;
	}

	public void setNavigationLevel(String navigationLevel) {
		this.navigationLevel = navigationLevel;
	}
	
	public String getSectionHigh() {
		return sectionHigh;
	}

	public void setSectionHigh(String sectionHigh) {
		this.sectionHigh = sectionHigh;
	}
	
	public String getDeckProfileGrade() {
		return deckProfileGrade;
	}

	public void setDeckProfileGrade(String deckProfileGrade) {
		this.deckProfileGrade = deckProfileGrade;
	}
	
	public String getWingWall1() {
		return wingWall1;
	}

	public void setWingWall1(String wingWall1) {
		this.wingWall1 = wingWall1;
	}
	
	public String getWingWall2() {
		return wingWall2;
	}

	public void setWingWall2(String wingWall2) {
		this.wingWall2 = wingWall2;
	}
	
	public String getWingWall3() {
		return wingWall3;
	}

	public void setWingWall3(String wingWall3) {
		this.wingWall3 = wingWall3;
	}
	
	public String getWingWall4() {
		return wingWall4;
	}

	public void setWingWall4(String wingWall4) {
		this.wingWall4 = wingWall4;
	}
	
	public String getConicalSlope1() {
		return conicalSlope1;
	}

	public void setConicalSlope1(String conicalSlope1) {
		this.conicalSlope1 = conicalSlope1;
	}
	
	public String getConicalSlope2() {
		return conicalSlope2;
	}

	public void setConicalSlope2(String conicalSlope2) {
		this.conicalSlope2 = conicalSlope2;
	}
	
	public String getConicalSlope3() {
		return conicalSlope3;
	}

	public void setConicalSlope3(String conicalSlope3) {
		this.conicalSlope3 = conicalSlope3;
	}
	
	public String getConicalSlope4() {
		return conicalSlope4;
	}

	public void setConicalSlope4(String conicalSlope4) {
		this.conicalSlope4 = conicalSlope4;
	}
	
	public String getProtectionSlope() {
		return protectionSlope;
	}

	public void setProtectionSlope(String protectionSlope) {
		this.protectionSlope = protectionSlope;
	}
	
	public String getPierDetail() {
		return pierDetail;
	}

	public void setPierDetail(String pierDetail) {
		this.pierDetail = pierDetail;
	}
	
	public String getAbutmentNum() {
		return abutmentNum;
	}

	public void setAbutmentNum(String abutmentNum) {
		this.abutmentNum = abutmentNum;
	}
	
	public String getPaNum() {
		return paNum;
	}

	public void setPaNum(String paNum) {
		this.paNum = paNum;
	}
	
	public String getBedNum() {
		return bedNum;
	}

	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}
	
	public String getRegStructure() {
		return regStructure;
	}

	public void setRegStructure(String regStructure) {
		this.regStructure = regStructure;
	}
	
	public String getLoadDetail() {
		return loadDetail;
	}

	public void setLoadDetail(String loadDetail) {
		this.loadDetail = loadDetail;
	}
	
	public String getGeneralDetail() {
		return generalDetail;
	}

	public void setGeneralDetail(String generalDetail) {
		this.generalDetail = generalDetail;
	}
	
	public String getSupportDetail() {
		return supportDetail;
	}

	public void setSupportDetail(String supportDetail) {
		this.supportDetail = supportDetail;
	}
	
	public String getDeckNum() {
		return deckNum;
	}

	public void setDeckNum(String deckNum) {
		this.deckNum = deckNum;
	}
	
	public String getJointNum() {
		return jointNum;
	}

	public void setJointNum(String jointNum) {
		this.jointNum = jointNum;
	}
	
	public String getSidewalk1() {
		return sidewalk1;
	}

	public void setSidewalk1(String sidewalk1) {
		this.sidewalk1 = sidewalk1;
	}
	
	public String getSidewalk2() {
		return sidewalk2;
	}

	public void setSidewalk2(String sidewalk2) {
		this.sidewalk2 = sidewalk2;
	}
	
	public String getGuardrail1() {
		return guardrail1;
	}

	public void setGuardrail1(String guardrail1) {
		this.guardrail1 = guardrail1;
	}
	
	public String getGuardrail2() {
		return guardrail2;
	}

	public void setGuardrail2(String guardrail2) {
		this.guardrail2 = guardrail2;
	}
	
	public String getDrainageSystem() {
		return drainageSystem;
	}

	public void setDrainageSystem(String drainageSystem) {
		this.drainageSystem = drainageSystem;
	}
	
	public String getIlluminatedSign() {
		return illuminatedSign;
	}

	public void setIlluminatedSign(String illuminatedSign) {
		this.illuminatedSign = illuminatedSign;
	}
	
	public String getStartPier() {
		return startPier;
	}

	public void setStartPier(String startPier) {
		this.startPier = startPier;
	}
	
	public String getEndPier() {
		return endPier;
	}

	public void setEndPier(String endPier) {
		this.endPier = endPier;
	}
	
	public String getPerPier() {
		return perPier;
	}

	public void setPerPier(String perPier) {
		this.perPier = perPier;
	}
	
	public String getBentCap() {
		return bentCap;
	}

	public void setBentCap(String bentCap) {
		this.bentCap = bentCap;
	}
	
	public String getTieBeam() {
		return tieBeam;
	}

	public void setTieBeam(String tieBeam) {
		this.tieBeam = tieBeam;
	}
	
	public String getTap() {
		return tap;
	}

	public void setTap(String tap) {
		this.tap = tap;
	}
	
	public String getPierDetails() {
		return pierDetails;
	}

	public void setPierDetails(String pierDetails) {
		this.pierDetails = pierDetails;
	}
	
	public String getPierNums() {
		return pierNums;
	}

	public void setPierNums(String pierNums) {
		this.pierNums = pierNums;
	}
	
	public String getBentCapNums() {
		return bentCapNums;
	}

	public void setBentCapNums(String bentCapNums) {
		this.bentCapNums = bentCapNums;
	}
	
	public String getTieBeamNums() {
		return tieBeamNums;
	}

	public void setTieBeamNums(String tieBeamNums) {
		this.tieBeamNums = tieBeamNums;
	}
	
	public String getLoadDetails() {
		return loadDetails;
	}

	public void setLoadDetails(String loadDetails) {
		this.loadDetails = loadDetails;
	}
	
	public String getLoadNums() {
		return loadNums;
	}

	public void setLoadNums(String loadNums) {
		this.loadNums = loadNums;
	}
	
	public String getGeneralDetails() {
		return generalDetails;
	}

	public void setGeneralDetails(String generalDetails) {
		this.generalDetails = generalDetails;
	}
	
	public String getGeneralNums() {
		return generalNums;
	}

	public void setGeneralNums(String generalNums) {
		this.generalNums = generalNums;
	}
	
	public String getSupportDetails() {
		return supportDetails;
	}

	public void setSupportDetails(String supportDetails) {
		this.supportDetails = supportDetails;
	}
	
	public String getSupportNums() {
		return supportNums;
	}

	public void setSupportNums(String supportNums) {
		this.supportNums = supportNums;
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
	
	public Base2BizImpl getBase2Biz() {
		return base2Biz;
	}

	public void setBase2Biz(Base2BizImpl base2Biz) {
		this.base2Biz = base2Biz;
	}
	
	public Base3BizImpl getBase3Biz() {
		return base3Biz;
	}

	public void setBase3Biz(Base3BizImpl base3Biz) {
		this.base3Biz = base3Biz;
	}
	
	public StructureBizImpl getStructureBiz() {
		return structureBiz;
	}

	public void setStructureBiz(StructureBizImpl structureBiz) {
		this.structureBiz = structureBiz;
	}
	
	public Parts1BizImpl getParts1Biz() {
		return parts1Biz;
	}

	public void setParts1Biz(Parts1BizImpl parts1Biz) {
		this.parts1Biz = parts1Biz;
	}
	
	public Parts2BizImpl getParts2Biz() {
		return parts2Biz;
	}

	public void setParts2Biz(Parts2BizImpl parts2Biz) {
		this.parts2Biz = parts2Biz;
	}
	
	public Pier_detailBizImpl getPier_detailBiz() {
		return pier_detailBiz;
	}

	public void setPier_detailBiz(Pier_detailBizImpl pier_detailBiz) {
		this.pier_detailBiz = pier_detailBiz;
	}
	
	public Load_detailBizImpl getLoad_detailBiz() {
		return load_detailBiz;
	}

	public void setLoad_detailBiz(Load_detailBizImpl load_detailBiz) {
		this.load_detailBiz = load_detailBiz;
	}
	
	public General_detailBizImpl getGeneral_detailBiz() {
		return general_detailBiz;
	}

	public void setGeneral_detailBiz(General_detailBizImpl general_detailBiz) {
		this.general_detailBiz = general_detailBiz;
	}
	
	public Support_detailBizImpl getSupport_detailBiz() {
		return support_detailBiz;
	}

	public void setSupport_detailBiz(Support_detailBizImpl support_detailBiz) {
		this.support_detailBiz = support_detailBiz;
	}
	
//	public Pier_addBizImpl getPier_addBiz() {
//		return pier_addBiz;
//	}
//
//	public void setPier_addBiz(Pier_addBizImpl pier_addBiz) {
//		this.pier_addBiz = pier_addBiz;
//	}
	

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
		
		if (this.getBridgeName() != null && !this.getBridgeName().trim().equals("")) {
			qo.add(new QueryObject("bridge_name", this.getBridgeName().trim(), null));
		}
		QueryItems qi = new QueryItems(qo, null, null, this.getPageNo(), Constant.PAGE_SIZE);
		Map<String, Object> result = (Map<String, Object>) base1Biz.getAllDetailBase1(qi);
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
		
		return "table_data";
	}
	
	public String viewBridge() {
		Base1 base1 = base1Biz.getBase1ByBridgeCode(this.getBridgeCode());
		Base2 base2 = base2Biz.getBase2ByBridgeCode(this.getBridgeCode());
		Base3 base3 = base3Biz.getBase3ByBridgeCode(this.getBridgeCode());
		Structure structure = structureBiz.getStructureByBridgeCode(this.getBridgeCode());
		Parts1 parts1 = parts1Biz.getParts1ByBridgeCode(this.getBridgeCode());
		Parts2 parts2 = parts2Biz.getParts2ByBridgeCode(this.getBridgeCode());
		Pier_detail pier_detail = pier_detailBiz.getPier_detailByBridgeCode(this.getBridgeCode());
		Load_detail load_detail = load_detailBiz.getLoad_detailByBridgeCode(this.getBridgeCode());
		General_detail general_detail = general_detailBiz.getGeneral_detailByBridgeCode(this.getBridgeCode());
		Support_detail support_detail = support_detailBiz.getSupport_detailByBridgeCode(this.getBridgeCode());
		
		if (base1 != null)
			request.put("base1", base1);
		if (base2 != null)
			request.put("base2", base2);
		if (base3 != null)
			request.put("base3", base3);
		if (structure != null)
			request.put("structure", structure);
		if (parts1 != null)
			request.put("parts1", parts1);
		if (parts2 != null)
			request.put("parts2", parts2);
		if (pier_detail != null)
			request.put("pier_detail", pier_detail);
		if (load_detail != null)
			request.put("load_detail", load_detail);
		if (general_detail != null)
			request.put("general_detail", general_detail);
		if (support_detail != null)
			request.put("support_detail", support_detail);
		
		//处理翼墙、耳墙、锥坡编号
		if (parts1 != null) {
			if (parts1.getWing_wall() != null) {
				char[] ww = parts1.getWing_wall().toCharArray();
				ArrayList<String> ww_al = new ArrayList<String>();
				
				if (ww[0] == '1')
					ww_al.add("L0");
				if (ww[1] == '1')
					ww_al.add("R0");
				if (ww[2] == '1')
					ww_al.add("L1");
				if (ww[3] == '1')
					ww_al.add("R1");
				request.put("wing_wall", ww_al.toString().replace("[", "").replace("]", ""));
			}
			if (parts1.getConical_slope() != null) {
				char[] cs = parts1.getConical_slope().toCharArray();
				ArrayList<String> cs_al = new ArrayList<String>();
				
				if (cs[0] == '1')
					cs_al.add("L0");
				if (cs[1] == '1')
					cs_al.add("R0");
				if (cs[2] == '1')
					cs_al.add("L1");
				if (cs[3] == '1')
					cs_al.add("R1");
				request.put("conical_slope", cs_al.toString().replace("[", "").replace("]", ""));
			}
		}
		
		//处理人行道、栏杆、护栏编号
		if (parts2 != null) {
			if (parts2.getSidewalk() != null) {
				char[] sw = parts2.getSidewalk().toCharArray();
				ArrayList<String> sw_al = new ArrayList<String>();
				
				if (sw[0] == '1')
					sw_al.add("L");
				if (sw[1] == '1')
					sw_al.add("R");
				request.put("sidewalk", sw_al.toString().replace("[", "").replace("]", ""));
			}
			if (parts2.getGuardrail() != null) {
				char[] gd = parts2.getGuardrail().toCharArray();
				ArrayList<String> gd_al = new ArrayList<String>();
				
				if (gd[0] == '1')
					gd_al.add("L");
				if (gd[1] == '1')
					gd_al.add("R");
				request.put("guardrail", gd_al.toString().replace("[", "").replace("]", ""));
			}
		}
		
		return "view";
	}
	
	public String deleteBridge() {
		base1Biz.deleteBase1ById(this.getId());
		return "list";
	}
	
	public String addBridge() throws IOException, ServletException {
		Base1 b1 = new Base1();
		
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		String[] bgCode = format.format(date).split(" ");
		String[] time = bgCode[1].split(":");
		String bridge_code = bgCode[0] + "-" + time[0] + time[1] + time[2]; // 用系统当前时间作为桥梁代码
		
		b1.setBridge_code(bridge_code);
		b1.setBridge_name(this.getBridgeName());
		b1.setPath_num(this.getPathNum());
		b1.setPath_name(this.getPathName());
		b1.setPath_type(this.getPathType());
		b1.setRode_grade(this.getRodeGrade());
		b1.setOrder_num(this.getOrderNum());
		b1.setLocation(this.getLocation());
		b1.setCenter_stake(this.getCenterStake());
		b1.setCustody_unit(this.getCustodyUnit());
		b1.setAcross_name(this.getAcrossName());
		b1.setAcross_type(this.getAcrossType());
		b1.setBridge_nature(this.getBridgeNature());
		b1.setFlag("0");
		base1Biz.addBase1(b1);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + bridge_code);
		return null;
	}
	
	public String showBase1() {
		Base1 base1 = base1Biz.getBase1ByBridgeCode(this.getBridgeCode());
		if (base1 != null) {
			request.put("id", base1.getId());
			request.put("bridge_code", base1.getBridge_code());
			request.put("bridge_name", base1.getBridge_name());
			request.put("path_num", base1.getPath_num());
			request.put("path_name", base1.getPath_name());
			request.put("path_type", base1.getPath_type());
			request.put("rode_grade", base1.getRode_grade());
			request.put("order_num", base1.getOrder_num());
			request.put("location", base1.getLocation());
			request.put("center_stake", base1.getCenter_stake());
			request.put("custody_unit", base1.getCustody_unit());
			request.put("across_name", base1.getAcross_name());
			request.put("across_type", base1.getAcross_type());
			request.put("bridge_nature", base1.getBridge_nature());
		}		
		return "base1";
	}
	
	public String changeBase1() throws IOException {
		Base1 base1 = new Base1();
		base1.setBridge_code(this.getBridgeCode());
		base1.setBridge_name(this.getBridgeName());
		base1.setPath_num(this.getPathNum());
		base1.setPath_name(this.getPathName());
		base1.setPath_type(this.getPathType());
		base1.setRode_grade(this.getRodeGrade());
		base1.setOrder_num(this.getOrderNum());
		base1.setLocation(this.getLocation());
		base1.setCenter_stake(this.getCenterStake());
		base1.setCustody_unit(this.getCustodyUnit());
		base1.setAcross_name(this.getAcrossName());
		base1.setAcross_type(this.getAcrossType());
		base1.setBridge_nature(this.getBridgeNature());

		Base1 b1 = base1Biz.getBase1ByBridgeCode(this.getBridgeCode());
		
		if (b1 != null) { // 修改
			base1.setId(b1.getId());
			base1.setFlag(b1.getFlag());
			
			base1Biz.updateBase1(base1);
		}
		else { // 添加
			base1.setFlag("0");
			
			base1Biz.addBase1(base1);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showBase2() {		
		Base2 base2 = base2Biz.getBase2ByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (base2 != null) {
			request.put("id", base2.getId());
			request.put("bridge_classify", base2.getBridge_classify());
			request.put("design_load", base2.getDesign_load());
			request.put("bridge_use", base2.getBridge_use());
			request.put("bridge_status", base2.getBridge_status());
			request.put("material_code", base2.getMaterial_code());
			request.put("bridge_panel", base2.getBridge_panel());
			request.put("stress_pattern", base2.getStress_pattern());
			request.put("support_type", base2.getSupport_type());
			request.put("bridge_type", base2.getBridge_type());
		}		
		return "base2";
	}
	
	public String changeBase2() throws IOException {
		Base2 base2 = new Base2();
		base2.setBg_id(this.getBridgeCode());
		base2.setBridge_classify(this.getBridgeClassify());
		base2.setDesign_load(this.getDesignLoad());
		base2.setBridge_use(this.getBridgeUse());
		base2.setBridge_status(this.getBridgeStatus());
		base2.setMaterial_code(this.getMaterialCode());
		base2.setBridge_panel(this.getBridgePanel());
		base2.setStress_pattern(this.getStressPattern());
		base2.setSupport_type(this.getSupportType());
		base2.setBridge_type(this.getBridgeType());

		Base2 b2 = base2Biz.getBase2ByBridgeCode(this.getBridgeCode());
		
		if (b2 != null) { // 修改
			base2.setId(b2.getId());
			base2.setFlag(b2.getFlag());
			
			base2Biz.updateBase2(base2);
		}
		else { // 添加
			base2.setFlag("0");
			
			base2Biz.addBase2(base2);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showBase3() {		
		Base3 base3 = base3Biz.getBase3ByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (base3 != null) {
			request.put("id", base3.getId());
			request.put("pier_material", base3.getPier_material());
			request.put("section_form", base3.getSection_form());
			request.put("pier_type", base3.getPier_type());
			request.put("section_shape", base3.getSection_shape());
			request.put("abutment_material", base3.getAbutment_material());
			request.put("abutment_type", base3.getAbutment_type());
			request.put("pier_abutment_material", base3.getPier_abutment_material());
			request.put("pier_abutment_base", base3.getPier_abutment_base());
			request.put("deck_type", base3.getDeck_type());
			request.put("joint_type", base3.getJoint_type());
		}		
		return "base3";
	}
	
	public String changeBase3() throws IOException {
		Base3 base3 = new Base3();
		base3.setBg_id(this.getBridgeCode());
		base3.setPier_material(this.getPierMaterial());
		base3.setSection_form(this.getSectionForm());
		base3.setPier_type(this.getPierType());
		base3.setSection_shape(this.getSectionShape());
		base3.setAbutment_material(this.getAbutmentMaterial());
		base3.setAbutment_type(this.getAbutmentType());
		base3.setPier_abutment_material(this.getPierAbutmentMaterial());
		base3.setPier_abutment_base(this.getPierAbutmentBase());
		base3.setDeck_type(this.getDeckType());
		base3.setJoint_type(this.getJointType());

		Base3 b3 = base3Biz.getBase3ByBridgeCode(this.getBridgeCode());
		
		if (b3 != null) { // 修改
			base3.setId(b3.getId());
			base3.setFlag(b3.getFlag());
			
			base3Biz.updateBase3(base3);
		}
		else { // 添加
			base3.setFlag("0");
			
			base3Biz.addBase3(base3);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showStructure() {		
		Structure structure = structureBiz.getStructureByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (structure != null) {
			request.put("id", structure.getId());
			request.put("bridge_span", structure.getBridge_span());
			request.put("longest_span", structure.getLongest_span());
			request.put("total_len", structure.getTotal_len());
			request.put("bridge_wide", structure.getBridge_wide());
			request.put("full_wide", structure.getFull_wide());
			request.put("clear_wide", structure.getClear_wide());
			request.put("bridge_high", structure.getBridge_high());
			request.put("high_limit", structure.getHigh_limit());
			request.put("building_time", structure.getBuilding_time());
			request.put("navigation_level", structure.getNavigation_level());
			request.put("section_high", structure.getSection_high());
			request.put("deck_profile_grade", structure.getDeck_profile_grade());
		}		
		return "structure";
	}
	
	public String changeStructure() throws IOException {
		Structure str = new Structure();
		str.setBg_id(this.getBridgeCode());
		str.setBridge_span(this.getBridgeSpan());
		str.setLongest_span(this.getLongestSpan());
		str.setTotal_len(this.getTotalLen());
		str.setBridge_wide(this.getBridgeWide());
		str.setFull_wide(this.getFullWide());
		str.setClear_wide(this.getClearWide());
		str.setBridge_high(this.getBridgeHigh());
		str.setHigh_limit(this.getHighLimit());
		str.setBuilding_time(this.getBuildingTime());
		str.setNavigation_level(this.getNavigationLevel());
		str.setSection_high(this.getSectionHigh());
		str.setDeck_profile_grade(this.getDeckProfileGrade());
		
		Structure structure = structureBiz.getStructureByBridgeCode(this.getBridgeCode());
		if (structure != null) { // 修改
			str.setId(structure.getId());
			str.setFlag(structure.getFlag());
			
			structureBiz.updateStructure(str);			
		}
		else { // 添加
			str.setFlag("0");
			
			structureBiz.addStructure(str);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showParts1() {
		Parts1 parts1 = parts1Biz.getParts1ByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (parts1 != null) {
			request.put("id", parts1.getId());
			request.put("wing_wall1", parts1.getWing_wall().charAt(0));
			request.put("wing_wall2", parts1.getWing_wall().charAt(1));
			request.put("wing_wall3", parts1.getWing_wall().charAt(2));
			request.put("wing_wall4", parts1.getWing_wall().charAt(3));
			request.put("conical_slope1", parts1.getConical_slope().charAt(0));
			request.put("conical_slope2", parts1.getConical_slope().charAt(1));
			request.put("conical_slope3", parts1.getConical_slope().charAt(2));
			request.put("conical_slope4", parts1.getConical_slope().charAt(3));
			request.put("protection_slope", parts1.getProtection_slope());
			request.put("pier_detail", parts1.getPier_detail());
			request.put("abutment_num", parts1.getAbutment_num());
			request.put("pa_num", parts1.getPa_num());
			request.put("bed_num", parts1.getBed_num());
			request.put("reg_structure", parts1.getReg_structure());
		}		
		return "parts1";
	}
	
	public String changeParts1() throws IOException {
		String wingWall = "";
		if (this.getWingWall1() != null && this.getWingWall1().equals("L0"))
			wingWall += "1";
		else
			wingWall += "0";
		
		if (this.getWingWall2() != null && this.getWingWall2().equals("R0"))
			wingWall += "1";
		else
			wingWall += "0";
		
		if (this.getWingWall3() != null && this.getWingWall3().equals("L1"))
			wingWall += "1";
		else
			wingWall += "0";
		
		if (this.getWingWall4() != null && this.getWingWall4().equals("R1"))
			wingWall += "1";
		else
			wingWall += "0";
		
		String conicalSlope = "";
		if (this.getConicalSlope1() != null && this.getConicalSlope1().equals("L0"))
			conicalSlope += "1";
		else
			conicalSlope += "0";
		
		if (this.getConicalSlope2() != null && this.getConicalSlope2().equals("R0"))
			conicalSlope += "1";
		else
			conicalSlope += "0";
		
		if (this.getConicalSlope3() != null && this.getConicalSlope3().equals("L1"))
			conicalSlope += "1";
		else
			conicalSlope += "0";
		
		if (this.getConicalSlope4() != null && this.getConicalSlope4().equals("R1"))
			conicalSlope += "1";
		else
			conicalSlope += "0";
		
		Parts1 p1 = new Parts1();
		p1.setBg_id(this.getBridgeCode());
		p1.setWing_wall(wingWall);
		p1.setConical_slope(conicalSlope);
		p1.setProtection_slope(this.getProtectionSlope());
		p1.setPier_detail("0");
		p1.setAbutment_num(this.getAbutmentNum());
		p1.setPa_num(this.getPaNum());
		p1.setBed_num(this.getBedNum());
		p1.setReg_structure(this.getRegStructure());
		
		Parts1 parts1 = parts1Biz.getParts1ByBridgeCode(this.getBridgeCode());
		if (parts1 != null) { // 修改
			p1.setId(parts1.getId());
			p1.setFlag(parts1.getFlag());
			
			parts1Biz.updateParts1(p1);
		}
		else { // 添加
			p1.setFlag("0");
			
			parts1Biz.addParts1(p1);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showParts2() {
		Parts2 parts2 = parts2Biz.getParts2ByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (parts2 != null) {			
			request.put("id", parts2.getId());
			request.put("load_detail", parts2.getLoad_detail());
			request.put("general_detail", parts2.getGeneral_detail());
			request.put("support_detail", parts2.getSupport_detail());
			request.put("deck_num", parts2.getDeck_num());
			request.put("joint_num", parts2.getJoint_num());
			request.put("sidewalk1", parts2.getSidewalk().charAt(0));
			request.put("sidewalk2", parts2.getSidewalk().charAt(1));
			request.put("guardrail1", parts2.getGuardrail().charAt(0));
			request.put("guardrail2", parts2.getGuardrail().charAt(1));
			request.put("drainage_system", parts2.getDrainage_system());
			request.put("illuminated_sign", parts2.getIlluminated_sign());
		}		
		return "parts2";
	}
	
	public String changeParts2() throws IOException {
		String sidewalk = "";
		if (this.getSidewalk1() != null && this.getSidewalk1().equals("L"))
			sidewalk += "1";
		else
			sidewalk += "0";
		
		if (this.getSidewalk2() != null && this.getSidewalk2().equals("R"))
			sidewalk += "1";
		else
			sidewalk += "0";
		
		String guardrail = "";
		if (this.getGuardrail1() != null && this.getGuardrail1().equals("L"))
			guardrail += "1";
		else
			guardrail += "0";
		
		if (this.getGuardrail2() != null && this.getGuardrail2().equals("R"))
			guardrail += "1";
		else
			guardrail += "0";
		
		Parts2 p2 = new Parts2();
		p2.setBg_id(this.getBridgeCode());
		p2.setLoad_detail("0");
		p2.setGeneral_detail("0");
		p2.setSupport_detail("0");
		p2.setDeck_num(this.getDeckNum());
		p2.setJoint_num(this.getJointNum());
		p2.setSidewalk(sidewalk);
		p2.setGuardrail(guardrail);
		p2.setDrainage_system(this.getDrainageSystem());
		p2.setIlluminated_sign(this.getIlluminatedSign());
		
		Parts2 parts2 = parts2Biz.getParts2ByBridgeCode(this.getBridgeCode());
		if (parts2 != null) { // 修改
			p2.setId(parts2.getId());
			p2.setFlag(parts2.getFlag());
			
			parts2Biz.updateParts2(p2);
		}
		else { // 添加
			p2.setFlag("0");
			
			parts2Biz.addParts2(p2);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showPierDetail() {		
		Pier_detail pier_detail = pier_detailBiz.getPier_detailByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (pier_detail != null) {
			request.put("id", pier_detail.getId());
			request.put("pier_details", pier_detail.getPier_details());
			request.put("pier_nums", pier_detail.getPier_nums());
			request.put("bent_cap_nums", pier_detail.getBent_cap_nums());
			request.put("tie_beam_nums", pier_detail.getTie_beam_nums());
		}		
		return "pier_detail";
	}
	
	public String changePierDetail() throws IOException {
		Pier_detail pd = new Pier_detail();
		pd.setBg_id(this.getBridgeCode());
		pd.setPier_details(this.getPierDetails());
		pd.setPier_nums(this.getPierNums());
		pd.setBent_cap_nums(this.getBentCapNums());
		pd.setTie_beam_nums(this.getTieBeamNums());		
		
		Pier_detail pier_detail = pier_detailBiz.getPier_detailByBridgeCode(this.getBridgeCode());
		if (pier_detail != null) { // 修改
			pd.setId(pier_detail.getId());
			pd.setFlag(pier_detail.getFlag());
			
			pier_detailBiz.updatePier_detail(pd);			
		}
		else { // 添加
			pd.setFlag("0");
			
			pier_detailBiz.addPier_detail(pd);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showLoadDetail() {		
		Load_detail load_detail = load_detailBiz.getLoad_detailByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (load_detail != null) {
			request.put("id", load_detail.getId());
			request.put("load_details", load_detail.getLoad_details());
			request.put("load_nums", load_detail.getLoad_nums());
		}		
		return "load_detail";
	}
	
	public String changeLoadDetail() throws IOException {
		Load_detail ld = new Load_detail();
		ld.setBg_id(this.getBridgeCode());
		ld.setLoad_details(this.getLoadDetails());
		ld.setLoad_nums(this.getLoadNums());
		
		Load_detail load_detail = load_detailBiz.getLoad_detailByBridgeCode(this.getBridgeCode());
		if (load_detail != null) { // 修改
			ld.setId(load_detail.getId());
			ld.setFlag(load_detail.getFlag());
			
			load_detailBiz.updateLoad_detail(ld);			
		}
		else { // 添加
			ld.setFlag("0");
			
			load_detailBiz.addLoad_detail(ld);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showGeneralDetail() {		
		General_detail general_detail = general_detailBiz.getGeneral_detailByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (general_detail != null) {
			request.put("id", general_detail.getId());
			request.put("general_details", general_detail.getGeneral_details());
			request.put("general_nums", general_detail.getGeneral_nums());
		}		
		return "general_detail";
	}
	
	public String changeGeneralDetail() throws IOException {
		General_detail gd = new General_detail();
		gd.setBg_id(this.getBridgeCode());
		gd.setGeneral_details(this.getGeneralDetails());
		gd.setGeneral_nums(this.getGeneralNums());
		
		General_detail general_detail = general_detailBiz.getGeneral_detailByBridgeCode(this.getBridgeCode());
		if (general_detail != null) { // 修改
			gd.setId(general_detail.getId());
			gd.setFlag(general_detail.getFlag());
			
			general_detailBiz.updateGeneral_detail(gd);
		}
		else { // 添加
			gd.setFlag("0");
			
			general_detailBiz.addGeneral_detail(gd);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public String showSupportDetail() {		
		Support_detail support_detail = support_detailBiz.getSupport_detailByBridgeCode(this.getBridgeCode());
		request.put("bg_id", this.getBridgeCode());
		if (support_detail != null) {
			request.put("id", support_detail.getId());
			request.put("support_details", support_detail.getSupport_details());
			request.put("support_nums", support_detail.getSupport_nums());
		}		
		return "support_detail";
	}
	
	public String changeSupportDetail() throws IOException {
		Support_detail sd = new Support_detail();
		sd.setBg_id(this.getBridgeCode());
		sd.setSupport_details(this.getSupportDetails());
		sd.setSupport_nums(this.getSupportNums());
		
		Support_detail support_detail = support_detailBiz.getSupport_detailByBridgeCode(this.getBridgeCode());
		if (support_detail != null) { // 修改
			sd.setId(support_detail.getId());
			sd.setFlag(support_detail.getFlag());
			
			support_detailBiz.updateSupport_detail(sd);
		}
		else { // 添加
			sd.setFlag("0");
			
			support_detailBiz.addSupport_detail(sd);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("bridge!viewBridge?bridgeCode=" + this.getBridgeCode());
		return null;
	}
	
	public void validate(){
		if(session.get("userName")==null){
			session.clear();
			this.addActionError("error");
		}
	}	
}

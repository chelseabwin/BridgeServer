package com.qjs.action;

import global.tool.Constant;
import global.tool.OtherFunction;
import global.tool.QueryItems;
import global.tool.QueryObject;
import global.tool.WordCreate;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.qjs.biz.impl.Base1BizImpl;
import com.qjs.biz.impl.Base2BizImpl;
import com.qjs.biz.impl.Base3BizImpl;
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
import com.qjs.biz.impl.EvaluationBizImpl;
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
import com.qjs.entity.Evaluation;
import com.qjs.entity.General_detail;
import com.qjs.entity.Load_detail;
import com.qjs.entity.Parts1;
import com.qjs.entity.Parts2;
import com.qjs.entity.Pier_detail;
import com.qjs.entity.Structure;
import com.qjs.entity.Support_detail;

public class DiseaseAction extends ActionSupport implements RequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	
	private String bg_name;
	private String table_name;
	private String dis_id;
	private String image;
	
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
	private String image_type;
	private String evaluation;
	private String score;
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
	private Base2BizImpl base2Biz;
	private Base3BizImpl base3Biz;
	private StructureBizImpl structureBiz;
	private Parts1BizImpl parts1Biz;
	private Parts2BizImpl parts2Biz;
	private Load_detailBizImpl load_detailBiz;
	private General_detailBizImpl general_detailBiz;
	private Support_detailBizImpl support_detailBiz;
	private Pier_detailBizImpl pier_detailBiz;
	
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
	private EvaluationBizImpl evaluationBiz;
	
	
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
	
	public String getDis_id() {
		return dis_id;
	}

	public void setDis_id(String dis_id) {
		this.dis_id = dis_id;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
	
	public String getImage_type() {
		return image_type;
	}

	public void setImage_type(String image_type) {
		this.image_type = image_type;
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
	
	public EvaluationBizImpl getEvaluationBiz() {
		return evaluationBiz;
	}
	
	public void setEvaluationBiz(EvaluationBizImpl evaluationBiz) {
		this.evaluationBiz = evaluationBiz;
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
	
//===================================================================================//	
	
	/**图片上传路径*/
	private String savePath = "/disease_image";
	/**这里的名字和html的名字必须对称*/
	private File img;
	/**要上传的文件类型*/
	private String imgContentType;
	/**文件的名称*/
	private String imgFileName;
	/**
	 * 指定的上传类型为图片格式的文件
	 */
	private static final String[] types = {"image/jpeg", "image/jpg", "image/png", "image/gif", "image/bmp"};
	
	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}
	
	public File getImg() {
		return img;
	}
	
	public void setImg(File img) {
		this.img = img;
	}
	
	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	/***
	 * 判断文件的类型是否为指定的文件类型
	 * @return
	 */
	public boolean filterType() {
		boolean isFileType = false;
		String fileType = getImgContentType();
		System.out.println(fileType);
		for (String type : types) {
			if (type.equals(fileType)) {
				isFileType = true;
				break;
			}
		}
		return isFileType;
	}
	
	/**
	 * 取得文件夹大小
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public long getFileSize(File f) throws Exception {
		return f.length();
	}

	public String FormetFileSize(long fileS) {// 转换文件大小
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}
	
	/**
	 * 上传文件操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public void upload() throws Exception {
		String result = "未知错误";
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String imgFilePath = null;
		if (!filterType()) {
			System.out.println("文件类型不正确");
			ServletActionContext.getRequest().setAttribute("typeError", "您要上传的文件类型不正确");

			result = "上传错误:" + getImgContentType() + " 文件类型不正确！";
		} else {
			System.out.println("当前文件大小为：" + FormetFileSize(getFileSize(getImg())));
			FileOutputStream fos = null;
			FileInputStream fis = null;
			try {
				
				// 保存文件那一个路径
				imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + getImgContentType().split("/")[1];
				fos = new FileOutputStream(imgFilePath);
				fis = new FileInputStream(getImg());
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				result = "success";
			} catch (Exception e) {
				result = "faild";
				e.printStackTrace();
			} finally {
				fos.close();
				fis.close();
			}
		}
		if (result.equals("success")) {
			String imgStr = getImageStr(imgFilePath);
			
			//创建JSONObject对象
			JSONObject json = new JSONObject();
			
			//向json中添加数据
			json.put("img_name", new File(imgFilePath).getName());
			json.put("img_str", imgStr);
			json.put("img_type", getImgContentType());

			out.write(json.toString());
		}
		else {
			out.write("faild");
		}
	}
	
//===================================================================================//	
	
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
		request.put("item_name", this.getItem_name());
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
		
		for (int i = 0; i < dataList.size(); i++) {
			// 获取实际evaluation值	
			Evaluation eval = evaluationBiz.getEvaluationExactly(table_name, bg_id, dataList.get(i).get("id").toString());
			if (eval != null) {
				dataList.get(i).put("real_eval", eval.getEvaluation());
			}
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
		
		return "disease_table_data";
	}
	
	public String viewDisease() throws IOException {
		request.put("bg_name", this.getBg_name());
		request.put("bg_id", this.getBg_id());
		request.put("table_name", this.getTable_name());
		request.put("item_name", this.getItem_name());
		
		switch (this.getTable_name()) {
		case "disease_girder":
			Disease_girder disease_girder = disease_girderBiz.getDisease_girderById(this.getId());
			String imgStr_girder = disease_girder.getDisease_image();
			if (imgStr_girder != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_girder.getImage_type().split("/")[1];
				if (generateImage(imgStr_girder, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_girder", disease_girder);
			return "girder_view";
			
		case "disease_wetjoint":
			Disease_wetjoint disease_wetjoint = disease_wetjointBiz.getDisease_wetjointById(this.getId());
			String imgStr_wetjoint = disease_wetjoint.getDisease_image();
			if (imgStr_wetjoint != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_wetjoint.getImage_type().split("/")[1];
				if (generateImage(imgStr_wetjoint, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_wetjoint", disease_wetjoint);
			return "wetjoint_view";
			
		case "disease_support":
			Disease_support disease_support = disease_supportBiz.getDisease_supportById(this.getId());
			String imgStr_support = disease_support.getDisease_image();
			if (imgStr_support != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_support.getImage_type().split("/")[1];
				if (generateImage(imgStr_support, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_support", disease_support);
			return "support_view";
			
		case "disease_pier":
			Disease_pier disease_pier = disease_pierBiz.getDisease_pierById(this.getId());
			String imgStr_pier = disease_pier.getDisease_image();
			if (imgStr_pier != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_pier.getImage_type().split("/")[1];
				if (generateImage(imgStr_pier, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_pier", disease_pier);
			return "pier_view";
			
		case "disease_bentcap":
			Disease_bentcap disease_bentcap = disease_bentcapBiz.getDisease_bentcapById(this.getId());
			String imgStr_bentcap = disease_bentcap.getDisease_image();
			if (imgStr_bentcap != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_bentcap.getImage_type().split("/")[1];
				if (generateImage(imgStr_bentcap, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_bentcap", disease_bentcap);
			return "bentcap_view";
			
		case "disease_tiebeam":
			Disease_tiebeam disease_tiebeam = disease_tiebeamBiz.getDisease_tiebeamById(this.getId());
			String imgStr_tiebeam = disease_tiebeam.getDisease_image();
			if (imgStr_tiebeam != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_tiebeam.getImage_type().split("/")[1];
				if (generateImage(imgStr_tiebeam, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_tiebeam", disease_tiebeam);
			return "tiebeam_view";
			
		case "disease_atbody":
			Disease_atbody disease_atbody = disease_atbodyBiz.getDisease_atbodyById(this.getId());
			String imgStr_atbody = disease_atbody.getDisease_image();
			if (imgStr_atbody != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_atbody.getImage_type().split("/")[1];
				if (generateImage(imgStr_atbody, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_atbody", disease_atbody);
			return "atbody_view";
			
		case "disease_atcapping":
			Disease_atcapping disease_atcapping = disease_atcappingBiz.getDisease_atcappingById(this.getId());
			String imgStr_atcapping = disease_atcapping.getDisease_image();
			if (imgStr_atcapping != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_atcapping.getImage_type().split("/")[1];
				if (generateImage(imgStr_atcapping, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_atcapping", disease_atcapping);
			return "atcapping_view";
			
		case "disease_pa":
			Disease_pa disease_pa = disease_paBiz.getDisease_paById(this.getId());
			String imgStr_pa = disease_pa.getDisease_image();
			if (imgStr_pa != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_pa.getImage_type().split("/")[1];
				if (generateImage(imgStr_pa, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_pa", disease_pa);
			return "pa_view";
			
		case "disease_bed":
			Disease_bed disease_bed = disease_bedBiz.getDisease_bedById(this.getId());
			String imgStr_bed = disease_bed.getDisease_image();
			if (imgStr_bed != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_bed.getImage_type().split("/")[1];
				if (generateImage(imgStr_bed, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_bed", disease_bed);
			return "bed_view";
			
		case "disease_regstruc":
			Disease_regstruc disease_regstruc = disease_regstrucBiz.getDisease_regstrucById(this.getId());
			String imgStr_regstruc = disease_regstruc.getDisease_image();
			if (imgStr_regstruc != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_regstruc.getImage_type().split("/")[1];
				if (generateImage(imgStr_regstruc, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_regstruc", disease_regstruc);
			return "regstruc_view";
			
		case "disease_wingwall":
			Disease_wingwall disease_wingwall = disease_wingwallBiz.getDisease_wingwallById(this.getId());
			String imgStr_wingwall = disease_wingwall.getDisease_image();
			if (imgStr_wingwall != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_wingwall.getImage_type().split("/")[1];
				if (generateImage(imgStr_wingwall, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_wingwall", disease_wingwall);
			return "wingwall_view";
			
		case "disease_conslope":
			Disease_conslope disease_conslope = disease_conslopeBiz.getDisease_conslopeById(this.getId());
			String imgStr_conslope = disease_conslope.getDisease_image();
			if (imgStr_conslope != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_conslope.getImage_type().split("/")[1];
				if (generateImage(imgStr_conslope, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_conslope", disease_conslope);
			return "conslope_view";
			
		case "disease_proslope":
			Disease_proslope disease_proslope = disease_proslopeBiz.getDisease_proslopeById(this.getId());
			String imgStr_proslope = disease_proslope.getDisease_image();
			if (imgStr_proslope != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_proslope.getImage_type().split("/")[1];
				if (generateImage(imgStr_proslope, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_proslope", disease_proslope);
			return "proslope_view";
			
		case "disease_deck":
			Disease_deck disease_deck = disease_deckBiz.getDisease_deckById(this.getId());
			String imgStr_deck = disease_deck.getDisease_image();
			if (imgStr_deck != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_deck.getImage_type().split("/")[1];
				if (generateImage(imgStr_deck, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_deck", disease_deck);
			return "deck_view";
			
		case "disease_joint":
			Disease_joint disease_joint = disease_jointBiz.getDisease_jointById(this.getId());
			String imgStr_joint = disease_joint.getDisease_image();
			if (imgStr_joint != "") {
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_joint.getImage_type().split("/")[1];
				if (generateImage(imgStr_joint, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_joint", disease_joint);
			return "joint_view";
			
		case "disease_sidewalk":
			Disease_sidewalk disease_sidewalk = disease_sidewalkBiz.getDisease_sidewalkById(this.getId());
			String imgStr_sidewalk = disease_sidewalk.getDisease_image();
			if (imgStr_sidewalk != "") {				
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_sidewalk.getImage_type().split("/")[1];
				if (generateImage(imgStr_sidewalk, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_sidewalk", disease_sidewalk);
			return "sidewalk_view";
			
		case "disease_fence":
			Disease_fence disease_fence = disease_fenceBiz.getDisease_fenceById(this.getId());
			String imgStr_fence = disease_fence.getDisease_image();
			if (imgStr_fence != "") {				
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_fence.getImage_type().split("/")[1];
				if (generateImage(imgStr_fence, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_fence", disease_fence);
			return "fence_view";
			
		case "disease_watertight":
			Disease_watertight disease_watertight = disease_watertightBiz.getDisease_watertightById(this.getId());
			String imgStr_watertight = disease_watertight.getDisease_image();
			if (imgStr_watertight != "") {				
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_watertight.getImage_type().split("/")[1];
				if (generateImage(imgStr_watertight, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_watertight", disease_watertight);
			return "watertight_view";
			
		case "disease_lighting":
			Disease_lighting disease_lighting = disease_lightingBiz.getDisease_lightingById(this.getId());
			String imgStr_lighting = disease_lighting.getDisease_image();
			if (imgStr_lighting != "") {				
				String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_lighting.getImage_type().split("/")[1];
				if (generateImage(imgStr_lighting, imgFilePath)) {
					request.put("img_name", new File(imgFilePath).getName());
				}
			}
			request.put("disease_lighting", disease_lighting);
			return "lighting_view";

		default:
			break;
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("disease!getBaseDiseaseList?table_name=" + this.getTable_name() + "&bg_id=" + this.getBg_id() + "&bg_name=" + this.getBg_name());
		return null;
	}
	
	public String addDisease() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String id_name = "bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(this.getBg_name(),"UTF-8");		
		
		switch (this.getTable_name()) {
		case "disease_girder":
			response.sendRedirect("disease!showGirder?" + id_name);
			return null;
		case "disease_wetjoint":
			response.sendRedirect("disease!showWetjoint?" + id_name);
			return null;
		case "disease_support":
			response.sendRedirect("disease!showSupport?" + id_name);
			return null;
		case "disease_pier":
			response.sendRedirect("disease!showPier?" + id_name);
			return null;
		case "disease_bentcap":
			response.sendRedirect("disease!showBentcap?" + id_name);
			return null;
		case "disease_tiebeam":
			response.sendRedirect("disease!showTiebeam?" + id_name);
			return null;			
		case "disease_atbody":
			response.sendRedirect("disease!showAtbody?" + id_name);
			return null;
		case "disease_atcapping":
			response.sendRedirect("disease!showAtcapping?" + id_name);
			return null;
		case "disease_pa":
			response.sendRedirect("disease!showPa?" + id_name);
			return null;
		case "disease_bed":
			response.sendRedirect("disease!showBed?" + id_name);
			return null;
		case "disease_regstruc":
			response.sendRedirect("disease!showRegstruc?" + id_name);
			return null;
		case "disease_wingwall":
			response.sendRedirect("disease!showWingwall?" + id_name);
			return null;
		case "disease_conslope":
			response.sendRedirect("disease!showConslope?" + id_name);
			return null;
		case "disease_proslope":
			response.sendRedirect("disease!showProslope?" + id_name);
			return null;
		case "disease_deck":
			response.sendRedirect("disease!showDeck?" + id_name);
			return null;
		case "disease_joint":
			response.sendRedirect("disease!showJoint?" + id_name);
			return null;
		case "disease_sidewalk":
			response.sendRedirect("disease!showSidewalk?" + id_name);
			return null;
		case "disease_fence":
			response.sendRedirect("disease!showFence?" + id_name);
			return null;
		case "disease_watertight":
			response.sendRedirect("disease!showWatertight?" + id_name);
			return null;
		case "disease_lighting":
			response.sendRedirect("disease!showLighting?" + id_name);
			return null;
		default:
			break;
		}
		return null;
	}
	
	public String showGirder() {
		if (this.getId() != null) {
			Disease_girder disease_girder = disease_girderBiz.getDisease_girderById(this.getId());
			if (disease_girder != null) {
				request.put("id", disease_girder.getId());
				request.put("bg_id", disease_girder.getBg_id());
				request.put("item_name", disease_girder.getItem_name());
				request.put("parts_id", disease_girder.getParts_id());
				request.put("rg_feature", disease_girder.getRg_feature());
				request.put("rg_fissure", disease_girder.getRg_fissure());
				request.put("sp_otherDisease", disease_girder.getSp_otherDisease());
				request.put("start", disease_girder.getStart());
				request.put("end", disease_girder.getEnd());
				request.put("area", disease_girder.getArea());
				request.put("length", disease_girder.getLength());
				request.put("width", disease_girder.getWidth());
				request.put("side_start", disease_girder.getSide_start());
				request.put("side_end", disease_girder.getSide_end());
				request.put("side_length", disease_girder.getSide_length());
				request.put("side_width", disease_girder.getSide_width());
				request.put("rg_location", disease_girder.getRg_location());
				request.put("add_content", disease_girder.getAdd_content());
				request.put("disease_image", disease_girder.getDisease_image());
				request.put("image_type", disease_girder.getImage_type());
				request.put("evaluation", disease_girder.getEvaluation());
				
				String imgStr = disease_girder.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_girder.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}
		
		return "disease_girder";
	}
	
	public String showWetjoint() {
		if (this.getId() != null) {
			Disease_wetjoint disease_wetjoint = disease_wetjointBiz.getDisease_wetjointById(this.getId());
			if (disease_wetjoint != null) {
				request.put("id", disease_wetjoint.getId());
				request.put("bg_id", disease_wetjoint.getBg_id());
				request.put("item_name", disease_wetjoint.getItem_name());
				request.put("parts_id", disease_wetjoint.getParts_id());
				request.put("rg_feature", disease_wetjoint.getRg_feature());
				request.put("rg_fissure", disease_wetjoint.getRg_fissure());
				request.put("sp_otherDisease", disease_wetjoint.getSp_otherDisease());
				request.put("l1_start", disease_wetjoint.getL1_start());
				request.put("l1_end", disease_wetjoint.getL1_end());
				request.put("l1_area", disease_wetjoint.getL1_area());
				request.put("l2_start", disease_wetjoint.getL2_start());
				request.put("l2_length", disease_wetjoint.getL2_length());
				request.put("l2_width", disease_wetjoint.getL2_width());
				request.put("add_content", disease_wetjoint.getAdd_content());
				request.put("disease_image", disease_wetjoint.getDisease_image());
				request.put("image_type", disease_wetjoint.getImage_type());
				request.put("evaluation", disease_wetjoint.getEvaluation());
				
				String imgStr = disease_wetjoint.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_wetjoint.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_wetjoint";
	}
	
	public String showSupport() {
		if (this.getId() != null) {
			Disease_support disease_support = disease_supportBiz.getDisease_supportById(this.getId());
			if (disease_support != null) {
				request.put("id", disease_support.getId());
				request.put("bg_id", disease_support.getBg_id());
				request.put("item_name", disease_support.getItem_name());
				request.put("parts_id", disease_support.getParts_id());
				request.put("rg_feature", disease_support.getRg_feature());
				request.put("add_content", disease_support.getAdd_content());
				request.put("disease_image", disease_support.getDisease_image());
				request.put("image_type", disease_support.getImage_type());
				request.put("evaluation", disease_support.getEvaluation());
				
				String imgStr = disease_support.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_support.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_support";
	}
	
	public String showPier() {
		if (this.getId() != null) {
			Disease_pier disease_pier = disease_pierBiz.getDisease_pierById(this.getId());
			if (disease_pier != null) {
				request.put("id", disease_pier.getId());
				request.put("bg_id", disease_pier.getBg_id());
				request.put("item_name", disease_pier.getItem_name());
				request.put("parts_id", disease_pier.getParts_id());
				request.put("rg_feature", disease_pier.getRg_feature());
				request.put("rg_fissure", disease_pier.getRg_fissure());
				request.put("sp_otherDisease", disease_pier.getSp_otherDisease());
				request.put("l1_start", disease_pier.getL1_start());
				request.put("l1_end", disease_pier.getL1_end());
				request.put("l1_area", disease_pier.getL1_area());
				request.put("l2_start", disease_pier.getL2_start());
				request.put("l2_length", disease_pier.getL2_length());
				request.put("l2_width", disease_pier.getL2_width());
				request.put("add_content", disease_pier.getAdd_content());
				request.put("disease_image", disease_pier.getDisease_image());
				request.put("image_type", disease_pier.getImage_type());
				request.put("evaluation", disease_pier.getEvaluation());
				
				String imgStr = disease_pier.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_pier.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_pier";
	}
	
	public String showBentcap() {
		if (this.getId() != null) {
			Disease_bentcap disease_bentcap = disease_bentcapBiz.getDisease_bentcapById(this.getId());
			if (disease_bentcap != null) {
				request.put("id", disease_bentcap.getId());
				request.put("bg_id", disease_bentcap.getBg_id());
				request.put("item_name", disease_bentcap.getItem_name());
				request.put("parts_id", disease_bentcap.getParts_id());
				request.put("rg_feature", disease_bentcap.getRg_feature());
				request.put("add_content", disease_bentcap.getAdd_content());
				request.put("disease_image", disease_bentcap.getDisease_image());
				request.put("image_type", disease_bentcap.getImage_type());
				request.put("evaluation", disease_bentcap.getEvaluation());
				
				String imgStr = disease_bentcap.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_bentcap.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_bentcap";
	}
	
	public String showTiebeam() {
		if (this.getId() != null) {
			Disease_tiebeam disease_tiebeam = disease_tiebeamBiz.getDisease_tiebeamById(this.getId());
			if (disease_tiebeam != null) {
				request.put("id", disease_tiebeam.getId());
				request.put("bg_id", disease_tiebeam.getBg_id());
				request.put("item_name", disease_tiebeam.getItem_name());
				request.put("parts_id", disease_tiebeam.getParts_id());
				request.put("rg_feature", disease_tiebeam.getRg_feature());
				request.put("add_content", disease_tiebeam.getAdd_content());
				request.put("disease_image", disease_tiebeam.getDisease_image());
				request.put("image_type", disease_tiebeam.getImage_type());
				request.put("evaluation", disease_tiebeam.getEvaluation());
				
				String imgStr = disease_tiebeam.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_tiebeam.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_tiebeam";
	}
	
	public String showAtbody() {
		if (this.getId() != null) {
			Disease_atbody disease_atbody = disease_atbodyBiz.getDisease_atbodyById(this.getId());
			if (disease_atbody != null) {
				request.put("id", disease_atbody.getId());
				request.put("bg_id", disease_atbody.getBg_id());
				request.put("item_name", disease_atbody.getItem_name());
				request.put("parts_id", disease_atbody.getParts_id());
				request.put("rg_feature", disease_atbody.getRg_feature());
				request.put("sp_otherDisease", disease_atbody.getSp_otherDisease());
				request.put("add_content", disease_atbody.getAdd_content());
				request.put("disease_image", disease_atbody.getDisease_image());
				request.put("image_type", disease_atbody.getImage_type());
				request.put("evaluation", disease_atbody.getEvaluation());
				
				String imgStr = disease_atbody.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_atbody.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_atbody";
	}
	
	public String showAtcapping() {
		if (this.getId() != null) {
			Disease_atcapping disease_atcapping = disease_atcappingBiz.getDisease_atcappingById(this.getId());
			if (disease_atcapping != null) {
				request.put("id", disease_atcapping.getId());
				request.put("bg_id", disease_atcapping.getBg_id());
				request.put("item_name", disease_atcapping.getItem_name());
				request.put("parts_id", disease_atcapping.getParts_id());
				request.put("rg_feature", disease_atcapping.getRg_feature());
				request.put("add_content", disease_atcapping.getAdd_content());
				request.put("disease_image", disease_atcapping.getDisease_image());
				request.put("image_type", disease_atcapping.getImage_type());
				request.put("evaluation", disease_atcapping.getEvaluation());
				
				String imgStr = disease_atcapping.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_atcapping.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_atcapping";
	}
	
	public String showPa() {
		if (this.getId() != null) {
			Disease_pa disease_pa = disease_paBiz.getDisease_paById(this.getId());
			if (disease_pa != null) {
				request.put("id", disease_pa.getId());
				request.put("bg_id", disease_pa.getBg_id());
				request.put("item_name", disease_pa.getItem_name());
				request.put("parts_id", disease_pa.getParts_id());
				request.put("rg_feature", disease_pa.getRg_feature());
				request.put("add_content", disease_pa.getAdd_content());
				request.put("disease_image", disease_pa.getDisease_image());
				request.put("image_type", disease_pa.getImage_type());
				request.put("evaluation", disease_pa.getEvaluation());
				
				String imgStr = disease_pa.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_pa.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_pa";
	}
	
	public String showBed() {
		if (this.getId() != null) {
			Disease_bed disease_bed = disease_bedBiz.getDisease_bedById(this.getId());
			if (disease_bed != null) {
				request.put("id", disease_bed.getId());
				request.put("bg_id", disease_bed.getBg_id());
				request.put("item_name", disease_bed.getItem_name());
				request.put("parts_id", disease_bed.getParts_id());
				request.put("rg_feature", disease_bed.getRg_feature());
				request.put("add_content", disease_bed.getAdd_content());
				request.put("disease_image", disease_bed.getDisease_image());
				request.put("image_type", disease_bed.getImage_type());
				request.put("evaluation", disease_bed.getEvaluation());
				
				String imgStr = disease_bed.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_bed.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_bed";
	}
	
	public String showRegstruc() {
		if (this.getId() != null) {
			Disease_regstruc disease_regstruc = disease_regstrucBiz.getDisease_regstrucById(this.getId());
			if (disease_regstruc != null) {
				request.put("id", disease_regstruc.getId());
				request.put("bg_id", disease_regstruc.getBg_id());
				request.put("item_name", disease_regstruc.getItem_name());
				request.put("parts_id", disease_regstruc.getParts_id());
				request.put("rg_feature", disease_regstruc.getRg_feature());
				request.put("add_content", disease_regstruc.getAdd_content());
				request.put("disease_image", disease_regstruc.getDisease_image());
				request.put("image_type", disease_regstruc.getImage_type());
				request.put("evaluation", disease_regstruc.getEvaluation());
				
				String imgStr = disease_regstruc.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_regstruc.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_regstruc";
	}
	
	public String showWingwall() {
		if (this.getId() != null) {
			Disease_wingwall disease_wingwall = disease_wingwallBiz.getDisease_wingwallById(this.getId());
			if (disease_wingwall != null) {
				request.put("id", disease_wingwall.getId());
				request.put("bg_id", disease_wingwall.getBg_id());
				request.put("item_name", disease_wingwall.getItem_name());
				request.put("parts_id", disease_wingwall.getParts_id());
				request.put("rg_feature", disease_wingwall.getRg_feature());
				request.put("add_content", disease_wingwall.getAdd_content());
				request.put("disease_image", disease_wingwall.getDisease_image());
				request.put("image_type", disease_wingwall.getImage_type());
				request.put("evaluation", disease_wingwall.getEvaluation());
				
				String imgStr = disease_wingwall.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_wingwall.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_wingwall";
	}
	
	public String showConslope() {
		if (this.getId() != null) {
			Disease_conslope disease_conslope = disease_conslopeBiz.getDisease_conslopeById(this.getId());
			if (disease_conslope != null) {
				request.put("id", disease_conslope.getId());
				request.put("bg_id", disease_conslope.getBg_id());
				request.put("item_name", disease_conslope.getItem_name());
				request.put("parts_id", disease_conslope.getParts_id());
				request.put("rg_feature", disease_conslope.getRg_feature());
				request.put("add_content", disease_conslope.getAdd_content());
				request.put("disease_image", disease_conslope.getDisease_image());
				request.put("image_type", disease_conslope.getImage_type());
				request.put("evaluation", disease_conslope.getEvaluation());
				
				String imgStr = disease_conslope.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_conslope.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_conslope";
	}
	
	public String showProslope() {
		if (this.getId() != null) {
			Disease_proslope disease_proslope = disease_proslopeBiz.getDisease_proslopeById(this.getId());
			if (disease_proslope != null) {
				request.put("id", disease_proslope.getId());
				request.put("bg_id", disease_proslope.getBg_id());
				request.put("item_name", disease_proslope.getItem_name());
				request.put("parts_id", disease_proslope.getParts_id());
				request.put("rg_feature", disease_proslope.getRg_feature());
				request.put("add_content", disease_proslope.getAdd_content());
				request.put("disease_image", disease_proslope.getDisease_image());
				request.put("image_type", disease_proslope.getImage_type());
				request.put("evaluation", disease_proslope.getEvaluation());
				
				String imgStr = disease_proslope.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_proslope.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_proslope";
	}
	
	public String showDeck() {
		if (this.getId() != null) {
			Disease_deck disease_deck = disease_deckBiz.getDisease_deckById(this.getId());
			if (disease_deck != null) {
				request.put("id", disease_deck.getId());
				request.put("bg_id", disease_deck.getBg_id());
				request.put("item_name", disease_deck.getItem_name());
				request.put("parts_id", disease_deck.getParts_id());
				request.put("rg_feature", disease_deck.getRg_feature());
				request.put("add_content", disease_deck.getAdd_content());
				request.put("disease_image", disease_deck.getDisease_image());
				request.put("image_type", disease_deck.getImage_type());
				request.put("evaluation", disease_deck.getEvaluation());
				
				String imgStr = disease_deck.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_deck.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}				
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_deck";
	}
	
	public String showJoint() {
		if (this.getId() != null) {
			Disease_joint disease_joint = disease_jointBiz.getDisease_jointById(this.getId());
			if (disease_joint != null) {
				request.put("id", disease_joint.getId());
				request.put("bg_id", disease_joint.getBg_id());
				request.put("item_name", disease_joint.getItem_name());
				request.put("parts_id", disease_joint.getParts_id());
				request.put("rg_feature", disease_joint.getRg_feature());
				request.put("add_content", disease_joint.getAdd_content());
				request.put("disease_image", disease_joint.getDisease_image());
				request.put("image_type", disease_joint.getImage_type());
				request.put("evaluation", disease_joint.getEvaluation());
				
				String imgStr = disease_joint.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_joint.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_joint";
	}
	
	public String showSidewalk() {
		if (this.getId() != null) {
			Disease_sidewalk disease_sidewalk = disease_sidewalkBiz.getDisease_sidewalkById(this.getId());
			if (disease_sidewalk != null) {
				request.put("id", disease_sidewalk.getId());
				request.put("bg_id", disease_sidewalk.getBg_id());
				request.put("item_name", disease_sidewalk.getItem_name());
				request.put("parts_id", disease_sidewalk.getParts_id());
				request.put("rg_feature", disease_sidewalk.getRg_feature());
				request.put("add_content", disease_sidewalk.getAdd_content());
				request.put("disease_image", disease_sidewalk.getDisease_image());
				request.put("image_type", disease_sidewalk.getImage_type());
				request.put("evaluation", disease_sidewalk.getEvaluation());
				
				String imgStr = disease_sidewalk.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_sidewalk.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_sidewalk";
	}
	
	public String showFence() {
		if (this.getId() != null) {
			Disease_fence disease_fence = disease_fenceBiz.getDisease_fenceById(this.getId());
			if (disease_fence != null) {
				request.put("id", disease_fence.getId());
				request.put("bg_id", disease_fence.getBg_id());
				request.put("item_name", disease_fence.getItem_name());
				request.put("parts_id", disease_fence.getParts_id());
				request.put("rg_feature", disease_fence.getRg_feature());
				request.put("add_content", disease_fence.getAdd_content());
				request.put("disease_image", disease_fence.getDisease_image());
				request.put("image_type", disease_fence.getImage_type());
				request.put("evaluation", disease_fence.getEvaluation());
				
				String imgStr = disease_fence.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_fence.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_fence";
	}
	
	public String showWatertight() {
		if (this.getId() != null) {
			Disease_watertight disease_watertight = disease_watertightBiz.getDisease_watertightById(this.getId());
			if (disease_watertight != null) {
				request.put("id", disease_watertight.getId());
				request.put("bg_id", disease_watertight.getBg_id());
				request.put("item_name", disease_watertight.getItem_name());
				request.put("parts_id", disease_watertight.getParts_id());
				request.put("rg_feature", disease_watertight.getRg_feature());
				request.put("add_content", disease_watertight.getAdd_content());
				request.put("disease_image", disease_watertight.getDisease_image());
				request.put("image_type", disease_watertight.getImage_type());
				request.put("evaluation", disease_watertight.getEvaluation());
				
				String imgStr = disease_watertight.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_watertight.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_watertight";
	}
	
	public String showLighting() {
		if (this.getId() != null) {
			Disease_lighting disease_lighting = disease_lightingBiz.getDisease_lightingById(this.getId());
			if (disease_lighting != null) {
				request.put("id", disease_lighting.getId());
				request.put("bg_id", disease_lighting.getBg_id());
				request.put("item_name", disease_lighting.getItem_name());
				request.put("parts_id", disease_lighting.getParts_id());
				request.put("rg_feature", disease_lighting.getRg_feature());
				request.put("add_content", disease_lighting.getAdd_content());
				request.put("disease_image", disease_lighting.getDisease_image());
				request.put("image_type", disease_lighting.getImage_type());
				request.put("evaluation", disease_lighting.getEvaluation());
				
				String imgStr = disease_lighting.getDisease_image();
				if (imgStr != "") {
					String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + disease_lighting.getImage_type().split("/")[1];
					if (generateImage(imgStr, imgFilePath)) {
						request.put("img_name", new File(imgFilePath).getName());
					}
				}
			}
		}		
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		
		return "disease_lighting";
	}
	
	public String changeGirder() throws Exception {
		Disease_girder girder = new Disease_girder();
		girder.setBg_id(this.getBg_id());
		girder.setParts_id(this.getParts_id());
		girder.setItem_name(this.getItem_name());
		girder.setRg_feature(this.getRg_feature());
		girder.setRg_fissure(this.getRg_fissure());
		girder.setSp_otherDisease(this.getSp_otherDisease());
		girder.setStart(this.getStart());
		girder.setEnd(this.getEnd());
		girder.setArea(this.getArea());
		girder.setLength(this.getLength());
		girder.setWidth(this.getWidth());
		girder.setSide_start(this.getSide_start());
		girder.setSide_end(this.getSide_end());
		girder.setSide_length(this.getSide_length());
		girder.setSide_width(this.getSide_width());
		girder.setRg_location(this.getRg_location());
		girder.setAdd_content(this.getAdd_content());
		girder.setDisease_image(this.getDisease_image());
		girder.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_girder dis = disease_girderBiz.getDisease_girderById(this.getId());
			if (dis != null) { // 修改
				girder.setId(dis.getId());
				girder.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature()) 
						|| (dis.getRg_feature().equals("其他病害") && !dis.getSp_otherDisease().equals(this.getSp_otherDisease()))) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_girder", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_girderBiz.updateDisease_girder(girder);				
				response.sendRedirect("disease!viewDisease?table_name=disease_girder&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			girder.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_girderBiz.addDisease_girder(girder);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_girder&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeWetjoint() throws IOException {
		Disease_wetjoint wetjoint = new Disease_wetjoint();
		wetjoint.setBg_id(this.getBg_id());
		wetjoint.setParts_id(this.getParts_id());
		wetjoint.setItem_name(this.getItem_name());
		wetjoint.setRg_feature(this.getRg_feature());
		wetjoint.setRg_fissure(this.getRg_fissure());
		wetjoint.setSp_otherDisease(this.getSp_otherDisease());
		wetjoint.setL1_start(this.getL1_start());
		wetjoint.setL1_end(this.getL1_end());
		wetjoint.setL1_area(this.getL1_area());
		wetjoint.setL2_start(this.getL2_start());
		wetjoint.setL2_length(this.getL2_length());
		wetjoint.setL2_width(this.getL2_width());
		wetjoint.setAdd_content(this.getAdd_content());
		wetjoint.setDisease_image(this.getDisease_image());
		wetjoint.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_wetjoint dis = disease_wetjointBiz.getDisease_wetjointById(this.getId());
			if (dis != null) { // 修改
				wetjoint.setId(dis.getId());
				wetjoint.setFlag(dis.getFlag());

				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature()) 
						|| (dis.getRg_feature().equals("其他病害") && !dis.getSp_otherDisease().equals(this.getSp_otherDisease()))) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_wetjoint", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_wetjointBiz.updateDisease_wetjoint(wetjoint);				
				response.sendRedirect("disease!viewDisease?table_name=disease_wetjoint&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			wetjoint.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_wetjointBiz.addDisease_wetjoint(wetjoint);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_wetjoint&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeSupport() throws IOException {
		Disease_support support = new Disease_support();
		support.setBg_id(this.getBg_id());
		support.setParts_id(this.getParts_id());
		support.setItem_name(this.getItem_name());
		support.setRg_feature(this.getRg_feature());
		support.setAdd_content(this.getAdd_content());
		support.setDisease_image(this.getDisease_image());
		support.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_support dis = disease_supportBiz.getDisease_supportById(this.getId());
			if (dis != null) { // 修改
				support.setId(dis.getId());
				support.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_support", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_supportBiz.updateDisease_support(support);
				response.sendRedirect("disease!viewDisease?table_name=disease_support&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			support.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_supportBiz.addDisease_support(support);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_support&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changePier() throws IOException {
		Disease_pier pier = new Disease_pier();
		pier.setBg_id(this.getBg_id());
		pier.setParts_id(this.getParts_id());
		pier.setItem_name(this.getItem_name());
		pier.setRg_feature(this.getRg_feature());
		pier.setRg_fissure(this.getRg_fissure());
		pier.setSp_otherDisease(this.getSp_otherDisease());
		pier.setL1_start(this.getL1_start());
		pier.setL1_end(this.getL1_end());
		pier.setL1_area(this.getL1_area());
		pier.setL2_start(this.getL2_start());
		pier.setL2_length(this.getL2_length());
		pier.setL2_width(this.getL2_width());
		pier.setAdd_content(this.getAdd_content());
		pier.setDisease_image(this.getDisease_image());
		pier.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_pier dis = disease_pierBiz.getDisease_pierById(this.getId());
			if (dis != null) { // 修改
				pier.setId(dis.getId());
				pier.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature()) 
						|| (dis.getRg_feature().equals("其他病害") && !dis.getSp_otherDisease().equals(this.getSp_otherDisease()))) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_pier", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_pierBiz.updateDisease_pier(pier);				
				response.sendRedirect("disease!viewDisease?table_name=disease_pier&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			pier.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_pierBiz.addDisease_pier(pier);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_pier&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeBentcap() throws IOException {
		Disease_bentcap bentcap = new Disease_bentcap();
		bentcap.setBg_id(this.getBg_id());
		bentcap.setParts_id(this.getParts_id());
		bentcap.setItem_name(this.getItem_name());
		bentcap.setRg_feature(this.getRg_feature());
		bentcap.setAdd_content(this.getAdd_content());
		bentcap.setDisease_image(this.getDisease_image());
		bentcap.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_bentcap dis = disease_bentcapBiz.getDisease_bentcapById(this.getId());
			if (dis != null) { // 修改
				bentcap.setId(dis.getId());
				bentcap.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_bentcap", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_bentcapBiz.updateDisease_bentcap(bentcap);				
				response.sendRedirect("disease!viewDisease?table_name=disease_bentcap&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			bentcap.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_bentcapBiz.addDisease_bentcap(bentcap);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_bentcap&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeTiebeam() throws IOException {
		Disease_tiebeam tiebeam = new Disease_tiebeam();
		tiebeam.setBg_id(this.getBg_id());
		tiebeam.setParts_id(this.getParts_id());
		tiebeam.setItem_name(this.getItem_name());
		tiebeam.setRg_feature(this.getRg_feature());
		tiebeam.setAdd_content(this.getAdd_content());
		tiebeam.setDisease_image(this.getDisease_image());
		tiebeam.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_tiebeam dis = disease_tiebeamBiz.getDisease_tiebeamById(this.getId());
			if (dis != null) { // 修改
				tiebeam.setId(dis.getId());
				tiebeam.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_tiebeam", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_tiebeamBiz.updateDisease_tiebeam(tiebeam);				
				response.sendRedirect("disease!viewDisease?table_name=disease_tiebeam&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			tiebeam.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_tiebeamBiz.addDisease_tiebeam(tiebeam);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_tiebeam&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeAtbody() throws IOException {
		Disease_atbody atbody = new Disease_atbody();
		atbody.setBg_id(this.getBg_id());
		atbody.setParts_id(this.getParts_id());
		atbody.setItem_name(this.getItem_name());
		atbody.setRg_feature(this.getRg_feature());
		atbody.setSp_otherDisease(this.getSp_otherDisease());
		atbody.setAdd_content(this.getAdd_content());
		atbody.setDisease_image(this.getDisease_image());
		atbody.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_atbody dis = disease_atbodyBiz.getDisease_atbodyById(this.getId());
			if (dis != null) { // 修改
				atbody.setId(dis.getId());
				atbody.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature()) 
						|| (dis.getRg_feature().equals("其他病害") && !dis.getSp_otherDisease().equals(this.getSp_otherDisease()))) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_atbody", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_atbodyBiz.updateDisease_atbody(atbody);				
				response.sendRedirect("disease!viewDisease?table_name=disease_atbody&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			atbody.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_atbodyBiz.addDisease_atbody(atbody);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_atbody&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeAtcapping() throws IOException {
		Disease_atcapping atcapping = new Disease_atcapping();
		atcapping.setBg_id(this.getBg_id());
		atcapping.setParts_id(this.getParts_id());
		atcapping.setItem_name(this.getItem_name());
		atcapping.setRg_feature(this.getRg_feature());
		atcapping.setAdd_content(this.getAdd_content());
		atcapping.setDisease_image(this.getDisease_image());
		atcapping.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_atcapping dis = disease_atcappingBiz.getDisease_atcappingById(this.getId());
			if (dis != null) { // 修改
				atcapping.setId(dis.getId());
				atcapping.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_atcapping", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_atcappingBiz.updateDisease_atcapping(atcapping);				
				response.sendRedirect("disease!viewDisease?table_name=disease_atcapping&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			atcapping.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_atcappingBiz.addDisease_atcapping(atcapping);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_atcapping&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changePa() throws IOException {
		Disease_pa pa = new Disease_pa();
		pa.setBg_id(this.getBg_id());
		pa.setParts_id(this.getParts_id());
		pa.setItem_name(this.getItem_name());
		pa.setRg_feature(this.getRg_feature());
		pa.setAdd_content(this.getAdd_content());
		pa.setDisease_image(this.getDisease_image());
		pa.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_pa dis = disease_paBiz.getDisease_paById(this.getId());
			if (dis != null) { // 修改
				pa.setId(dis.getId());
				pa.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_pa", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_paBiz.updateDisease_pa(pa);				
				response.sendRedirect("disease!viewDisease?table_name=disease_pa&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			pa.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_paBiz.addDisease_pa(pa);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_pa&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeBed() throws IOException {
		Disease_bed bed = new Disease_bed();
		bed.setBg_id(this.getBg_id());
		bed.setParts_id(this.getParts_id());
		bed.setItem_name(this.getItem_name());
		bed.setRg_feature(this.getRg_feature());
		bed.setAdd_content(this.getAdd_content());
		bed.setDisease_image(this.getDisease_image());
		bed.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_bed dis = disease_bedBiz.getDisease_bedById(this.getId());
			if (dis != null) { // 修改
				bed.setId(dis.getId());
				bed.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_bed", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_bedBiz.updateDisease_bed(bed);				
				response.sendRedirect("disease!viewDisease?table_name=disease_bed&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			bed.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_bedBiz.addDisease_bed(bed);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_bed&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeRegstruc() throws IOException {
		Disease_regstruc regstruc = new Disease_regstruc();
		regstruc.setBg_id(this.getBg_id());
		regstruc.setParts_id(this.getParts_id());
		regstruc.setItem_name(this.getItem_name());
		regstruc.setRg_feature(this.getRg_feature());
		regstruc.setAdd_content(this.getAdd_content());
		regstruc.setDisease_image(this.getDisease_image());
		regstruc.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_regstruc dis = disease_regstrucBiz.getDisease_regstrucById(this.getId());
			if (dis != null) { // 修改
				regstruc.setId(dis.getId());
				regstruc.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_regstruc", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_regstrucBiz.updateDisease_regstruc(regstruc);				
				response.sendRedirect("disease!viewDisease?table_name=disease_regstruc&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			regstruc.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_regstrucBiz.addDisease_regstruc(regstruc);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_regstruc&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeWingwall() throws IOException {
		Disease_wingwall wingwall = new Disease_wingwall();
		wingwall.setBg_id(this.getBg_id());
		wingwall.setParts_id(this.getParts_id());
		wingwall.setItem_name(this.getItem_name());
		wingwall.setRg_feature(this.getRg_feature());
		wingwall.setAdd_content(this.getAdd_content());
		wingwall.setDisease_image(this.getDisease_image());
		wingwall.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_wingwall dis = disease_wingwallBiz.getDisease_wingwallById(this.getId());
			if (dis != null) { // 修改
				wingwall.setId(dis.getId());
				wingwall.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_wingwall", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_wingwallBiz.updateDisease_wingwall(wingwall);				
				response.sendRedirect("disease!viewDisease?table_name=disease_wingwall&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			wingwall.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_wingwallBiz.addDisease_wingwall(wingwall);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_wingwall&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeConslope() throws IOException {
		Disease_conslope conslope = new Disease_conslope();
		conslope.setBg_id(this.getBg_id());
		conslope.setParts_id(this.getParts_id());
		conslope.setItem_name(this.getItem_name());
		conslope.setRg_feature(this.getRg_feature());
		conslope.setAdd_content(this.getAdd_content());
		conslope.setDisease_image(this.getDisease_image());
		conslope.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_conslope dis = disease_conslopeBiz.getDisease_conslopeById(this.getId());
			if (dis != null) { // 修改
				conslope.setId(dis.getId());
				conslope.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_conslope", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_conslopeBiz.updateDisease_conslope(conslope);				
				response.sendRedirect("disease!viewDisease?table_name=disease_conslope&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			conslope.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_conslopeBiz.addDisease_conslope(conslope);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_conslope&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeProslope() throws IOException {
		Disease_proslope proslope = new Disease_proslope();
		proslope.setBg_id(this.getBg_id());
		proslope.setParts_id(this.getParts_id());
		proslope.setItem_name(this.getItem_name());
		proslope.setRg_feature(this.getRg_feature());
		proslope.setAdd_content(this.getAdd_content());
		proslope.setDisease_image(this.getDisease_image());
		proslope.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_proslope dis = disease_proslopeBiz.getDisease_proslopeById(this.getId());
			if (dis != null) { // 修改
				proslope.setId(dis.getId());
				proslope.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_proslope", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_proslopeBiz.updateDisease_proslope(proslope);				
				response.sendRedirect("disease!viewDisease?table_name=disease_proslope&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			proslope.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_proslopeBiz.addDisease_proslope(proslope);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_proslope&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeDeck() throws IOException, SerialException, SQLException {
		Disease_deck deck = new Disease_deck();
		deck.setBg_id(this.getBg_id());
		deck.setParts_id(this.getParts_id());
		deck.setItem_name(this.getItem_name());
		deck.setRg_feature(this.getRg_feature());
		deck.setAdd_content(this.getAdd_content());
		deck.setDisease_image(this.getDisease_image());
		deck.setImage_type(this.getImage_type());
		
		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_deck dis = disease_deckBiz.getDisease_deckById(this.getId());
			if (dis != null) { // 修改
				deck.setId(dis.getId());
				deck.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_deck", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_deckBiz.updateDisease_deck(deck);				
				response.sendRedirect("disease!viewDisease?table_name=disease_deck&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			deck.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_deckBiz.addDisease_deck(deck);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_deck&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeJoint() throws IOException {
		Disease_joint joint = new Disease_joint();
		joint.setBg_id(this.getBg_id());
		joint.setParts_id(this.getParts_id());
		joint.setItem_name(this.getItem_name());
		joint.setRg_feature(this.getRg_feature());
		joint.setAdd_content(this.getAdd_content());
		joint.setDisease_image(this.getDisease_image());
		joint.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_joint dis = disease_jointBiz.getDisease_jointById(this.getId());
			if (dis != null) { // 修改
				joint.setId(dis.getId());
				joint.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_joint", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_jointBiz.updateDisease_joint(joint);				
				response.sendRedirect("disease!viewDisease?table_name=disease_joint&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			joint.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_jointBiz.addDisease_joint(joint);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_joint&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeSidewalk() throws IOException {
		Disease_sidewalk sidewalk = new Disease_sidewalk();
		sidewalk.setBg_id(this.getBg_id());
		sidewalk.setParts_id(this.getParts_id());
		sidewalk.setItem_name(this.getItem_name());
		sidewalk.setRg_feature(this.getRg_feature());
		sidewalk.setAdd_content(this.getAdd_content());
		sidewalk.setDisease_image(this.getDisease_image());
		sidewalk.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_sidewalk dis = disease_sidewalkBiz.getDisease_sidewalkById(this.getId());
			if (dis != null) { // 修改
				sidewalk.setId(dis.getId());
				sidewalk.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_sidewalk", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_sidewalkBiz.updateDisease_sidewalk(sidewalk);				
				response.sendRedirect("disease!viewDisease?table_name=disease_sidewalk&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			sidewalk.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_sidewalkBiz.addDisease_sidewalk(sidewalk);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_sidewalk&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeFence() throws IOException {
		Disease_fence fence = new Disease_fence();
		fence.setBg_id(this.getBg_id());
		fence.setParts_id(this.getParts_id());
		fence.setItem_name(this.getItem_name());
		fence.setRg_feature(this.getRg_feature());
		fence.setAdd_content(this.getAdd_content());
		fence.setDisease_image(this.getDisease_image());
		fence.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_fence dis = disease_fenceBiz.getDisease_fenceById(this.getId());
			if (dis != null) { // 修改
				fence.setId(dis.getId());
				fence.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_fence", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_fenceBiz.updateDisease_fence(fence);				
				response.sendRedirect("disease!viewDisease?table_name=disease_fence&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			fence.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_fenceBiz.addDisease_fence(fence);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_fence&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	public String changeWatertight() throws IOException {
		Disease_watertight watertight = new Disease_watertight();
		watertight.setBg_id(this.getBg_id());
		watertight.setParts_id(this.getParts_id());
		watertight.setItem_name(this.getItem_name());
		watertight.setRg_feature(this.getRg_feature());
		watertight.setAdd_content(this.getAdd_content());
		watertight.setDisease_image(this.getDisease_image());
		watertight.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_watertight dis = disease_watertightBiz.getDisease_watertightById(this.getId());
			if (dis != null) { // 修改
				watertight.setId(dis.getId());
				watertight.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_watertight", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_watertightBiz.updateDisease_watertight(watertight);				
				response.sendRedirect("disease!viewDisease?table_name=disease_watertight&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			watertight.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_watertightBiz.addDisease_watertight(watertight);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_watertight&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public String changeLighting() throws IOException {
		Disease_lighting lighting = new Disease_lighting();
		lighting.setBg_id(this.getBg_id());
		lighting.setParts_id(this.getParts_id());
		lighting.setItem_name(this.getItem_name());
		lighting.setRg_feature(this.getRg_feature());
		lighting.setAdd_content(this.getAdd_content());
		lighting.setDisease_image(this.getDisease_image());
		lighting.setImage_type(this.getImage_type());

		String bg_name = base1Biz.getBase1ByBridgeCode(this.getBg_id()).getBridge_name();		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if (this.getId() != null) {
			Disease_watertight dis = disease_watertightBiz.getDisease_watertightById(this.getId());
			if (dis != null) { // 修改
				lighting.setId(dis.getId());
				lighting.setFlag(dis.getFlag());
				
				// 如果修改了病害类型，重新打分
				if (!dis.getRg_feature().equals(this.getRg_feature())) { // 分病害和其他病害两种情况

					Evaluation eval = evaluationBiz.getEvaluationExactly("disease_lighting", dis.getBg_id(), dis.getId().toString());
					if (eval != null) {						
						Evaluation evaluation = new Evaluation();
						evaluation.setId(eval.getId());
						evaluation.setTable_name(eval.getTable_name());
						evaluation.setBg_id(eval.getBg_id());
						evaluation.setParts_id(eval.getParts_id());
						evaluation.setDis_id(eval.getDis_id());
						evaluation.setEvaluation("");
						evaluation.setScore("");
						evaluationBiz.updateEvaluation(evaluation);
					}
				}
				
				disease_lightingBiz.updateDisease_lighting(lighting);				
				response.sendRedirect("disease!viewDisease?table_name=disease_lighting&id=" + this.getId() + "&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
			}
		}
		else { // 添加
			lighting.setFlag("0");
			
			if (this.getItem_name().length() != 0 && this.getParts_id().length() != 0) {
				disease_lightingBiz.addDisease_lighting(lighting);				
			}
			response.sendRedirect("disease!getBaseDiseaseList?table_name=disease_lighting&bg_id=" + this.getBg_id() + "&bg_name=" + URLEncoder.encode(bg_name, "UTF-8"));
		}		
		return null;
	}
	
	// 显示病害打分页面
	@SuppressWarnings("unchecked")
	public String showEvaluation() {
		request.put("table_name", this.getTable_name());
		request.put("bg_id", this.getBg_id());
		request.put("bg_name", this.getBg_name());
		request.put("item_name", this.getItem_name());
		
		List<Map<String, String>> evallist = evaluationBiz.getEvaluationByTwo(this.getTable_name(), this.getBg_id());
		
		String evalstr = new String();
		if (evallist.size() != 0) {
			// 将标度从list转化为字符串
			for (int i = 0; i < evallist.size(); i++) {
				evalstr += evallist.get(i).get("dis_id") + ":" + evallist.get(i).get("evaluation") + "-" + evallist.get(i).get("score") + ",";
			}
			evalstr = evalstr.substring(0, evalstr.length()-1);
		}		

		List<QueryObject> qo = new ArrayList<QueryObject>();
		
		if (this.getBg_id() != null && !this.getBg_id().trim().equals("")) {
			qo.add(new QueryObject("bg_id", this.getBg_id().trim(), null));
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
		
		Map<String, String> eval_index = new OtherFunction().EVALUATION.get(this.getTable_name()); // 获取标度索引表
		for (int i = 0; i < dataList.size(); i++) {
			// 显示病害图片
	        if (dataList.get(i).get("disease_image") != "") {
	        	String imgFilePath = getSavePath() + "\\" + Math.random()*1000 + "." + dataList.get(i).get("image_type").toString().split("/")[1];
				if (generateImage(dataList.get(i).get("disease_image").toString(), imgFilePath)) {
					dataList.get(i).put("img_name", new File(imgFilePath).getName());
				}
	        }
	        
	        // 配置索引标度
	        if (eval_index.get(dataList.get(i).get("rg_feature")) != null) { // 如果在病害类型中匹配
				dataList.get(i).put("eval_peak", eval_index.get(dataList.get(i).get("rg_feature")));
			}
			else if (dataList.get(i).get("rg_feature").equals("其他病害")
					&& eval_index.get(dataList.get(i).get("sp_otherDisease")) != null) { // 如果在其他病害中匹配
				dataList.get(i).put("eval_peak", eval_index.get(dataList.get(i).get("sp_otherDisease")));
			}
			else { // 不匹配
				dataList.get(i).put("eval_peak", "5");
			}
	    }
		
		request.put("datalist", dataList);
		request.put("evalstr", evalstr);
		request.put("count", count);
		
		return "evaluation_table_data";
	}
	
	public String saveEvaluation() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String table_name = request.getParameter("table_name");
		String bg_id = request.getParameter("bg_id");
		String evaluation_val = request.getParameter("evaluation_val");
		String[] evals = evaluation_val.split(",");
		
		for (int i = 0; i < evals.length; i++) {
			Evaluation evaluation = new Evaluation();
			evaluation.setTable_name(table_name);
			evaluation.setBg_id(bg_id);
			evaluation.setDis_id(evals[i].split(":")[0]);
			evaluation.setEvaluation(evals[i].split(":")[1].split("-")[0]);
			evaluation.setScore(evals[i].split(":")[1].split("-")[1]);
			
			if (evaluationBiz.getEvaluationExactly(table_name, bg_id, evals[i].split(":")[0]) != null) { // 判断是否有对应的病害id，有就修改
				Evaluation eval = evaluationBiz.getEvaluationExactly(table_name, bg_id, evals[i].split(":")[0]);
				evaluation.setId(eval.getId());
				evaluationBiz.updateEvaluation(evaluation);
			}
			else { // 没有就添加
				evaluationBiz.addEvaluation(evaluation);
			}
		}		
		return null;		
	}
	
	public String getAllMember () {
		System.out.println("aaaaaaaaaaaaaaaaaa");
		Parts1 parts1 = parts1Biz.getParts1ByBridgeCode(this.getBg_id());
		Parts2 parts2 = parts2Biz.getParts2ByBridgeCode(this.getBg_id());
		Pier_detail pier_detail = pier_detailBiz.getPier_detailByBridgeCode(this.getBg_id());
		Load_detail load_detail = load_detailBiz.getLoad_detailByBridgeCode(this.getBg_id());
		General_detail general_detail = general_detailBiz.getGeneral_detailByBridgeCode(this.getBg_id());
		Support_detail support_detail = support_detailBiz.getSupport_detailByBridgeCode(this.getBg_id());
		System.out.println("bbbbbbbbbbbbbbbb");
		
		// 上部
//		int load_num = 0;
//		if (load_detail != null) {
//			load_num = load_detail.getLoad_nums().split(";").length-1; // 上部承重构件个数
//		}
		
		int load_num = load_detail.getLoad_nums().split(";").length-1; // 上部承重构件个数
		int general_num = general_detail.getGeneral_nums().split(";").length-1; // 上部一般构件个数
		int support_num = support_detail.getSupport_nums().split(";").length-1; // 支座个数
		
		// 下部
		int wall_num = nativeOnenum(parts1.getWing_wall()); // 翼墙、耳墙个数
		int slope_num = nativeOnenum(parts1.getConical_slope()) + Integer.parseInt(parts1.getProtection_slope()); // 锥坡、护坡个数
		int pier_num = pier_detail.getPier_nums().split(";").length-1 + pier_detail.getBent_cap_nums().length()-1 
				+ pier_detail.getTie_beam_nums().length()-1; // 桥墩、盖梁、系梁个数
		int abutment_num = Integer.parseInt(parts1.getAbutment_num()); // 桥台个数		
		int pa_num = Integer.parseInt(parts1.getPa_num()); // 墩台基础个数
		int bed_num = Integer.parseInt(parts1.getBed_num()); // 河床个数
		int regstruc_num = Integer.parseInt(parts1.getReg_structure());	// 调治构造物个数	
		
		// 桥面系
		int deck_num = Integer.parseInt(parts2.getDeck_num()); // 桥面铺装个数
		int joint_num = Integer.parseInt(parts2.getJoint_num()); // 伸缩缝装置个数
		int sidewalk_num = nativeOnenum(parts2.getSidewalk()); // 人行横道个数
		int fence_num = nativeOnenum(parts2.getGuardrail()); // 栏杆、护栏个数
		int watertight_num = Integer.parseInt(parts2.getDrainage_system()); // 防排水系统个数
		int lighting_num = Integer.parseInt(parts2.getIlluminated_sign()); // 照明、标志个数
		
		// 上部结构
		List<Map<String, Object>> result_girder = disease_girderBiz.getAllDisease_girderByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_wetjoint = disease_wetjointBiz.getAllDisease_wetjointByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_support = disease_supportBiz.getAllDisease_supportByBridgeCode(this.getBg_id());
		
		// 下部结构
		List<Map<String, Object>> result_pier = disease_pierBiz.getAllDisease_pierByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_bentcap = disease_bentcapBiz.getAllDisease_bentcapByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_tiebeam = disease_tiebeamBiz.getAllDisease_tiebeamByBridgeCode(this.getBg_id());

		List<Map<String, Object>> result_atbody = disease_atbodyBiz.getAllDisease_atbodyByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_atcapping = disease_atcappingBiz.getAllDisease_atcappingByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_pa = disease_paBiz.getAllDisease_paByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_bed = disease_bedBiz.getAllDisease_bedByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_regstruc = disease_regstrucBiz.getAllDisease_regstrucByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_wingwall = disease_wingwallBiz.getAllDisease_wingwallByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_conslope = disease_conslopeBiz.getAllDisease_conslopeByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_proslope = disease_proslopeBiz.getAllDisease_proslopeByBridgeCode(this.getBg_id());
		
		// 桥面系
		List<Map<String, Object>> result_deck = disease_deckBiz.getAllDisease_deckByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_joint = disease_jointBiz.getAllDisease_jointByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_sidewalk = disease_sidewalkBiz.getAllDisease_sidewalkByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_fence = disease_fenceBiz.getAllDisease_fenceByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_watertight = disease_watertightBiz.getAllDisease_watertightByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_lighting = disease_lightingBiz.getAllDisease_lightingByBridgeCode(this.getBg_id());
		
		System.out.println("ccccccccccccccc");
		//计算MCI
		double[] mci_girder = getMCI(result_girder, "disease_girder");
		System.out.println("mci_girder:" + Arrays.toString(mci_girder)); // 输出数组
		double[] mci_wetjoint = getMCI(result_wetjoint, "disease_wetjoint");
		System.out.println("mci_wetjoint:" + Arrays.toString(mci_wetjoint)); // 输出数组
		double[] mci_support = getMCI(result_support, "disease_support");
		System.out.println("mci_support:" + Arrays.toString(mci_support)); // 输出数组
		
		
		double[] mci_pier = getMCI(result_pier, "disease_pier");
		double[] mci_bentcap = getMCI(result_bentcap, "disease_bentcap");
		double[] mci_tiebeam = getMCI(result_tiebeam, "disease_tiebeam");
		
		double[] mci_new_pier = new double[mci_pier.length + mci_bentcap.length + mci_tiebeam.length];		  
		System.arraycopy(mci_pier, 0, mci_new_pier, 0, mci_pier.length);		  
		System.arraycopy(mci_bentcap, 0, mci_new_pier, mci_pier.length, mci_bentcap.length);
		System.arraycopy(mci_tiebeam, 0, mci_new_pier, mci_pier.length + mci_bentcap.length, mci_tiebeam.length);
        System.out.println("mci_pier:" + Arrays.toString(mci_new_pier));//输出数组
		
		double[] mci_atbody = getMCI(result_atbody, "disease_atbody");
		double[] mci_atcapping = getMCI(result_atcapping, "disease_atcapping");
		
		double[] mci_at = new double[mci_atbody.length + mci_atcapping.length];		  
		System.arraycopy(mci_atbody, 0, mci_at, 0, mci_atbody.length);		  
		System.arraycopy(mci_atcapping, 0, mci_at, mci_atbody.length, mci_atcapping.length);
        System.out.println("mci_at:" + Arrays.toString(mci_at));//输出数组
		
		double[] mci_pa = getMCI(result_pa, "disease_pa");
		System.out.println("mci_pa:" + Arrays.toString(mci_pa));//输出数组
		double[] mci_bed = getMCI(result_bed, "disease_bed");
		System.out.println("mci_bed:" + Arrays.toString(mci_bed));//输出数组
		double[] mci_regstruc = getMCI(result_regstruc, "disease_regstruc");
		System.out.println("mci_regstruc:" + Arrays.toString(mci_regstruc));//输出数组
		double[] mci_wingwall = getMCI(result_wingwall, "disease_wingwall");
		System.out.println("mci_wingwall:" + Arrays.toString(mci_wingwall));//输出数组
		double[] mci_conslope = getMCI(result_conslope, "disease_conslope");
		double[] mci_proslope = getMCI(result_proslope, "disease_proslope");
		
		double[] mci_slope = new double[mci_conslope.length + mci_proslope.length];		  
		System.arraycopy(mci_conslope, 0, mci_slope, 0, mci_conslope.length);		  
		System.arraycopy(mci_conslope, 0, mci_slope, mci_conslope.length, mci_proslope.length);
        System.out.println("mci_slope:" + Arrays.toString(mci_slope));//输出数组
		
		double[] mci_deck = getMCI(result_deck, "disease_deck");
		System.out.println("mci_deck:" + Arrays.toString(mci_deck));//输出数组
		double[] mci_joint = getMCI(result_joint, "disease_joint");
		System.out.println("mci_joint:" + Arrays.toString(mci_joint));//输出数组
		double[] mci_sidewalk = getMCI(result_sidewalk, "disease_sidewalk");
		System.out.println("mci_sidewalk:" + Arrays.toString(mci_sidewalk));//输出数组
		double[] mci_fence = getMCI(result_fence, "disease_fence");
		System.out.println("mci_fence:" + Arrays.toString(mci_fence));//输出数组
		double[] mci_watertight = getMCI(result_watertight, "disease_watertight");
		System.out.println("mci_watertight:" + Arrays.toString(mci_watertight));//输出数组
		double[] mci_lighting = getMCI(result_lighting, "disease_lighting");
		System.out.println("mci_lighting:" + Arrays.toString(mci_lighting));//输出数组
		
		//计算CCI
		double cci_girder = getCCI(mci_girder, load_num, 1);
		double cci_wetjoint = getCCI(mci_wetjoint, general_num, 0);
		double cci_support = getCCI(mci_support, support_num, 1);
		
		double cci_pier = getCCI(mci_new_pier, pier_num, 1);
		double cci_at = getCCI(mci_at, abutment_num, 1);
		double cci_pa = getCCI(mci_pa, pa_num, 1);
		double cci_bed = getCCI(mci_bed, bed_num, 0);		
		double cci_regstruc = getCCI(mci_regstruc, regstruc_num, 0);
		double cci_wingwall = getCCI(mci_wingwall, wall_num, 0);
		double cci_slope = getCCI(mci_slope, slope_num, 0);
		
		double cci_deck = getCCI(mci_deck, deck_num, 0);
		double cci_joint = getCCI(mci_joint, joint_num, 0);
		double cci_sidewalk = getCCI(mci_sidewalk, sidewalk_num, 0);
		double cci_fence = getCCI(mci_fence, fence_num, 0);
		double cci_watertight = getCCI(mci_watertight, watertight_num, 0);
		double cci_lighting = getCCI(mci_lighting, lighting_num, 0);
		
		double[] cci_up_arr = {cci_girder, cci_wetjoint, cci_support};
		System.out.println("cci_up_arr:" + Arrays.toString(cci_up_arr));//输出数组
		double[] cci_down_arr = {cci_pier, cci_at, cci_pa, cci_bed, cci_regstruc, cci_wingwall, cci_slope};
		System.out.println("cci_down_arr:" + Arrays.toString(cci_down_arr));//输出数组
		double[] cci_deck_arr = {cci_deck, cci_joint, cci_sidewalk, cci_fence, cci_watertight, cci_lighting};
		System.out.println("cci_deck_arr:" + Arrays.toString(cci_deck_arr));//输出数组
		
		int[] num_up_arr = {load_num, general_num, support_num};
		int[] num_down_arr = {pier_num, abutment_num, pa_num, bed_num, regstruc_num, wall_num, slope_num};
		int[] num_deck_arr = {deck_num, joint_num, sidewalk_num, fence_num, watertight_num, lighting_num};
		
		//计算CI
		double ci_up = getCI(cci_up_arr, OtherFunction.UP_WEIGHT, num_up_arr);
		double ci_down = getCI(cci_down_arr, OtherFunction.DOWN_WEIGHT, num_down_arr);
		double ci_deck = getCI(cci_deck_arr, OtherFunction.DECK_WEIGHT, num_deck_arr);
		
		double[] ci_arr = {ci_up, ci_down, ci_deck};
		System.out.println("ci_arr:" + Arrays.toString(ci_arr));//输出数组
		
		//计算DR
		double dr = new OtherFunction().calDR(ci_arr);
		
		System.out.println("dr:" + dr);
		
		request.put("mci_girder", Arrays.toString(mci_girder));
		request.put("mci_wetjoint", Arrays.toString(mci_wetjoint));
		request.put("mci_support", Arrays.toString(mci_support));
		
		request.put("mci_pier", Arrays.toString(mci_new_pier));
		request.put("mci_at", Arrays.toString(mci_at));
		request.put("mci_pa", Arrays.toString(mci_pa));
		request.put("mci_bed", Arrays.toString(mci_bed));
		request.put("mci_regstruc", Arrays.toString(mci_regstruc));
		request.put("mci_wingwall", Arrays.toString(mci_wingwall));
		request.put("mci_slope", Arrays.toString(mci_slope));
		
		request.put("mci_deck", Arrays.toString(mci_deck));
		request.put("mci_joint", Arrays.toString(mci_joint));
		request.put("mci_sidewalk", Arrays.toString(mci_sidewalk));
		request.put("mci_fence", Arrays.toString(mci_fence));
		request.put("mci_watertight", Arrays.toString(mci_watertight));
		request.put("mci_lighting", Arrays.toString(mci_lighting));
		
		request.put("cci_up_arr", Arrays.toString(cci_up_arr));
		request.put("cci_down_arr", Arrays.toString(cci_down_arr));
		request.put("cci_deck_arr", Arrays.toString(cci_deck_arr));
		
		request.put("ci_arr", Arrays.toString(ci_arr));
		request.put("dr", dr);
		
		return "evaluation_result";
	}
	
	// 桥梁构件技术状况评分
	public double[] getMCI(List<Map<String, Object>> datalist, String table_name) {
		if (datalist == null) {
			System.out.println("kkkkkkkkkkkkkk");
			double[] mci_arr = {};
			return mci_arr;
		}
		Map<String, List<String>> evalmap = new HashMap<>();
		
		for (int i = 0; i < datalist.size(); i++) {
//			String evalname = datalist.get(i).get("parts_id") + "#" + datalist.get(i).get("item_name"); // 病害打分构件号
			String evalname = datalist.get(i).get("parts_id").toString(); // 病害打分构件号
			Evaluation eval = evaluationBiz.getEvaluationExactly(table_name, 
					datalist.get(i).get("bg_id").toString(), datalist.get(i).get("id").toString());  // 获取精确evaluation
			
			if (evalmap.get(evalname) == null) {
				List<String> scorelist = new ArrayList<>();
				if (eval != null) {
					scorelist.add(eval.getScore());
					evalmap.put(evalname, scorelist);
				}
			}
			else {
				evalmap.get(evalname).add(eval.getScore());
			}
		}
		Map<String, Double> mci_result = new OtherFunction().calMciMap(evalmap); // 计算MCI
		
		Iterator<Entry<String, Double>> entries = mci_result.entrySet().iterator();
		int i = 0;
		double[] mci_arr = new double[mci_result.size()];
		while (entries.hasNext()) {  
			  
		    Entry<String, Double> entry = entries.next();
		    mci_arr[i] = entry.getValue();
		    i++;
		}
		
		return mci_arr;		
	}
	
	// 桥梁部件技术状况评分
	public double getCCI(double[] mci_arr, int num, int major_flag) {
		double cci_result = new OtherFunction().calCCI(mci_arr, num, major_flag);
		
		return cci_result;		
	}
	
	// 桥梁结构技术状况评分
	public double getCI(double[] cci_arr, double[] weight, int[] num) {
		double[] new_weight = new OtherFunction().calWeight(weight, num);
		
		double ci_result = new OtherFunction().calCI(cci_arr, new_weight);
		
		return ci_result;		
	}
	
	// 生成病害报告
	public void createReport() throws IOException {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		Base1 base1 = base1Biz.getBase1ByBridgeCode(this.getBg_id());
		Base2 base2 = base2Biz.getBase2ByBridgeCode(this.getBg_id());
		Base3 base3 = base3Biz.getBase3ByBridgeCode(this.getBg_id());
		Structure structure = structureBiz.getStructureByBridgeCode(this.getBg_id());
		Parts1 parts1 = parts1Biz.getParts1ByBridgeCode(this.getBg_id());
		Parts2 parts2 = parts2Biz.getParts2ByBridgeCode(this.getBg_id());
		Pier_detail pier_detail = pier_detailBiz.getPier_detailByBridgeCode(this.getBg_id());
		Load_detail load_detail = load_detailBiz.getLoad_detailByBridgeCode(this.getBg_id());
		General_detail general_detail = general_detailBiz.getGeneral_detailByBridgeCode(this.getBg_id());
		Support_detail support_detail = support_detailBiz.getSupport_detailByBridgeCode(this.getBg_id());
		
		// 桥梁照片
		dataMap.put("bridge_img1", base1.getBridge_image1());
		dataMap.put("bridge_img2", base1.getBridge_image2());
		
		// A.行政识别数据
		dataMap.put("bridge_name", base1.getBridge_name());
		dataMap.put("path_num", base1.getPath_num());
		dataMap.put("path_name", base1.getPath_name());
		dataMap.put("rode_grade", base1.getRode_grade().split("]")[1]);
		dataMap.put("center_stake", base1.getCenter_stake());
		dataMap.put("bridge_classify", base2.getBridge_classify().split("]")[1]);
		dataMap.put("deck_type", base3.getDeck_type().split("]")[1]);
		dataMap.put("custody_unit", base1.getCustody_unit());
		dataMap.put("building_time", structure.getBuilding_time());
		
		// B.结构技术数据
		dataMap.put("total_len", structure.getTotal_len());
		dataMap.put("full_wide", structure.getFull_wide());
		dataMap.put("bridge_high", structure.getBridge_high());
		dataMap.put("high_limit", structure.getHigh_limit());
		
		dataMap.put("bridge_type", base2.getBridge_type().split("]")[1]);
		dataMap.put("abutment_type", base3.getAbutment_type().split("]")[1]);
		dataMap.put("pier_type", base3.getPier_type().split("]")[1]);
		dataMap.put("abutment_material", base3.getAbutment_material().split("]")[1]);
		dataMap.put("pier_material", base3.getPier_material().split("]")[1]);
		dataMap.put("material_code", base2.getMaterial_code().split("]")[1]);
		dataMap.put("pier_abutment_base", base3.getPier_abutment_base().split("]")[1]);
		dataMap.put("pier_abutment_material", base3.getPier_abutment_material().split("]")[1]); //?
		
		dataMap.put("joint_type", base3.getJoint_type().split("]")[1]);
		dataMap.put("support_type", base2.getSupport_type().split("]")[1]);
		
		// 桥梁构件信息表
		dataMap.put("load_num", load_detail.getLoad_nums().split(";").length-1);
		dataMap.put("general_num", general_detail.getGeneral_nums().split(";").length-1);
		dataMap.put("support_num", support_detail.getSupport_nums().split(";").length-1);
		dataMap.put("wing_wall", nativeOnenum(parts1.getWing_wall()));
		dataMap.put("conical_slope", nativeOnenum(parts1.getConical_slope()));
		dataMap.put("protection_slope", parts1.getProtection_slope());
		dataMap.put("pier_num", pier_detail.getPier_nums().split(";").length-1);
		dataMap.put("abutment_num", parts1.getAbutment_num());
		dataMap.put("pa_num", parts1.getPa_num());
		dataMap.put("bed_num", parts1.getBed_num());
		dataMap.put("reg_structure", parts1.getReg_structure());		
		dataMap.put("deck_num", parts2.getDeck_num());
		dataMap.put("joint_num", parts2.getJoint_num());
		dataMap.put("sidewalk", nativeOnenum(parts2.getSidewalk()));
		dataMap.put("guardrail", nativeOnenum(parts2.getGuardrail()));
		dataMap.put("drainage_system", parts2.getDrainage_system());
		dataMap.put("illuminated_sign", parts2.getIlluminated_sign());
		
		// 病害部分
		// 桥面系
		List<Map<String, Object>> result_deck = disease_deckBiz.getAllDisease_deckByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_joint = disease_jointBiz.getAllDisease_jointByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_sidewalk = disease_sidewalkBiz.getAllDisease_sidewalkByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_fence = disease_fenceBiz.getAllDisease_fenceByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_watertight = disease_watertightBiz.getAllDisease_watertightByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_lighting = disease_lightingBiz.getAllDisease_lightingByBridgeCode(this.getBg_id());
		
		// 下部结构
		List<Map<String, Object>> result_pier = disease_pierBiz.getAllDisease_pierByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_bentcap = disease_bentcapBiz.getAllDisease_bentcapByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_tiebeam = disease_tiebeamBiz.getAllDisease_tiebeamByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_atbody = disease_atbodyBiz.getAllDisease_atbodyByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_atcapping = disease_atcappingBiz.getAllDisease_atcappingByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_pa = disease_paBiz.getAllDisease_paByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_bed = disease_bedBiz.getAllDisease_bedByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_regstruc = disease_regstrucBiz.getAllDisease_regstrucByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_wingwall = disease_wingwallBiz.getAllDisease_wingwallByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_conslope = disease_conslopeBiz.getAllDisease_conslopeByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_proslope = disease_proslopeBiz.getAllDisease_proslopeByBridgeCode(this.getBg_id());
		
		// 上部结构
		List<Map<String, Object>> result_girder = disease_girderBiz.getAllDisease_girderByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_wetjoint = disease_wetjointBiz.getAllDisease_wetjointByBridgeCode(this.getBg_id());
		List<Map<String, Object>> result_support = disease_supportBiz.getAllDisease_supportByBridgeCode(this.getBg_id());
		
		List<List<Map<String, Object>>> list_up = new ArrayList<>(); // 病害列表
		List<List<Map<String, Object>>> img_up = new ArrayList<>(); // 病害图片
		

		String load_nums = load_detail.getLoad_nums();
		String general_nums = general_detail.getGeneral_nums();
		String support_nums = support_detail.getSupport_nums();
		
		// 确定跨号
		int stride = Integer.parseInt(load_nums.split("; ")[load_nums.split("; ").length-2].split("-")[0]);
		int stride_general = Integer.parseInt(general_nums.split("; ")[general_nums.split("; ").length-2].split("-")[0]);
		int stride_support = Integer.parseInt(support_nums.split("; ")[support_nums.split("; ").length-2].split("-")[0]);
		
		if (stride < stride_general) {
			stride = stride_general;
		}
		if (stride < stride_support) {
			stride = stride_support;
		}
		
		result_girder.addAll(result_wetjoint);
		result_girder.addAll(result_support);
		
		for (int i = 0; i < stride; i++) {
			List<Map<String, Object>> up = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> img = new ArrayList<Map<String, Object>>();
			for (int j = 0; j < result_girder.size(); j++) {
				
		        if (Integer.parseInt(result_girder.get(j).get("parts_id").toString().split("-")[0]) == i + 1) {
		        	
		        	String girder_str = result_girder.get(j).get("item_name").toString();
					if ("主梁".equals(girder_str) || "空心板".equals(girder_str) || "主拱圈".equals(girder_str) 
							|| "钢、桁架拱片".equals(girder_str) || "上部承重构件".equals(girder_str)) {
						
						if ("裂缝".equals(result_girder.get(j).get("rg_feature").toString())) {
							String girder_content = result_girder.get(j).get("rg_location") + "纵向距本跨梁端" 
									+ result_girder.get(j).get("start") + "米到" 
									+ result_girder.get(j).get("end") + "米" 
									+ result_girder.get(j).get("rg_fissure");
							
							if ("网裂缝".equals(result_girder.get(j).get("rg_fissure").toString())) {
								girder_content += ",面积" 
										+ result_girder.get(j).get("area") + ",";
							}
							else {
								girder_content += ",长度" 
										+ result_girder.get(j).get("length") + "米,宽度" 
										+ result_girder.get(j).get("width") + "米,";
							}
							
							if ("左翼板".equals(result_girder.get(j).get("rg_location").toString()) 
									|| "右翼板".equals(result_girder.get(j).get("rg_location").toString())) {
								girder_content += "距下缘" 
										+ result_girder.get(j).get("side_start") + "米到" 
										+ result_girder.get(j).get("side_end") + "米开裂,长度"
										+ result_girder.get(j).get("side_length") + "米,宽度" 
										+ result_girder.get(j).get("side_width") + "米,";
							}
							
							girder_content += result_girder.get(j).get("add_content");
							result_girder.get(j).put("add_content", girder_content);
						}
						else if ("其他病害".equals(result_girder.get(j).get("rg_feature").toString())) {
							String girder_content = result_girder.get(j).get("rg_location") + "纵向距本跨梁端" 
									+ result_girder.get(j).get("start") + "米到" 
									+ result_girder.get(j).get("end") + "米"
									+ result_girder.get(j).get("sp_otherDisease") + ",面积" 
									+ result_girder.get(j).get("area") + "," 
									+ result_girder.get(j).get("add_content");
							result_girder.get(j).put("add_content", girder_content);
							result_girder.get(j).put("rg_feature", result_girder.get(j).get("sp_otherDisease"));
						}
						else {
							String girder_content = result_girder.get(j).get("rg_location") + "纵向距本跨梁端" 
									+ result_girder.get(j).get("start") + "米到" 
									+ result_girder.get(j).get("end") + "米"
									+ result_girder.get(j).get("rg_feature") + ",面积" 
									+ result_girder.get(j).get("area") + "," 
									+ result_girder.get(j).get("add_content");
							result_girder.get(j).put("add_content", girder_content);
						}
					}
					else if ("湿接缝".equals(girder_str) || "横隔板".equals(girder_str) || "铰缝".equals(girder_str) 
							|| "拱上结构".equals(girder_str) || "横向联结系".equals(girder_str) || "上部一般构件".equals(girder_str)) {
						
						if ("裂缝".equals(result_girder.get(j).get("rg_feature").toString())) {
							String girder_content = "纵向距本跨梁端";
							
							if ("网裂缝".equals(result_girder.get(j).get("rg_fissure").toString())) {
								girder_content += result_girder.get(j).get("l1_start") + "米到" 
										+ result_girder.get(j).get("l1_end") + "米"
										+ result_girder.get(j).get("rg_fissure") + ",面积"
										+ result_girder.get(j).get("l1_area") + ",";
							}
							else {
								girder_content += result_girder.get(j).get("l2_start") + "米"
										+ result_girder.get(j).get("rg_fissure") +",长度" 
										+ result_girder.get(j).get("l2_length") + "米,宽度" 
										+ result_girder.get(j).get("l2_width") + "米,";
							}
							
							girder_content += result_girder.get(j).get("add_content");
							result_girder.get(j).put("add_content", girder_content);
						}
						else if ("其他病害".equals(result_girder.get(j).get("rg_feature").toString())) {
							String girder_content = result_girder.get(j).get("sp_otherDisease") + ","
									+ result_girder.get(j).get("add_content");
							result_girder.get(j).put("add_content", girder_content);
							result_girder.get(j).put("rg_feature", result_girder.get(j).get("sp_otherDisease"));
						}
						else {
							String girder_content = "纵向距本跨梁端" 
									+ result_girder.get(j).get("l1_start") + "米到" 
									+ result_girder.get(j).get("l1_end") + "米"
									+ result_girder.get(j).get("rg_feature") + ",面积" 
									+ result_girder.get(j).get("l1_area") + "," 
									+ result_girder.get(j).get("add_content");
							result_girder.get(j).put("add_content", girder_content);
						}						
					}
		        	
		        	up.add(result_girder.get(j));
		        	
		        	if (result_girder.get(j).get("disease_image") != "") {
		        		img.add(result_girder.get(j));
			        }
		        }		        
		    }
			list_up.add(up);
			img_up.add(img);
		}
		
		List<Map<String, Object>> list_deck = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list_down = new ArrayList<Map<String, Object>>();
		
		// 桥面系列表
		list_deck = result_deck;
		list_deck.addAll(result_joint);
		list_deck.addAll(result_sidewalk);
		list_deck.addAll(result_fence);
		list_deck.addAll(result_watertight);
		list_deck.addAll(result_lighting);
		
		// 下部列表
		list_down = result_pier;
		list_down.addAll(result_bentcap);
		list_down.addAll(result_tiebeam);
		list_down.addAll(result_atbody);
		list_down.addAll(result_atcapping);
		list_down.addAll(result_pa);
		list_down.addAll(result_bed);
		list_down.addAll(result_regstruc);
		list_down.addAll(result_wingwall);
		list_down.addAll(result_conslope);
		list_down.addAll(result_proslope);
		
		for (int i = 0; i < list_down.size(); i++) {
			String down_str = list_down.get(i).get("item_name").toString();
			if ("桥墩".equals(down_str)) {
				if ("裂缝".equals(list_down.get(i).get("rg_feature").toString())) {
					String down_content = "纵向距本跨梁端";
					
					if ("网裂缝".equals(list_down.get(i).get("rg_fissure").toString())) {
						down_content += list_down.get(i).get("l1_start") + "米到" 
								+ list_down.get(i).get("l1_end") + "米"
								+ list_down.get(i).get("rg_fissure") + ",面积"
								+ list_down.get(i).get("l1_area") + ",";
					}
					else {
						down_content += list_down.get(i).get("l2_start") + "米"
								+ list_down.get(i).get("rg_fissure") +",长度" 
								+ list_down.get(i).get("l2_length") + "米,宽度" 
								+ list_down.get(i).get("l2_width") + "米,";
					}
					
					down_content += list_down.get(i).get("add_content");
					list_down.get(i).put("add_content", down_content);					
				}
				else if ("其他病害".equals(list_down.get(i).get("rg_feature").toString())) {
					String down_content = list_down.get(i).get("sp_otherDisease") + ","
							+ list_down.get(i).get("add_content");
					list_down.get(i).put("add_content", down_content);
					list_down.get(i).put("rg_feature", list_down.get(i).get("sp_otherDisease"));
				}
				else {
					String down_content = "纵向距本跨梁端" 
							+ list_down.get(i).get("l1_start") + "米到" 
							+ list_down.get(i).get("l1_end") + "米"
							+ list_down.get(i).get("rg_feature") + ",面积" 
							+ list_down.get(i).get("l1_area") + "," 
							+ list_down.get(i).get("add_content");
					list_down.get(i).put("add_content", down_content);
				}
			}
			else if ("桥台身".equals(down_str) && "其他病害".equals(list_down.get(i).get("rg_feature").toString())) {
				String down_content = list_down.get(i).get("sp_otherDisease") + ","
						+ list_down.get(i).get("add_content");
				list_down.get(i).put("add_content", down_content);
				list_down.get(i).put("rg_feature", list_down.get(i).get("sp_otherDisease"));
			}
		}
		
		List<Map<String, Object>> img_deck = new ArrayList<Map<String, Object>>();		
		List<Map<String, Object>> img_down = new ArrayList<Map<String, Object>>();
		
		// 桥面系图片
		for (int i = 0; i < list_deck.size(); i++) {
	        if (list_deck.get(i).get("disease_image") != "") {
	        	img_deck.add(list_deck.get(i));
	        }
	    }
		
		// 下部图片
		for (int i = 0; i < list_down.size(); i++) {
	        if (list_down.get(i).get("disease_image") != "") {
	        	img_down.add(list_down.get(i));
	        }
	    }
		
		dataMap.put("list_deck", list_deck);
		dataMap.put("list_down", list_down);
		dataMap.put("list_up", list_up);
		
		dataMap.put("img_deck", img_deck);
		dataMap.put("img_down", img_down);
		dataMap.put("img_up", img_up);
		
		WordCreate test = new WordCreate();
		test.createWord(dataMap);
	}
	
	public void validate(){
		if(session.get("userName")==null){
			session.clear();
			this.addActionError("error");
		}
	}
	
	int nativeOnenum(String str) {   
	    int count = 0;
	    for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == '1') {
				count++;
			}
        }
	    return count;   
	}
	
	// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	public String getImageStr(String imgFilePath) {
		 InputStream in = null;
		 byte[] data = null;
		 try {
			 in = new FileInputStream(imgFilePath);
			 data = new byte[in.available()];
			 in.read(data);
			 in.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 BASE64Encoder encoder = new BASE64Encoder();
		 return encoder.encode(data);
	 }
	
	// 对字节数组字符串进行Base64解码并生成图片
	public static boolean generateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

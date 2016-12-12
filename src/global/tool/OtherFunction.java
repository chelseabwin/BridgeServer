package global.tool;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OtherFunction {
	
	public final static Map<String, String> GIRDER_WETJOINT_EVAL = new HashMap<String, String>() { // 上部
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("蜂窝、麻面", "3");
			put("剥落、掉角", "4");
			put("空洞、孔洞", "4");
			put("混凝土保护层厚度", "4");	
			put("钢筋锈蚀", "5");
			put("混凝土碳化", "4");
			put("混凝土强度", "5");
			put("跨中挠度", "5");
			put("结构变位", "5");
			put("预应力构件损伤", "5");
			put("裂缝", "5");
		}		
	};
	
	public final static Map<String, String> SUPPORT_EVAL = new HashMap<String, String>() { // 支座
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("老化、开裂", "5");
			put("缺陷", "4");
			put("串动、脱空或剪切超限", "5");
			put("组件损坏", "5");	
			put("聚四氟乙烯滑板磨损", "4");
			put("位移、转角超限", "4");
		}		
	};
	
	public final static Map<String, String> PIER_EVAL = new HashMap<String, String>() { // 桥墩
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("蜂窝、麻面", "3");
			put("剥落、露筋", "4");
			put("空洞、孔洞", "4");
			put("钢筋锈蚀", "5");	
			put("混凝土碳化、腐蚀", "4");
			put("磨损", "4");
			put("圬工砌体缺陷", "4");
			put("位移", "5");
			put("裂缝", "5");
		}		
	};
	
	public final static Map<String, String> BENTCAP_TIEBEAM_EVAL = new HashMap<String, String>() { // 盖梁和系梁
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("蜂窝、麻面", "3");
			put("剥落、露筋", "4");
			put("空洞、孔洞", "4");
			put("钢筋锈蚀", "5");	
			put("混凝土碳化、腐蚀", "4");
			put("裂缝", "4");
		}		
	};
	
	public final static Map<String, String> ATBODY_EVAL = new HashMap<String, String>() { // 桥台身
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("剥落", "4");
			put("空洞、孔洞", "4");
			put("磨损", "3");
			put("混凝土碳化、腐蚀", "3");
			put("圬工砌体缺陷", "4");
			put("桥台跳车", "4");
			put("台背排水", "4");	
			put("位移", "5");
			put("裂缝", "5");
		}
	};
	
	public final static Map<String, String> ATCAPPING_EVAL = new HashMap<String, String>() { // 桥台帽
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("破损", "4");
			put("混凝土碳化、腐蚀", "3");
			put("裂缝", "4");
			put("空洞、孔洞", "4");
		}
	};
	
	public final static Map<String, String> PA_EVAL = new HashMap<String, String>() { // 墩台基础
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("冲刷、淘空", "5");
			put("剥落、露筋", "5");
			put("冲蚀", "4");
			put("河底铺砌", "4");
			put("沉降", "5");
			put("滑移和倾斜", "5");
			put("裂缝", "5");
		}
	};
	
	public final static Map<String, String> BED_EVAL = new HashMap<String, String>() { // 河床
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("堵塞", "3");
			put("冲刷", "4");
			put("河床变迁", "4");
		}
	};
	
	public final static Map<String, String> REGSTRUC_EVAL = new HashMap<String, String>() { // 调治构造物
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("损坏", "4");
			put("冲刷、变形", "4");
		}
	};
	
	public final static Map<String, String> WINGWALL_EVAL = new HashMap<String, String>() { // 翼墙、耳墙
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("破损", "4");
			put("位移", "4");
			put("鼓肚、砌体松动", "4");
			put("裂缝", "4");
		}
	};
	
	public final static Map<String, String> CONSLOPE_PROSLOPE_EVAL = new HashMap<String, String>() { // 锥坡、护坡
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("缺陷", "4");
			put("冲刷", "4");
		}
	};
	
	public final static Map<String, String> DECK_EVAL = new HashMap<String, String>() { // 桥面铺装
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("变形（车辙、拥包、高低不平等）", "4");
			put("泛油", "4");
			put("破损", "4");
			put("裂缝", "4");
		}
	};
	
	public final static Map<String, String> JOINT_EVAL = new HashMap<String, String>() { // 伸缩缝装置
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("凹凸不平", "4");
			put("锚固区缺陷", "4");
			put("破损", "4");
			put("失效", "4");
		}
	};
	
	public final static Map<String, String> SIDEWALK_EVAL = new HashMap<String, String>() { // 人行道
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("破损", "4");
			put("缺失", "4");
		}
	};
	
	public final static Map<String, String> FENCE_EVAL = new HashMap<String, String>() { // 栏杆、护栏 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{			
			put("撞坏、缺失", "4");
			put("破损", "4");
		}
	};
	
	public final static Map<String, String> WATERTIGHT_EVAL = new HashMap<String, String>() { // 防排水系统
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{			
			put("排水不畅", "4");
			put("排水管、引水槽缺陷", "3");
		}
	};
	
	public final static Map<String, String> LIGHTING_EVAL = new HashMap<String, String>() { // 照明、标志
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{			
			put("污损或破坏 ", "4");
			put("照明设施缺失", "4");
			put("标志脱落、缺失", "3");
		}
	};
	
	public final Map<String,Map<String, String>> EVALUATION = new HashMap<String,Map<String, String>>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{		
			put("disease_girder", GIRDER_WETJOINT_EVAL);
			put("disease_wetjoint", GIRDER_WETJOINT_EVAL);
			put("disease_support", SUPPORT_EVAL);
			put("disease_pier", PIER_EVAL);
			put("disease_bentcap", BENTCAP_TIEBEAM_EVAL);
			put("disease_tiebeam", BENTCAP_TIEBEAM_EVAL);
			put("disease_atbody", ATBODY_EVAL);
			put("disease_atcapping", ATCAPPING_EVAL);
			put("disease_pa", PA_EVAL);
			put("disease_bed", BED_EVAL);
			put("disease_regstruc", REGSTRUC_EVAL);
			put("disease_wingwall", WINGWALL_EVAL);
			put("disease_conslope", CONSLOPE_PROSLOPE_EVAL);
			put("disease_proslope", CONSLOPE_PROSLOPE_EVAL);
			put("disease_deck", DECK_EVAL);
			put("disease_joint", JOINT_EVAL);
			put("disease_sidewalk", SIDEWALK_EVAL);
			put("disease_fence", FENCE_EVAL);
			put("disease_watertight", WATERTIGHT_EVAL);
			put("disease_lighting", LIGHTING_EVAL);
		}		
	};
	
	public final static Map<Integer, Double> CCI_T = new HashMap<Integer, Double>() { // t值
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{			
			put(1, Double.POSITIVE_INFINITY);
			put(2, 10.0);
			put(3, 9.7);
			put(4, 9.5);
			put(5, 9.2);
			put(6, 8.9);
			put(7, 8.7);
			put(8, 8.5);
			put(9, 8.3);
			put(10, 8.1);
			put(11, 7.9);
			put(12, 7.7);
			put(13, 7.5);
			put(14, 7.3);
			put(15, 7.2);
			put(16, 7.08);
			put(17, 6.96);
			put(18, 6.84);
			put(19, 6.72);
			put(20, 6.6);
			put(21, 6.48);
			put(22, 6.36);
			put(23, 6.24);
			put(24, 6.12);
			put(25, 6.00);
			put(26, 5.88);
			put(27, 5.76);
			put(28, 5.64);
			put(29, 5.52);
			put(30, 5.4);
			put(40, 4.9);
			put(50, 4.4);
			put(60, 4.0);
			put(70, 3.6);
			put(80, 3.2);
			put(90, 2.8);
			put(100, 2.5);
			put(200, 2.3);
		}
	};
	
	// 默认权重
	public final static double[] UP_WEIGHT = {0.7, 0.18, 0.12}; // 上部
	public final static double[] DOWN_WEIGHT = {0.02, 0.01, 0.3, 0.3, 0.28, 0.07, 0.02}; // 下部
	public final static double[] DECK_WEIGHT = {0.4, 0.25, 0.1, 0.1, 0.1, 0.05}; // 桥面系
	
	// 按照parts_id升顺序排列
	public void listSort(List<Map<String,Object>> resultList) throws Exception {  
        // resultList是需要排序的list，其内放的是Map
        // 返回的结果集        
		Collections.sort(resultList,new Comparator<Map<String,Object>>() {
			public int compare(Map<String, Object> o1,Map<String, Object> o2) {          
				//o1，o2是list中的Map，可以在其内取得值，按其排序，此例为升序，s1和s2是排序字段值
				String s1 = (String) o1.get("parts_id");
				String s2 = (String) o2.get("parts_id");
          
				if(s1.compareTo(s2) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
	}
	
	// 整合构件技术状况评分
	public Map<String, Double> calMciMap(Map<String, List<String>> evalmap) {
		Map<String, Double> mciResult = new HashMap<>();
		
		Iterator<Entry<String, List<String>>> entries = evalmap.entrySet().iterator();
		
		while (entries.hasNext()) {			  
		    Entry<String, List<String>> entry = entries.next();
		    
		    double[] score_num = new double[entry.getValue().size()];
		    
		    for (int i = 0; i < entry.getValue().size(); i++) { // 将score转化为double数组
		    	score_num[i] = Double.parseDouble(entry.getValue().get(i));
			}
		    
		    sort(score_num); // 将score排序		    
		    mciResult.put(entry.getKey(), calMCI(score_num)); // 计算MCI并写入Map
		}		
		return mciResult;
	}
	
	// double数组从大到小排序
	public void sort(double[] arr) {
	    for (int i = 0; i < arr.length - 1; i++) {
	        for (int j = i+1; j < arr.length; j++) {
	            if (arr[i] < arr[j]) {
	              double temp = arr[i];
	              arr[i] = arr[j];
	              arr[j] = temp;
	            }
	        }
	    }
	}
	
	// 找出数组中的最小值
	public double min(double[] arr) {
		double minnum = arr[0];
	    for (int i = 0; i < arr.length - 1; i++) {
	    	if (arr[i] < minnum) {
	    		minnum = arr[i];
	    	}
	    }
	    return minnum;
	}
	
	// 找出数组中的平均值
	public double avg(double[] arr) {
		double avgnum = 0;
	    for (int i = 0; i < arr.length - 1; i++) {
	    	avgnum += arr[i];
	    }
	    return (avgnum / arr.length);
	}
	
	// 找t值
	public double getTValue(double num) {
		if (OtherFunction.CCI_T.get(num) != null) {
			return OtherFunction.CCI_T.get(num); // 如果找到t值，直接返回
		}
		
		// 内插法求t值
		double t = 0;
		
		if (num >= 200) {
			t = 2.3;
		}
		else if (num >= 100 && num < 200) {
			t = 2.5 + ((num - 100) / 100) * (-0.2);			
		}
		else {
			int ceil = (int) Math.ceil((double) num); // 上限
			int floor = (int) Math.floor((double) num); // 下限
					
			new OtherFunction();
			double ceil_t = OtherFunction.CCI_T.get(ceil); // 获取上限t值
			double floor_t = OtherFunction.CCI_T.get(floor); // 获取下限t值
			t = floor_t + ((num - floor) / 10) * (floor_t - ceil_t);
		}
		return t;
	}
	
	// 计算权重
	public double[] calWeight(double[] weight, int[] ele_num) {
		double temp = 0.0;
		for (int i = 0; i < ele_num.length; i++) {
			if (ele_num[i] == 0) {
				temp += weight[i];
				weight[i] = 0.0;
			}
		}
		
		for (int i = 0; i < weight.length; i++) {
			if (weight[i] != 0.0) {
				weight[i] += (weight[i] / (1 - temp)) * temp;
			}
		}
		return weight;		
	}
	
	// 计算构件技术状况评分
	public double calMCI(double[] eval) {
		double[] temp = new double[eval.length];
		double index = 0;
		for (int i = 0; i < eval.length; i++) {
			if (i == 0) {
				temp[i] = eval[i];				
			}
			else {
				temp[i] = (eval[i] / (100 * Math.sqrt(i+1))) * (100 - index);
			}
			index += temp[i];
		}		
		return (100 - index);
	}
	
	// 计算部件技术状况评分
	public double calCCI(double[] eval, int ele_num, int major_flag) {
		if (major_flag == 1) { // 是主要部件
			for (int i = 0; i < eval.length - 1; i++) {
		    	if (eval[i] < 40.0) {
					return eval[i];
				}
		    }			
		}
		
		double eval_min = min(eval); // 找出数组中的最小值

		double avgnum = 0.0;
	    for (int i = 0; i < eval.length - 1; i++) {
	    	avgnum += eval[i];
	    }
	    avgnum += 100.0 * (ele_num - eval.length); // 没有病害的全部按100分计算
		
		double eval_avg = avgnum / ele_num; // 找出数组中的平均值
		double t_val = getTValue(ele_num); // t值
		
		return (eval_avg - ((100 - eval_min) / t_val));
	}
	
	// 计算结构技术状况评分
	public double calCI(double[] cci_arr, double[] new_weight) {
		double ci_val = 0.0;
		for (int i = 0; i < cci_arr.length; i++) {
			ci_val += cci_arr[i] * new_weight[i];
		}
		return ci_val;		
	}
	
	// 计算桥梁总体技术状况评分
	public double calDR(double[] ci_arr) {
		return (ci_arr[0] * 0.4 + ci_arr[1] * 0.4 + ci_arr[2] * 0.2);
	}
}

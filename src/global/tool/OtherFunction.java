package global.tool;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OtherFunction {
	
	public final static Map<String, String> GIRDER_WETJOINT_EVAL = new HashMap<String, String>() { // �ϲ�
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("���ѡ�����", "3");
			put("���䡢����", "4");
			put("�ն����׶�", "4");
			put("��������������", "4");	
			put("�ֽ���ʴ", "5");
			put("������̼��", "4");
			put("������ǿ��", "5");
			put("�����Ӷ�", "5");
			put("�ṹ��λ", "5");
			put("ԤӦ����������", "5");
			put("�ѷ�", "5");
		}		
	};
	
	public final static Map<String, String> SUPPORT_EVAL = new HashMap<String, String>() { // ֧��
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("�ϻ�������", "5");
			put("ȱ��", "4");
			put("�������ѿջ���г���", "5");
			put("�����", "5");	
			put("���ķ���ϩ����ĥ��", "4");
			put("λ�ơ�ת�ǳ���", "4");
		}		
	};
	
	public final static Map<String, String> PIER_EVAL = new HashMap<String, String>() { // �Ŷ�
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("���ѡ�����", "3");
			put("���䡢¶��", "4");
			put("�ն����׶�", "4");
			put("�ֽ���ʴ", "5");	
			put("������̼������ʴ", "4");
			put("ĥ��", "4");
			put("�ع�����ȱ��", "4");
			put("λ��", "5");
			put("�ѷ�", "5");
		}		
	};
	
	public final static Map<String, String> BENTCAP_TIEBEAM_EVAL = new HashMap<String, String>() { // ������ϵ��
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("���ѡ�����", "3");
			put("���䡢¶��", "4");
			put("�ն����׶�", "4");
			put("�ֽ���ʴ", "5");	
			put("������̼������ʴ", "4");
			put("�ѷ�", "4");
		}		
	};
	
	public final static Map<String, String> ATBODY_EVAL = new HashMap<String, String>() { // ��̨��
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("����", "4");
			put("�ն����׶�", "4");
			put("ĥ��", "3");
			put("������̼������ʴ", "3");
			put("�ع�����ȱ��", "4");
			put("��̨����", "4");
			put("̨����ˮ", "4");	
			put("λ��", "5");
			put("�ѷ�", "5");
		}
	};
	
	public final static Map<String, String> ATCAPPING_EVAL = new HashMap<String, String>() { // ��̨ñ
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("����", "4");
			put("������̼������ʴ", "3");
			put("�ѷ�", "4");
			put("�ն����׶�", "4");
		}
	};
	
	public final static Map<String, String> PA_EVAL = new HashMap<String, String>() { // ��̨����
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("��ˢ���Կ�", "5");
			put("���䡢¶��", "5");
			put("��ʴ", "4");
			put("�ӵ�����", "4");
			put("����", "5");
			put("���ƺ���б", "5");
			put("�ѷ�", "5");
		}
	};
	
	public final static Map<String, String> BED_EVAL = new HashMap<String, String>() { // �Ӵ�
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("����", "3");
			put("��ˢ", "4");
			put("�Ӵ���Ǩ", "4");
		}
	};
	
	public final static Map<String, String> REGSTRUC_EVAL = new HashMap<String, String>() { // ���ι�����
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("��", "4");
			put("��ˢ������", "4");
		}
	};
	
	public final static Map<String, String> WINGWALL_EVAL = new HashMap<String, String>() { // ��ǽ����ǽ
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("����", "4");
			put("λ��", "4");
			put("�Ķǡ������ɶ�", "4");
			put("�ѷ�", "4");
		}
	};
	
	public final static Map<String, String> CONSLOPE_PROSLOPE_EVAL = new HashMap<String, String>() { // ׶�¡�����
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("ȱ��", "4");
			put("��ˢ", "4");
		}
	};
	
	public final static Map<String, String> DECK_EVAL = new HashMap<String, String>() { // ������װ
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("���Σ����ޡ�ӵ�����ߵͲ�ƽ�ȣ�", "4");
			put("����", "4");
			put("����", "4");
			put("�ѷ�", "4");
		}
	};
	
	public final static Map<String, String> JOINT_EVAL = new HashMap<String, String>() { // ������װ��
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("��͹��ƽ", "4");
			put("ê����ȱ��", "4");
			put("����", "4");
			put("ʧЧ", "4");
		}
	};
	
	public final static Map<String, String> SIDEWALK_EVAL = new HashMap<String, String>() { // ���е�
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("����", "4");
			put("ȱʧ", "4");
		}
	};
	
	public final static Map<String, String> FENCE_EVAL = new HashMap<String, String>() { // ���ˡ����� 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{			
			put("ײ����ȱʧ", "4");
			put("����", "4");
		}
	};
	
	public final static Map<String, String> WATERTIGHT_EVAL = new HashMap<String, String>() { // ����ˮϵͳ
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{			
			put("��ˮ����", "4");
			put("��ˮ�ܡ���ˮ��ȱ��", "3");
		}
	};
	
	public final static Map<String, String> LIGHTING_EVAL = new HashMap<String, String>() { // ��������־
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{			
			put("������ƻ� ", "4");
			put("������ʩȱʧ", "4");
			put("��־���䡢ȱʧ", "3");
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
	
	public final static Map<Integer, Double> CCI_T = new HashMap<Integer, Double>() { // tֵ
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
	
	// Ĭ��Ȩ��
	public final static double[] UP_WEIGHT = {0.7, 0.18, 0.12}; // �ϲ�
	public final static double[] DOWN_WEIGHT = {0.02, 0.01, 0.3, 0.3, 0.28, 0.07, 0.02}; // �²�
	public final static double[] DECK_WEIGHT = {0.4, 0.25, 0.1, 0.1, 0.1, 0.05}; // ����ϵ
	
	// ����parts_id��˳������
	public void listSort(List<Map<String,Object>> resultList) throws Exception {  
        // resultList����Ҫ�����list�����ڷŵ���Map
        // ���صĽ����        
		Collections.sort(resultList,new Comparator<Map<String,Object>>() {
			public int compare(Map<String, Object> o1,Map<String, Object> o2) {          
				//o1��o2��list�е�Map������������ȡ��ֵ���������򣬴���Ϊ����s1��s2�������ֶ�ֵ
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
	
	// ���Ϲ�������״������
	public Map<String, Double> calMciMap(Map<String, List<String>> evalmap) {
		Map<String, Double> mciResult = new HashMap<>();
		
		Iterator<Entry<String, List<String>>> entries = evalmap.entrySet().iterator();
		
		while (entries.hasNext()) {			  
		    Entry<String, List<String>> entry = entries.next();
		    
		    double[] score_num = new double[entry.getValue().size()];
		    
		    for (int i = 0; i < entry.getValue().size(); i++) { // ��scoreת��Ϊdouble����
		    	score_num[i] = Double.parseDouble(entry.getValue().get(i));
			}
		    
		    sort(score_num); // ��score����		    
		    mciResult.put(entry.getKey(), calMCI(score_num)); // ����MCI��д��Map
		}		
		return mciResult;
	}
	
	// double����Ӵ�С����
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
	
	// �ҳ������е���Сֵ
	public double min(double[] arr) {
		double minnum = arr[0];
	    for (int i = 0; i < arr.length - 1; i++) {
	    	if (arr[i] < minnum) {
	    		minnum = arr[i];
	    	}
	    }
	    return minnum;
	}
	
	// �ҳ������е�ƽ��ֵ
	public double avg(double[] arr) {
		double avgnum = 0;
	    for (int i = 0; i < arr.length - 1; i++) {
	    	avgnum += arr[i];
	    }
	    return (avgnum / arr.length);
	}
	
	// ��tֵ
	public double getTValue(double num) {
		if (OtherFunction.CCI_T.get(num) != null) {
			return OtherFunction.CCI_T.get(num); // ����ҵ�tֵ��ֱ�ӷ���
		}
		
		// �ڲ巨��tֵ
		double t = 0;
		
		if (num >= 200) {
			t = 2.3;
		}
		else if (num >= 100 && num < 200) {
			t = 2.5 + ((num - 100) / 100) * (-0.2);			
		}
		else {
			int ceil = (int) Math.ceil((double) num); // ����
			int floor = (int) Math.floor((double) num); // ����
					
			new OtherFunction();
			double ceil_t = OtherFunction.CCI_T.get(ceil); // ��ȡ����tֵ
			double floor_t = OtherFunction.CCI_T.get(floor); // ��ȡ����tֵ
			t = floor_t + ((num - floor) / 10) * (floor_t - ceil_t);
		}
		return t;
	}
	
	// ����Ȩ��
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
	
	// ���㹹������״������
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
	
	// ���㲿������״������
	public double calCCI(double[] eval, int ele_num, int major_flag) {
		if (major_flag == 1) { // ����Ҫ����
			for (int i = 0; i < eval.length - 1; i++) {
		    	if (eval[i] < 40.0) {
					return eval[i];
				}
		    }			
		}
		
		double eval_min = min(eval); // �ҳ������е���Сֵ

		double avgnum = 0.0;
	    for (int i = 0; i < eval.length - 1; i++) {
	    	avgnum += eval[i];
	    }
	    avgnum += 100.0 * (ele_num - eval.length); // û�в�����ȫ����100�ּ���
		
		double eval_avg = avgnum / ele_num; // �ҳ������е�ƽ��ֵ
		double t_val = getTValue(ele_num); // tֵ
		
		return (eval_avg - ((100 - eval_min) / t_val));
	}
	
	// ����ṹ����״������
	public double calCI(double[] cci_arr, double[] new_weight) {
		double ci_val = 0.0;
		for (int i = 0; i < cci_arr.length; i++) {
			ci_val += cci_arr[i] * new_weight[i];
		}
		return ci_val;		
	}
	
	// �����������弼��״������
	public double calDR(double[] ci_arr) {
		return (ci_arr[0] * 0.4 + ci_arr[1] * 0.4 + ci_arr[2] * 0.2);
	}
}

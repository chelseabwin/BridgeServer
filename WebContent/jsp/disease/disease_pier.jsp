<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->


						<!-- END BEGIN STYLE CUSTOMIZER -->  

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							病害数据管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								资料管理

								<i class="icon-angle-right"></i>

							</li>

							<li>

								病害数据管理

								<i class="icon-angle-right"></i>

							</li>

							<li>病害数据<s:if test="#request.bg_id==null">添加</s:if><s:else>修改</s:else></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">
					
						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>病害数据<s:if test="#request.id==null">添加</s:if><s:else>修改</s:else></div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="update_form" action="" class="form-horizontal" method="post">
								<input type="hidden" name="id" value="<s:property value="#request.id"/>">
								<input type="hidden" name="bg_id" value="<s:property value="#request.bg_id"/>">

												<div class="control-group">

													<label class="control-label">部件名称</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="item_name" value="<s:property value="#request.item_name"/>" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">部件编号</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="parts_id" value="<s:property value="#request.parts_id"/>" <s:if test="#request.id!=null">readOnly="true"</s:if> />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">病害类型</label>

													<div class="controls">
													
													    <label class="radio">
													    	<input type="radio" id="rgFeature1" name="rg_feature" value="蜂窝、麻面">&nbsp;蜂窝、麻面
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature2" name="rg_feature" value="剥落、露筋">&nbsp;剥落、露筋
													    </label>
													  	
													  	<label class="radio">
													        <input type="radio" id="rgFeature3" name="rg_feature" value="空洞、孔洞">&nbsp;空洞、孔洞
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature4" name="rg_feature" value="圬工砌体缺陷">&nbsp;圬工砌体缺陷
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature5" name="rg_feature" value="裂缝">&nbsp;裂缝
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature6" name="rg_feature" value="其他病害">&nbsp;其他病害
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group" id="fis_div">

													<label class="control-label">裂缝类型</label>

													<div class="controls">
													
													    <label class="radio">
													    	<input type="radio" id="rgFissure1" name="rg_fissure" value="竖向裂缝">&nbsp;竖向裂缝
													    </label>
													  	
													  	<label class="radio">
													        <input type="radio" id="rgFissure2" name="rg_fissure" value="斜向裂缝">&nbsp;斜向裂缝
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFissure3" name="rg_fissure" value="水平裂缝">&nbsp;水平裂缝
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFissure4" name="rg_fissure" value="网裂缝">&nbsp;网裂缝
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group" id="od_div">

													<label class="control-label">其他病害</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="sp_otherDisease" id="spOtherDiseaseId" list="{'[1]钢筋锈蚀','[2]混凝土碳化、腐蚀','[3]磨损','[4]位移','[5]其他'}" />

													</div>

												</div>
												
												<div class="control-group" id="1s_div">

													<label class="control-label">距本跨梁端起始距离</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="l1_start" value="<s:property value="#request.l1_start"/>"/>

													</div>

												</div>
												
												<div class="control-group" id="1e_div">

													<label class="control-label">距本跨梁端终止距离</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="l1_end" value="<s:property value="#request.l1_end"/>"/>

													</div>

												</div>
												
												<div class="control-group" id="ar_div">

													<label class="control-label">病害面积</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="l1_area" value="<s:property value="#request.l1_area"/>"/>

													</div>

												</div>
												
												<div class="control-group" id="2s_div">

													<label class="control-label">距本跨梁端起始距离</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="l2_start" value="<s:property value="#request.l2_start"/>"/>

													</div>

												</div>
												
												<div class="control-group" id="lg_div">

													<label class="control-label">病害长度</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="l2_length" value="<s:property value="#request.l2_length"/>"/>

													</div>

												</div>
												
												<div class="control-group" id="wt_div">

													<label class="control-label">病害宽度</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="l2_width" value="<s:property value="#request.l2_width"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">病害描述</label>

													<div class="controls">

														<textarea class="large m-wrap" rows="3" name="add_content"><s:property value="#request.add_content"/></textarea>

													</div>

												</div>

												<div class="form-actions">
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/disease!changePier');"><i class="icon-ok"></i> 保存</a>
													<s:if test="#request.id!=null">
														<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!viewDisease?table_name=disease_pier&id=<s:property value="id"/>&bg_name=<s:property value="bg_name"/>&bg_id=<s:property value="bg_id"/>');">取消</a>
													</s:if>
													<s:else>
														<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=disease_pier&bg_name=<s:property value="bg_name"/>&bg_id=<s:property value="bg_id"/>');">取消</a>
													</s:else>
												</div>

											</form>

								<!-- END FORM-->       

							</div>

						</div>
					</div>

				</div>

				<!-- END PAGE CONTENT-->

			</div>
<script>
$("input[name=rg_feature][value='<s:property value="#request.rg_feature"/>']").attr("checked",true);

if ($("input[name=rg_feature]:checked").val()=="裂缝") {
	$("#fis_div").show();
	$("#od_div").hide();
	$("input[name=rg_fissure][value='<s:property value="#request.rg_fissure"/>']").attr("checked",true);
	
	if ($("input[name=rg_fissure]:checked").val()=="网裂缝") {
		$("#1s_div").show();
		$("#1e_div").show();
		$("#ar_div").show();
		$("#2s_div").hide();
		$("#lg_div").hide();
		$("#wt_div").hide();
	}
	else {
		$("#1s_div").hide();
		$("#1e_div").hide();
		$("#ar_div").hide();
		$("#2s_div").show();
		$("#lg_div").show();
		$("#wt_div").show();
	}
}
else if ($("input[name=rg_feature]:checked").val()=="其他病害") {
	$("#fis_div").hide();
	$("#od_div").show();
	$("#spOtherDiseaseId").val("<s:property value="#request.sp_otherDisease"/>");
	$("#1s_div").hide();
	$("#1e_div").hide();
	$("#ar_div").hide();
	$("#2s_div").hide();
	$("#lg_div").hide();
	$("#wt_div").hide();
}
else {
	$("#fis_div").hide();
	$("#od_div").hide();
	$("#1s_div").show();
	$("#1e_div").show();
	$("#ar_div").show();
	$("#2s_div").hide();
	$("#lg_div").hide();
	$("#wt_div").hide();
}

$("input[name=rg_feature]").change(function() { 
	if ($("input[name=rg_feature]:checked").val()=="裂缝") {
		$("#fis_div").show();
		$("#od_div").hide();		
		$("input[name=rg_fissure][value='<s:property value="#request.rg_fissure"/>']").attr("checked",true);
		
		if ($("input[name=rg_fissure]:checked").val()=="网裂缝") {
			$("#1s_div").show();
			$("#1e_div").show();
			$("#ar_div").show();
			$("#2s_div").hide();
			$("#lg_div").hide();
			$("#wt_div").hide();
		}
		else {
			$("#1s_div").hide();
			$("#1e_div").hide();
			$("#ar_div").hide();
			$("#2s_div").show();
			$("#lg_div").show();
			$("#wt_div").show();
		}
	}
	else if ($("input[name=rg_feature]:checked").val()=="其他病害") {
		$("#fis_div").hide();
		$("#od_div").show();
		$("#spOtherDiseaseId").val("<s:property value="#request.sp_otherDisease"/>");
		$("#1s_div").hide();
		$("#1e_div").hide();
		$("#ar_div").hide();
		$("#2s_div").hide();
		$("#lg_div").hide();
		$("#wt_div").hide();
	}
	else {
		$("#fis_div").hide();
		$("#od_div").hide();
		$("#1s_div").show();
		$("#1e_div").show();
		$("#ar_div").show();
		$("#2s_div").hide();
		$("#lg_div").hide();
		$("#wt_div").hide();
	}
});

$("input[name=rg_fissure]").change(function() {
	if ($("input[name=rg_fissure]:checked").val()=="网裂缝") {
		$("#1s_div").show();
		$("#1e_div").show();
		$("#ar_div").show();
		$("#2s_div").hide();
		$("#lg_div").hide();
		$("#wt_div").hide();
	}
	else {
		$("#1s_div").hide();
		$("#1e_div").hide();
		$("#ar_div").hide();
		$("#2s_div").show();
		$("#lg_div").show();
		$("#wt_div").show();
	}
});

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
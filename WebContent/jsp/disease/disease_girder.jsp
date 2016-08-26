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

								<form id="update_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data">
								<input type="hidden" name="id" value="<s:property value="#request.id"/>">
								<input type="hidden" name="bg_id" value="<s:property value="#request.bg_id"/>">
								<input type="hidden" id="disease_image_id" name="disease_image" value="<s:property value="#request.disease_image"/>">
								<input type="hidden" id="image_type_id" name="image_type" value="<s:property value="#request.image_type"/>">
								<input type="hidden" id="img_name_id" name="img_name" value="<s:property value="#request.img_name"/>">

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
										        <input type="radio" id="rgFeature2" name="rg_feature" value="剥落、掉角">&nbsp;剥落、掉角
										    </label>
										  	
										  	<label class="radio">
										        <input type="radio" id="rgFeature3" name="rg_feature" value="空洞、孔洞">&nbsp;空洞、孔洞
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature4" name="rg_feature" value="裂缝">&nbsp;裂缝
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature5" name="rg_feature" value="其他病害">&nbsp;其他病害
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
										        <input type="radio" id="rgFissure2" name="rg_fissure" value="横向裂缝">&nbsp;横向裂缝
										    </label>
										  	
										  	<label class="radio">
										        <input type="radio" id="rgFissure3" name="rg_fissure" value="斜向裂缝">&nbsp;斜向裂缝
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFissure4" name="rg_fissure" value="纵向裂缝">&nbsp;纵向裂缝
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFissure5" name="rg_fissure" value="网裂缝">&nbsp;网裂缝
										    </label>
										    
										</div>
										
									</div>
									
									<div class="control-group" id="od_div">

										<label class="control-label">其他病害</label>

										<div class="controls">
										
											<s:select class="medium m-wrap" name="sp_otherDisease" id="spOtherDiseaseId" list="{'混凝土保护层厚度','钢筋锈蚀','混凝土碳化','混凝土强度','跨中挠度','结构变位','预应力构件损伤','其他'}" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">距本跨梁端起始距离</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="start" value="<s:property value="#request.start"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">距本跨梁端终止距离</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="end" value="<s:property value="#request.end"/>"/>

										</div>

									</div>
									
									<div class="control-group" id="ar_div">

										<label class="control-label">病害面积</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="area" value="<s:property value="#request.area"/>"/>

										</div>

									</div>
									
									<div class="control-group" id="lg_div">

										<label class="control-label">病害长度</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="length" value="<s:property value="#request.length"/>"/>

										</div>

									</div>
									
									<div class="control-group" id="wt_div">

										<label class="control-label">病害宽度</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="width" value="<s:property value="#request.width"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">病害位置</label>

										<div class="controls">
										
										    <label class="radio">
										    	<input type="radio" id="rgLocation1" name="rg_location" value="左翼板">&nbsp;左翼板
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgLocation2" name="rg_location" value="右翼板">&nbsp;右翼板
										    </label>
										  	
										  	<label class="radio">
										        <input type="radio" id="rgLocation3" name="rg_location" value="左腹板">&nbsp;左腹板
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgLocation4" name="rg_location" value="右腹板">&nbsp;右腹板
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgLocation5" name="rg_location" value="底板">&nbsp;底板
										    </label>
										    
										</div>
										
									</div>
									
									<div class="control-group" id="ss_div">

										<label class="control-label">侧向距本跨梁端起始距离</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="side_start" value="<s:property value="#request.side_start"/>"/>

										</div>

									</div>
									
									<div class="control-group" id="se_div">

										<label class="control-label">侧向距本跨梁端终止距离</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="side_end" value="<s:property value="#request.side_end"/>"/>

										</div>

									</div>
									
									<div class="control-group" id="sl_div">

										<label class="control-label">侧向裂缝长度</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="side_length" value="<s:property value="#request.side_length"/>"/>

										</div>

									</div>
									
									<div class="control-group" id="sw_div">

										<label class="control-label">侧向裂缝宽度</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="side_width" value="<s:property value="#request.side_width"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">病害描述</label>

										<div class="controls">

											<textarea class="large m-wrap" rows="3" name="add_content"><s:property value="#request.add_content"/></textarea>

										</div>

									</div>
								
								</form>	
								
								<form id="image_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data">
								<input type="hidden" name="bg_id" value="<s:property value="#request.bg_id"/>">
								<input type="hidden" name="id" value="<s:property value="#request.id"/>">
								<input type="hidden" name="table_name" value="disease_girder">
								
										<div class="control-group">

											<label class="control-label">病害图片</label>
											
											<div class="controls">
											    
											    <input id="img_id" type="file" size="40" name="img" class="file" accept="image/*">
											    
											    <input type="button" class="btn green" value="上传" onclick="doUpload()" />
											    
											    (注：图片文件名请勿带有中文字符，以免无法识别！)
										
											</div>
										
										</div>
										
										<div id="img_div" class="control-group">

											<label class="control-label"></label>
											
											<div class="controls">
											    
											    <!-- <img id="dis_img_id" src="data:<s:property value="#request.image_type"/>;base64,<s:property value="#request.disease_image"/>" width="400" height="300" /> -->
												<img id="dis_img_id" src="/BridgeServer/disease_image/<s:property value="#request.img_name"/>" width="400" height="300" />
											
											</div>
										
										</div>
										
								</form>

								<div class="form-actions">
									<a href="#" class="btn blue" onclick="submitData('/BridgeServer/disease!changeGirder');"><i class="icon-ok"></i> 保存</a>
									<s:if test="#request.id!=null">
										<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!viewDisease?table_name=disease_girder&id=<s:property value="id"/>&bg_name=<s:property value="bg_name"/>&bg_id=<s:property value="bg_id"/>');">取消</a>
									</s:if>
									<s:else>
										<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=disease_girder&bg_name=<s:property value="bg_name"/>&bg_id=<s:property value="bg_id"/>');">取消</a>
									</s:else>
								</div>
								
								<!-- END FORM-->       

							</div>

						</div>
					</div>

				</div>

				<!-- END PAGE CONTENT-->

			</div>
<script>
$("input[name=rg_feature][value='<s:property value="#request.rg_feature"/>']").attr("checked",true);
$("input[name=rg_location][value='<s:property value="#request.rg_location"/>']").attr("checked",true);

if ($("#disease_image_id").val() == "") {
	$("#img_div").hide();
}

if ($("input[name=rg_feature]:checked").val()=="裂缝") {
	$("#fis_div").show();
	$("#od_div").hide();
	$("input[name=rg_fissure][value='<s:property value="#request.rg_fissure"/>']").attr("checked",true);
	
	if ($("input[name=rg_fissure]:checked").val()=="网裂缝") {
		$("#ar_div").show();
		$("#lg_div").hide();
		$("#wt_div").hide();		
	}
	else {
		$("#ar_div").hide();
		$("#lg_div").show();
		$("#wt_div").show();		
	}
	
	if ($("input[name=rg_location]:checked").val()=="左翼板" || $("input[name=rg_location]:checked").val()=="右翼板") {
		$("#ss_div").show();
		$("#se_div").show();
		$("#sl_div").show();
		$("#sw_div").show();
	}
	else {
		$("#ss_div").hide();
		$("#se_div").hide();
		$("#sl_div").hide();
		$("#sw_div").hide();
	}
}
else if ($("input[name=rg_feature]:checked").val()=="其他病害") {
	$("#fis_div").hide();
	$("#od_div").show();
	$("#spOtherDiseaseId").val("<s:property value="#request.sp_otherDisease"/>");
	$("#ar_div").show();
	$("#lg_div").hide();
	$("#wt_div").hide();
	$("#ss_div").hide();
	$("#se_div").hide();
	$("#sl_div").hide();
	$("#sw_div").hide();
}
else {
	$("#fis_div").hide();
	$("#od_div").hide();
	$("#ar_div").show();
	$("#lg_div").hide();
	$("#wt_div").hide();
	$("#ss_div").hide();
	$("#se_div").hide();
	$("#sl_div").hide();
	$("#sw_div").hide();
}

$("input[name=rg_feature]").change(function() { 
	if ($("input[name=rg_feature]:checked").val()=="裂缝") {
		$("#fis_div").show();
		$("#od_div").hide();		
		$("input[name=rg_fissure][value='<s:property value="#request.rg_fissure"/>']").attr("checked",true);
		
		if ($("input[name=rg_fissure]:checked").val()=="网裂缝") {
			$("#ar_div").show();
			$("#lg_div").hide();
			$("#wt_div").hide();		
		}
		else {
			$("#ar_div").hide();
			$("#lg_div").show();
			$("#wt_div").show();		
		}
		
		if ($("input[name=rg_location]:checked").val()=="左翼板" || $("input[name=rg_location]:checked").val()=="右翼板") {
			$("#ss_div").show();
			$("#se_div").show();
			$("#sl_div").show();
			$("#sw_div").show();
		}
		else {
			$("#ss_div").hide();
			$("#se_div").hide();
			$("#sl_div").hide();
			$("#sw_div").hide();
		}
	}
	else if ($("input[name=rg_feature]:checked").val()=="其他病害") {
		$("#fis_div").hide();
		$("#od_div").show();
		$("#spOtherDiseaseId").val("<s:property value="#request.sp_otherDisease"/>");
		$("#ar_div").show();
		$("#lg_div").hide();
		$("#wt_div").hide();
		$("#ss_div").hide();
		$("#se_div").hide();
		$("#sl_div").hide();
		$("#sw_div").hide();
	}
	else {
		$("#fis_div").hide();
		$("#od_div").hide();
		$("#ar_div").show();
		$("#lg_div").hide();
		$("#wt_div").hide();
		$("#ss_div").hide();
		$("#se_div").hide();
		$("#sl_div").hide();
		$("#sw_div").hide();
	}
});

$("input[name=rg_fissure]").change(function() {
	if ($("input[name=rg_fissure]:checked").val()=="网裂缝") {
		$("#ar_div").show();
		$("#lg_div").hide();
		$("#wt_div").hide();		
	}
	else {
		$("#ar_div").hide();
		$("#lg_div").show();
		$("#wt_div").show();		
	}
});

$("input[name=rg_location]").change(function() {
	if ($("input[name=rg_feature]:checked").val()=="裂缝") {
		if ($("input[name=rg_location]:checked").val()=="左翼板" || $("input[name=rg_location]:checked").val()=="右翼板") {
			$("#ss_div").show();
			$("#se_div").show();
			$("#sl_div").show();
			$("#sw_div").show();
		}
		else {
			$("#ss_div").hide();
			$("#se_div").hide();
			$("#sl_div").hide();
			$("#sw_div").hide();
		}
	}
});

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

function doUpload() {
    var formData = new FormData($("#image_form")[0]);
    $.ajax({
         url: '/BridgeServer/disease!upload' ,
         type: 'POST',
         data: formData,
         async: false,
         cache: false,
         contentType: false,
         processData: false,
         success: function (returndata) {
        	 if (returndata == "faild") {
        		 alert("上传失败！");
        	 }
        	 else {
				 var obj = JSON.parse(returndata);
        		 
        		 $("#disease_image_id").attr("value", obj.img_str);
        		 $("#img_name_id").attr("value", obj.img_name);
        		 $("#image_type_id").attr("value", obj.img_type);
        		 $("#dis_img_id").attr("src", "/BridgeServer/disease_image/" + obj.img_name);
        		 $("#img_div").show();
        	 }
         }
    });
}

</script>
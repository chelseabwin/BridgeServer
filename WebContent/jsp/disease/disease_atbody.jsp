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
								<input type="hidden" id="disease_image_id" name="disease_image" value="<s:property value="#request.disease_image"/>">
								<input type="hidden" id="image_type_id" name="image_type" value="<s:property value="#request.image_type"/>">
								<input type="hidden" id="img_name_id" name="img_name" value="<s:property value="#request.img_name"/>">

									<div class="control-group">

										<label class="control-label">部件名称</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="item_name" value="桥台身" readOnly/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">部件编号</label>

										<div class="controls">   

											<select class="medium m-wrap" name="parts_id" id="partsIdId"></select>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">病害类型</label>

										<div class="controls">
										
										    <label class="radio">
										    	<input type="radio" id="rgFeature1" name="rg_feature" value="剥落">&nbsp;剥落
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature2" name="rg_feature" value="空洞、孔洞">&nbsp;空洞、孔洞
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature3" name="rg_feature" value="磨损">&nbsp;磨损
										    </label>
										  	
										  	<label class="radio">
										        <input type="radio" id="rgFeature4" name="rg_feature" value="裂缝">&nbsp;裂缝
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature5" name="rg_feature" value="圬工砌体缺陷">&nbsp;圬工砌体缺陷
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature6" name="rg_feature" value="桥台跳车">&nbsp;桥台跳车
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature7" name="rg_feature" value="台背排水">&nbsp;台背排水
										    </label>
										    
										    <label class="radio">
										        <input type="radio" id="rgFeature8" name="rg_feature" value="其他病害">&nbsp;其他病害
										    </label>
										    
										</div>
										
									</div>
									
									<div class="control-group" id="od_div">

										<label class="control-label">其他病害</label>

										<div class="controls">
										
											<s:select class="medium m-wrap" name="sp_otherDisease" id="spOtherDiseaseId" list="{'混凝土碳化、腐蚀','位移','其他'}" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">病害描述</label>

										<div class="controls">

											<textarea class="large m-wrap" rows="3" name="add_content"><s:property value="#request.add_content"/></textarea>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">检测时间</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="detect_time" value="<s:property value="#request.detect_time"/>"/>

										</div>

									</div>
												
								</form>	
								
								<form id="image_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data">
								<input type="hidden" name="bg_id" value="<s:property value="#request.bg_id"/>">
								<input type="hidden" name="id" value="<s:property value="#request.id"/>">
								<input type="hidden" name="table_name" value="disease_atbody">
								
										<div class="control-group">

											<label class="control-label">病害图片</label>
											
											<div class="controls">
											    
											    <input id="img_id" type="file" size="40" name="img" class="file" accept="image/*">
											    
											    <input type="button" class="btn green" value="上传" onclick="doUpload()" />
											    
											    (注：图片文件名请勿带有中文字符，以免无法识别！图片大小尽量小于1M)
										
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
									<a href="#" class="btn blue" onclick="submitData('/BridgeServer/disease!changeAtbody');"><i class="icon-ok"></i> 保存</a>
									<s:if test="#request.id!=null">
										<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!viewDisease?table_name=disease_atbody&id=<s:property value="id"/>&bg_id=<s:property value="bg_id"/>&bg_name=<s:property value="bg_name"/>');">取消</a>
									</s:if>
									<s:else>
										<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=disease_atbody&bg_id=<s:property value="bg_id"/>&bg_name=<s:property value="bg_name"/>');">取消</a>
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
var parts_nums = "<s:property value="#request.parts_nums"/>";
var parts_nums_arr = parts_nums.split(",");

for (var i = 0; i < parts_nums_arr.length; i++) {
	var option = $("<option>" + parts_nums_arr[i] + "</option>");
	$("#partsIdId").append(option);
}

$("#partsIdId").val("<s:property value="#request.parts_id"/>");
$("input[name=rg_feature][value='<s:property value="#request.rg_feature"/>']").attr("checked",true);

if ($("#disease_image_id").val() == "") {
	$("#img_div").hide();
}

if ($("input[name=rg_feature]:checked").val()=="其他病害") {
	$("#od_div").show();
	$("#spOtherDiseaseId").val("<s:property value="#request.sp_otherDisease"/>");
}
else {
	$("#od_div").hide();
}

$("input[name=rg_feature]").change(function() { 
	if ($("input[name=rg_feature]:checked").val()=="其他病害") {
		$("#od_div").show();
		$("#spOtherDiseaseId").val("<s:property value="#request.sp_otherDisease"/>");
	}
	else {
		$("#od_div").hide();
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
        		 alert("上传失败！文件格式错误或文件过大！");
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
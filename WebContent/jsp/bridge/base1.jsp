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

							桥梁数据管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								资料管理

								<i class="icon-angle-right"></i>

							</li>

							<li>

								桥梁数据管理

								<i class="icon-angle-right"></i>

							</li>

							<li>桥梁数据<s:if test="#request.bridge_code==null">添加</s:if><s:else>修改</s:else></li>

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

								<div class="caption"><i class="icon-reorder"></i>桥梁数据<s:if test="#request.bridge_code==null">添加</s:if><s:else>修改</s:else></div>

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
								<input type="hidden" id="bridge_image1_id" name="bridgeImage1" value="<s:property value="#request.bridge_image1"/>">
								<input type="hidden" id="bridge_image2_id" name="bridgeImage2" value="<s:property value="#request.bridge_image2"/>">
								<input type="hidden" id="image1_type_id" name="image1Type" value="<s:property value="#request.image1_type"/>">
								<input type="hidden" id="image2_type_id" name="image2Type" value="<s:property value="#request.image2_type"/>">
								<input type="hidden" id="img1_name_id" name="img1_name" value="<s:property value="#request.img1_name"/>">
								<input type="hidden" id="img2_name_id" name="img2_name" value="<s:property value="#request.img2_name"/>">

									<div class="control-group">

										<label class="control-label">桥梁名称</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="bridgeName" value="<s:property value="#request.bridge_name"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">路线号</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="pathNum" value="<s:property value="#request.path_num"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">路线名称</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="pathName" value="<s:property value="#request.path_name"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">路线类型</label>

										<div class="controls">
										
											<s:select class="medium m-wrap" name="pathType" id="pathTypeId" list="{'[L]左线','[R]右线','[K]跨线','[Z]匝道','[Y]支线'}" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">公路技术等级</label>

										<div class="controls">
										
											<s:select class="medium m-wrap" name="rodeGrade" id="rodeGradeId" list="{'[0]高速公路','[1]一级公路','[2]二级公路','[3]三级公路','[4]四级公路','[5]等外路'}" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">顺序号</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="orderNum" value="<s:property value="#request.order_num"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">所在地</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="location" value="<s:property value="#request.location"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">中心桩号</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="centerStake" value="<s:property value="#request.center_stake"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">管养单位</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="custodyUnit" value="<s:property value="#request.custody_unit"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">跨越地物名称</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="acrossName" value="<s:property value="#request.across_name"/>"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">跨越地物类型</label>

										<div class="controls">
										
											<s:select class="medium m-wrap" name="acrossType" id="acrossTypeId" list="{'[1]沟壑','[2]跨海','[3]河流（运河、湖泊）','[4]管道（大型运输管道）','[5]道路','[6]铁路','[7]水渠','[8]其他地物'}" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">桥梁性质</label>

										<div class="controls">
										
											<s:select class="medium m-wrap" name="bridgeNature" id="bridgeNatureId" list="{'[1]永久性','[2]半永久性','[3]临时性'}" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label">检测时间</label>

										<div class="controls">   

											<input class="m-wrap medium" type="text" name="detectTime" value="<s:property value="#request.detect_time"/>"/>

										</div>

									</div>												

								</form>
									
								<form id="image_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data">
									<input type="hidden" name="bg_id" value="<s:property value="#request.bridge_code"/>">
									<input type="hidden" name="id" value="<s:property value="#request.id"/>">
									<input type="hidden" name="table_name" value="base1">
									
									<div class="control-group">

										<label class="control-label">正面照</label>
										
										<div class="controls">
										    
										    <input id="img1_id" type="file" size="40" name="img1" class="file" accept="image/*">
									
										</div>
									
									</div>
									
									<div id="img1_div" class="control-group">

										<label class="control-label"></label>
										
										<div class="controls">
										    
										    <img id="bg_img1_id" src="/BridgeServer/bridge_image/<s:property value="#request.img1_name"/>" width="400" height="300" />
										
										</div>
									
									</div>
									
									<div class="control-group">

										<label class="control-label">立面照</label>
										
										<div class="controls">
										    
										    <input id="img2_id" type="file" size="40" name="img2" class="file" accept="image/*">
									
										</div>
									
									</div>
									
									<div id="img2_div" class="control-group">

										<label class="control-label"></label>
										
										<div class="controls">
										    
										    <img id="bg_img2_id" src="/BridgeServer/bridge_image/<s:property value="#request.img2_name"/>" width="400" height="300" />
										
										</div>
									
									</div>
									
									<div class="control-group">

										<label class="control-label"></label>
										
										<div class="controls">
										    
										    <input type="button" class="btn green" value="上传" onclick="doUpload()" />
											    
											(注：图片文件名请勿带有中文字符，以免无法识别！ 请先分别选择“正面照”和“立面照”之后再点击“上传”按钮)
									
										</div>
									
									</div>
										
								</form>

								<div class="form-actions">
									<s:if test="#request.bridge_code==null">
								        <a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!addBridge');"><i class="icon-ok"></i> 添加</a>
										<a href="#" class="btn" onclick="loadPage('/BridgeServer/bridge!getBaseList');">取消</a>
									</s:if>
								    <s:else>
								        <a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeBase1?bridgeCode=<s:property value="#request.bridge_code"/>');"><i class="icon-ok"></i> 保存</a>
										<a href="#" class="btn" onclick="loadPage('/BridgeServer/bridge!viewBridge?bridgeCode=<s:property value="#request.bridge_code"/>');">取消</a>
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
$("#pathTypeId").val("<s:property value="#request.path_type"/>");
$("#rodeGradeId").val("<s:property value="#request.rode_grade"/>");
$("#acrossTypeId").val("<s:property value="#request.across_type"/>");
$("#bridgeNatureId").val("<s:property value="#request.bridge_nature"/>");

if ($("#bridge_image1_id").val() == "") {
	$("#img1_div").hide();
}

if ($("#bridge_image2_id").val() == "") {
	$("#img2_div").hide();
}

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

function doUpload() {
    var formData = new FormData($("#image_form")[0]);
    $.ajax({
         url: '/BridgeServer/bridge!upload' ,
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
        		 $("#bridge_image1_id").attr("value", obj.img1_str);
        		 $("#img1_name_id").attr("value", obj.img1_name);
        		 $("#image1_type_id").attr("value", obj.img1_type);
        		 $("#bg_img1_id").attr("src", "/BridgeServer/bridge_image/" + obj.img1_name);
        		 $("#img1_div").show();
        		 
        		 $("#bridge_image2_id").attr("value", obj.img2_str);
        		 $("#img2_name_id").attr("value", obj.img2_name);
        		 $("#image2_type_id").attr("value", obj.img2_type);
        		 $("#bg_img2_id").attr("src", "/BridgeServer/bridge_image/" + obj.img2_name);
        		 $("#img2_div").show();
        	 }
         }
    });
}

</script>
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

							<li>桥梁数据添加/修改</li>

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

								<div class="caption"><i class="icon-reorder"></i>桥梁数据添加/修改</div>

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

												<div class="control-group">

													<label class="control-label">桥墩材料</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="pierMaterial" id="pierMaterialId" list="{'[1]钢筋混凝土','[2]浆砌块石','[3]浆砌片石','[4]预应力钢筋混凝土','[5]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥墩截面形式</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="sectionForm" id="sectionFormId" list="{'[1]空心','[2]实心','[3]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥墩类型</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="pierType" id="pierTypeId" list="{'[1]重力式墩','[2]单柱墩','[3]双柱式墩','[4]多柱墩','[5]双壁墩','[6]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥墩截面形状</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="sectionShape" id="sectionShapeId" list="{'[1]矩形','[2]圆形','[3]花瓶形','[4]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥台材料</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="abutmentMaterial" id="abutmentMaterialId" list="{'[1]钢筋混凝土','[2]浆砌块石','[3]浆砌片石','[4]预应力钢筋混凝土','[5]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥台类型</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="abutmentType" id="abutmentTypeId" list="{'[1]肋板式桥台','[2]薄壁式桥台','[3]轻型桥台','[4]U形桥台','[5]八字形桥台','[6]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">墩台基础材料</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="pierAbutmentMaterial" id="pierAbutmentMaterialId" list="{'[1]钢筋混凝土','[2]浆砌块石','[3]浆砌片石','[4]预应力钢筋混凝土','[5]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">墩台基础</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="pierAbutmentBase" id="pierAbutmentBaseId" list="{'[1]灌注桩基础','[2]扩大基础','[3]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥面铺装类型</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="deckType" id="deckTypeId" list="{'[1]沥青混凝土','[2]水泥混凝土','[3]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">伸缩缝类型</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="jointType" id="jointTypeId" list="{'[1]毛勒缝','[2]橡胶伸缩缝','[3]梳形钢板伸缩缝','[4]锌铁皮U形伸缩缝','[5]型钢伸缩缝','[6]模数式伸缩缝','[7]其他'}" />

													</div>

												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeBase3?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/bridge!viewBridge?bridgeCode=<s:property value="#request.bg_id"/>');">取消</a>

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
$("#pierMaterialId").val("<s:property value="#request.pier_material"/>");
$("#sectionFormId").val("<s:property value="#request.section_form"/>");
$("#pierTypeId").val("<s:property value="#request.pier_type"/>");
$("#sectionShapeId").val("<s:property value="#request.section_shape"/>");
$("#abutmentMaterialId").val("<s:property value="#request.abutment_material"/>");
$("#abutmentTypeId").val("<s:property value="#request.abutment_type"/>");
$("#pierAbutmentMaterialId").val("<s:property value="#request.pier_abutment_material"/>");
$("#pierAbutmentBaseId").val("<s:property value="#request.pier_abutment_base"/>");
$("#deckTypeId").val("<s:property value="#request.deck_type"/>");
$("#jointTypeId").val("<s:property value="#request.joint_type"/>");

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
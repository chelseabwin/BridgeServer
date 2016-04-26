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

													<label class="control-label">桥梁分类</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="bridgeClassify" id="bridgeClassifyId" list="{'[1]特大桥','[2]大桥','[3]中桥','[4]小桥'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">设计荷载等级</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="designLoad" id="designLoadId" list="{'[1]公路I级','[2]公路II级','[3]汽车-超20级','[4]汽车-20级','[5]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥梁用途</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="bridgeUse" id="bridgeUseId" list="{'[1]公路桥','[2]公铁两用','[3]漫水桥','[4]高速公路跨线桥','[5]人行桥','[6]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥梁状态</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="bridgeStatus" id="bridgeStatusId" list="{'[1]营运','[2]在建','[3]正在改建'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">材料编码</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="materialCode" id="materialCodeId" list="{'[1]预应力钢筋混凝土','[2]部分预应力钢筋混凝土','[3]钢筋混凝土','[4]其他圬工材料','[5]钢','[6]其他材料'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥面板位</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="bridgePanel" id="bridgePanelId" list="{'[1]上承','[2]中承','[3]下承'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">受力型式</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="stressPattern" id="stressPatternlId" list="{'[1]简支','[2]连续','[3]悬臂','[4]无铰','[5]二铰','[6]三铰','[7]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">支座类型</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="supportType" id="supportTypeId" list="{'[1]板式橡胶支座','[2]盆式橡胶支座','[3]聚四佛乙烯滑板式支座','[4]钢支座','[5]减震支座','[6]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥型</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="bridgeType" id="bridgeTypeId" list="{'[1.1]实心板梁','[1.2]空心板梁','[1.3]整体现浇板','[2.1]T梁','[2.2]I形梁','[2.3]II形梁',
														'[2.4]箱型梁','[2.5]桁架梁','[2.6]组合式梁','[3.1]门式刚构','[3.2]斜腿刚构','[3.3]T形刚构','[3.4]连续刚构','[3.5]刚构-连续组合','[4.1]板拱','[4.2]肋拱','[4.3]双曲拱','[4.4]箱型拱',
														'[4.5]桁架拱','[4.6]刚架拱','[4.7]系杆拱','[4.8]其他拱桥','[5.1]斜拉桥','[5.2]矮塔斜拉桥'}" />

													</div>

												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeBase2?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
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
$("#bridgeClassifyId").val("<s:property value="#request.bridge_classify"/>");
$("#designLoadId").val("<s:property value="#request.design_load"/>");
$("#bridgeUseId").val("<s:property value="#request.bridge_use"/>");
$("#bridgeStatusId").val("<s:property value="#request.bridge_status"/>");
$("#materialCodeId").val("<s:property value="#request.material_code"/>");
$("#bridgePanelId").val("<s:property value="#request.bridge_panel"/>");
$("#stressPatternlId").val("<s:property value="#request.stress_pattern"/>");
$("#supportTypeId").val("<s:property value="#request.support_type"/>");
$("#bridgeTypeId").val("<s:property value="#request.bridge_type"/>");

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
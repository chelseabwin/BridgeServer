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

													<label class="control-label">翼墙、耳墙</label>

													<div class="controls">
													
													    <label class="checkbox">
													    	<input type="checkbox" id="wingWall1" name="wingWall1" value="L0">&nbsp;L0
													    </label>
													  	
													  	<label class="checkbox">													    	
													        <input type="checkbox" id="wingWall2" name="wingWall2" value="R0">&nbsp;R0
													    </label>
													  	
													  	<label class="checkbox">    
													        <input type="checkbox" id="wingWall3" name="wingWall3" value="L1">&nbsp;L1
													    </label>
													  	
													  	<label class="checkbox">
													        <input type="checkbox" id="wingWall4" name="wingWall4" value="R1">&nbsp;R1
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group">

													<label class="control-label">锥坡</label>

													<div class="controls">
													
													    <label class="checkbox">
													    	<input type="checkbox" id="conicalSlope1" name="conicalSlope1" value="L0">&nbsp;L0
													    </label>
													    
													    <label class="checkbox">
													        <input type="checkbox" id="conicalSlope2" name="conicalSlope2" value="R0">&nbsp;R0
													    </label>
													  	
													  	<label class="checkbox">
													        <input type="checkbox" id="conicalSlope3" name="conicalSlope3" value="L1">&nbsp;L1
													    </label>
													    
													    <label class="checkbox">
													        <input type="checkbox" id="conicalSlope4" name="conicalSlope4" value="R1">&nbsp;R1
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group">

													<label class="control-label">护坡个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="protectionSlope" value="<s:property value="#request.protection_slope"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥台个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="abutmentNum" value="<s:property value="#request.abutment_num"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">墩台基础个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="paNum" value="<s:property value="#request.pa_num"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">河床个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="bedNum" value="<s:property value="#request.bed_num"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">调治构造物个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="regStructure" value="<s:property value="#request.reg_structure"/>"/>

													</div>

												</div>												

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeParts1?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
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
$("#navigationLevelId").val("<s:property value="#request.navigation_level"/>");

if(<s:property value="#request.wing_wall1"/>=="1") {
	$("#wingWall1").prop("checked",true);
}
if(<s:property value="#request.wing_wall2"/>=="1") {
	$("#wingWall2").prop("checked",true);
}
if(<s:property value="#request.wing_wall3"/>=="1") {
	$("#wingWall3").prop("checked",true);
}
if(<s:property value="#request.wing_wall4"/>=="1") {
	$("#wingWall4").prop("checked",true);
}

if(<s:property value="#request.conical_slope1"/>=="1") {
	$("#conicalSlope1").prop("checked",true);
}
if(<s:property value="#request.conical_slope2"/>=="1") {
	$("#conicalSlope2").prop("checked",true);
}
if(<s:property value="#request.conical_slope3"/>=="1") {
	$("#conicalSlope3").prop("checked",true);
}
if(<s:property value="#request.conical_slope4"/>=="1") {
	$("#conicalSlope4").prop("checked",true);
}

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
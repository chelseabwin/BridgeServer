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

													<label class="control-label">桥面铺装个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="deckNum" value="<s:property value="#request.deck_num"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">伸缩缝装置个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="jointNum" value="<s:property value="#request.joint_num"/>"/>

													</div>

												</div>

												<div class="control-group">

													<label class="control-label">人行道</label>

													<div class="controls">
													
													    <label class="checkbox">
													    	<input type="checkbox" id="sidewalk1" name="sidewalk1" value="L">&nbsp;L
													    </label>
													  	
													  	<label class="checkbox">													    	
													        <input type="checkbox" id="sidewalk2" name="sidewalk2" value="R">&nbsp;R
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group">

													<label class="control-label">栏杆、护栏</label>

													<div class="controls">
													
													    <label class="checkbox">
													    	<input type="checkbox" id="guardrail1" name="guardrail1" value="L">&nbsp;L
													    </label>
													    
													    <label class="checkbox">
													        <input type="checkbox" id="guardrail2" name="guardrail2" value="R">&nbsp;R
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group">

													<label class="control-label">防排水系统个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="drainageSystem" value="<s:property value="#request.drainage_system"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">照明、标志个数</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="illuminatedSign" value="<s:property value="#request.illuminated_sign"/>"/>

													</div>

												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeParts2?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
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
if(<s:property value="#request.sidewalk1"/>=="1") {
	$("#sidewalk1").prop("checked",true);
}
if(<s:property value="#request.sidewalk2"/>=="1") {
	$("#sidewalk2").prop("checked",true);
}

if(<s:property value="#request.guardrail1"/>=="1") {
	$("#guardrail1").prop("checked",true);
}
if(<s:property value="#request.guardrail2"/>=="1") {
	$("#guardrail2").prop("checked",true);
}

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
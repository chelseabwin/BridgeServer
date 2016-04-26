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

													<label class="control-label">桥跨组合</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="bridgeSpan" value="<s:property value="#request.bridge_span"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">最大跨径</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="longestSpan" value="<s:property value="#request.longest_span"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥梁全长</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="totalLen" value="<s:property value="#request.total_len"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥宽组合</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="bridgeWide" value="<s:property value="#request.bridge_wide"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥面全宽</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="fullWide" value="<s:property value="#request.full_wide"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥面净宽</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="clearWide" value="<s:property value="#request.clear_wide"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥高</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="bridgeHigh" value="<s:property value="#request.bridge_high"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥梁限高</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="highLimit" value="<s:property value="#request.high_limit"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">建桥时间</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="buildingTime" value="<s:property value="#request.building_time"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">通航等级</label>

													<div class="controls">
													
														<s:select class="medium m-wrap" name="navigationLevel" id="navigationLevelId" list="{'[1]不通航','[2]一级航道','[3]二级航道','[4]三级航道','[5]四级航道','[6]五级航道','[7]六级航道','[8]七级航道','[9]其他'}" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">跨中截面高</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="sectionHigh" value="<s:property value="#request.section_high"/>"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥面纵坡</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="deckProfileGrade" value="<s:property value="#request.deck_profile_grade"/>"/>

													</div>

												</div>
												
												

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeStructure?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
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

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
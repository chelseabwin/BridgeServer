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

													<label class="control-label">支座详情</label>

													<div class="controls">
													
														<textarea class="form-control" rows="5" name="supportDetails"><s:property value="#request.support_details"/></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">支座编号</label>

													<div class="controls">
													
														<textarea class="form-control" rows="5" name="supportNums"><s:property value="#request.support_nums"/></textarea>

													</div>

												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeSupportDetail?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
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

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
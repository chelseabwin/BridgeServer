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
													    	<input type="radio" id="rgFeature1" name="rg_feature" value="变形（车辙、拥包、高低不平等）">&nbsp;变形（车辙、拥包、高低不平等）
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature2" name="rg_feature" value="泛油">&nbsp;泛油
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature3" name="rg_feature" value="破损">&nbsp;破损
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature4" name="rg_feature" value="裂缝">&nbsp;裂缝
													    </label>
													    
													    <label class="radio">
													        <input type="radio" id="rgFeature5" name="rg_feature" value="其他病害">&nbsp;其他病害
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group">

													<label class="control-label">病害描述</label>

													<div class="controls">

														<textarea class="large m-wrap" rows="3" name="add_content"><s:property value="#request.add_content"/></textarea>

													</div>

												</div>

												<div class="form-actions">
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/disease!changeDeck');"><i class="icon-ok"></i> 保存</a>
													<s:if test="#request.id!=null">
														<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!viewDisease?table_name=disease_deck&id=<s:property value="id"/>&bg_name=<s:property value="bg_name"/>&bg_id=<s:property value="bg_id"/>');">取消</a>
													</s:if>
													<s:else>
														<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=disease_deck&bg_name=<s:property value="bg_name"/>&bg_id=<s:property value="bg_id"/>');">取消</a>
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

function submitData(url){
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
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

							导航栏权限管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								系统设置

								<i class="icon-angle-right"></i>

							</li>

							<li>

								导航栏权限管理

								<i class="icon-angle-right"></i>

							</li>

							<li>添加导航栏权限</li>

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

								<div class="caption"><i class="icon-reorder"></i>导航栏权限管理</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="add_permission" action="" class="form-horizontal" method="post">

												<div class="control-group">

													<label class="control-label">导航栏权限名称</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="permission_name" />

													</div>

												</div>
											
												
												<div class="control-group">

													<label class="control-label">导航栏权限描述</label>

													<div class="controls">

														<textarea class="large m-wrap" rows="3" name="permission_note"></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">导航栏选择</label>
			
													<div class="controls">
			
														<select id="dplist" onclick="dpstr();" class="span6 m-wrap" multiple="multiple" data-placeholder="选择导航栏" tabindex="1">
														<s:iterator value="%{#request.datalist}" id="data">
		
															<!-- <td><input type="checkbox" class="checkboxes" value="1" /></td>-->
															<s:if test="level == 1"><option value="<s:property value="navigation_bar_id"/>">
															&nbsp;&nbsp;<s:property value="name"/></option>
															</s:if>
															<s:if test="level == 2"><option value="<s:property value="navigation_bar_id"/>">
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="name"/></option>
															</s:if>
															
														</s:iterator>
															
			
														</select>
			
													</div>
													<input id="navigation_barList" name="navigation_barList" type="hidden" value=" ">
			
												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/permission!addPermission');"><i class="icon-ok"></i> 保存</a>
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/permission!getBaseList');">取消</a>

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
	$.axs(url, $("#add_permission").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};
function dpstr(){
	var str="";
	$("#dplist option:selected").each(function(){
		str = str + $(this).val()+" ";
        
    });
	$("#navigation_barList").val(str);
	
}

</script>
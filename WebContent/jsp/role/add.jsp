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

							角色管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								系统设置

								<i class="icon-angle-right"></i>

							</li>

							<li>

								角色管理

								<i class="icon-angle-right"></i>

							</li>

							<li>添加角色</li>

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

								<div class="caption"><i class="icon-reorder"></i>用户角色添加</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="add_role" action="" class="form-horizontal" method="post">

												<div class="control-group">

													<label class="control-label">用户角色名称</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="role_name" />

													</div>

												</div>
											
												
												<div class="control-group">

													<label class="control-label">用户角色描述</label>

													<div class="controls">

														<textarea class="large m-wrap" rows="3" name="role_note"></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">导航栏权限选择</label>
			
													<div class="controls">
			
														<select id="spermissionList" onclick="dpstr('permissionList');" class="span6 m-wrap" multiple="multiple" data-placeholder="" tabindex="1">
														
															<s:iterator value="%{#request.permissionList}" id="data">
															<option value="<s:property value="permission_id"/>"><s:property value="permission_name"/></option>
															</s:iterator>
			
														</select>
			
													</div>
													<input id="permissionList" name="permissionList" type="hidden" value=" ">
			
												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/role!addRole');"><i class="icon-ok"></i> 保存</a>
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/role!getBaseList');">取消</a>

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
	$.axs(url, $("#add_role").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};
function dpstr(name){
	var str="";
	$("#s"+name+" option:selected").each(function(){
		str = str + $(this).val()+" ";
        
    });
	$("#"+name).val(str);
	
}

</script>
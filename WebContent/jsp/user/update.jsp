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

							用户管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								系统设置

								<i class="icon-angle-right"></i>

							</li>

							<li>

								用户管理

								<i class="icon-angle-right"></i>

							</li>

							<li>用户信息更改</li>

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

								<div class="caption"><i class="icon-reorder"></i>用户管理</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="add_user" action="" class="form-horizontal" method="post">
								<input type="hidden" name="user_id" value="<s:property value="#request.user_id"/>">

												<div class="control-group">

													<label class="control-label">用户登录名</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="loginName" value="<s:property value="#request.loginname"/>" readonly="readonly"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">用户姓名</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" name="name" value="<s:property value="#request.name"/>"/>

													</div>

												</div>						
												
												<div class="control-group">

													<label class="control-label">角色添加</label>
			
													<div class="controls">
			
														<select id="rlist" onclick="dpstr();" class="span6 m-wrap" multiple="multiple" data-placeholder="Choose a Category" tabindex="1">
														
															<s:iterator value="%{#request.roleList}" id="data">
															<s:set name="allRoleId" value="role_id"/>
															<s:set name="flag" value="0"/>
																<s:iterator value="%{#request.authIdList}" id="rlist">
																<s:set name="preRoleId" value="rlist"/>
																	<s:if test="#allRoleId == #preRoleId">
																		<s:set name="flag" value="1"/>
																		<option value="<s:property value="role_id"/>" selected="selected"><s:property value="role_name"/></option>
																	</s:if>
																</s:iterator>
																<s:if test="#flag == 0">
																	<option value="<s:property value="role_id"/>"><s:property value="role_name"/></option>
																</s:if>
															</s:iterator>
			
														</select>
			
													</div>
													<input id="roleList" name="roleList" type="hidden" value=" ">
			
												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/user!update');"><i class="icon-ok"></i> 保存</a>
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/user!getBaseList');">取消</a>

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
	$.axs(url, $("#add_user").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};
function dpstr(){
	var str="";
	$("#rlist option:selected").each(function(){
		str = str + $(this).val()+" ";
        
    });
	$("#roleList").val(str);
	
}

</script>
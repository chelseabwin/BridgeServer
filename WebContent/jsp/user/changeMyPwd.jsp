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

							更改密码

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								系统设置

								<i class="icon-angle-right"></i>

							</li>

							<li>

								更改密码


							</li>


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

								<div class="caption"><i class="icon-reorder"></i>更改密码</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="changepwd" action="" class="form-horizontal" method="post">

												<div class="control-group">

													<label class="control-label">登录名</label>

													<div class="controls">   

														<input name="loginName" class="m-wrap medium" type="text" value="<s:property value="%{#request.username}"/>"  readonly />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">姓名</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" value="<s:property value="%{#request.name}"/>" readonly />

													</div>

												</div>
											
												
												<div class="control-group">

													<label class="control-label">旧密码</label>

													<div class="controls">

														<input class="m-wrap medium" type="password" name="password" value="" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">新密码</label>

													<div class="controls">

														<input class="m-wrap medium" type="password" name="newPassword" value="" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">再次输入新密码</label>

													<div class="controls">

														<input class="m-wrap medium" type="password" name="newPassword2" value="" />

													</div>

												</div>
												
												<div class="control-group">

													<div class="controls" id="msg">

														<label class="alert-error">

														<s:property value="#request.msg"/>
										
														</label> 

													</div>

												</div>
												
												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/user!changeMyPwd');"><i class="icon-ok"></i> 更改</a>

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
	$.axs(url, $("#changepwd").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

</script>
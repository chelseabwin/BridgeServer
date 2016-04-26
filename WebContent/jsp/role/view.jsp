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

							<li>查看角色</li>

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

								<div class="caption"><i class="icon-reorder"></i>角色查看</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="add_auth" action="" class="form-horizontal" method="post">

												<div class="control-group">

													<label class="control-label">角色名称</label>

													<div class="controls alert alert-info">   

														&nbsp;<s:property value="%{#request.role.role_name}"/>

													</div>

												</div>
											
												
												<div class="control-group">

													<label class="control-label">角色描述</label>

													<div class="controls alert alert-info">

														&nbsp;<s:property value="%{#request.role.role_note}"/>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">导航栏权限</label>
			
													<div class="controls alert alert-info">
															<s:iterator value="%{#request.res_rpl}" id="data">
															&nbsp;<span><s:property value="name"/></span>
															</s:iterator>
													</div>
			
												</div>

												<div class="form-actions">
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/role!getBaseList');">返回</a>
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

</script>
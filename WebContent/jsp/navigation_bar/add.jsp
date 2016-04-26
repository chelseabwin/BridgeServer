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

							导航栏管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								系统设置

								<i class="icon-angle-right"></i>

							</li>

							<li>

								导航栏管理

								<i class="icon-angle-right"></i>

							</li>

							<li>导航栏列表</li>

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

								<div class="caption"><i class="icon-reorder"></i>导航栏列表</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form action="/BridgeServer/datainfo!addData" class="form-horizontal" enctype="multipart/form-data" method="post" target="screct_frame">

												<div class="control-group">

													<label class="control-label">用户</label>

													<div class="controls">   

														<input class="m-wrap medium" type="text" value="<s:property value="#session.user.name"/>" readonly />

													</div>

												</div>

												<div class="control-group">

													<label class="control-label">部门</label>

													<div class="controls">

														<select class="medium m-wrap" tabindex="1" name="department_id">
														<s:iterator value="#session.departmentList" id="data">
															<option value="<s:property value="department_id"/>"><s:property value="department_name"/></option>
														</s:iterator>
														</select>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">数据类型</label>

													<div class="controls">

														<select class="medium m-wrap" tabindex="1" name="data_type_id">
															<s:iterator value="#session.data_typeList" id="data" >
																<option value="<s:property value="data_type_id"/>"><s:property value="data_type_name"/></option>
															</s:iterator>

														</select>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">图片资料</label>

													<div class="controls">

														<input type="file" class="default" name="image" />

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">文字资料</label>

													<div class="controls">

														<textarea class="large m-wrap" rows="3" name="message"></textarea>

													</div>

												</div>

												<div class="form-actions">
												
													<button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>

													<button type="button" class="btn">Cancel</button>

												</div>

											</form>

								<!-- END FORM-->       

							</div>

						</div>
					</div>

				</div>

				<!-- END PAGE CONTENT-->

			</div>
			
			<iframe name="screct_frame" style="display:none;"></iframe>
<script>


</script>
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

							资料管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								资料管理

								<i class="icon-angle-right"></i>

							</li>

							<li>

								病害数据列表

								<i class="icon-angle-right"></i>

							</li>

							<li>病害数据查看</li>

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

								<div class="caption"><i class="icon-reorder"></i><s:property value="%{#request.bg_name}"/> 病害数据查看</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="bridge_view" action="" class="form-horizontal" method="post">
								
												<table class="table table-bordered">
													<tbody>
												      <tr>
												         <th width='100'>部件名称</th>
												         <td class="alert alert-info" width='100'><s:property value="%{#request.disease_conslope.item_name}"/></td>
												         <th width='100'>部件编号</th>
												         <td class="alert alert-info" width='100'><s:property value="%{#request.disease_conslope.parts_id}"/></td>
												      </tr>
												      
												      <tr>
												         <th>病害类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.disease_conslope.rg_feature}"/></td>
												         <th>病害描述</th>
												         <td class="alert alert-info"><s:property value="%{#request.disease_conslope.add_content}"/></td>
												      </tr>
												      
												      <tr>
												         <th>指标标度类别</th>
												         <td class="alert alert-info"><s:if test="#request.evaluation!=null && #request.evaluation!=''"><s:property value="%{#request.evaluation}"/>类</s:if></td>
												         <th>检测时间</th>
												         <td class="alert alert-info"><s:property value="%{#request.disease_conslope.detect_time}"/></td>
												      </tr>
												      
												      <tr>
											         	 <th>病害图片</th>
											         	 <!-- <td colspan="3"><s:if test="#request.disease_deck.disease_image!=null"><img src="data:<s:property value="%{#request.disease_deck.image_type}"/>;base64,<s:property value="%{#request.disease_deck.disease_image}"/>" width="400" height="300" /></s:if></td> -->
											         	 <td colspan="3"><s:if test="#request.img_name!=null"><img src="/BridgeServer/disease_image/<s:property value="%{#request.img_name}"/>" width="400" height="300" /></s:if></td>
											          </tr>
												      
													</tbody>
												</table>

												<div>
													<a href="#" class="btn blue" onclick="loadPage('/BridgeServer/disease!showConslope?id=<s:property value="%{#request.disease_conslope.id}"/>&table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&bg_name=<s:property value="bg_name"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</a>
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&bg_name=<s:property value="bg_name"/>');">返回</a>
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
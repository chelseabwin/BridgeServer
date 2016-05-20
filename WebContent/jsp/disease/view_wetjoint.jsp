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
												         <td class="alert alert-info" width='100'><s:property value="%{#request.disease_wetjoint.item_name}"/></td>
												         <th width='100'>部件编号</th>
												         <td class="alert alert-info" width='100'><s:property value="%{#request.disease_wetjoint.parts_id}"/></td>
												      </tr>
												      
												      <tr>
												         <th>病害类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.rg_feature}"/></td>
												         <th>
												         	<s:if test="#request.disease_wetjoint.rg_feature=='裂缝'">裂缝类型</s:if>
												         	<s:if test="#request.disease_wetjoint.rg_feature=='其他病害'">其他病害</s:if>
												         </th>
												         <td class="alert alert-info">
												         	<s:if test="#request.disease_wetjoint.rg_feature=='裂缝'">
												         		<s:property value="%{#request.disease_wetjoint.rg_fissure}"/>
												         	</s:if>
												         	
												         	<s:if test="#request.disease_wetjoint.rg_feature=='其他病害'">
												         		<s:property value="%{#request.disease_wetjoint.sp_otherDisease}"/>
												         	</s:if>
												         </td>
												      </tr>
												      
												      <s:if test="#request.disease_girder.rg_feature=='裂缝'">
										         	  	 <s:if test="#request.disease_girder.rg_fissure!='网裂缝'">
											         	  	<tr>
														        <th>裂缝距本跨梁端起始距离</th>
														        <td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.l2_start}"/></td>
														        <th>裂缝长度</th>
												         		<td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.l2_length}"/></td>
														    </tr>
												      
										         	  	 	<tr>
												         		<th>裂缝宽度</th>
												         		<td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.l2_width}"/></td>
												         		<th>病害描述</th>
												         	<td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.add_content}"/></td>
												      	 	</tr>
										         	  	 </s:if>
										         	  </s:if>
										         	  
										         	  <s:else>
										         	  	 <tr>
													         <th>距本跨梁端起始距离</th>
													         <td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.l1_start}"/></td>
													         <th>距本跨梁端终止距离</th>
													         <td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.l1_end}"/></td>
													     </tr>
													     
										         	  	 <tr>
												         	<th>病害面积</th>
												         	<td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.l1_area}"/></td>
												         	<th>病害描述</th>
												         	<td class="alert alert-info"><s:property value="%{#request.disease_wetjoint.add_content}"/></td>
												      	 </tr>
										         	  </s:else>
												      
													</tbody>
												</table>

												<div>
													<button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showWetjoint?id=<s:property value="%{#request.disease_wetjoint.id}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</button>
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
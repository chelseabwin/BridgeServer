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

								<div class="caption"><i class="icon-reorder"></i><s:property value="%{#request.bg_name}"/> 病害打分结果</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form id="evaluation_form" action="" class="form-horizontal" method="post">
								
									<table class="table table-bordered">
										<tbody>
										
										  <tr>
									         <th class="alert alert-info">构件打分结果</th>
									      </tr>
									      
									      <tr>
									         <td>
									         	上部承重构件：<s:property value="%{#request.mci_girder}"/><br>
									         	上部一般构件：<s:property value="%{#request.mci_wetjoint}"/><br>
									         	支座：<s:property value="%{#request.mci_support}"/><br>
									         	<br>
									         	桥墩：<s:property value="%{#request.mci_pier}"/><br>
									         	桥台：<s:property value="%{#request.mci_at}"/><br>
									         	墩台基础：<s:property value="%{#request.mci_pa}"/><br>
									         	河床：<s:property value="%{#request.mci_bed}"/><br>
									         	调治构造物：<s:property value="%{#request.mci_regstruc}"/><br>
									         	翼墙、耳墙：<s:property value="%{#request.mci_wingwall}"/><br>
									         	锥坡、护坡：<s:property value="%{#request.mci_slope}"/><br>
									         	<br>
									         	桥面铺装：<s:property value="%{#request.mci_deck}"/><br>
									         	伸缩缝装置：<s:property value="%{#request.mci_joint}"/><br>
									         	人行道：<s:property value="%{#request.mci_sidewalk}"/><br>
									         	栏杆、护栏：<s:property value="%{#request.mci_fence}"/><br>
									         	排水系统：<s:property value="%{#request.mci_watertight}"/><br>
									         	照明、标志：<s:property value="%{#request.mci_lighting}"/><br>
									         </td>
									      </tr>
									      
									      <tr>
									         <th class="alert alert-info">部件打分结果</th>
									      </tr>
									      
									      <tr>
									         <td>
									         	上部结构：<s:property value="%{#request.cci_up_arr}"/><br>
									         	下部结构：<s:property value="%{#request.cci_down_arr}"/><br>
									         	桥面系：<s:property value="%{#request.cci_deck_arr}"/><br>
									         </td>
									      </tr>
									      
									      <tr>
									         <th class="alert alert-info">结构打分结果</th>
									      </tr>
									      
									      <tr>
									         <td>
									         	结构：<s:property value="%{#request.ci_arr}"/><br>
									         </td>
									      </tr>
									      
									      <tr>
									         <th class="alert alert-info">桥梁总体打分结果</th>
									      </tr>
									      
									      <tr>
									         <td>
									         	桥梁总体：<s:property value="%{#request.dr}"/><br>
									         </td>
									      </tr>
									    
										</tbody>
									</table>

									<div>
										<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!getBaseList');">返回</a>
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
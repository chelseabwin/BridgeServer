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

								桥梁数据列表

								<i class="icon-angle-right"></i>

							</li>

							<li>桥梁数据查看</li>

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

								<div class="caption"><i class="icon-reorder"></i>桥梁数据查看</div>

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
												         <th width='100'>桥梁名称</th>
												         <td class="alert alert-info" width='100'><s:property value="%{#request.base1.bridge_name}"/></td>
												         <th width='100'>路线号</th>
												         <td class="alert alert-info" width='100'><s:property value="%{#request.base1.path_num}"/></td>
												      </tr>
												      
												      <tr>
												         <th>路线名称</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.path_name}"/></td>
												         <th>路线类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.path_type}"/></td>
												      </tr>
												      
												      <tr>
												         <th>公路技术等级</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.rode_grade}"/></td>
												         <th>顺序号</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.order_num}"/></td>
												      </tr>
												      
												      <tr>
												         <th>所在地</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.location}"/></td>
												         <th>中心桩号</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.center_stake}"/></td>
												      </tr>
												      
												      <tr>
												         <th>管养单位</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.custody_unit}"/></td>
												         <th>跨越地物名称</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.across_name}"/></td>
												      </tr>
												      
												      <tr>
												         <th>跨越地物类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.across_type}"/></td>
												         <th>桥梁性质</th>
												         <td class="alert alert-info"><s:property value="%{#request.base1.bridge_nature}"/></td>
												      </tr>
												      
												      <tr>
												      	 <td></td>
												      	 <td></td>
												      	 <td></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showBase1?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</button></td>
												      </tr>
												      
												      <tr>
												         <th>桥梁分类</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.bridge_classify}"/></td>
												         <th>设计荷载等级</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.design_load}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥梁用途</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.bridge_use}"/></td>
												         <th>桥梁状态</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.bridge_status}"/></td>
												      </tr>
												      
												      <tr>
												         <th>材料编码</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.material_code}"/></td>
												         <th>桥面板位</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.bridge_panel}"/></td>
												      </tr>
												      
												      <tr>
												         <th>受力形式</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.stress_pattern}"/></td>
												         <th>支座类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.support_type}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥型</th>
												         <td class="alert alert-info"><s:property value="%{#request.base2.bridge_type}"/></td>
												         <td></td>
												         <td class="alert alert-info"></td>
												      </tr>
												      
												      <tr>
												      	 <td></td>
												      	 <td></td>
												      	 <td></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showBase2?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</button></td>
												      </tr>
												      
												      <tr>
												         <th>桥墩材料</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.pier_material}"/></td>
												         <th>桥墩截面形式</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.section_form}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥墩类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.pier_type}"/></td>
												         <th>桥墩截面形状</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.section_shape}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥台材料</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.abutment_material}"/></td>
												         <th>桥台类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.abutment_type}"/></td>
												      </tr>
												      
												      <tr>
												         <th>墩台基础材料</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.pier_abutment_material}"/></td>
												         <th>墩台基础</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.pier_abutment_base}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥面铺装材料</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.deck_type}"/></td>
												         <th>伸缩缝类型</th>
												         <td class="alert alert-info"><s:property value="%{#request.base3.joint_type}"/></td>
												      </tr>
												      
												      <tr>
												      	 <td></td>
												      	 <td></td>
												      	 <td></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showBase3?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</button></td>
												      </tr>
												      
												      <tr>
												         <th>桥跨组合</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.bridge_span}"/></td>
												         <th>最大跨径</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.longest_span}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥梁全长</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.total_len}"/></td>
												         <th>桥宽组合</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.bridge_wide}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥面全宽</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.full_wide}"/></td>
												         <th>桥面净宽</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.clear_wide}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥高</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.bridge_high}"/></td>
												         <th>桥梁限高</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.high_limit}"/></td>
												      </tr>
												      
												      <tr>
												         <th>建桥时间</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.building_time}"/></td>
												         <th>通航等级</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.navigation_level}"/></td>
												      </tr>
												      
												      <tr>
												         <th>跨中截面高</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.section_high}"/></td>
												         <th>桥面纵坡</th>
												         <td class="alert alert-info"><s:property value="%{#request.structure.deck_profile_grade}"/></td>
												      </tr>
												      
												      <tr>
												      	 <td></td>
												      	 <td></td>
												      	 <td></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showStructure?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</button></td>
												      </tr>
												      
												      <tr>
												         <th>翼墙、耳墙</th>
												         <td class="alert alert-info"><s:property value="%{#request.wing_wall}"/></td>
												         <th>锥坡</th>
												         <td class="alert alert-info"><s:property value="%{#request.conical_slope}"/></td>
												      </tr>
												      
												      <tr>
												         <th>护坡个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts1.protection_slope}"/></td>
												         <th>桥台个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts1.abutment_num}"/></td>
												      </tr>
												      
												      <tr>
												         <th>墩台基础个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts1.pa_num}"/></td>
												         <th>河床个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts1.bed_num}"/></td>
												      </tr>
												      
												      <tr>
												         <th>调治构造物个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts1.reg_structure}"/></td>
												         <td></td>
												         <td class="alert alert-info"></td>
												      </tr>
												      
												      <tr>
												         <th>桥墩详情</th>
												         <td class="alert alert-info"><s:property value="%{#request.pier_detail.pier_details}"/></td>
												         <th>桥墩编号</th>
												         <td class="alert alert-info"><s:property value="%{#request.pier_detail.pier_nums}"/></td>
												      </tr>
												      
												      <tr>
												         <th>盖梁号</th>
												         <td class="alert alert-info"><s:property value="%{#request.pier_detail.bent_cap_nums}"/></td>
												         <th>系梁号</th>
												         <td class="alert alert-info"><s:property value="%{#request.pier_detail.tie_beam_nums}"/></td>
												      </tr>
												      
												      <tr>
												      	 <td></td>
												      	 <td></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showPierDetail?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改桥墩信息</button></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showParts1?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</button></td>
												      </tr>
												      
												      <tr>
												         <th>上部承重构件详情</th>
												         <td class="alert alert-info"><s:property value="%{#request.load_detail.load_details}"/></td>
												         <th>上部承重构件编号</th>
												         <td class="alert alert-info"><s:property value="%{#request.load_detail.load_nums}"/></td>
												      </tr>
												      
												      <tr>
												         <th>上部一般构件详情</th>
												         <td class="alert alert-info"><s:property value="%{#request.general_detail.general_details}"/></td>
												         <th>上部一般构件编号</th>
												         <td class="alert alert-info"><s:property value="%{#request.general_detail.general_nums}"/></td>
												      </tr>
												      
												      <tr>
												         <th>支座详情</th>
												         <td class="alert alert-info"><s:property value="%{#request.support_detail.support_details}"/></td>
												         <th>支座编号</th>
												         <td class="alert alert-info"><s:property value="%{#request.support_detail.support_nums}"/></td>
												      </tr>
												      
												      <tr>
												         <th>桥面铺装个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts2.deck_num}"/></td>
												         <th>伸缩缝装置个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts2.joint_num}"/></td>
												      </tr>
												      
												      <tr>
												         <th>人行道</th>
												         <td class="alert alert-info"><s:property value="%{#request.sidewalk}"/></td>
												         <th>栏杆、护栏</th>
												         <td class="alert alert-info"><s:property value="%{#request.guardrail}"/></td>
												      </tr>
												      
												      <tr>
												         <th>防排水系统个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts2.drainage_system}"/></td>
												         <th>照明、标志个数</th>
												         <td class="alert alert-info"><s:property value="%{#request.parts2.illuminated_sign}"/></td>
												      </tr>
												      
												      <tr>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showLoadDetail?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改上部承重构件信息</button></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showGeneralDetail?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改上部一般构件信息</button></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showSupportDetail?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改支座信息</button></td>
												      	 <td><button class="btn blue" onclick="loadPage('/BridgeServer/bridge!showParts2?bridgeCode=<s:property value="%{#request.base1.bridge_code}"/>');"><i class="m-icon-swapright m-icon-white"></i> 修改</button></td>
												      </tr>
												      
													</tbody>
												</table>

												<div>
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/bridge!getBaseList');">返回</a>
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
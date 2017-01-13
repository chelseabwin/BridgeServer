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

							桥梁数据管理

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								资料管理

								<i class="icon-angle-right"></i>

							</li>

							<li>

								桥梁数据管理

								<i class="icon-angle-right"></i>

							</li>

							<li>桥梁数据添加/修改</li>

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

								<div class="caption"><i class="icon-reorder"></i>桥梁数据添加/修改</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">
							
								<div class="control-group">

									<button class="btn blue" data-toggle="modal" data-target="#myModal">批量添加</button>
									
									<button type="button" class="btn red" onclick="deleteAll()">清除所有桥墩信息</button>
		
								</div>
								
								<!-- 模态框（Modal） -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
												<h4 class="modal-title" id="myModalLabel">
													新建桥墩信息
												</h4>
											</div>
											
											<div class="modal-body">
											
											<form id="modal_form" action="" class="form-horizontal" method="post">
												
												<div class="control-group">

													<label class="control-label">起始桥墩号</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="startPier" id="startPierId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">终止桥墩号</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="endPier" id="endPierId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">每个桥墩墩身数</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="perPierNum" id="perPierNumId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">是否有盖梁</label>

													<div class="controls">
													
													    <label class="checkbox">
													    	<input type="checkbox" id="hasBentCap" name="hasBentCap" value="1">
													    </label>
													    
													</div>
													
												</div>
												
												<div class="control-group">

													<label class="control-label">是否有系梁</label>

													<div class="controls">
													
													    <label class="checkbox">
													    	<input type="checkbox" id="hasTieBeam" name="hasTieBeam" value="1">
													    </label>
													    
													</div>
													
												</div>
												
											</form>
												
											</div>
											
											<div class="modal-footer">
											    <input type="button" class="btn green" value="提交" onclick="updateModal()" />
												<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
											</div>
										</div><!-- /.modal-content -->
									</div><!-- /.modal -->
								</div>

								<!-- BEGIN FORM-->

								<form id="update_form" action="" class="form-horizontal" method="post">
								<input type="hidden" name="id" value="<s:property value="#request.id"/>">
												
												<div class="control-group">

													<label class="control-label">桥墩详情</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:400px;" rows="5" name="pierDetails" id="pierDetailsId"><s:property value="#request.pier_details"/></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">桥墩编号</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:400px;" rows="5" name="pierNums" id="pierNumsId"><s:property value="#request.pier_nums"/></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">盖梁号</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:400px;" rows="5" name="bentCapNums" id="bentCapNumsId"><s:property value="#request.bent_cap_nums"/></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">系梁号</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:400px;" rows="5" name="tieBeamNums" id="tieBeamNumsId"><s:property value="#request.tie_beam_nums"/></textarea>

													</div>

												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changePierDetail?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
													<a href="#" class="btn" onclick="loadPage('/BridgeServer/bridge!viewBridge?bridgeCode=<s:property value="#request.bg_id"/>');">取消</a>

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
	$.axs(url, $("#update_form").serializeArray(), function(data){
		$("#page_content").html(data);
    });
};

function updateModal() {
	var start_pier = $("input[name='startPier']").val();
	var end_pier = $("input[name='endPier']").val();
	var per_pier_num = $("input[name='perPierNum']").val();
	var has_bent_cap = $('#hasBentCap').is(':checked');
	var has_tie_beam = $('#hasTieBeam').is(':checked');
    
    var bc = (has_bent_cap == true)?"有盖梁，":"无盖梁，";
	var tb = (has_tie_beam == true)?"有系梁\n":"无系梁\n";
    
    var pier_details = "从" + start_pier + "墩到" + end_pier + "墩，每墩" + per_pier_num + "个墩身，" + bc + tb;
    var pier_nums = "";
    var bent_cap_nums = "";
    var tie_beam_nums = "";
    
    for (var i = parseInt(start_pier); i <= parseInt(end_pier); i++) {
		for (var j = 1; j <= parseInt(per_pier_num); j++) {
			pier_nums += i + "-" + j + "; "; // 设置桥墩编号                    			
		}
		pier_nums += "\n";
		
		if (has_bent_cap == true) {
			bent_cap_nums += i + ", "; // 设置盖梁编号
		}
		
		if (has_tie_beam == true) {
			tie_beam_nums += i + ", "; // 设置系梁编号
		}
	}
	
	// 写入文本框
	var old_pier_details = $("textarea[name='pierDetails']").val();
	var old_pier_nums = $("textarea[name='pierNums']").val();
	var old_bent_cap_nums = $("textarea[name='bentCapNums']").val();
	var old_tie_beam_nums = $("textarea[name='tieBeamNums']").val();
	
	$("#pierDetailsId").val(old_pier_details + pier_details);
	$("#pierNumsId").val(old_pier_nums + pier_nums);
	$("#bentCapNumsId").val(old_bent_cap_nums + bent_cap_nums);
	$("#tieBeamNumsId").val(old_tie_beam_nums + tie_beam_nums);
	
	// 关闭dialog
	$("#startPierId").val("");
	$("#endPierId").val("");
	$("#perPierNumId").val("");
	$("#hasBentCap").prop("checked",false);
	$("#hasTieBeam").prop("checked",false);
	$("#myModal").modal('hide');
}

function deleteAll() {
	$("#pierDetailsId").val("");
	$("#pierNumsId").val("");
	$("#bentCapNumsId").val("");
	$("#tieBeamNumsId").val("");
}

</script>
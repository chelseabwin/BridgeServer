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
									
									<button type="button" class="btn red" onclick="deleteAll()">清除所有上部承重构件信息</button>
		
								</div>
								
								<!-- 模态框（Modal） -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
												<h4 class="modal-title" id="myModalLabel">
													新建上部承重构件信息
												</h4>
											</div>
											
											<div class="modal-body">
											
											<form id="modal_form" action="" class="form-horizontal" method="post">
												
												<div class="control-group">

													<label class="control-label">起始跨号</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="startLoad" id="startLoadId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">终止跨号</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="endLoad" id="endLoadId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">每跨个数</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="perLoadNum" id="perLoadNumId"/>
			
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

													<label class="control-label">上部承重构件详情</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:400px;" rows="5" name="loadDetails" id="loadDetailsId"><s:property value="#request.load_details"/></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">上部承重构件编号</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:400px;" rows="5" name="loadNums" id="loadNumsId"><s:property value="#request.load_nums"/></textarea>

													</div>

												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeLoadDetail?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
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
	var start_load = $("input[name='startLoad']").val();
	var end_load = $("input[name='endLoad']").val();
	var per_load_num = $("input[name='perLoadNum']").val();
	
	var load_details = "从" + start_load + "跨到" + end_load + "跨，每跨" + per_load_num + "个\n";
    var load_nums = "";
    
    for (var i = parseInt(start_load); i <= parseInt(end_load); i++) {
		for (var j = 1; j <= parseInt(per_load_num); j++) {
			load_nums += i + "-" + j + "; "; // 设置桥跨编号                    			
		}
		load_nums += "\n";
	}
	
	// 写入文本框
	var old_load_details = $("textarea[name='loadDetails']").val();
	var old_load_nums = $("textarea[name='loadNums']").val();
	
	$("#loadDetailsId").val(old_load_details + load_details);
	$("#loadNumsId").val(old_load_nums + load_nums);
	
	// 关闭dialog
	$("#startLoadId").val("");
	$("#endLoadId").val("");
	$("#perLoadNumId").val("");
	$("#myModal").modal('hide');
}

function deleteAll() {
	$("#loadDetailsId").val("");
	$("#loadNumsId").val("");
}

</script>
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
									
									<button type="button" class="btn red" onclick="deleteAll()">清除所有支座信息</button>
		
								</div>
								
								<!-- 模态框（Modal） -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
												<h4 class="modal-title" id="myModalLabel">
													新建支座信息
												</h4>
											</div>
											
											<div class="modal-body">
											
											<form id="modal_form" action="" class="form-horizontal" method="post">
												
												<div class="control-group">

													<label class="control-label">起始墩（台）号</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="startSupport" id="startSupportId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">终止墩（台）号</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="endSupport" id="endSupportId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">每墩（台）排数</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="perRowNum" id="perRowNumId"/>
			
													</div>
			
												</div>
												
												<div class="control-group">

													<label class="control-label">每排支座数</label>
			
													<div class="controls">   
			
														<input class="m-wrap medium" type="text" name="perSupportNum" id="perSupportNumId"/>
			
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

													<label class="control-label">支座详情</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:400px;" rows="5" name="supportDetails" id="supportDetailsId"><s:property value="#request.support_details"/></textarea>

													</div>

												</div>
												
												<div class="control-group">

													<label class="control-label">支座编号</label>

													<div class="controls">
													
														<textarea class="form-control" style="width:500px;" rows="5" name="supportNums" id="supportNumsId"><s:property value="#request.support_nums"/></textarea>

													</div>

												</div>

												<div class="form-actions">
												
													<a href="#" class="btn blue" onclick="submitData('/BridgeServer/bridge!changeSupportDetail?bridgeCode=<s:property value="#request.bg_id"/>');"><i class="icon-ok"></i> 保存</a>
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
	var start_support = $("input[name='startSupport']").val();
	var end_support = $("input[name='endSupport']").val();
	var per_row_num = $("input[name='perRowNum']").val();
	var per_support_num = $("input[name='perSupportNum']").val();
	
	var support_details = "从" + start_support + "墩台到" + end_support + "墩台，每墩台" + per_row_num + "排，每排" + per_support_num + "个\n";
    var support_nums = "";
    
    for (var i = parseInt(start_support); i <= parseInt(end_support); i++) {
		for (var j = 1; j <= parseInt(per_row_num); j++) {
			for (var k = 1; k <= parseInt(per_support_num); k++) {
				support_nums += i + "-" + j + "-" + k + "; "; // 设置支座编号
			}		            					
		}
		support_nums += "\n";
	}
	
	// 写入文本框
	var old_support_details = $("textarea[name='supportDetails']").val();
	var old_support_nums = $("textarea[name='supportNums']").val();
	
	$("#supportDetailsId").val(old_support_details + support_details);
	$("#supportNumsId").val(old_support_nums + support_nums);
	
	// 关闭dialog
	$("#startSupportId").val("");
	$("#endSupportId").val("");
	$("#perRowNumId").val("");
	$("#perSupportNumId").val("");
	$("#myModal").modal('hide');
}

function deleteAll() {
	$("#supportDetailsId").val("");
	$("#supportNumsId").val("");
}

</script>
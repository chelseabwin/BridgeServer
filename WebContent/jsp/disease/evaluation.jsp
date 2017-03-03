<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="media/css/chosen.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="media/css/datepicker.css" />
<link href="/BridgeServer/media/css/jquery.fancybox.css" rel="stylesheet" />
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

								<div class="caption"><i class="icon-reorder"></i><s:property value="%{#request.bg_name}"/> 病害打分</div>

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
									<input name="pageNo" id="pageNo" type="hidden" value="1"/>
									<div id="table_data">
									
									</div>	

									<div>
										<a href="#" class="btn blue" onclick="submitData('/BridgeServer/disease!saveEvaluation');"><i class="icon-ok"></i> 保存</a>
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
			
			<script type="text/javascript" src="/BridgeServer/media/js/select2.min.js"></script>

			<script type="text/javascript" src="/BridgeServer/media/js/jquery.dataTables.js"></script>
		
			<script type="text/javascript" src="/BridgeServer/media/js/DT_bootstrap.js"></script>
			
			<script type="text/javascript" src="/BridgeServer/media/js/chosen.jquery.min.js"></script>
			
			<script type="text/javascript" src="/BridgeServer/media/js/bootstrap-datepicker.js"></script>
			
			<script src="/BridgeServer/media/js/gallery.js"></script>  
			
			<script src="/BridgeServer/media/js/table-managed.js"></script>
			<script src="/BridgeServer/media/js/ui-general.js"></script> 
		
			<script type="text/javascript" src="/BridgeServer/media/js/jquery.bootpag.min.js"></script>
			<div id="image_fancybox"></div>
<script>
var str = "<s:property value="#request.evalstr"/>";
var arr = str.split(",");
for(var j = 0; j < arr.length; j++) {
	$("#" + arr[j].split(":")[0]).val(arr[j].split(":")[1]);
}	
	
function submitData(url){
	var selects = $("select");
	var results = [];
	
	for(var i = 0; i < selects.length; i++) {
		var select = selects[i];
		
		results.push($(select).attr("id") + ":" + $(select).val());
	}
	
	$.ajax({
        url:url,
        type:"post",
        data:{"table_name": "<s:property value="table_name"/>",
        	  "bg_id": "<s:property value="bg_id"/>",
        	  "evaluation_val" : results.join(",")},
        dataType : "json",
        success:function(data){
        	loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&bg_name=<s:property value="bg_name"/>');
        },
     	error: function (msg) {
            alert("病害打分失败！");
            loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&bg_name=<s:property value="bg_name"/>');
        }
    });
};

function resetQuery(){
	$("#pageNo").val("1");
	getInformation('/BridgeServer/disease!showEvaluationTable?table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&item_name=<s:property value="item_name"/>&bg_name=<s:property value="bg_name"/>');
};

function getInformation(url){
	$("#table_data").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");
	$.axs(url, $("#evaluation_form").serializeArray(), function(data){
		$("#table_data").html(data);
    });
};

function loadTable(url){
	$("#table_data").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");
	$.axs(url, null, function(data){
		$("#table_data").html(data);
    });
};

loadTable('/BridgeServer/disease!showEvaluationTable?table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&item_name=<s:property value="item_name"/>&bg_name=<s:property value="bg_name"/>');
</script>
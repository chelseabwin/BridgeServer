<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%><%@ taglib prefix="s" uri="/struts-tags" %><link href="media/css/chosen.css" rel="stylesheet" type="text/css"/><link rel="stylesheet" type="text/css" href="media/css/datepicker.css" /><link href="/BridgeServer/media/css/jquery.fancybox.css" rel="stylesheet" /><div class="container-fluid">				<!-- BEGIN PAGE HEADER-->				<div class="row-fluid">					<div class="span12">						<!-- BEGIN STYLE CUSTOMIZER -->						<!-- END BEGIN STYLE CUSTOMIZER -->  						<!-- BEGIN PAGE TITLE & BREADCRUMB-->						<h3 class="page-title">							资料管理						</h3>						<ul class="breadcrumb">							<li>								<i class="icon-home"></i>								资料管理								<i class="icon-angle-right"></i>							</li>							<li>								病害数据列表							</li>						</ul>						<!-- END PAGE TITLE & BREADCRUMB-->					</div>				</div>				<!-- END PAGE HEADER-->				<!-- BEGIN PAGE CONTENT-->				<div class="row-fluid">					<div class="span12">						<!-- BEGIN EXAMPLE TABLE PORTLET-->						<div class="portlet box light-grey">							<div class="portlet-title">								<div class="caption"><i class="icon-globe"></i><s:property value="%{#request.bg_name}"/> 病害数据列表</div>								<div class="tools">									<a href="javascript:;" class="collapse"></a>								</div>							</div>							<div class="portlet-body">															<div id="table_data">									<table class="table table-striped table-bordered table-hover" id="sample_1">										<thead>																				<tr>																					<th>部件名称</th>																					<th>病害数量</th>																								<th>操作</th>																								<th>部件名称</th>																					<th>病害数量</th>																								<th>操作</th>																				</tr>																			</thead>																			<tbody>																						<s:iterator value="%{#request.datalist}" id="data" status="status">																						<s:if test="#status.index % 4 == 0">											<tr class="odd gradeX">											</s:if>																					<td><s:property value="item_name"/></td>																					<td><s:property value="disease_count"/></td>																								<td>												<button class="btn green" onclick="loadPage('/BridgeServer/disease!getBaseDiseaseList?table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&bg_name=<s:property value="%{#request.bg_name}"/>');"><i class="m-icon-swapright m-icon-white"></i> 查看病害信息</button>												</td>																							<s:if test="#status.index % 4 == 1 || #status.last">											</tr>											</s:if>																						</s:iterator>																			</tbody>																		</table>																		<div>										<a href="#" class="btn" onclick="loadPage('/BridgeServer/disease!getBaseList');">返回</a>									</div>								</div>															</div>						</div>						<!-- END EXAMPLE TABLE PORTLET-->					</div>				</div>								<!-- END PAGE CONTENT-->			</div>			<script type="text/javascript" src="/BridgeServer/media/js/select2.min.js"></script>			<script type="text/javascript" src="/BridgeServer/media/js/jquery.dataTables.js"></script>					<script type="text/javascript" src="/BridgeServer/media/js/DT_bootstrap.js"></script>						<script type="text/javascript" src="/BridgeServer/media/js/chosen.jquery.min.js"></script>						<script type="text/javascript" src="/BridgeServer/media/js/bootstrap-datepicker.js"></script>						<script src="/BridgeServer/media/js/gallery.js"></script>  						<script src="/BridgeServer/media/js/table-managed.js"></script>			<script src="/BridgeServer/media/js/ui-general.js"></script> 					<script type="text/javascript" src="/BridgeServer/media/js/jquery.bootpag.min.js"></script>			<div id="image_fancybox"></div>			<script>		        function resetQuery(){		        	$("#pageNo").val("1");		        	getInformation('/BridgeServer/disease!getlist');		        };		        function getInformation(url){		        	$("#table_data").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");	    			$.axs(url, $("#data_query").serializeArray(), function(data){	    				$("#table_data").html(data);	                });		        };		        function loadTable(url){					$("#table_data").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");					$.axs(url, null, function(data){						$("#table_data").html(data);		            });				};								<script>				var test = $("input[type=checkbox]:not(.toggle), input[type=radio]:not(.toggle, .star)");				if (test.size() > 0) {				    test.each(function () {				            if ($(this).parents(".checker").size() == 0) {				                $(this).show();				                $(this).uniform();				            }				        });				};				jQuery('#sample_1 .group-checkable').change(function () {				    var set = jQuery(this).attr("data-set");				    var checked = jQuery(this).is(":checked");				    jQuery(set).each(function () {				        if (checked) {				            $(this).attr("checked", true);				        } else {				            $(this).attr("checked", false);				        }				    });				    jQuery.uniform.update(set);				});				var totalNumber = parseInt("<s:property value="#request.count"/>");				var pageNumber = parseInt("<s:property value="#request.totalPageNumber"/>");				var pageCur = parseInt("<s:property value="#request.pageCur"/>");				jQuery("#table_current").html("记录总数:"+totalNumber);					$('#page_info').bootpag({					    total: pageNumber,					    page: pageCur,					    maxVisible: 6 					}).on('page', function(event, num){						$("#pageNo").val(num);						getInformation('/BridgeServer/disease!getlist');					});												loadTable("/BridgeServer/disease!showDisease");			</script>			
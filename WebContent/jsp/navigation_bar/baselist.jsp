<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%><%@ taglib prefix="s" uri="/struts-tags" %><link href="media/css/chosen.css" rel="stylesheet" type="text/css"/><link rel="stylesheet" type="text/css" href="media/css/datepicker.css" /><link href="/BridgeServer/media/css/jquery.fancybox.css" rel="stylesheet" /><div class="container-fluid">				<!-- BEGIN PAGE HEADER-->				<div class="row-fluid">					<div class="span12">						<!-- BEGIN STYLE CUSTOMIZER -->						<!-- END BEGIN STYLE CUSTOMIZER -->  						<!-- BEGIN PAGE TITLE & BREADCRUMB-->						<h3 class="page-title">							导航栏管理						</h3>						<ul class="breadcrumb">							<li>								<i class="icon-home"></i>								系统设置								<i class="icon-angle-right"></i>							</li>							<li>								导航栏管理								<i class="icon-angle-right"></i>							</li>							<li>导航栏列表</li>						</ul>						<!-- END PAGE TITLE & BREADCRUMB-->					</div>				</div>				<!-- END PAGE HEADER-->				<!-- BEGIN PAGE CONTENT-->				<div class="row-fluid">					<div class="span12">						<!-- BEGIN EXAMPLE TABLE PORTLET-->						<div class="portlet box light-grey">							<div class="portlet-title">								<div class="caption"><i class="icon-globe"></i>导航栏列表</div>								<div class="tools">									<a href="javascript:;" class="collapse"></a>									<a href="#portlet-config" data-toggle="modal" class="config"></a>									<a href="javascript:;" class="reload"></a>									<a href="javascript:;" class="remove"></a>								</div>							</div>							<div class="portlet-body">								<div id="table_data">																</div>															</div>						</div>						<!-- END EXAMPLE TABLE PORTLET-->					</div>				</div>								<!-- END PAGE CONTENT-->			</div>			<script type="text/javascript" src="/BridgeServer/media/js/select2.min.js"></script>	<script type="text/javascript" src="/BridgeServer/media/js/jquery.dataTables.js"></script>	<script type="text/javascript" src="/BridgeServer/media/js/DT_bootstrap.js"></script>		<script type="text/javascript" src="/BridgeServer/media/js/chosen.jquery.min.js"></script>		<script type="text/javascript" src="/BridgeServer/media/js/bootstrap-datepicker.js"></script>		<script src="/BridgeServer/media/js/gallery.js"></script>  		<script src="/BridgeServer/media/js/table-managed.js"></script>	<script src="/BridgeServer/media/js/ui-general.js"></script> 	<script type="text/javascript" src="/BridgeServer/media/js/jquery.bootpag.min.js"></script>	<div id="image_fancybox"></div>			<script>		        $(".chosen").each(function () {		            $(this).chosen({		                allow_single_deselect: $(this).attr("data-with-diselect") === "1" ? true : false		            });		        });		        function getInformation(url){		        	$("#table_data").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");	    			$.axs(url, $("#data_query").serializeArray(), function(data){	    				$("#table_data").html(data);	                });		        };		        if (jQuery().datepicker) {		            $('.date-picker').datepicker({		                rtl : App.isRTL()		            });		        };		        function loadTable(url){					$("#table_data").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");					$.axs(url, null, function(data){						$("#table_data").html(data);		            });				};								function deleteNavigation_bar(id){					$("#table_data").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");					$.axs("/BridgeServer/navigation_bar!deleteNavigation_bar?navigation_bar_id="+id, null, function(data){						$("#table_data").html(data);		            });				};												loadTable("/BridgeServer/navigation_bar!getlist");			</script>			
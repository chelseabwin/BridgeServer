<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%><%@ taglib prefix="s" uri="/struts-tags" %><!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 2.3.1
Version: 1.3
Author: KeenThemes
Website: http://www.keenthemes.com/preview/?theme=metronic
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>桥梁数据管理系统</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="/BridgeServer/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="/BridgeServer/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="/BridgeServer/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="/BridgeServer/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="/BridgeServer/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="/BridgeServer/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="/BridgeServer/media/image/favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<a class="brand" href="index.html">
			
				</a>
				<!-- END LOGO -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
				<img src="/BridgeServer/media/image/menu-toggler.png" alt="" />
				</a>          
				<!-- END RESPONSIVE MENU TOGGLER -->            
				<!-- BEGIN TOP NAVIGATION MENU -->              
				<ul class="nav pull-right">
					<!-- BEGIN NOTIFICATION DROPDOWN -->   
					
					<!-- END NOTIFICATION DROPDOWN -->
					<!-- BEGIN INBOX DROPDOWN -->
					
					<!-- END INBOX DROPDOWN -->
					<!-- BEGIN TODO DROPDOWN -->
					
					<!-- END TODO DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						
						<span class="username"><i class="icon-user"></i> 欢迎：<s:property value="%{#session.userName}"/></span>
						<i class="icon-angle-down"></i>
						</a>
						<ul class="dropdown-menu">													<li><a href="#" onclick="loadPage('/BridgeServer/user!changeMyPwd');"><i class="icon-lock"></i> 更改密码</a></li>
							<li><a href="/BridgeServer/user!logout"><i class="icon-key"></i> 注销</a></li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
				<!-- END TOP NAVIGATION MENU --> 
			</div>
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->        
			<ul class="page-sidebar-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li>
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
					<form class="sidebar-search">
						<div class="input-box"><!--
							<a href="javascript:;" class="remove"></a>
							<input type="text" placeholder="Search..." />
							<input type="button" class="submit" value=" " /> -->
						</div>
					</form>
					<!-- END RESPONSIVE QUICK SEARCH FORM -->
				</li>
				<li class="start active ">
					<a href="#">
					<i class="icon-home"></i> 
					<span class="title">导航栏</span>
					<span class="selected"></span>
					</a>
				</li>								<s:iterator value="#request.navigationLevel1" id="navigation1">
				<li class="test">
					<a href="javascript:;">
					<i class="icon-cogs"></i> 
					<span class="title"><s:property value="name"/></span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">						<s:set name="uplevel" value="navigation_bar_id"/>						<s:iterator value="#request.navigationLevel2" id="navigation2">						<s:set name="nowlevel" value="up"/>							<s:if test="#uplevel == #nowlevel">
							<li id="active<s:property value="navigation_bar_id"/>" title="active" onclick="active(<s:property value="navigation_bar_id"/>);">
								<a href="#" onclick="loadPage('<s:property value="url"/>');">	
								<s:property value="name"/></a>	
							</li>							</s:if>						</s:iterator>
					</ul>
				</li>				</s:iterator>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div id="page_content" class="page-content">
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		<div class="footer-inner">
			2016 &copy; 山西省交通科学研究院 - 桥梁检测所
		</div>
		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>
	</div>		<div id="deleteModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="deleteModal" aria-hidden="true">		<div class="modal-header">			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>			<h3 id="myModalLabel3">删除</h3>		</div>		<div class="modal-body">			<p>确认删除？</p>		</div>		<div class="modal-footer">			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>			<a id="deleteButton" href="#" data-dismiss="modal" onclick="" class="btn black"><i class="icon-trash"></i> 确认</a>					</div>	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="/BridgeServer/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="/BridgeServer/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="/BridgeServer/media/js/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
	<script src="/BridgeServer/media/js/excanvas.min.js"></script>
	<script src="/BridgeServer/media/js/respond.min.js"></script>  
	<![endif]-->   
	<script src="/BridgeServer/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="/BridgeServer/media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="/BridgeServer/media/js/jquery.vmap.js" type="text/javascript"></script>   
	<script src="/BridgeServer/media/js/jquery.vmap.russia.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.vmap.world.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.vmap.europe.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.vmap.germany.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.vmap.usa.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  
	<script src="/BridgeServer/media/js/jquery.flot.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.flot.resize.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.pulsate.min.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/date.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/daterangepicker.js" type="text/javascript"></script>     
	<script src="/BridgeServer/media/js/jquery.gritter.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/fullcalendar.min.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>
	<script src="/BridgeServer/media/js/jquery.sparkline.min.js" type="text/javascript"></script>  
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="/BridgeServer/media/js/app.js" type="text/javascript"></script>		<script src="/BridgeServer/media/js/ajax.js" type="text/javascript"></script>      		<script src="/BridgeServer/media/js/jquery.fancybox.pack.js"></script>   		<script type="text/javascript" src="media/js/bootstrap-fileupload.js"></script>
	<!-- END PAGE LEVEL SCRIPTS -->  
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		   Index.init();
		   Index.initJQVMAP(); // init index page's custom scripts
		   Index.initCalendar(); // init index page's custom scripts
		   Index.initCharts(); // init index page's custom scripts
		   Index.initChat();
		   Index.initMiniCharts();
		   Index.initDashboardDaterange();
		   Index.initIntro();		   		   Gallery.init();
		});				function loadPage(url){			$("#page_content").html("<img src=\"/BridgeServer/media/image/ajax-loading.gif\"/>");			$.axs(url, null, function(data){				$("#page_content").html(data);            });		};		function active(id){			$("li[title='active']").attr("class", " ");			$("#active"+id).attr("class", "active");		};
	</script>
	<!-- END JAVASCRIPTS -->
<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>
<!-- END BODY -->
</html>
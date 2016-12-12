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
								
									<table class="table table-bordered">
										<tbody>
										
										  <tr>
									         <th class="alert alert-info" width='100'>部件详情</th>
									         <th class="alert alert-info" width='100'>部件病害照片</th>
									         <th class="alert alert-info" width='100'>指标标度类别</th>
									      </tr>
										
										<s:iterator value="%{#request.datalist}" id="data">
									      <tr>
									         <td width='200'>
										         <s:property value="parts_id"/>#<s:property value="item_name"/><br>
										         <s:if test="%{#data.rg_feature=='其他病害' && #data.sp_otherDisease!=null}">
													<s:property value="sp_otherDisease"/>
												 </s:if>
												 <s:else>
													<s:property value="rg_feature"/>
												 </s:else>
												 <br><s:property value="add_content"/>
									         </td>
									         <td width='300'>												         
									         	 <s:if test="#data.img_name!=null"><img src="/BridgeServer/disease_image/<s:property value="img_name"/>" width="400" height="300" /></s:if>
									         </td>
									         <td width='200'>
									         <s:if test='#data.eval_peak=="3"'>
									         	<select id="<s:property value='id'/>" class="form-control">
											      <option value ="1-0">1类</option>
											      <option value ="2-20">2类</option>
											      <option value ="3-35">3类</option>
											    </select>
											 </s:if>
											 
											 <s:elseif test='#data.eval_peak=="4"'>
											 	<select id="<s:property value='id'/>" class="form-control">
											      <option value ="1-0">1类</option>
											      <option value ="2-25">2类</option>
											      <option value ="3-40">3类</option>
											      <option value ="4-50">4类</option>
											    </select>
											 </s:elseif>
											 
											 <s:else>
											 	<select id="<s:property value='id'/>" class="form-control">
											      <option value ="1-0">1类</option>
											      <option value ="2-35">2类</option>
											      <option value ="3-45">3类</option>
											      <option value ="4-60">4类</option>
											      <option value ="5-100">5类</option>
											    </select>
											 </s:else>
									         </td>
									      </tr>
									    </s:iterator>
									    
										</tbody>
									</table>

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
</script>
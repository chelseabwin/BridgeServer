<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table class="table table-striped table-bordered table-hover" id="sample_1">

	<thead>

		<tr>

			<th>桥梁名称</th>

			<th>病害数量</th>
			
			<th>操作</th>

		</tr>

	</thead>

	<tbody>
		
		<s:iterator value="%{#request.datalist}" id="data">
		
		<tr class="odd gradeX">

			<td><s:property value="bridge_name"/></td>

			<td><s:property value="disease_count"/></td>
			
			<td>
			<button class="btn green" onclick="loadPage('/BridgeServer/disease!showDisease?bg_id=<s:property value="bridge_code"/>');"><i class="m-icon-swapright m-icon-white"></i> 查看详情</button>
			<a href="#" onclick="doCreateReport('/BridgeServer/disease!createReport?bg_id=<s:property value="bridge_code"/>');" class="btn blue"><i class="m-icon-swapright m-icon-white"></i> 生成病害报告</a>
			<button class="btn blue" onclick="loadPage('/BridgeServer/disease!getAllMember?bg_id=<s:property value="bridge_code"/>');"><i class="m-icon-swapright m-icon-white"></i> 查看打分结果</button>
			</td>
		</tr>
		
		</s:iterator>

	</tbody>

</table>
</div>
<div class="row-fluid">
	<div class="span6">
		<div id="table_current">
		
		</div>
	</div>
	<div class="span6">
		<p id="page_info" class="pagination pull-right"></p>
	</div>
	</div>

<script>
function doCreateReport(url) {
	$.ajax({
         url: url,
         type: 'GET',
         data: null,
         async: false,
         cache: false,
         contentType: false,
         processData: false,
         success: function (data) {
        	 if (data == "faild") {
        		 alert("生成报告失败！");
        	 }
        	 else {
        		 location.href = "/BridgeServer/wordDownload/" + data;
        	 }
         }
    });
}

var test = $("input[type=checkbox]:not(.toggle), input[type=radio]:not(.toggle, .star)");
if (test.size() > 0) {
    test.each(function () {
            if ($(this).parents(".checker").size() == 0) {
                $(this).show();
                $(this).uniform();
            }
        });
};
jQuery('#sample_1 .group-checkable').change(function () {
    var set = jQuery(this).attr("data-set");
    var checked = jQuery(this).is(":checked");
    jQuery(set).each(function () {
        if (checked) {
            $(this).attr("checked", true);
        } else {
            $(this).attr("checked", false);
        }
    });
    jQuery.uniform.update(set);
});
var totalNumber = parseInt("<s:property value="#request.count"/>");
var pageNumber = parseInt("<s:property value="#request.totalPageNumber"/>");
var pageCur = parseInt("<s:property value="#request.pageCur"/>");
jQuery("#table_current").html("记录总数:"+totalNumber);
$('#page_info').bootpag({
    total: pageNumber,
    page: pageCur,
    maxVisible: 6 
}).on('page', function(event, num){
	$("#pageNo").val(num);
	getInformation('/BridgeServer/disease!getlist');
});

</script>
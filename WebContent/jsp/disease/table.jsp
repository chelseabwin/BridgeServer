<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table class="table table-striped table-bordered table-hover" id="sample_1">

	<thead>

		<tr>

			<th>桥梁名称</th>

			<th>部件名称</th>

			<th>部件编号</th>

			<th>病害类型</th>
			
			<th>病害描述</th>
			
			<th>操作</th>

		</tr>

	</thead>

	<tbody>
		
		<s:iterator value="%{#request.datalist}" id="data">
		
		<tr class="odd gradeX">

			<td><s:property value="bg_name"/></td>

			<td><s:property value="item_name"/></td>

			<td><s:property value="parts_id"/></td>

			<td><s:property value="rg_feature"/></td>
			
			<td><s:property value="add_content"/></td>
			
			<td>
			<button class="btn green" onclick="loadPage('/BridgeServer/disease!viewDisease?table_name=<s:property value="table_name"/>&id=<s:property value="id"/>&bg_name=<s:property value="bg_name"/>');"><i class="m-icon-swapright m-icon-white"></i> 查看详情</button>
			<!--<a href="#" onclick="loadPage('/BridgeServer/bridge!update?id=<s:property value="id"/>');" class="btn blue"><i class="m-icon-swapright m-icon-white"></i> 修改</a>
			<a href="#" onclick="loadPage('/BridgeServer/bridge!delete?id=<s:property value="id"/>');" class="btn red"><i class="m-icon-swapright m-icon-white"></i> 删除</a>
			  -->
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
		getInformation('/BridgeServer/bridge!getlist');
	});

</script>
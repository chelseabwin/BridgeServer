<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table class="table table-striped table-bordered table-hover" id="sample_1">

	<thead>

		<tr>

			<th>导航栏权限名称</th>			
			<th>导航栏权限描述</th>
			<th>操作</th>

		</tr>

	</thead>

	<tbody>
		
		<s:iterator value="%{#request.datalist}" id="data">
		
		<tr class="odd gradeX">

			<!-- <td><input type="checkbox" class="checkboxes" value="1" /></td>-->
			<td><s:property value="permission_name"/></td>
			<td ><s:property value="permission_note"/></td>
			<td ><a href="#deleteModal" data-toggle="modal" onclick="del(<s:property value="permission_id"/>);" class="btn mini black"><i class="icon-trash"></i> &nbsp;删除</a></td>
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
function del(id){
	jQuery("#deleteButton").attr("onclick","deletePermission("+ id+");");
};
if (jQuery(".fancybox-button").size() > 0) {
    jQuery(".fancybox-button").fancybox({
        groupAttr: 'data-rel',
        prevEffect: 'none',
        nextEffect: 'none',
        closeBtn: true,
        helpers: {
            title: {
                type: 'inside'
            }
        }
    });
};
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
		getInformation('/BridgeServer/permission!getlist');
	});

</script>
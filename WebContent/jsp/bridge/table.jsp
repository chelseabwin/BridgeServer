<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table class="table table-striped table-bordered table-hover" id="sample_1">

	<thead>

		<tr>

			<th>桥梁名称</th>

			<th>路线号</th>

			<th>路线名称</th>

			<th>路线类型</th>
			
			<th>所在地</th>			
			
			<th>管养单位</th>
			
			<th>操作</th>

		</tr>

	</thead>

	<tbody>
		
		<s:iterator value="%{#request.datalist}" id="data">
		
		<tr class="odd gradeX">

			<td><s:property value="bridge_name"/></td>

			<td><s:property value="path_num"/></td>

			<td><s:property value="path_name"/></td>

			<td><s:property value="path_type"/></td>
			
			<td><s:property value="location"/></td>
			
			<td><s:property value="custody_unit"/></td>
			<td>
			<button class="btn green" onclick="loadPage('/BridgeServer/bridge!viewBridge?bridgeCode=<s:property value="bridge_code"/>');"><i class="m-icon-swapright m-icon-white"></i> 查看详情</button>
			<a href="#" onclick="doCreateQRCode('/BridgeServer/bridge!createQRCode?bridgeCode=<s:property value="bridge_code"/>');" class="btn blue"><i class="m-icon-swapright m-icon-white"></i> 生成二维码</a>
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
	
<!-- Modal -->
<div class="modal hide fade" id="myModal" tabindex="-1" role="dialog">
	<div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
	<h3 id="myModalLabel">Modal header</h3>
</div>
<div class="modal-body"></div>
</div>
<script>

function doCreateQRCode(url) {
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
        		 alert("生成二维码失败！");
        	 }
        	 else {
        		 window.open("/BridgeServer/QRCodeDownload/" + data);
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
		getInformation('/BridgeServer/bridge!getlist');
	});

</script>
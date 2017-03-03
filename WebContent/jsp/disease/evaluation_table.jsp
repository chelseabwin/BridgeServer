<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table class="table table-striped table-bordered table-hover" id="sample_1">

	<thead>

		<tr>
	         <th class="alert alert-info" width='100'>部件详情</th>
	         
	         <th class="alert alert-info" width='100'>部件病害照片</th>
	         
	         <th class="alert alert-info" width='100'>指标标度类别</th>
	    </tr>

	</thead>

	<tbody>
		
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
var str = "<s:property value="#request.evalstr"/>";
var arr = str.split(",");
for(var j = 0; j < arr.length; j++) {
	$("#" + arr[j].split(":")[0]).val(arr[j].split(":")[1]);
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
		getInformation('/BridgeServer/disease!showEvaluationTable?table_name=<s:property value="table_name"/>&bg_id=<s:property value="bg_id"/>&item_name=<s:property value="%{#request.item_name}"/>&bg_name=<s:property value="%{#request.bg_name}"/>');
	});

</script>
$(document).ready(function(){
	$('#editReportForm')
	.on('click','#btn-return',back)
	.on('click','#btn-ok',dueWithReport)

});
function dueWithReport(){
	var flag=confirm("确定执行操作["+$("#due"+$("input[name='due']:checked").val()).text()+"]吗？");
	if(flag){
		var url="report/dueWithReport.do";	
		var params={
				"id":$("#titleId").val(),
				"dueType":$("input[name='due']:checked").val(),
				"opinion":$("#opinion").val()
		}
		$.post(url,params,function(result){
			if(result.state==1){
				alert("操作成功！");
				back();
			}else{
				alert(result.message);
			}
		})
	}
	return false;
}
function back(){
	$('.content').load('report/listUI.do');
}

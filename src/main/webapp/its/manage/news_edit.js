$(document).ready(function(){
	$('#editNewsForm')
	.on('click','input[name="type"]',changeType)
	.on('click','.btn-warning',back)
	.on('click','#btn-ok',doSaveNews);
	changeType();
	doGetNewsContent();
});
function doSaveNews(){	
	var doSave="news/doSaveNews.do";
	var update="news/doUpdateNews.do"
	var url=$("#titleId").val()==0?doSave:update;
	var params={
			"id":$("#titleId").val(),
			"title":$("#title").val(),
			"subTitle":$("#subTitle").val(),
			"type":$("input[name='type']:checked").val(),
			"newsType":$("input[name='newsType']:checked").val(),
			"link":$("#link").val(),
			"content":editor.txt.html()
	}
	$.post(url,params,function(result){
		if(result.state==1){
			alert("保存成功！");
			back();
		}else{
			alert(result.message)
		}
	})	
}
function back(){
	$('.content').load('news/listUI.do');
}
function changeType(){
	var type=$("input[name='type']:checked").val();
	if(type==1){
		$("#news_link").show();
		$("#editor").hide();
	}else{
		$("#news_link").hide();
		$("#editor").show();
	}
}
function doGetNewsContent(){
	if($("#titleId").val()!=0){
		var url="news/doGetNewsContent.do";
		var params={
				"id":$("#titleId").val()
		}
		$.post(url,params,function(result){
			if(result.state==1){
				editor.txt.html(result.data);
			}else{
				alert(result.message)
			}
		})	
	}
}
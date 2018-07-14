$(document).ready(function(){
	$('#reportFormHead')
	.on('click','.btn-search',doGetObjects)
	.on('click','.btn-examine',doLoadEditPage);
	doGetObjects();
});
function doGetObjects(){
	var url="report/doGetObjects.do";
	var params={
			"type":$("#searchTypeId").val(),
			"state":$("#searchValidId").val(),
			"pageNo":1
	}
	$.post(url,params,function(result){
//		console.log(JSON.stringify(result));
		if(result.state==1){
			var page=result.data.page;
			$("#Pagination").pagination({
				   currentPage:page.pageCurrent,// 当前页数
				   totalPage:result.data.pageCount,// 总页数
				   isShow: true,// 是否显示首尾页
				   count:page.pageSize,// 显示个数
				   homePageText: "首页",// 首页文本
				   endPageText: "尾页",// 尾页文本
				   prevPageText: "上一页",// 上一页文本
				   nextPageText: "下一页",// 下一页文本
				   callback: function(current) {
					   PageCallback(current);
				   }
				});	
			setReportObjects(result.data.report);
		}else if(result.state==0){
			alert("系统繁忙！");
		}
	})
	
}
//翻页调用  
function PageCallback(index, jq) {
	var url="report/doGetObjects.do";
	var params={
			"type":$("#searchTypeId").val(),
			"state":$("#searchValidId").val(),
			"pageNo":index
	}
	$.post(url,params,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setReportObjects(result.data.report);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
function doLoadEditPage(){
	var url="report/editUI.do?id="+$(this).val();
	$(".content").load(url);
}
function setReportObjects(report){
	//获得tbody对象(根据id获得)
	//在使用$函数获得某个id对应的对象一定要添加#
	var tBody=$("#tbodyId");
	//清空body中内容(假如方法不记得了怎么办)
	tBody.empty();//doc.tedu.cn
	//迭代json对象
	for(var i=0;i<report.length;i++){//循环一次取一行[{"name":"AAA",...},{},{}]
		//构建一个tr对象
		var tr=$("<tr></tr>");
		//在tr对象上绑定一个值
		var type=report[i].type==0? "0-用户":
					report[i].type==1? "1-话题":
						report[i].type==2? "2-资源" :"3-其它";
		tr.append("<td>"+type+"</td>");
		tr.append("<td>"+report[i].reason+"</td>");
		var state=report[i].state==0?"0-未处理":"1-已处理";
		tr.append("<td>"+state+"</td>");
		var opinion=report[i].opinion!=null ? report[i].opinion:"";
		tr.append("<td>"+opinion+"</td>");	
		tr.append("<td>" +
				"<button type='button' class='btn btn-warning btn-examine' value='"+report[i].id+"'>查看</button>"+
				"</td>");
		tBody.append(tr);//将每一行记录再追加到tbody中
	}
}

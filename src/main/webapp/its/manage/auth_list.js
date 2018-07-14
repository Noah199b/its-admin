$(document).ready(function(){
	$('#reportFormHead')
	.on('click','.btn-search',doGetObjects)
	.on('click','.btn-audit',doLoadEditPage);
	doGetObjects();
});
function doGetObjects(){
	var url="auth/doGetObjects.do";
	var params={
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
			setAuthObjects(result.data.auth);
		}else if(result.state==0){
			alert("系统繁忙！");
		}
	})
	
}
//翻页调用  
function PageCallback(index, jq) {
	var url="auth/doGetObjects.do";
	var params={
			"state":$("#searchValidId").val(),
			"pageNo":index
	}
	$.post(url,params,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setAuthObjects(result.data.auth);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
function doLoadEditPage(){
	var url="auth/editUI.do?id="+$(this).val();
	$(".content").load(url);
}
function setAuthObjects(auth){
	//获得tbody对象(根据id获得)
	//在使用$函数获得某个id对应的对象一定要添加#
	var tBody=$("#tbodyId");
	//清空body中内容(假如方法不记得了怎么办)
	tBody.empty();//doc.tedu.cn
	//迭代json对象
	for(var i=0;i<auth.length;i++){//循环一次取一行[{"name":"AAA",...},{},{}]
		//构建一个tr对象
		var tr=$("<tr></tr>");
		//在tr对象上绑定一个值
		tr.append("<td>"+new Date(auth[i].createdTime).Format("yyyy-MM-dd")+"</td>");
		tr.append("<td>"+auth[i].username+"</td>");
		tr.append("<td>"+auth[i].name+"</td>");
		tr.append("<td>"+auth[i].edu+"</td>");
		tr.append("<td>"+auth[i].speciality+"</td>");
		var state=auth[i].state==0?"0-未审核":
			auth[i].state==1?"1-已通过":"2-未通过";
		tr.append("<td>"+state+"</td>");
		if(auth[i].state==0){
			tr.append("<td>" +
					"<button type='button' class='btn btn-warning btn-audit' value='"+auth[i].id+"'>审核</button>"+
					"</td>");
		}else{
			tr.append("<td>" +
					"<button type='button' class='btn btn-warning btn-audit' value='"+auth[i].id+"'>查看</button>"+
					"</td>");
		}
		tBody.append(tr);//将每一行记录再追加到tbody中
	}
}

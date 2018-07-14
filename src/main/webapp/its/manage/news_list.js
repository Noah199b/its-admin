$(document).ready(function(){
	$('#newsFormHead')
	.on('click','.btn-add,.btn-update',doLoadEditPage)
	.on('click','.btn-search',doGetObjects)
	.on('click','.btn-delete',doDeleteNews);
	doGetObjects();
});
function doDeleteNews(){
	var flag=confirm("确定删除此新闻吗？");
	if(flag){
		var url="news/doDeleteNews.do";
		var params={
				"id":$(this).val()
		}
		$.post(url,params,function(result){
			if(result.state==1){
				alert("删除成功！");
				doGetObjects();
			}else{
				alert(result.message);
			}
		})
	}
}
function doGetObjects(){
	var url="news/doGetObjects.do";
	var params={
			"search":$("#newsTitle").val(),
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
			setNewsObjects(result.data.news);
		}else if(result.state==0){
			alert("系统繁忙！");
		}
	})
	
}
//翻页调用  
function PageCallback(index, jq) {
	var url="news/doGetObjects.do";
	var params={
			"search":$("newsTitle").val(),
			"pageNo":index
	}
	$.post(url,params,function(result){		
		console.log(JSON.stringify(result));
		if(result.state==1){		
			setNewsObjects(result.data.news);
		}else if(result.state==0){
			alert("请求超时，请重试！");			
		}	
	});
}
function doLoadEditPage(){
	var url="news/editUI.do?id="+$(this).val();
	$(".content").load(url);
}
function setNewsObjects(news){
	//获得tbody对象(根据id获得)
	//在使用$函数获得某个id对应的对象一定要添加#
	var tBody=$("#tbodyId");
	//清空body中内容(假如方法不记得了怎么办)
	tBody.empty();//doc.tedu.cn
	//迭代json对象
	for(var i=0;i<news.length;i++){//循环一次取一行[{"name":"AAA",...},{},{}]
		//构建一个tr对象
		var tr=$("<tr></tr>");
		//在tr对象上绑定一个值
		tr.append("<td>"+new Date(news[i].createdTime).Format("yyyy-MM-dd")+"</td>");
		tr.append("<td>"+news[i].title+"</td>");
		var newsType=news[i].newsType==1?"1-教育新闻":"0-时事热点";
		tr.append("<td>"+newsType+"</td>");
		var type=news[i].type==1?"1-站外链接":"0-本站编辑";
		tr.append("<td>"+type+"</td>");	
		tr.append("<td>" +
				"<button type='button' class='btn btn-warning btn-delete' value='"+news[i].id+"'>删除</button>&nbsp;&nbsp;&nbsp;" +
				"<button type='button' class='btn btn-primary btn-update' value='"+news[i].id+"'>修改</button>" +
				"</td>");
		tBody.append(tr);//将每一行记录再追加到tbody中
	}
}

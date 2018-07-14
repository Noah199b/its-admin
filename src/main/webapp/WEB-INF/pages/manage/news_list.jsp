<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script src="${basePath}/ttms/common/page.js"></script>
<div class="container">
   <!-- 页面导航 -->
    <div class="page-header">
		<div class="page-title" style="padding-bottom: 5px">
			<ol class="breadcrumb">
			  <li class="active" id="titleId">新闻管理</li>
			</ol>
		</div>
	</div>
	<form method="post" id="newsFormHead">
	    <!-- 查询表单 -->
		<div class="row page-search">
		 <div class="col-md-12">
			<ul class="list-unstyled list-inline">
				<li><input type="text" id="newsTitle" class="form-control" placeholder="新闻标题"></li>
				<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
				<li class='O2'><button type="button" class="btn btn-primary btn-add">新增</button></li>
			</ul>
		  </div>
		</div>
		<!-- 列表显示内容 -->
		<div class="row col-md-12">
			<table class="table table-bordered" id="userTable">
				<thead>
					<tr>
					    <th>发表日期</th>
						<th>标题</th>
						<th>新闻类型</th>
						<th>是否站内</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="tbodyId"></tbody>
			</table>
			<!--分页-->
			<div class="pages">
				<div id="Pagination"></div>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="${basePath}/its/manage/news_list.js"></script>
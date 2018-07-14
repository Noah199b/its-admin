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
			  <li class="active" id="titleId">举报处理</li>
			</ol>
		</div>
	</div>
	<form method="post" id="reportFormHead">
	    <!-- 查询表单 -->
		<div class="row page-search">
		 <div class="col-md-12">
			<ul class="list-unstyled list-inline">
				<li>
					<select id="searchTypeId" class="form-control">
							<option value="">选择类型</option>
							<option value="0">0-用户</option>
							<option value="1">1-话题</option>
							<option value="2">2-资料</option>
							<option value="3">3-其它</option>
					</select>
				</li>
				<li>
					<select id="searchValidId" class="form-control">
							<option value="">选择状态</option>
							<option value="0">0-未处理</option>
							<option value="1">1-已处理</option>
					</select>
				</li>
				<li><button type="button" class="btn btn-primary btn-search" >查询</button></li>
			</ul>
		  </div>
		</div>
		<!-- 列表显示内容 -->
		<div class="row col-md-12">
			<table class="table table-bordered" id="userTable">
				<thead>
					<tr>
					    <th>举报类型</th>
						<th>举报原因</th>
						<th>处理状态</th>
						<th>处理意见</th>
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
<script type="text/javascript" src="${basePath}/its/manage/report_list.js"></script>
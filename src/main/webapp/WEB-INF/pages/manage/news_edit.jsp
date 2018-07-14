<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<div class="container">
	<!-- 页面导航 -->
	<div class="page-header">
		<div class="page-title" style="padding-bottom: 5px">
			<ol class="breadcrumb">
			<li class="active" id="titleId" value="${empty its_news?0:its_news.id}">新闻编辑</li>				
			</ol>
		</div>
	</div>
	 <div class="row col-md-12">
			<form class="form-horizontal" id="editNewsForm">
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>标题：</div>
					<div class="col-sm-10">
						<input type="text" name="title" id="title" placeholder="新闻标题(10-50字)" class="form-control dynamicClear required" value="${its_news.title}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>副标题：</div>
					<div class="col-sm-10">
						<input type="text" name="subTitle" id="subTitle" placeholder="新闻副标题(10-50字)" class="form-control dynamicClear required" value="${its_news.subTitle}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
			         <label class="col-md-2 control-label"><font color="red">*</font>新闻类型：</label>
			         <div class="col-md-10">
			           <c:choose>
			            	<c:when test="${its_news.newsType==0}">
			            		<label class="radio-inline"><input  type="radio" name="newsType" value="1" > 教育新闻</label>
			            	  <label class="radio-inline"><input  type="radio" name="newsType" checked value="0"> 时事热点</label>
			            	</c:when>
			            	<c:otherwise>
			            	  	<label class="radio-inline"><input  type="radio" name="newsType" checked value="1" > 教育新闻</label>
			            	  	<label class="radio-inline"><input  type="radio" name="newsType" value="0"> 时事热点</label>			           
			            	</c:otherwise>
			            </c:choose>
			          </div>
			    </div>
			    <div class="form-group">
			         <label class="col-md-2 control-label"><font color="red">*</font>是否本站：</label>
			         <div class="col-md-10">
			        	 <c:choose>
			            	<c:when test="${its_news.type==0}">
			            		<label class="radio-inline"><input  type="radio" name="type"  value="1" > 站外链接</label>
			            		<label class="radio-inline"><input  type="radio" name="type" checked value="0"> 站内编辑</label>
			            	</c:when>
			            	<c:otherwise>
			           	 		<label class="radio-inline"><input  type="radio" name="type" checked value="1" > 站外链接</label>
			            		<label class="radio-inline"><input  type="radio" name="type" value="0"> 站内编辑</label>
			          	 	</c:otherwise>
			         </c:choose>
			         </div>
			    </div>
			    <div class="form-group" id="news_link">
					<div class="col-sm-2 control-label"><font color="red">*</font>新闻链接：</div>
					<div class="col-sm-10">
						<input type="text" name="link" id="link" placeholder="新闻链接" class="form-control dynamicClear required" value="${its_news.link}">
					</div>
				</div>
				<!-- 编辑器 -->
				<div id="editor">
				        <div id="news_content"></div>
				</div>
				<script type="text/javascript">
			        var E = window.wangEditor
			        var editor = new E('#editor')
			        // 或者 var editor = new E( document.getElementById('editor') )
			        editor.create();
			    </script>
				<!-- 编辑器 -->
				<div class="form-group">
					<div class="col-sm-5 control-label">
						<input type="button" class="btn btn-primary" id="btn-ok" value="确定">
						&nbsp;&nbsp;
						<input type="button" value="返回" class="btn btn-warning" id="btn-return">				
					</div>		
				</div>		
			</form>
	 </div>
 </div>
<script type="text/javascript" src="${basePath}/its/manage/news_edit.js"></script>
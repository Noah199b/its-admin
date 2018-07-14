<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<div class="container">
	<!-- 页面导航 -->
	<div class="page-header">
		<div class="page-title" style="padding-bottom: 5px">
			<ol class="breadcrumb">
			<li class="active" id="titleId" value="${its_report.id}">举报处理</li>				
			</ol>
		</div>
	</div>
	 <div class="row col-md-12">
			<form class="form-horizontal" id="editReportForm">
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>举报类型：</div>
					<div class="col-sm-10">
						<input type="text" name="type" id="type" readonly class="form-control dynamicClear required" 
						value="${its_report.type==0?'0-用户':its_report.type==1?'1-话题':its_report.type==2?'2-资源':'3-其它'}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>处理状态：</div>
					<div class="col-sm-10">
						<input type="text" name="state" id="state" readonly class="form-control dynamicClear required" value="${its_report.state==0?'0-未处理':'1-已处理'}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>用户：</div>
					<div class="col-sm-10">
						<input type="text" name="username" id="username" readonly class="form-control dynamicClear required" value="${its_report.username}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>链接：</div>
					<div class="col-sm-10">
						<input type="text" name="link" id="link" readonly class="form-control dynamicClear required" value="${its_report.link}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>举报原因：</div>
					<div class="col-sm-10">
						<input type="text" name="reason" id="reason" readonly class="form-control dynamicClear required" value="${its_report.reason}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
			         <label class="col-md-2 control-label"><font color="red">*</font>处理操作：</label>
			         <div class="col-md-10">
			          	  <label class="radio-inline" id="due3"><input  type="radio" name="due" checked value="3"> 标记已处理 </label>
			          	  <label class="radio-inline" id="due4"><input  type="radio" name="due"  value="4"> 标记未处理 </label>
				           <c:choose>
				            	<c:when test="${its_report.type==0}">
				            		<label class="radio-inline" id="due0"><input  type="radio" name="due" value="0" > 禁用用户 </label>
				            	</c:when>
				            	<c:when test="${its_report.type==1}">
				            		<label class="radio-inline" id="due1"><input  type="radio" name="due" value="1" > 删除话题 </label>
				            	</c:when>
				            	<c:when test="${its_report.type==2}">
				            		<label class="radio-inline" id="due2"><input  type="radio" name="due" value="2" > 删除资源 </label>
				            	</c:when>
				            </c:choose>
			          </div>
			    </div>
			    <div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>处理意见：</div>
					<div class="col-sm-10">
						<c:choose>
							<c:when test="${its_report.state==0}">
								<input type="text" name="opinion" id="opinion" placeholder="处理意见" class="form-control dynamicClear required" value="${its_report.opinion}" maxlength="100">
							</c:when>
							<c:otherwise>
								<input type="text" name="opinion" id="opinion" readonly placeholder="处理意见" class="form-control dynamicClear required" value="${its_report.opinion}">
							</c:otherwise>
						</c:choose>
						
					</div>
				</div>
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
<script type="text/javascript" src="${basePath}/its/manage/report_edit.js"></script>
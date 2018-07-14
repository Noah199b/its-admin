<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container">
	<!-- 页面导航 -->
	<div class="page-header">
		<div class="page-title" style="padding-bottom: 5px">
			<ol class="breadcrumb">
			<li class="active" id="titleId" value="${authInfo.id}">认证审核</li>				
			</ol>
		</div>
	</div>
	 <div class="row col-md-12">
			<form class="form-horizontal" id="editReportForm">
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>申请账号：</div>
					<div class="col-sm-10">
						<input type="text" name="username" id="username" readonly class="form-control dynamicClear required" 
						value="${authInfo.username}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>申请日期：</div>
					<div class="col-sm-10">
						<input type="text" name="createdTime" id="createdTime" readonly class="form-control dynamicClear required" value="<fmt:formatDate value="${authInfo.createdTime}" type="date" pattern="yyyy-MM-dd"/>" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>审核状态：</div>
					<div class="col-sm-10">
						<input type="text" name="state" id="state" readonly class="form-control dynamicClear required" value="${authInfo.state==0?'0-未审核':authInfo.state==1?'1-已通过':'2-未通过'}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>申请人：</div>
					<div class="col-sm-10">
						<input type="text" name="name" id="name" readonly class="form-control dynamicClear required" value="${authInfo.name}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>身份证号：</div>
					<div class="col-sm-10">
						<input type="text" name="idNo" id="idNo" readonly class="form-control dynamicClear required" value="${authInfo.idNo}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>邮箱：</div>
					<div class="col-sm-10">
						<input type="text" name="email" id="email" readonly class="form-control dynamicClear required" value="${authInfo.email}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>联系电话：</div>
					<div class="col-sm-10">
						<input type="text" name="tel" id="tel" readonly class="form-control dynamicClear required" value="${authInfo.tel}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>学历：</div>
					<div class="col-sm-10">
						<input type="text" name="edu" id="edu" readonly class="form-control dynamicClear required" value="${authInfo.edu}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>专业：</div>
					<div class="col-sm-10">
						<input type="text" name="speciality" id="speciality" readonly class="form-control dynamicClear required" value="${authInfo.speciality}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>毕业院校：</div>
					<div class="col-sm-10">
						<input type="text" name="school" id="school" readonly class="form-control dynamicClear required" value="${authInfo.school}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>工作单位：</div>
					<div class="col-sm-10">
						<input type="text" name="workspace" id="workspace" readonly class="form-control dynamicClear required" value="${authInfo.workspace}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>QQ：</div>
					<div class="col-sm-10">
						<input type="text" name="qq" id="qq" readonly class="form-control dynamicClear required" value="${authInfo.qq}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>微信：</div>
					<div class="col-sm-10">
						<input type="text" name="wechat" id="wechat" readonly class="form-control dynamicClear required" value="${authInfo.wechat}" maxlength="50">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>身份证正面：</div>
					<div class="col-sm-10">
						<img alt="身份证正面" src="${authInfo.frontPath}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>身份证反面：</div>
					<div class="col-sm-10">
						<img alt="身份证反面" src="${authInfo.backPath}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>辅助材料1：</div>
					<div class="col-sm-10">
						<img alt="辅助认证" src="${authInfo.aidPath1}">
					</div>
				</div>
				<c:if test="${!empty authInfo.aidPath2 }">
					<div class="form-group">
						<div class="col-sm-2 control-label"><font color="red">*</font>辅助材料2：</div>
						<div class="col-sm-10">
							<img alt="辅助认证" src="${authInfo.aidPath2}">
						</div>
					</div>				
				</c:if>
				<c:if test="${!empty authInfo.aidPath3}">
					<div class="form-group">
						<div class="col-sm-2 control-label"><font color="red">*</font>辅助材料3：</div>
						<div class="col-sm-10">
							<img alt="辅助认证" src="${authInfo.aidPath3}">
						</div>
					</div>				
				</c:if>
				<c:if test="${authInfo.state==0}">
					<div class="form-group">
			         <label class="col-md-2 control-label"><font color="red">*</font>处理操作：</label>
			         <div class="col-md-10">
			          	  <label class="radio-inline" id="due1"><input  type="radio" name="due" checked value="1"> 通过</label>
			          	  <label class="radio-inline" id="due2"><input  type="radio" name="due"  value="2"> 不通过</label>
			          </div>
			    	</div>			
				</c:if>
				<c:if test="${authInfo.state!=0}">
					<div class="form-group">
						<div class="col-sm-2 control-label"><font color="red">*</font>审核人：</div>
						<div class="col-sm-10">
							<input type="text" name="auditUser" id="auditUser" readonly class="form-control dynamicClear required" value="${authInfo.auditUser}" maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2 control-label"><font color="red">*</font>审核日期：</div>
						<div class="col-sm-10">
							<input type="text" name="auditTime" id="auditTime" readonly class="form-control dynamicClear required" value="<fmt:formatDate value="${authInfo.auditTime}" type="date" pattern="yyyy-MM-dd"/>" maxlength="50">
						</div>
					</div>
				</c:if>		
			    <div class="form-group">
					<div class="col-sm-2 control-label"><font color="red">*</font>审核意见：</div>
					<div class="col-sm-10">
						<c:choose>
							<c:when test="${authInfo.state==0}">
								<input type="text" name="opinion" id="opinion" placeholder="审核意见" class="form-control dynamicClear required" value="${authInfo.opinion}" maxlength="100">
							</c:when>
							<c:otherwise>
								<input type="text" name="opinion" id="opinion" readonly placeholder="审核意见" class="form-control dynamicClear required" value="${authInfo.opinion}">
							</c:otherwise>
						</c:choose>						
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-5 control-label">
						<c:if test="${authInfo.state==0}">
							<input type="button" class="btn btn-primary" id="btn-ok" value="确定">
						</c:if>										
						&nbsp;&nbsp;
						<input type="button" value="返回" class="btn btn-warning" id="btn-return">				
					</div>		
				</div>		
			</form>
	 </div>
 </div>
<script type="text/javascript" src="${basePath}/its/manage/auth_edit.js"></script>
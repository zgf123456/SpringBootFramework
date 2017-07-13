<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
	<title>测试管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test_data_zgf/testDataZgf/">测试列表</a></li>
		<shiro:hasPermission name="test_data_zgf:testDataZgf:edit"><li><a href="${ctx}/test_data_zgf/testDataZgf/form">测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="testDataZgf" action="${ctx}/test_data_zgf/testDataZgf/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
		&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="test_data_zgf:testDataZgf:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="testDataZgf">
			<tr>
				<td><a href="${ctx}/test_data_zgf/testDataZgf/form?id=${testDataZgf.id}">
					${testDataZgf.name}
				</a></td>
				<td>
					<fmt:formatDate value="${testDataZgf.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${testDataZgf.remarks}
				</td>
				<shiro:hasPermission name="test_data_zgf:testDataZgf:edit"><td>
    				<a href="${ctx}/test_data_zgf/testDataZgf/form?id=${testDataZgf.id}">修改</a>
					<a href="${ctx}/test_data_zgf/testDataZgf/delete?id=${testDataZgf.id}" onclick="return confirmx('确认要删除该测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
	<title>代码生成测试管理</title>
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
		<li class="active"><a href="${ctx}/testdatazgf/testDataZgf/">代码生成测试列表</a></li>
		<shiro:hasPermission name="testdatazgf:testDataZgf:edit"><li><a href="${ctx}/testdatazgf/testDataZgf/form">代码生成测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="testDataZgf" action="${ctx}/testdatazgf/testDataZgf/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
			<label>归属用户：</label>
				<sys:treeselect id="user" name="user.id" value="${testDataZgf.user.id}" labelName="user.name" labelValue="${testDataZgf.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			<label>归属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${testDataZgf.office.id}" labelName="office.name" labelValue="${testDataZgf.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			<label>归属区域：</label>
				<sys:treeselect id="area" name="area.id" value="${testDataZgf.area.id}" labelName="area.name" labelValue="${testDataZgf.area.name}"
					title="区域" url="/sys/area/treeData" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			<label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			<label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			<div style="margin-top:8px;">
				<label>加入日期：</label>
					<input name="beginInDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
						value="<fmt:formatDate value="${testDataZgf.beginInDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> -
					<input name="endInDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
						value="<fmt:formatDate value="${testDataZgf.endInDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>编号</th>
				<th>归属用户</th>
				<th>归属部门</th>
				<th>归属区域</th>
				<th>名称</th>
				<th>性别</th>
				<th>加入日期</th>
				<th>备注信息</th>
				<shiro:hasPermission name="testdatazgf:testDataZgf:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="testDataZgf">
			<tr>
				<td><a href="${ctx}/testdatazgf/testDataZgf/form?id=${testDataZgf.id}">
					${testDataZgf.id}
				</a></td>
				<td>
					${testDataZgf.user.name}
				</td>
				<td>
					${testDataZgf.office.name}
				</td>
				<td>
					${testDataZgf.area.name}
				</td>
				<td>
					${testDataZgf.name}
				</td>
				<td>
					${fns:getDictLabel(testDataZgf.sex, 'sex', '')}
				</td>
				<td>
					<fmt:formatDate value="${testDataZgf.inDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${testDataZgf.remarks}
				</td>
				<shiro:hasPermission name="testdatazgf:testDataZgf:edit"><td>
    				<a href="${ctx}/testdatazgf/testDataZgf/form?id=${testDataZgf.id}">修改</a>
					<a href="${ctx}/testdatazgf/testDataZgf/delete?id=${testDataZgf.id}" onclick="return confirmx('确认要删除该代码生成测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
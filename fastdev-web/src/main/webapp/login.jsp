<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme() + "://"
            + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<body>
login page
<form action="${basePath}/account/login" method="post">
    account: <input type="text" name="account"/> <br/>
    password : <input type="password" name="password"/><br/>
    rememberMe : <input type="text" name="rememberMe"/><br/>
    <input type="submit" value="登录" />
</form>
</body>
</html>

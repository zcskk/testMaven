<%@page import="java.util.List" %>
<%@page import="model.*" %>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="index">
<input name="txt" type="text">
<table>
<tr><td>id</td><td>名字</td><td>类型</td><td>书名</td></tr>
<c:forEach items="${list}" var="row">
<tr><td>${row.id }</td><td>${row.name }</td><td>${row.statusname }</td><td>${row.bookname }</td></tr>
</c:forEach>
</table>
<input type="submit">
</form>
</body>
</html>

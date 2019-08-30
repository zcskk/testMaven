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
<script type="text/javascript">
function del(id) {
	if(confirm("删除")){
		open("delete?id="+id,'_self')
	}
}
</script>
<form action="index">
<input name="txt" type="text">
<input type="submit">
</form>
<a href="add">新增</a>
<table>
<tr><td>id</td><td>名字</td><td>性别</td><td>类型</td><td>修改</td></tr>
<c:forEach items="${list}" var="row">
<tr><td>${row.id }</td><td>${row.name }</td><td>${row.sexname }</td><td>${row.typename }</td>
<td><a href="upd?id=${row.id}">修改</a><a href="javascript:del(${row.id})">删除</a></td></tr>
</c:forEach>
</table>

</body>
</html>

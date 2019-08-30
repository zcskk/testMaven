<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${info ==null}">
<form action="insert" method="get">
</c:if>
<c:if test="${info !=null }">
<form action="update" >
</c:if>
<input type="text" name="name" value="${info.name}" >
<select name="status">
<c:forEach items="${statuslist }"  var="row" varStatus="v">
<c:if test="${v.index==info.status }">
<option value="${v.index }" selected="selected">${row }</option>
</c:if>
<c:if test="${v.index !=info.status }">
<option value="${v.index }">${row }</option>
</c:if>
</c:forEach>
</select>

<select name="bookid">
<c:forEach items="${booklist}"  var="row1" >
<c:if test="${row1.id==info.bookid }">
<option value="${row1.id }" selected="selected">${row1.name }</option>
</c:if>
<c:if test="${row1.id !=info.bookid }">
<option value="${row1.id }">${row1.name }</option>
</c:if>
</c:forEach>
</select>
<c:if test="${info !=null }">
<input name="id" value="${info.id}" type="hidden">
</c:if>
<input type="submit">
</form>
</body>
</html>
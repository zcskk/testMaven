<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function ok(o) {
	if(o.contentWindow.loaction.href.indexof("login")>0){
		open("login.html","_self")
	}
}
</script>
<iframe name="right" src="../Book/index2.jsp" onload="ok(this)" ></iframe>
<a href="outlogin">注销</a>
</body>
</html>
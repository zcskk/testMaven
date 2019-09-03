<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<base href="../"> 
<link href="layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="layui/layui.all.js"></script>
<script src="js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>


<form class="layui-form" lay-filter="myform" >
<c:if test="${param.id==null}">
<input type="hidden" name="cmd" value="insert">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="cmd" value="update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="sex" >
      </select>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select name="typeid" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">



var id="${param.id}";
function init(){
	$.post("Book/"+id,{_method:"GET"}, function(json) {
		render('myform', json);
		getarray("Book/getsex",{_method:"GET"},"[name=sex]",json.sex);
		getlist("Book/gettype",{_method:"GET"},"[name=typeid]",json.typeid)
	},"json");
	
}
if(id !=null&&id.length>0){
	init();
	layui.use(['form',], function(){
		  var form = layui.form;
		 
		  form.on('submit(demo1)', function(data){
			  data.field._method="PUT";
			 $.post("Book/"+id, data.field, function(json) {
				  closeFrame();
				  parent.fresh('demo');
				}, "json");
			    
			    return false;
			  });
	});

}else{
	getarray("Book/getsex",{_method:"GET"},"[name=sex]",0);
	getlist("Book/gettype",{_method:"GET"},"[name=typeid]",0);
	layui.use(['form',], function(){
		  var form = layui.form;
		  form.on('submit(demo1)', function(data){
			 $.post("Book", data.field, function(json) {
				  closeFrame();
				  parent.fresh('demo');
				}, "json");
			    
			    return false;
			  });
	});

}

</script>
</body>
</html>
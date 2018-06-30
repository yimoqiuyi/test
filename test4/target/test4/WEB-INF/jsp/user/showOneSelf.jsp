<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.yp.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>显示界面</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style type="text/css">
	body{
	   background: url("${pageContext.request.contextPath}/images/a.jpg")repeat;
	}
	#login-box {
		/*border:1px solid #F00;*/
		padding: 35px;
		border-radius:15px;
		background: #56666B;
		color: #fff;
	}

	</style>
</head>
<body>
<% User user=(User)request.getAttribute("user"); 
   String path="/test/picture/"+user.getPicture();
%>
<div class="container" id="top">
		<div class="row" style="margin-top:100px; ">
		<div class="col-md-4"></div>
		<div class="col-md-4" id="login-box">
 <form class="form-horizontal" action="/test/user/main.do?id=${id}" >
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" value="<%=user.getName() %>" style="width:180px" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control"  name="password" value="<%=user.getPassword() %>" style="width:180px" readonly="readonly">
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">简介:</label>
    <div class="col-sm-10">
      <input  type="text" class="form-control"  name="note"  value="${user.note }" readonly>
    </div>
  </div>
      <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label" style="width:100px">个人照:</label>
    <div class="col-sm-10">
      <img alt="个人照"  style="width:100px"  src="<%=path%>">
    </div>
  </div>
     <div class="form-group pull-right" style="margin-right: 40px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	   <button type="reset"class="btn btn-default btn-info" style="width:60px"><a href="/test/user/select.do?id=<%=user.getId()%>">修改</a></button> 
      </div>
 	  </div>
      <div class="form-group pull-right" style="margin-right: 40px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	   <button type="reset"class="btn btn-default btn-info" style="width:60px">确定</button>
    </div>
 	  </div>
</form>
</div>
</div></div>
  
</body>
</html>
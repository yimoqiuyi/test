<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册界面</title>
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
<div class="container" id="top">
		<div class="row" style="margin-top:100px; ">
		<div class="col-md-4"></div>
		<div class="col-md-4" id="login-box">
 <form class="form-horizontal" action="${pageContext.request.contextPath}/user/insert.do" method="get" enctype="multipart/form-data">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" style="width:180px" placeholder="name">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control"  name="password" style="width:180px" placeholder="Password">
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">简介:</label>
    <div class="col-sm-10">
      <textarea  class="form-control"  name="note" placeholder="我是"></textarea>
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">照片:</label>
    <div class="col-sm-10">
       <input type="file" name="file" value="点击上传">
    </div>
  </div>  
     <div class="form-group pull-right" style="margin-right: 40px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="submit"class="btn btn-default btn-info" style="width:60px">注册</button>
    </div>
 	  </div>
     <div class="form-group pull-right" style="margin-right: 40px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="reset"class="btn btn-default btn-info" style="width:60px">撤销</button>
    </div>
 	  </div>
</form>
</div>
</div></div>
 
</body>
</html>
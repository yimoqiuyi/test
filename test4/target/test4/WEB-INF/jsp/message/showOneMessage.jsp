<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,com.yp.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>写留言</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<% 
Message mes=(Message)request.getAttribute("message"); 
String userId=request.getAttribute("userId").toString();
%>
 <div class="container" id="top">
		<div class="row" style="margin-top:100px; ">
		<div class="col-md-4"></div>
		<div class="col-md-4" id="login-box">
<form class="form-horizontal">
  <div class="form-group">
    <label  class="col-sm-2 control-label">题目:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title"   style="width:200px" placeholder="<%=mes.getTitle() %>" readonly="readonly">
    </div>
  </div>
   <div class="form-group">
    <label  class="col-sm-2 control-label">日期:</label>
    <div class="col-sm-10">
   <input type="text" id="typeId" name="date" class="form-control" style="width:200px"  value="<%=mes.getDate()%>" readonly>   
      </div>
  </div>
    <div class="form-group">
    <label  class="col-sm-2 control-label">注释:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="note" style="width:200px" placeholder="<%=mes.getNote() %>"  readonly>
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">发布内容:</label>
    <div class="col-sm-10">
      <input class="form-control"   name="context" style="width:200px"  placeholder="<%=mes.getContext()%>"readonly> 
    </div>
  </div>
  <div class="panel-footer">
<div class="form-group pull-right" style="margin-right: 140px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="submit"class="btn btn-default btn-info" style="width:60px"><a href="${pageContext.request.contextPath}/message/delete.do?id=${id}&userId=${userId}">删除</a></button>
    </div>
 	  </div>
     <div class="form-group pull-right" style="margin-right: 40px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="reset" class="btn btn-default btn-info" style="width:60px"><a href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=1&id=${id}">返回</a></button>
    </div>
 	  </div>
 	  </div>
 </form>
 </div></div></div>
</body>
</html>
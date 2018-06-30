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
 String id=request.getAttribute("userid").toString();
%>
  <div class="container" id="top">
		<div class="row" style="margin-top:100px; ">
		<div class="col-md-4"></div>
		<div class="col-md-4" id="login-box">
<form class="form-horizontal" action="${pageContext.request.contextPath}/message/insert.do">
 <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">作者:</label>
    <div class="col-sm-10">
      <input class="form-control"   name="userid" style="width:200px" value="<%=id %>"  placeholder="<%=id%>"readonly> 
    </div>
  </div>
  <div class="form-group">
    <label  class="col-sm-2 control-label">题目:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title"  style="width:200px" placeholder="title">
    </div>
  </div>
    <div class="form-group">
    <label  class="col-sm-2 control-label">日期:</label>
    <div class="col-sm-10">
     <input id="releaseDate" class="Wdate" name="date"  type="text" style="width:200px" onfocus="WdatePicker({skin:'whyGreen',minDate:'%y%M%d',maxDate:'2028-12-20'})" placeholder="2018-8-5"/>
    </div>
  </div>
    <div class="form-group">
    <label  class="col-sm-2 control-label">注释:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="note" style="width:200px" placeholder="note">
    </div>
  </div>
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">类型:</label>
    <div class="col-sm-10">
    <%
      ArrayList<Type> list=(ArrayList<Type>)request.getAttribute("typeList");
    		for(int i=0;i<list.size();i++)
     {  Type type=(Type)list.get(i);
        
      %>
      <label class="checkbox-inline">
         <input type="checkbox" id="typeId" name="type" value="<%=type.getId()%>" >   <%= type.getTypeName()%>
    </label>
       <% 
    			}
    %>
     </div>
  </div>
 <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">发布内容:</label>
    <div class="col-sm-10">
      <textarea class="form-control" rows="3"  name="context" style="width:200px"></textarea>
    </div>
  </div>
   <div class="form-group pull-right" style="margin-right: 140px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="submit"class="btn btn-default btn-info" style="width:60px">发布 </button>
    </div>
 	  </div>
     <div class="form-group pull-right" style="margin-right: 40px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="reset" class="btn btn-default btn-info" style="width:60px">撤销</button>
    </div>
 	  </div>
 </form>
 </div></div></div>
</body>
</html>
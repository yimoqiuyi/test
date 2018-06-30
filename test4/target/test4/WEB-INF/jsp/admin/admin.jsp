<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,com.yp.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>用户信息</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
<%  Admin admin=(Admin)request.getAttribute("admin");
   String id=request.getAttribute("adminId").toString(); 
   String path="/test/picture/"+admin.getPicture();
   %>
  
   	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="top.jsp"></jsp:include>
			 <div class="col-md-10">
				<div class="panel panel-default">
  <form class="form-horizontal">
  <div class="form-group">
    <label  class="col-sm-2 control-label">姓名:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title"   style="width:200px" placeholder="<%=admin.getName()%>" readonly="readonly">
    </div>
  </div>
   <div class="form-group">
    <label  class="col-sm-2 control-label">密码:</label>
    <div class="col-sm-10">
   <input type="text" id="typeId" name="date" class="form-control" style="width:200px"  value="<%=admin.getPassword()%>" readonly>   
      </div>
  </div>
    <div class="form-group">
    <label  class="col-sm-2 control-label">头像:</label>
    <div class="col-sm-10">
       <img alt="头像" src="<%=path%>">
    </div>
  </div>
 <div class="form-group pull-right" style="margin-right: 140px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="submit"class="btn btn-default btn-info" style="width:60px"><a href="${pageContext.request.contextPath}/admin/show.do?&adminId=<%=admin.getId()%>">返回</a></button>
    </div>
 	  </div>
     <div class="form-group pull-right" style="margin-right: 40px;">
 	    <div  class="col-sm-offset-2 col-sm-10">
 	  <button type="submit" class="btn btn-default btn-info" style="width:60px"><a href="${pageContext.request.contextPath}/admin/update.do?adminId=<%=admin.getId()%>">修改</a></button>
    </div>
 	  </div>
 	  </form>
 	  </div>
    </div>
	   </div>
	 </div>
 </html>
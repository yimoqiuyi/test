<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.yp.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<title>回复页面</title>
</head>
<body>
<%
String userid=request.getAttribute("userid").toString();
String touserid=request.getAttribute("touserid").toString();
Commont com=(Commont)request.getAttribute("commont");
 %>
 <div> 
<form action="${pageContext.request.contextPath}/role/insertRecom.do" method="post">
<table>
<tr><td>
<%="评论者"+touserid+"评论:"+com.getContext()%>
</td></tr>
<tr>
<td>回复者<%=userid%>
  <%="@" %><%=touserid+":"%></td>
 <td> 
 <input type='hidden' name='userid' value="<%=userid%>"/> 
  <input type='hidden' name='touserid' value="<%=touserid%>"/> 
   <input type='hidden' name='id' value="<%=com.getId()%>"/> 
 </td>
  </tr>
 <tr>
 <td>
 <textarea rows="10" cols="40" name="context">
  </textarea>
 </td>		
 </tr>
 <tr>
 <td ><button type="submit">提交</button></td>
 <td style="margin-left:20px;"><button type="reset">撤销</button></td>
 </tr>
</table>
</form></div>
</body>
</html>
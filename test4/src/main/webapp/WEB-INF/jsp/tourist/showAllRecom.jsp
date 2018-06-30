<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.yp.pojo.*,java.util.*"%>
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
<form>
<table border="1px">
<tr><td>
<%="评论者"+touserid+"评论:"+com.getContext()%>
</td></tr>
<tr>
 <td> 
 <input type='hidden' name='userid' value="<%=userid%>"/> 
  <input type='hidden' name='touserid' value="<%=touserid%>"/> 
   <input type='hidden' name='id' value="<%=com.getId()%>"/> 
 </td>
  </tr>
 <tr>
 <td><%
 ArrayList list=(ArrayList)request.getAttribute("reList");
  for(int i=0;i<list.size();i++)
  {
	   Recommont recom=(Recommont)list.get(i);
  %>
    <tr><td>回复者
        <%=recom.getUserid()%>
        <%="@" %><%=touserid+":"%>
        <%=recom.getContext()%>
        </td>
            </tr>
          <tr>
          <td>
        <a href="${pageContext.request.contextPath}/role/index.do?id=<%=userid%>">  <input type="button" value="评论"></a>
        </td> </tr>
 <% 
  }
 %>	</td>
 </tr>
  
</table>
</form></div>
</body>
</html>
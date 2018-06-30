<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.pojo.*" %>
  <%  String id=request.getAttribute("id").toString(); %>
   <div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.contextPath}/role/message.do?pageNumber=1&id=<%=id%>">文章首页<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/user/login2.do?id=<%=id%>">个人首页<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/user/regist.do">登录?注册<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
     </ul>
</div>
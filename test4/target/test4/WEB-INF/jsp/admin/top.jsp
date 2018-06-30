<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.pojo.*" %>
   <div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
     <%  String id=request.getAttribute("adminId").toString(); %>
         <li><a href="${pageContext.request.contextPath}/admin/show.do?id=<%=id%>">个人信息<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/message/showAll.do?id=<%=id%>&pageNumber=1">查看文章<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/message/showcheck.do?id=<%=id%>&pageNumber=1">已审核文章<span class="badge pull-right"></span></a></li>
         <li><a href="${pageContext.request.contextPath}/user/showAlluser.do?id=<%=id%>&pageNumber=1">管理用户<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
     </ul>
</div>
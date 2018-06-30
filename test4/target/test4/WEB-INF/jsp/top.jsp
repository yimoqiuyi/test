<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.pojo.*" %>
   <div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.contextPath}/admin/show.do>">文章首页<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/message/showAll.d?pageNumber=1">推荐文章<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/message/showAll.d?pageNumber=1">搜索文章(根据类别搜索)<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/user/showAlluser.do">登录?注册<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
     </ul>
</div>
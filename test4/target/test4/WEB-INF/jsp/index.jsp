<%@ page contentType="text/html;charset=UTF-8" language="java"
	import="java.util.*,com.yp.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <!DOCTYPE html>
<html>
<head>
<title>留言文本</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	   href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
 	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="top.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">文章列表</h1>
							<form class="bs-example bs-example-form col-md-5" role="form"
								style="margin: 20px 0 10px 0;"
								action="${pageContext.request.contextPath}/message/find.do?pageNumber=1'"
								id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入.."
										name="findByName"> <span class="input-group-addon btn"
										onclick="document.getElementById('form1').submit" id="sub">搜索</span>
								</div>
							</form>

						</div>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>题目</th>
								<th>发布时间</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${messageList}" var="item">
								<tr>
									<td>${item.id}</td>
									<td>${item.title}</td>
									<td>${item.date}</td>
									<td>${state}</td>
									<td>
 										<button class="btn btn-default btn-xs btn-info"
											onClick="location.href='/test/message/Comment.do?id=${item.id}'">评论</button>
										<!--弹出框-->
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="panel-footer">
						<nav style="text-align: center">
							<ul class="pagination">
								<li><a
									href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=1">第一页</a></li>
								<li><a
									href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=${pageNumber-1}">上一页</a></li>
								<c:if test="${pageNumber <=totalCount}">
									<li><a
										href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=${pageNumber}">${pageNumber}</a></li>
								</c:if>
								<c:if test="${pageNumber+1<=totalCount}">
									<li><a
										href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=${pageNumber+1}">${pageNumber+1}</a></li>
								</c:if>
								<c:if test="${pageNumber+1 <=totalCount}">
									<li><a
										href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=${pageNumber+1}">${pageNumber+2}</a></li>
								</c:if>
								<c:if test="${pageNumber+1<totalCount}">
									<li><a
										href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=${pageNumber+1}">${pageNumber+3}</a></li>
								</c:if>
								<li><a
									href="${pageContext.request.contextPath}/message/selectOneallMs.do?pageNumber=${totalCount}">最后一页
								</a></li>
							</ul>
						</nav>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	
<%--设置菜单中--%>
	$("#sub").click(function() {
		$("#form1").submit();
	});
</script>
</html>
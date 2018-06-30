<%@ page contentType="text/html;charset=UTF-8" language="java"
	import="java.util.*,com.yp.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
	<%
		Message mes = (Message) request.getAttribute("message");
	   String id=request.getAttribute("id").toString();
	%>
	<div class="container" id="top">
		<div class="row" style="margin-top: 100px;">
			<div class="col-md-4"></div>
			<div class="col-md-4" id="login-box">
				<form class="form-horizontal">
					<table style="margin-top: 20px;">
						<tr>
							<td>题目: <input type="text" class="form-control" name="title"
								style="width: 200px" placeholder="<%=mes.getTitle()%>"
								readonly="readonly">
							</td>
						<tr>
							<td>日期: <input type="text" id="typeId" name="date"
								class="form-control" style="width: 200px"
								value="<%=mes.getDate()%>" readonly>
							</td>
						</tr>
						<tr>
							<td>发布内容: <input class="form-control" name="context"
								style="width: 200px" placeholder="<%=mes.getContext()%>"
								readonly>
							</td>
						</tr>
					</table>
				</form>
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/role/commont.do"
					method="post">
					<div class="panel-footer">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label"
								style="width: 80px">我想说:</label>
							<div class="col-sm-10">
								<input class="form-control" name="content" id="content"
									style="width: 200px" placeholder="我认为....">
							</div>
						</div>
						<input type='hidden' name='userid' value="<%= id%>"/> 
						<input type='hidden' name='mesid' value='<%=mes.getId()%>'/>
						<div>
 						<div class="form-group pull-right" style="margin-right: 40px;">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default btn-info"
									style="width: 60px">评论</button>
							</div>
						</div>
						<div class="form-group pull-right" style="margin-right: 100px;">
							<div class="col-sm-offset-2 col-sm-10">
								<a
									href="${pageContext.request.contextPath}/role/allcommont.do?userid=1"><input
									type="button" class="btn btn-default btn-info" value="查看更多"
									style="width: 80px"> </a>
							</div>
						</div>
						</div>
					</div>
				</form>
				</div>
		</div>
	</div>
	<div class="row" style="margin-top: 100px;">
			<div class="col-md-4"></div>
			<div class="col-md-4" id="login-box">
				<form class="form-horizontal" >
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>评论者</th>
								<th>评论内容</th>
 								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${commontList}" var="item">
								<tr>
									<td>${item.userid}</td>
									<td>${item.context}</td>
 									<td> 
 										<a href="${pageContext.request.contextPath}/role/recommont.do?touserid=${item.userid}&userid=<%=id%>&id=${item.id}"><input class="btn btn-default btn-xs btn-info"
								        type="button" value="回复"></a>
 	  									 <a href="${pageContext.request.contextPath}/role/Allrecommont.do?touserid=${item.userid}&userid=<%=id%>&id=${item.id}"><input class="btn btn-default btn-xs btn-info"
								        type="button" value="更多回复"></a>
 								</td></tr>
							</c:forEach>
						</tbody>
					</table>
 				</form>
 			 </div></div>
</body>
  </html>
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
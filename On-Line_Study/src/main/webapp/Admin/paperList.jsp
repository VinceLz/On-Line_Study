<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<script type="text/javascript">
	function paperDelete(paperId) {
		if (confirm("确定要删除这条记录吗?")) {
			$
					.post(
							"ExamServlet",
							{
								paperId : paperId,
								method : 'deletePaper'
							},
							function(result) {
								if (!result) {
									alert("删除失败");
								} else {
									alert("删除成功！");
									window.location.href = "${pageContext.request.contextPath}/ExamServlet?method=showAllPaper";
								}
							});
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="public.jsp"%>
	<section id="main-content"> <section class="wrapper">
	<div>
		<p id="ur">
			<span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>考试管理>>查看考试情况
		</p>
	</div>
	<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
	<center>

		<div class="data_content">
			<table class="table table-bordered table-hover">
				<tr>
					<th>序号</th>
					<th>试卷名称</th>
					<th>添加日期</th>
					<th>操作</th>
				</tr>
				<c:forEach var="paper" items="${paper}" varStatus="status">
					<tr>
						<td>${status.index+1 }</td>
						<td>${paper.paperName }</td>
						<td><fmt:formatDate value="${paper.joinDate }" type="date"
								pattern="yyyy-MM-dd" />
						</td>
						<td><button class="btn btn-mini btn-info" type="button"
								onclick="javascript:window.location='ExamServlet?method=preSave&paperId=${paper.id}'">修改</button>&nbsp;&nbsp;
							<button class="btn btn-mini btn-danger" type="button"
								onclick="paperDelete('${paper.id}')">删除</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</center>
	</section> </section>
	<%@include file="footer.jsp"%>
</body>
</html>

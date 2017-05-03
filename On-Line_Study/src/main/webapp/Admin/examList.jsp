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
		<div class="data_list">
			<div class="data_info">
				<p>考生成绩列表</p>
			</div>
		</div>
		<div class="data_content">
			<table class="table table-bordered table-hover">
				<tr>
					<th>序号</th>
					<th>准考证号</th>
					<th>考生姓名</th>
					<th>试卷名称</th>
					<th>考试日期</th>
					<th>单选题得分</th>
					<th>多选题得分</th>
					<th>总分</th>
				</tr>
				<c:forEach var="exam" items="${exam}" varStatus="status">
					<tr>
						<td>${status.index+1 }</td>
						<td>${exam.student.id }</td>
						<td>${exam.student.nickName }</td>
						<td>${exam.paper.paperName }</td>
						<td><fmt:formatDate value="${exam.examDate }" type="date"
								pattern="yyyy-MM-dd" />
						</td>
						<td>${exam.singleScore }</td>
						<td>${exam.moreScore }</td>
						<td><font color="red">${exam.score }</font>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<div class="pagination pagination-centered">
				<ul>${pageCode }
				</ul>
			</div>
		</div>
		</div>
	</center>
	</section> </section>
	<%@include file="footer.jsp"%>
</body>
</html>

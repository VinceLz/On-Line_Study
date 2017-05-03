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
<script type="text/javascript">
	function checkForm(){
		var paperName=$("#paperName").val();
		if(paperName==null || paperName==""){
			$("#error").html("试卷名称不能为空！");
			return false;
		}
		return true;
	}
</script>
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

		<div class="data_content">
			<form action="ExamServlet?method=updatePaper" method="post"
				onsubmit="return checkForm()">
				<table width="40%" align="center">
					<tr>
						<td><label>试卷名称：</label></td>
						<td><input type="text" id="paperName" name="paper.paperName"
							value="${paper.paperName }" /></td>
					</tr>

					<tr>
						<input type="hidden" name="paperId" value="${paper.id}" />
						<td>
							<button class="btn btn-primary" type="submit">保存</button>
						</td>
						<td>
							<button class="btn btn-primary" type="button"
								onclick="javascript:history.back()">返回</button> &nbsp;&nbsp;<font
							id="error" color="red">${error }</font>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</center>
	</section> </section>
	<%@include file="footer.jsp"%>
</body>
</html>

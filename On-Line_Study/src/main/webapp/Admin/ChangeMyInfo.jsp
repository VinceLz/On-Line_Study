<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="public.jsp"%>
<script type="text/javascript">
	function check() {
		var oldpwd = document.getElementById("oldpwd");
		var newpwd1 = document.getElementById("newpwd1");

		if (oldpwd.value == "") {
			alert("请输入昵称");
			return false;
		}

		if (newpwd1.value == "") {
			alert("请输入电话");
			return false;
		}

	}
</script>
<style>
input {
	margin-left: -100px;
}

.content-panel {
	background-color: #ffffff;
}
</style>
<section id="main-content">
	<section class="wrapper">
		<div>
			<p id="ur">
				<span class="glyphicon glyphicon-home"></span>&nbsp 当前位置>><a
					href="index.jsp">首页</a>>><a href="#">个人中心</a>>><a href="#">修改我的信息</a>
			</p>
		</div>
		<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
		</div>
		<p>当前账号：${admin }</p>
		<div class="row mt">
			<div class="content-panel">
				<center>
					<form action="<c:url value='/AdminInfoServlet'></c:url>"
						method="post">
						<table class="table table-striped table-advance table-hover"
							style="width: 60%;">
							<tr>
								<td><i class="glyphicon glyphicon-th"></i>属性</td>
								<td><i class="glyphicon glyphicon-th"></i>值</td>
							</tr>
							<tr>
								<td><i class="glyphicon glyphicon-th"></i>我的昵称：</td>
								<td><input type="text" name="nikename" id="oldpwd"
									class="form-control" style="" value="${myinfo.getNikename() }"></td>
							</tr>
							<tr>
								<td><i class=" 	glyphicon glyphicon-earphone"></i>我的联系方式：</td>
								<td><input type="text" name="phone" id="newpwd1"
									class="form-control" value="${myinfo.getCell() }"></td>
							</tr>

							<tr>
								<td style="text-align: center;"><input type="submit"
									value="修改" class="btn btn-success" onclick="return check()"></td>
								<td style="text-align: center;"><input type="reset"
									value="重置" class="btn btn-success"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="hidden" value="YesChangeMyInfo"
									name="method"></td>
								<td colspan="2"><input type="hidden" value="${admin }"
									name="account"></td>
							</tr>
						</table>
					</form>
				</center>
	</section>
</section>

<%@include file="footer.jsp"%>
</body>
</html>
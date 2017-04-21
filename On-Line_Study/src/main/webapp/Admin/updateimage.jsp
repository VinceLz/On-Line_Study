<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<%@include file="public.jsp"%>


	<section id="main-content">
		<section class="wrapper">
			<div class="">
				<div>
					<p id="ur">
						<span class="glyphicon glyphicon-home"></span>&nbsp
						当前位置>><a href="index.jsp">首页</a>>><a href="#">管理员修改头像</a>
					</p>
					<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
				</div>
				<center><div class="oldimage">
					<img src='<c:url value="/Admin/${img }"></c:url>' width="100px"
						height="120px;" />
					<p>这是您以前的头像</p>
				</div>
				<div>
					<form
						action="<c:url value='/AdminFileUploadServlet?method=fileupload'/>"
						method="post" enctype="multipart/form-data">
						<br /> 选择您需要上传的头像：<input type="file" name="zhaoPian" /><br /> <input
							type="submit" value="修改" class="btn btn-success"/>
					</form>
				</div>
				</center>
			</div>
		
	</section>
	</section>
	<%@include file="footer.jsp"%>


</body>
</html>

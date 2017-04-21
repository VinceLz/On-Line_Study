<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.glyphicon{
color:orange;}
table{
margin-top: 8%;
}
</style>
		<%@include file="public.jsp"%>

	<section id="main-content">
		<section class="wrapper">
			<div>
				<p id="ur">
					<span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>个人中心
				</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
			<div id="">
				<center><table class="table table-bordered table-striped table-condensed table-hover" style="width: 50%;">
					<tr>
						<td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span> 我的ID：</td>
						<td>${admininfo.getId() }</td>
					</tr>

					<tr>
						<td><span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span> 我的账号：</td>
						<td>${admininfo.getAccount() }</td>
					</tr>

					<tr>
						<td><span class="glyphicon glyphicon-link" aria-hidden="true"></span> 我的昵称：</td>
						<td>${admininfo.getNikename() }</td>
					</tr>

					<tr>
						<td><span class="glyphicon glyphicon-tint" aria-hidden="true"></span> 我的级别：</td>
						<td><c:if test="${admininfo.getRank()==0 }">
								<c:out value="超級"></c:out>
							</c:if> <c:if test="${admininfo.getRank()==1 }">
								<c:out value="普通"></c:out>
							</c:if> <c:if test="${admininfo.getRank()==2 }">
								<c:out value="待定"></c:out>
							</c:if></td>
					</tr>

					<tr>
						<td><span class=" 	glyphicon glyphicon-phone-alt" aria-hidden="true"></span> 电话：</td>
						<td>${admininfo.getCell() }</td>
					</tr>

					<tr>
						<td><span class=" 	glyphicon glyphicon-picture" aria-hidden="true"></span> 我的头像：</td>
						<td><img src="Admin/${img }" width="100px" height="150px"/></td>
					</tr>

					<tr>
						<td><span class=" 	glyphicon glyphicon-transfer" aria-hidden="true"></span> 历史登录次数：</td>
						<td>${admininfo.getLogintime() }</td>
					</tr>
				</table></center>
			</div>
		
	</section>
	</section>
	<%@include file="footer.jsp"%>

</body>
</html>

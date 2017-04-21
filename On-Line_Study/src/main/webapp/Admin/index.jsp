<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<%@include file="public.jsp"%>

<section id="main-content">
	<section class="wrapper">
		<div>
			<p id="ur">
				<span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页
			</p>
		</div>
		<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
		<div id="content" style="margin-top: 5%;">
			<table
				class="table table-bordered table-striped table-condensed table-hover"
				id="userinfo">
				<tr>
					<td colspan="4">系统信息</td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td>${admin }</td>
					<td>IP：</td>
					<td>${UIP }</td>
				</tr>
				<tr>
					<td>现在时间：</td>
					<td><div id="time"></div>
					</td>
					<td>过期时间：</td>
					<td>30分钟</td>
				</tr>
				<tr>
					<td>登录次数：</td>
					<td>${logintime+1 }</td>
					<td>本次上线时间：</td>
					<td>${time }</td>
				</tr>
				<tr>
					<td>网站名称：</td>
					<td>智源学堂</td>
					<td>网站域名：</td>
					<td>www.zhiyuanxt.com</td>
				</tr>

				<tr>
					<td>网站版权信息：</td>
					<td>zhaoyongbo</td>
					<td>备案号：</td>
					<td>1235131231561321</td>
				</tr>

				<tr>
					<td>当前操作系统：</td>
					<td>${userbrowser }</td>
					<td>当前浏览器名：</td>
					<td>${useros}</td>
				</tr>

				<tr>
					<td>服务器操作系统：</td>
					<td>${os }</td>
					<td>服务器IP：</td>
					<td>${ip }</td>
				</tr>
			</table>
		</div>

	</section>
</section>
<%@include file="footer.jsp"%>

</body>
</html>

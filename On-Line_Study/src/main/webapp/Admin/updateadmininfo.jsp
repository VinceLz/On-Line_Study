<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.p{
font-size: 40%;
color: red;
}
</style>

<c:if test="${grade!=0 }"><jsp:forward page="/Admin/isnotsuperadmin.jsp"/></c:if>
	
		<%@include file="public.jsp"%>
	 <c:if test="${grade!=1&&grade!=0 }"><jsp:forward page="/Admin/isnotnormaladmin.jsp"/></c:if>
	
	<section id="main-content">
		<section class="wrapper">
			<div>
				<p id="ur">
					<span class="glyphicon glyphicon-home"></span>&nbsp
					当前位置>>首页>>所有用户>>修改信息
				</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
			<div  class="form-group">
				<center><form action='<c:url value="/AdminInfoServlet"></c:url>'
					method="post">
					<table class="table table-bordered table-striped table-condensed table-hover"  style="width: 60%;">

						<tr>
							<td>管理员ID：</td>
							<td><input type="text" name="id"
								value="${updateadmininfo.getId() }" readOnly="true"  class="form-control"/><p class="p">不可更改</p></td>
						</tr>

						<tr>
							<td>管理员账号：</td>
							<td><input type="text" name="account"
								value="${updateadmininfo.getAccount() }" readOnly="true"  class="form-control"/><p class="p">不可更改</p></td>
						</tr>

						<tr>
							<td>密码：</td>
							<td><input type="text" name="pwd"
								value="${updateadmininfo.getPwd() }"  class="form-control"/></td>
						</tr>

						<tr>
							<td>级别：</td>
							<td><select   name="rank" <c:if test="${admin==updateadmininfo.getAccount() }"><c:out value="onfocus=this.defaultIndex=this.selectedIndex; onchange=this.selectedIndex=this.defaultIndex;"></c:out></c:if>  class="form-control"  style="width: 30%;">
									<option value="超级"
										<c:if test="${updateadmininfo.getRank()==0 }"><c:out value="selected='selected'"></c:out></c:if>>超级</option>
									<option value="普通"
										<c:if test="${updateadmininfo.getRank()==1 }"><c:out value="selected='selected'"></c:out></c:if>>普通</option>
									<option value="待定"
										<c:if test="${updateadmininfo.getRank()==2 }"><c:out value="selected='selected'"></c:out></c:if>>待定</option>
							</select><c:if test="${admin==updateadmininfo.getAccount() }"><p class="p"><c:out value="这是您自己的信息，级别不可更改"></c:out></p></c:if></td>
						</tr>

						<tr>
							<td>电话：</td>
							<td><input type="text" name="cell"
								value="${updateadmininfo.getCell() }"  class="form-control"/></td>
						</tr>

						<tr>
							<td>昵称：</td>
							<td><input type="text" name="nikename"
								value="${updateadmininfo.getNikename() }"  class="form-control"/></td>
						</tr>

						<tr>
							<td>头像：</td>
							<td><input type="text" name="picture"
								value="${updateadmininfo.getPicture() }"  class="form-control"/></td>
						</tr>

						<tr>
							<td>登录次数：</td>
							<td><input type="text" name="logintime"
								value="${updateadmininfo.getLogintime() }" readOnly="true"  class="form-control"/><p class="p">不可更改</p></td>
						</tr>
						<input type="hidden" name="method" value="yesupdatemethod"  class="form-control"/>

						<tr>
							<td></td>
							<td><input type="submit" value="确认修改"  class="btn btn-success" /></td>
						</tr>
					</table>
				</form></center>
			</div>
			</center>
		</section>
	</section>

	<!--main content end-->
	<!--footer start-->
	<footer class="site-footer">
		<div class="text-center">
			2014 - Alvarez.is <a href="http://www.mycodes.net/" target="_blank">源码之家</a>
			<a href="http://www.mycodes.net/" target="_blank">源码之家</a> <a
				href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
			</a>
		</div>
	</footer>
	<!--footer end-->
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>

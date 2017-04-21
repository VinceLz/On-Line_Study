<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:if test="${grade!=1&&grade!=0 }"><jsp:forward page="/Admin/isnotnormaladmin.jsp"/></c:if>

		<%@include file="public.jsp"%>

	<section id="main-content">
		<section class="wrapper">
			<div>
				<p id="ur">
					<span class="glyphicon glyphicon-home"></span>&nbsp
				当前位置>>首页>>所有用户>>修改用户信息</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
			<div  class="form-group">
				<center><form action='<c:url value="/AdminUpdateUserServlet"></c:url>'
					method="post">
					<table class="table table-bordered table-striped table-condensed table-hover" style="width: 50%;">
						<tr>
							<td>用户账号：</td>
							<td><input type="text" name="account"
								value="${updatestuinfo.getAccount() }" class="form-control" readonly="readonly">不可修改</td>
						</tr>

						<tr>
							<td>用户密码：</td>
							<td><input type="text" name="pwd"
								value="${updatestuinfo.getPwd() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>昵称：</td>
							<td><input type="text" name="nickname"
								value="${updatestuinfo.getNickName() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>职业：</td>
							<td><input type="text" name="profession"
								value="${updatestuinfo.getProfession() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>性别：</td>
							<td><select name="sex" class="form-control" style="width: 40%;">
									<option value="男"
										<c:if test="${updatestuinfo.getSex()=='男'}"><c:out value="selected=selected"></c:out></c:if>>男</option>
									<option value="女"
										<c:if test="${updatestuinfo.getSex()=='女' }"><c:out value="selected=selected"></c:out></c:if>>女</option>
									<option value="未"
										<c:if test="${updatestuinfo.getSex()=='未' }"><c:out value="selected=selected"></c:out></c:if>>未</option>
							</select></td>
						</tr>

						<tr>
							<td>省：</td>
							<td><input type="text" name="province"
								value="${updatestuinfo.getProvince() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>市：</td>
							<td><input type="text" name="city"
								value="${updatestuinfo.getCity() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>邮箱：</td>
							<td><input type="text" name="email"
								value="${updatestuinfo.getE_mail() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>兴趣：</td>
							<td><select name="interest" class="form-control"  style="width: 40%;">
									<c:forEach var="inter" items="${allinterest }">
										<option value="${inter.getInterestName()}"
											<c:if test="${updatestuinfo.getInterest() ==inter.getInterestName()}"><c:out value="selected='selected'"></c:out></c:if>>${inter.getInterestName() }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>程度：</td>
							<td><input type="text" name="degree"
								value="${updatestuinfo.getDegree() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>个人简介：</td>
							<td><input type="text" name="resume"
								value="${updatestuinfo.getResume() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>个性签名：</td>
							<td><input type="text" name="signature"
								value="${updatestuinfo.getSignature() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>注册日期：</td>
							<td><input type="text" name="date"
								value="${updatestuinfo.getDate() }" class="form-control"/></td>
						</tr>

						<tr>
							<td>头像：</td>
							<td><input type="text" name="picture"
								value="${updatestuinfo.getPicture() }" class="form-control"/></td>
						</tr>

						<input type="hidden" name="method" value="yesupdatemethod" />

						<tr>
							<td></td>
							<td><input type="submit" value="确认修改" class="btn btn-success" /></td>
						</tr>
					</table>
				</form></center>
			</div>
			</center>
		
	</section>
	</section>
	<%@include file="footer.jsp"%>

</body>
</html>

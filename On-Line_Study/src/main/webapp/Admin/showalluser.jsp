<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="public.jsp"%>
<style>
td {
	word-break: break-all;
}

th {
	text-align: center;
}
</style>
<script>
	function IsOk() {
		if (window.confirm("确定删除？此操作不可返回")) {
			return true;
		} else {
			return false;
		}
	}
</script>
<section id="main-content">
	<section class="wrapper">
		<div>
			<p id="ur">
				<span class="glyphicon glyphicon-home"></span>&nbsp 当前位置>><a
					href="index.jsp">首页</a>>><a href="#">用户管理</a>>><a href="#">所有用户信息</a>
			</p>
		</div>
		<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
		<div id="serch" class="form-group">
			<table>
				<form action="<c:url value='/AdminShowUserInfoServlet'></c:url>"
					method="post">
					<input type="hidden" name="method" value="accountsearch"><input
						type="hidden" name="count" value="1">
					<td><input type="hidden" name="page" value="1">
					<tr>
						<td>账号搜索：</td>
						<td><input type="text" name="account" placeholder="用户账号"
							class="form-control" style="width: 200px;"></td>
						<td><input type="submit" value="搜索" class="btn btn-success" /></td>
					</tr>
				</form>
			</table>
		</div>
		<div style="">
			<p>
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>所有用户信息
			</p>
			<table
				class="table table-bordered table-striped table-condensed table-hover"
				border="1" style="text-align: center;">
				<tr>
					<td colspan="17"><strong>用户信息</strong></td>
				</tr>
				<tr>
					<th>用户ID</th>
					<th>用户账号</th>
					<th>密码</th>
					<th>昵称</th>
					<th>职业</th>
					<th>性别</th>
					<th>省</th>
					<th>市</th>
					<th>邮箱</th>
					<th>兴趣</th>
					<th>程度</th>
					<th>个人简介</th>
					<th>个性签名</th>
					<th>时间</th>
					<th>图片路径</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
				<c:forEach var="aa" items="${alluser }">
					<c:if test="${aa.getId()==null}">
						<p>无此记录</p>
					</c:if>
				</c:forEach>
				<c:forEach var="aa" items="${alluser }">
					<tr>
						<td style="">${aa.getId()}</td>
						<td>${aa.getAccount()}</td>
						<td>${aa.getPwd()}</td>
						<td>${aa.getNickName()}</td>
						<td>${aa.getProfession()}</td>
						<td>${aa.getSex()}</td>
						<td>${aa.getProvince()}</td>
						<td>${aa.getCity()}</td>
						<td>${aa.getE_mail()}</td>
						<td>${aa.getInterest()}</td>
						<td>${aa.getDegree()}</td>
						<td>${aa.getResume()}</td>
						<td>${aa.getSignature()}</td>
						<td>${aa.getDate()}</td>
						<td>${aa.getPicture()}</td>
						<td><a
							href="<c:url value="/AdminUpdateUserServlet?method=update&acount=${aa.getAccount() }"></c:url>"
							class="btn btn-warning"><i class="fa fa-pencil"></i></a></td>
						<td><a
							href="<c:url value="/AdminUpdateUserServlet?method=delete&acount=${aa.getAccount() }"></c:url>"
							class="btn btn-danger" onclick="return IsOk()"><i
								class="fa fa-trash-o "></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${unique!='account' }">
			<div id="fenye">
				<a
					href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">首页</a><a
					href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${page-1 }'></c:url>">上一页</a>
				<c:if test="${page<3 }">
					<c:if test="${weiye==1}">
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>

					</c:if>
					<c:if test="${weiye==2}">
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>

					</c:if>
					<c:if test="${weiye==3}">
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>

					</c:if>
					<c:if test="${weiye==4}">
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=4'></c:url>">4</a>
					</c:if>
					<c:if test="${weiye==5}">
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=4'></c:url>">4</a>
						<a
							href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=5'></c:url>">5</a>
					</c:if>
				</c:if>
				<c:if test="${page>=3}">
					<a
						href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${page-2 }'></c:url>">${page-2 }</a>
					<a
						href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${page-1 }'></c:url>">${page-1 }</a>
					<a
						href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${page }'></c:url>">${page }</a>
					<a
						href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${page+1 }'></c:url>">${page+1 }</a>
					<a
						href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${page+2 }'></c:url>">${page+2 }</a>
				</c:if>
				<a>第${page }页/共${weiye }页</a> <a
					href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${page+1 }'></c:url>">下一页</a>

				<a
					href="<c:url value='/AdminShowUserInfoServlet?method=showinfo&count=${count }&page=${weiye }'></c:url>">尾页</a>
				<form
					action="<c:url value="${request.getContextPath}/AdminChangeCountServlet"></c:url>">
					每页显示：<input type="text" name="count" /> <select>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					</select> <input type="hidden" name="method" value="change" /> <input
						type="submit" value="确定" />
				</form>

			</div>
		</c:if>
	</section>
</section>

<%@include file="footer.jsp"%>

</body>
</html>
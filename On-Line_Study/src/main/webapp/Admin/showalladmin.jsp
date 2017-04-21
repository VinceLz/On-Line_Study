<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${grade!=0 }"><jsp:forward
		page="/Admin/isnotsuperadmin.jsp" /></c:if>
<%@include file="public.jsp"%>

<!--sidebar end-->
<style>
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
<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<div>
			<p id="ur">
				<span class="glyphicon glyphicon-home"></span>&nbsp 当前位置>><a
					href="index.jsp">首页</a>>><a href="#">管理员管理</a>>><a href="#">所有管理员信息</a>
			</p>
		</div>
		<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
		<div id="serch" class="form-group">
			<table>
				<form action="<c:url value='/AdminInfoServlet'></c:url>"
					method="post">
					<tr>
						<td>账号搜索：</td>
						<td><input type="text" name="account" class="form-control"
							placeholder="管理员账号"></td>
						<input type="hidden" name="method" value="accountsearch">
						<input type="hidden" name="count" value="1">
						<td><input type="hidden" name="page" value="1" /> <input
							type="submit" value="搜索" class="btn btn-success" /></td>
					</tr>
				</form>
			</table>
		</div>
		<div>
			<p>
				<span class="glyphicon glyphicon-font" aria-hidden="true"></span>
				所有管理员信息
			</p>
			<table
				class="table table-bordered table-striped table-condensed table-hover">
				<tr>
					<td colspan="17">管理员信息</td>
				</tr>
				<tr>
					<th>管理员ID</th>
					<th>管理员账号</th>
					<th>密码</th>
					<th>昵称</th>
					<th>级别</th>
					<th>联系方式</th>
					<th>登陆次数</th>
					<th>头像</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
				<c:forEach var="aa" items="${alladmin }">
					<c:if test="${aa.getId()==null}">
						<p>无此记录</p>
					</c:if>
				</c:forEach>
				<c:forEach var="aa" items="${alladmin }">
					<tr>
						<td>${aa.getId()}</td>
						<td>${aa.getAccount()}</td>
						<td>${aa.getPwd()}</td>
						<td>${aa.getNikename()}</td>
						<td><c:if test="${aa.getRank()==0 }">
								<c:out value="超級"></c:out>
							</c:if> <c:if test="${aa.getRank()==1 }">
								<c:out value="普通"></c:out>
							</c:if> <c:if test="${aa.getRank()==2 }">
								<c:out value="待定"></c:out>
							</c:if></td>
						<td>${aa.getCell()}</td>
						<td>${aa.getLogintime()}</td>
						<td>${aa.getPicture()}</td>
						<td><a
							href="<c:url value="/AdminInfoServlet?method=update&acount=${aa.getAccount() }"></c:url>"
							class="btn btn-warning"><i class="fa fa-pencil"></i></a></td>
						<td><a
							href="<c:url value="/AdminInfoServlet?method=delete&acount=${aa.getAccount() }"></c:url>"
							class="btn btn-danger" onclick="return IsOk()"><i
								class="fa fa-trash-o "></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${unique!='account' }">
			<div id="fenye">
				<a
					href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">首页</a><a
					href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${page-1 }'></c:url>">上一页</a>
				<c:if test="${page<3 }">
					<c:if test="${weiye==1}">
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>

					</c:if>
					<c:if test="${weiye==2}">
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>

					</c:if>
					<c:if test="${weiye==3}">
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>

					</c:if>
					<c:if test="${weiye==4}">
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=4'></c:url>">4</a>
					</c:if>
					<c:if test="${weiye==5}">
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=4'></c:url>">4</a>
						<a
							href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=5'></c:url>">5</a>
					</c:if>
				</c:if>
				<c:if test="${page>=3}">
					<a
						href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${page-2 }'></c:url>">${page-2 }</a>
					<a
						href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${page-1 }'></c:url>">${page-1 }</a>
					<a
						href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${page }'></c:url>">${page }</a>
					<a
						href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${page+1 }'></c:url>">${page+1 }</a>
					<a
						href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${page+2 }'></c:url>">${page+2 }</a>
				</c:if>
				<a>${page }/${weiye }</a> <a
					href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${page+1 }'></c:url>">下一页</a>

				<a
					href="<c:url value='/AdminInfoServlet?method=showinfo&count=${count }&page=${weiye }'></c:url>">尾页</a>
				<form
					action="<c:url value="${request.getContextPath}/AdminInfoServlet"></c:url>">
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

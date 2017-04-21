<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function IsOk() {
		if (window.confirm("确定删除？此操作不可返回")) {
			return true;
		} else {
			return false;
		}
	}
</script>
<style>
tr {
	text-align: center;
}

td {
	text-align: center;
}
</style>
<%@include file="public.jsp"%>
<section id="main-content">
	<section class="wrapper">
		<div>
			<p id="ur">
				<span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>兴趣管理>>所有兴趣
			</p>
		</div>
		<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
		<div id="">
			<table
				class="table table-bordered table-striped table-condensed table-hover">
				<tr>
					<td colspan="7">兴趣列表</td>
				</tr>
				<tr>
					<th>兴趣ID</th>
					<th>兴趣名称</th>
					<th>兴趣详情</th>
					<th>是否首页显示</th>
					<th>链接</th>
					<th>修改</th>
					<th>删除</th>
				</tr>

				<c:forEach var="aa" items="${allinterest }">
					<c:if test="${aa.getId()==null}">
						<p>无此记录</p>
					</c:if>
				</c:forEach>
				<c:forEach var="aa" items="${allinterest }">
					<tr>
						<td>${aa.getId()}</td>
						<td>${aa.getInterestName()}</td>
						<td>${aa.getAttribute()}</td>
						<td>${aa.getIsuse()}</td>
						<td>${aa.getSrc()}</td>
						<td><a
							href="<c:url value="/AdminManageInterestServlet?method=update&id=${aa.getId() }"></c:url>"
							class="btn btn-warning"><i class="fa fa-pencil"></i></a></td>
						<td><a
							href="<c:url value="/AdminManageInterestServlet?method=delete&id=${aa.getId() }"></c:url>"
							class="btn btn-danger" onclick="return IsOk()"><i
								class="fa fa-trash-o "></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${unique!='account' }">
			<div id="fenye">
				<a
					href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=1'></c:url>">首页</a><a
					href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${page-1 }'></c:url>">上一页</a>
				<c:if test="${page<=6 }">
				<c:out value="${weiye }"></c:out>
					<c:if test="${weiye==1}">
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>

					</c:if>
					<c:if test="${weiye==2}">
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>

					</c:if>
					<c:if test="${weiye==3}">
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>

					</c:if>
					<c:if test="${weiye==4}">
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=4'></c:url>">4</a>
					</c:if>
					<c:if test="${weiye==5}">
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=4'></c:url>">4</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=5'></c:url>">5</a>
					</c:if>
					<c:if test="${weiye==6}">
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=1'></c:url>">1</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=2'></c:url>">2</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=3'></c:url>">3</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=4'></c:url>">4</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=5'></c:url>">5</a>
						<a
							href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=6'></c:url>">6</a>
					</c:if>

				</c:if>
				<c:if test="${page>=7}">
					<a
						href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${page-2 }'></c:url>">${page-2 }</a>
					<a
						href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${page-1 }'></c:url>">${page-1 }</a>
					<a
						href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${page }'></c:url>">${page }</a>
					<a
						href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${page+1 }'></c:url>">${page+1 }</a>
					<a
						href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${page+2 }'></c:url>">${page+2 }</a>
				</c:if>
				<a>${page }/${weiye }</a> <a
					href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${page+1 }'></c:url>">下一页</a>

				<a
					href="<c:url value='/AdminManageInterestServlet?method=showinfo&count=${count }&page=${weiye }'></c:url>">尾页</a>
				<form
					action="<c:url value="${request.getContextPath}/AdminManageInterestServlet"></c:url>">
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
		</table>
		</div>

	</section>
</section>
<%@include file="footer.jsp"%>

</body>
</html>

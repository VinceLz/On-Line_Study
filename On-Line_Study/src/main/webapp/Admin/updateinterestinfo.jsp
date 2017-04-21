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
					<span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>兴趣管理>>所有兴趣
				</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
			<div  class="form-group"> 

				<center><form class="well form-search" action="AdminManageInterestServlet">
					<table class="table table-bordered table-striped table-condensed table-hover" style="width: 50%;">
						<tr>
							<th>属性</th>
							<th>值</th>
						</tr>
						<tr>
							<td>兴趣ID:</td>
							<td><input name="id" value="${interestinfoone.getId() }" readonly="readonly" class="form-control"/>不可更改</td>
						</tr>
						<tr>
							<td>兴趣名称:</td>
							<td><select name="interestname" class="form-control"  style="width: 20%;">
									<c:forEach var="inter" items="${allinterestlist }">
										<option value="${inter.getInterestName()}"
											<c:if test="${interestinfoone.getInterestName() ==inter.getInterestName()}"><c:out value="selected='selected'"></c:out></c:if>>${inter.getInterestName() }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>兴趣详情:</td>
							
							<td><textarea rows="3" cols="20" name="attribute" class="form-control">${interestinfoone.getAttribute() }</textarea>详情间用半角分号隔开</td>
						</tr>
						<tr>
							<td>首页是否显示:</td>
							<td><select name="isuse" class="form-control"  style="width: 15%;">
									<option value="是"
										<c:if test="${interestinfoone.getIsuse()=='是'}"><c:out value="selected=selected"></c:out></c:if>>是</option>
									<option value="否"
										<c:if test="${interestinfoone.getIsuse()=='否' }"><c:out value="selected=selected"></c:out></c:if>>否</option>
							</select></td>
						</tr>
						<tr>
							<td>链接地址:</td>
							<td><input name="src" value="${interestinfoone.getSrc() }" class="form-control"/></td>
						</tr>
						<tr><input type="hidden"  name="method" value="yesUpdateInterestInfo"  class="form-control"/>
							<td colspan="2"><center><input type="submit" value="提交" class="btn btn-success" class="form-control"/></center></td>
							
						</tr>
						<input type="hidden" name="method" value="adminYesUpdateInterestInfo"  class="form-control"/>
					</table>
				</form></center>
			</div>
		
	</section>
	</section>
	<%@include file="footer.jsp"%>

</body>
<style>
th{
text-align: center;
}
tr{
text-align: center;
}
</style>
</html>

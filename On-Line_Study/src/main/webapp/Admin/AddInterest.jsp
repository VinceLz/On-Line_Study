<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:if test="${grade!=1&&grade!=0 }"><jsp:forward page="/Admin/isnotnormaladmin.jsp"/></c:if>
      <%@include file="public.jsp" %>

      <section id="main-content">
          <section class="wrapper">
          	<div>
			<p id="ur"><span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>兴趣管理>>添加兴趣名称</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
            <div>
         <form class="well form-search" action="AdminManageInterestServlet">
					<table class="table table-striped table-advance table-hover">
						<tr>
							<th>属性</th>
							<th>值</th>
						</tr>
						<tr>
							<td>兴趣名称</td>
							<td><select name="interestname">
									<c:forEach var="inter" items="${allinterestlist }">
										<option value="${inter.getInterestName()}">${inter.getInterestName()}</option>
									     
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>兴趣详情</td>
							
							<td><textarea rows="3" cols="20" name="attribute"></textarea><p>详情间用半角分号隔开</p></td>
						</tr>
						<tr>
							<td>首页是否显示</td>
							<td><select name="isuse">
									<option value="是">是</option>
									<option value="否">否</option>
							</select></td>
						</tr>
						<tr>
							<td>链接</td>
							<td><input name="src" class="input-medium search-query" /></td>
						</tr>
						<tr><input type="hidden"  name="method" value="YesAddInterest" />
						
							<td colspan="2"><input type="submit" value="提交" class="btn btn-success"/></td>
							<td colspan="2"><input type="hidden" name="method" value="adminYesUpdateInterestInfo" /></td>
						</tr>
					</table>
				</form>
            </div>
         
      </section>
  </section>
  <%@include file="footer.jsp" %>

  </body>
  
</html>

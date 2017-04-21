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
            <form action="AdminManageInterestServlet" method="post" class="well form-search">
            兴趣名称：<input type="text" name="interestname" class="well search-query"/>
            <input type="hidden" name="method" value="AddInterestName">
            <input type="submit" value="添加" class="btn btn-success"/>
            </form>
            </div>
         
      </section>
  </section>
  <%@include file="footer.jsp" %>

  </body>
</html>

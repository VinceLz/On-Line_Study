<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <c:if test="${grade!=0 }"><jsp:forward page="/Admin/isnotsuperadmin.jsp"/></c:if>
 <c:if test="${grade!=1&&grade!=0 }"><jsp:forward page="/Admin/isnotnormaladmin.jsp"/></c:if>
      <%@include file="public.jsp" %>
<!-- sdfesfsfdsd -->
      <section id="main-content">
          <section class="wrapper">
          	<div>
			<p id="ur"><span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>用户管理>>添加用户</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
            <center><div id="content" class="form-group">           
                  	           <form action='<c:url value="/AdminInfoServlet"></c:url>' method="post">
            <table border="1" class="table table-bordered table-striped table-condensed table-hover" style="width: 50%;"> 
             <tr>
             <td>管理员账号：</td>
             <td><input type="text" name="account" class="form-control"/></td>
             </tr>  
             
              <tr>
             <td>管理员密码：</td>
             <td><input type="text" name="pwd" class="form-control"/></td>
             </tr>  
             
              <tr>
             <td>级别：</td>
             <td><select name="rank" class="form-control" style="width: 25%;">
             <option value="超级">超级</option>
             <option value="普通">普通</option>
             <option value="待定">待定</option>
             </select></td>
             </tr>  
             
              <tr>
             <td>电话：</td>
             <td><input type="text" name="cell" class="form-control"/></td>
             </tr>  
             
             
             <tr>
             <td>昵称：</td>
             <td><input type="text" name="nikename" class="form-control"/></td>
             </tr>  
         
             <input type="hidden" name="method" value="addadmin"/>
             
              <tr>
             <td></td>
             <td><input type="submit" value="确认添加" class="btn btn-success"/></td>
             </tr>
            </table>
           </form>
                    </div>  </center> 
          
      </section>
  </section>
     <%@include file="footer.jsp" %>
 
  </body>
</html>

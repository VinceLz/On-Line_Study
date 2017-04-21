<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
	<%@include file="/Admin/public.jsp"%>
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> 菜单管理</h3>

              <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
	                  	  	  <h4><i class="fa fa-angle-right"></i> 菜单项管理</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th><i class="glyphicon glyphicon-pushpin"></i>id</th>
                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> 父菜单id</th>
                                  <th><i class="glyphicon glyphicon-fire"></i> 菜单名</th>
                                  <th><i class=" fa fa-edit"></i> 菜单链接</th>
                                  <th><i class="glyphicon glyphicon-sort"></i> 菜单顺序</th>
                                  <th><i class="glyphicon glyphicon-eye-open"></i> 是否启用</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              
                              <c:forEach items="${menuList }" var="menu">
                              <tr>
                                  <td><a href="basic_table.html#">${menu.menuId }</a></td>
                                  <c:if test="${menu.parentMenuId !=0}">
                                  <td class="hidden-phone">${menu.parentMenuId }</td>
                                  </c:if>
                                  <c:if test="${menu.parentMenuId ==0}">
                                  <td class="hidden-phone">无</td>
                                  </c:if>
                                  <td>${menu.menuName }</td>
                                  <td><span class="label label-info label-mini">${menu.menuAddr }</span></td>
                                  <td>${menu.menuOrder} </td>
                                  <c:if test="${menu.isUse == 0}">
                                  <td>是</td>
                                  </c:if>
                                  <c:if test="${menu.isUse !=0 }">
                                  <td>否</td>
                                  </c:if>                               
                                  <td>
                                      <button class="btn btn-primary btn-xs" onclick="location='AdminMenuServlet?method=showMenuDetail&mid=${menu.menuId}'"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs" onclick="location='AdminMenuServlet?method=deleteMenu&menuId=${menu.menuId}'"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </c:forEach>    
                              </tbody>
                          </table>
                      </div><!-- /content-panel -->
                  </div><!-- /col-md-12 -->
              </div><!-- /row -->

		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is  <a href="http://www.mycodes.net/" target="_blank">xxx</a>
              <a href="basic_table.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>
     <%@include file="footer.jsp" %>    
  </body>
</html>

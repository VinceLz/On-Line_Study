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
	                  	  	  <h4><i class="fa fa-angle-right"></i> 资源种类管理</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th><i class="glyphicon glyphicon-pushpin"></i>资源种类id</th>
                                  <th><i class="glyphicon glyphicon-fire"></i> 种类名</th>
                                  <th><i class=" fa fa-edit"></i> 种类链接</th>
                   
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              
                              <c:forEach items="${categoryList }" var="category">
                              <tr>
                                  <td><a href="basic_table.html#">${category.categoryId }</a></td>
                                  <td>${category.categoryName }</td>
                                  <td>${category.categoryLink} </td>                             
                                  <td>
                                      <button class="btn btn-primary btn-xs" onclick="location='AdminCategoryServlet?method=showCategoryDetail&cId=${category.categoryId}'"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs" onclick="location='AdminCategoryServlet?method=deleteCategory&cId=${category.categoryId}'"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </c:forEach>    
                              </tbody>
                          </table>
                      </div><!-- /content-panel -->
                  </div><!-- /col-md-12 -->
              </div><!-- /row -->
				<c:if test="${unique!='account' }">
					<div id="fenye">
						<a
						href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=1'></c:url>">首页</a><a
						href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${page-1 }'></c:url>">上一页</a>
						<c:if test="${page<3}">
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=1'></c:url>">1</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=2'></c:url>">2</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=3'></c:url>">3</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=4'></c:url>">4</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=5'></c:url>">5</a>
						</c:if>
						<c:if test="${page>=3}">
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${page-2 }'></c:url>">${page-2 }</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${page-1 }'></c:url>">${page-1 }</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${page }'></c:url>">${page }</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${page+1 }'></c:url>">${page+1 }</a>
							<a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${page+2 }'></c:url>">${page+2 }</a>
						</c:if>
						<a>${page }/${weiye }</a> <a
						href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${page+1 }'></c:url>">下一页</a>
						<a
						href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=${count }&page=${weiye }'></c:url>">尾页</a>
					</div>
				</c:if> 
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

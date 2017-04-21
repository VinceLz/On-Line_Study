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
          	<h3><i class="fa fa-angle-right"></i> 资源管理</h3>

              <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
	                  	  <h4><i class="fa fa-angle-right"></i> 资源项管理</h4>
	                  	  <section id="unseen">
                          <table class="table table-bordered table-striped table-condensed">
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th>id</th>
                                  <th class="numeric"> 资源名</th>
                                  <th class="numeric"> 上传时间</th>
                                  <th class="numeric"> 种类</th>
                                  <th class="numeric"> 兴趣id</th>
                                  <th class="numeric"> 等级id</th>
                                  <th class="numeric"> 摘要</th>
                                  <th class="numeric"> 课程id</th>
                                  <th class="numeric"> 积分</th>
                                  <th class="numeric"> 资源类型</th>
                                  <th class="numeric"> 链接地址</th>
                                  <th class="numeric"> 前台class名</th>
                                  <th class="numeric"> 点赞数</th>
                                  <th class="numeric"></th>
                              </tr>
                              </thead>
                              <tbody>
                              
                              <c:forEach items="${resourceList }" var="resource">
                              <tr>
                                  <td>${resource.id}</td>
                                  <td>${resource.resourceName }</td>
                                  <td>${resource.uploadeDate }</td>
                                  <td>${resource.category} </td>
                                  <td>${resource.beLongToInterestID}</td>
                                  <td>${resource.beLongToDegreeID}</td>
                                  <td>${resource.resume} </td>
                                  <td>${resource.classNameID} </td>
                                  <td>${resource.score} </td>
                                  <td>${resource.resourceType} </td>
                                  <td>${resource.linkSrc} </td>
                                  <td>${resource.frontClassName} </td>
                                  <td>${resource.likeSum} </td>
                                  <td>
                                      <button class="btn btn-primary btn-xs" onclick="location='AdminResourceServlet?method=showResourceDetailById&rId=${resource.id}'"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs" onclick="location='AdminResourceServlet?method=deleteResourceById&rId=${resource.id}'"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </c:forEach>    
                              </tbody>
                          </table>
                          </section>
                      </div><!-- /content-panel -->
                  </div><!-- /col-md-12 -->
              </div><!-- /row -->
				<c:if test="${unique!='account' }">
					<div id="fenye">
						<a
						href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=1'></c:url>">首页</a><a
						href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${page-1 }'></c:url>">上一页</a>
						<c:if test="${page<3}">
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=1'></c:url>">1</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=2'></c:url>">2</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=3'></c:url>">3</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=4'></c:url>">4</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=5'></c:url>">5</a>
						</c:if>
						<c:if test="${page>=3}">
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${page-2 }'></c:url>">${page-2 }</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${page-1 }'></c:url>">${page-1 }</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${page }'></c:url>">${page }</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${page+1 }'></c:url>">${page+1 }</a>
							<a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${page+2 }'></c:url>">${page+2 }</a>
						</c:if>
						<a>${page }/${weiye }</a> <a
						href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${page+1 }'></c:url>">下一页</a>

						<a
						href="<c:url value='/AdminResourceServlet?method=showAllResource&count=${count }&page=${weiye }'></c:url>">尾页</a>
						<form
						action="<c:url value="${request.getContextPath}/AdminResourceServlet"></c:url>">
							每页显示：<input type="text" name="count" />
							<input type="hidden" name="method" value="changePage" /> <input
							type="submit" value="确定" />
						</form>

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
 
     <%@include file="footer.jsp" %>    
  </body>
</html>

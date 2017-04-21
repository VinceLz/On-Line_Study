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
          	<h3><i class="fa fa-angle-right"></i> 首页管理</h3>

              <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
	                  	  	  <h4><i class="fa fa-angle-right"></i> 首页管理</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th><i class="glyphicon glyphicon-pushpin"></i>id</th>
                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> logo主题名</th>
                                  <th><i class="glyphicon glyphicon-fire"></i> 摘要1</th>
                                  <th><i class=" fa fa-edit"></i> 摘要2</th>
                                  <th><i class="fa fa-edit"></i> 优势1主标题</th>
                                  <th><i class="fa fa-edit"></i> 优势2主标题</th>
                                  <th><i class="fa fa-edit"></i> 优点1主标题</th>
                                  <th><i class="fa fa-edit"></i> 优点2主标题</th>
                                  <th><i class="fa fa-edit"></i> 优点3主标题</th>
                                  <th><i class="fa fa-edit"></i> 优点4主标题</th>
                                  <th><i class="fa fa-edit"></i> 是否启用</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              
                              <c:forEach items="${indexModelList }" var="indexModel">
                              <tr>
                                  <td>${indexModel.indexId}</td>
                                  <td>${indexModel.logoTitle}</td>
                                  <td>${indexModel.summaryMain}</td>
                                  <td>${indexModel.summarySub}</td>
                                  <td>${indexModel.advantage1}</td>
                                  <td>${indexModel.advantage2}</td>
                                  <td>${indexModel.merit1}</td>
                                  <td>${indexModel.merit2}</td>
                                  <td>${indexModel.merit3}</td>
                                  <td>${indexModel.merit4}</td>
                                  
                                  <c:if test="${indexModel.isUse == 0}">
                                  <td>是</td>
                                  </c:if>
                                  <c:if test="${indexModel.isUse !=0 }">
                                  <td>否</td>
                                  </c:if>
                                                                 
                                  <td>
                                      <button class="btn btn-primary btn-xs" onclick="location='AdminIndexServlet?method=showIndexDetail&indexId=${indexModel.indexId}'"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs" onclick="location='AdminIndexServlet?method=deleteIndex&indexId=${indexModel.indexId}'"><i class="fa fa-trash-o "></i></button>
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

  </section>
     <%@include file="footer.jsp" %>    
  </body>
</html>

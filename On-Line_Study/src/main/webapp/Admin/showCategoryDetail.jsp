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
          	<h3><i class="fa fa-angle-right"></i>修改资源种类</h3>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 资源种类详情页</h4>
                      <form class="form-horizontal style-form" action="<c:url value='/AdminCategoryServlet'/>" method="post">
                      <input type="hidden" name="method" value="updateCategoryById" /> 
                      	 <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">资源种类id</label>
                              <div class="col-sm-10">
                                  <input name="categoryId" value="${category.categoryId }" class="form-control" id="disabledInput" type="text" placeholder="${menu.menuId }" readOnly="true" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">资源种类名</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="categoryName" value="${category.categoryName }">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">资源种类链接地址</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="categoryLink" value="${category.categoryLink }">
                              </div>
                          </div>

                          <button type="submit" class=" btn btn-theme">修改资源种类</button>
                      </form>
                  </div>
          		</div><!-- col-lg-12-->      	
          	</div><!-- /row -->      	
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is  <a href="http://www.mycodes.net/" target="_blank">智源学堂</a>
              <a href="form_component.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="Admin/assets/js/jquery.js"></script>
    <script src="Admin/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="Admin/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="Admin/assets/js/jquery.scrollTo.min.js"></script>
    <script src="Admin/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="Admin/assets/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="Admin/assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="Admin/assets/js/bootstrap-switch.js"></script>
	
	<!--custom tagsinput-->
	<script src="Admin/assets/js/jquery.tagsinput.js"></script>
	
	<!--custom checkbox & radio-->
	
	<script type="text/javascript" src="Admin/assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="Admin/assets/js/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="Admin/assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<script type="text/javascript" src="Admin/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="Admin/assets/js/form-component.js"></script>    
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>
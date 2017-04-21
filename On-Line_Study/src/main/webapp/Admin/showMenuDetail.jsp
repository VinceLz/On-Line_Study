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
          	<h3><i class="fa fa-angle-right"></i>修改菜单项</h3>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 菜单项</h4>
                      <form class="form-horizontal style-form" action="<c:url value='/AdminMenuServlet'/>" method="post">
                      <input type="hidden" name="method" value="updataMenu" /> 
                      	 <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">菜单id</label>
                              <div class="col-sm-10">
                                  <input name="menuId" value="${menu.menuId }" class="form-control" id="disabledInput" type="text" placeholder="${menu.menuId }" readOnly="true" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">父级菜单id</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="parentMenuId" value="${menu.parentMenuId }">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">菜单名</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="menuName" value="${menu.menuName }">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">菜单链接地址</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="menuAddr" value="${menu.menuAddr }">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">菜单顺序</label>
                              <div class="col-sm-10">
                                  <input class="form-control" id="focusedInput" type="text" name="menuOrder" value="${menu.menuOrder}">
                              </div>
                          </div>
                         
                          <div class="form-group">
                          	<label class="col-sm-2 col-sm-2 control-label">是否启用</label>
                            	<div class="row mt">
                              		<div class="col-sm-1 text-center">
                                  	<input type="checkbox" checked="" data-toggle="switch" value="0"  name="isUse"/>
                              		</div>
                          		</div>
                          </div>
                          <button type="submit" class=" btn btn-theme">修改菜单项</button>
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
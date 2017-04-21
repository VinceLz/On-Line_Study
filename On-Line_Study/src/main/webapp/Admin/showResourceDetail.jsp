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
          	<h3><i class="fa fa-angle-right"></i>修改资源项</h3>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 资源详情</h4>
                      <form class="form-horizontal style-form" action="<c:url value='/AdminResourceServlet'/>" method="post">
                      <input type="hidden" name="method" value="updataResource" /> 
                      	 <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">资源id</label>
                              <div class="col-sm-10">
                                  <input name="resourceId" value="${resource.id }" class="form-control" id="disabledInput" type="text" placeholder="${resource.id}" readOnly="true" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">资源名</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="resourceName" value="${resource.resourceName }">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">上传时间</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="uploadeDate" value="${resource.uploadeDate }" id="disabledInput" readOnly="true">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">资源路径</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="src" value="${resource.src }" id="disabledInput" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminResourceServlet?method=showUploadResource&resourceSrc=${resource.src }&resourceId=${resource.id}'">上传资源</button>
                              	  <i style="color:red">${resourceUploadResult}</i>                              
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">种类</label>
                              <div class="col-sm-10">
                                    <select class="form-control" name="category" id="category">
                              		<c:forEach items="${categoryList }" var="category">
                              		<option id="${category.categoryId }" value="${category.categoryId }" name="category">${category.categoryId }.${category.categoryName }</option>
                              		</c:forEach>
                              	</select>
                              </div>
                          </div>
                         <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">所属兴趣id</label>
                              <div class="col-sm-10">
                              	<select class="form-control" name="beLongToInterestID" id="beLongToInterestID">
                              		<c:forEach items="${interestList }" var="interest">
                              		<option id="${interest.id }" value="${interest.id }" name="beLongToInterestID">${interest.id }.${interest.interestName }</option>
                              		</c:forEach>
                              	</select>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">所属等级id</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="beLongToDegreeID" value="${resource.beLongToDegreeID}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">摘要</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="resume" value="${resource.resume}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">课程id</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="classNameID" value="${resource.classNameID}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">所需积分</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="score" value="${resource.score}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">封面图</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="showImageSrc" value="${resource.showImageSrc}" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminResourceServlet?method=showUploadShowImageSrc&resourceShowImageSrc=${resource.showImageSrc }&resourceId=${resource.id}'">上传图片</button>
                              	  <i style="color:red">${showImageUploadResult}</i> 
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">资源类型</label>
                              <div class="col-sm-10">
                                <select class="form-control" name="resourceType" id="resourceType">
                              		<option id="0" value="0" name="resourceType">0(视频)</option>
                              		<option id="1" value="1" name="resourceType">1(文档)</option>
                              		<option id="2" value="2" name="resourceType">2(其他)</option>
                              	</select>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">网页链接地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="linkSrc" value="${resource.linkSrc}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">前台class名</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="frontClassName" value="${resource.frontClassName}">
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">点赞数</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="likeSum" value="${resource.likeSum}">
                              </div>
                          </div>
                        </div> 
                     
                          <button type="submit" class=" btn btn-theme">修改资源信息</button>
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

      $(function(){
          $('select.styled').customSelect();
         
      });
      
      window.onload=function(){
    	  var int_all_options = document.getElementById("beLongToInterestID").options;
    	  var id=${resource.beLongToInterestID};
    	  for(var i=0;i<int_all_options.length;i++){
    		  if (int_all_options[i].id == id){
    			  int_all_options[i].selected = true; 
    		  }
    	  }

    	  var category_all_options = document.getElementById("category").options;
    	  var categoryId = ${resource.category};
    	  for(var i=0;i<category_all_options.length;i++){
    		  if(category_all_options[i].id == categoryId){
    			  category_all_options[i].selected = true; 
    		  }
    	  }
    	  
    	  var resourceType_all_options = document.getElementById("resourceType").options;
    	  var resourceType = ${resource.resourceType};
    	  for(var i=0;i<resourceType_all_options.length;i++){
    		  if(resourceType_all_options[i].id == resourceType){
    			  resourceType_all_options[i].selected = true; 
    		  }
    	  }
      };
  </script>

  </body>
</html>
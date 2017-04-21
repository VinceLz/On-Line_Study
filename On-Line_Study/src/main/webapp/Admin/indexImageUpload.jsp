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
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> 修改图片</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		<div class="form-panel">
                  	<h4 class="mb"><i class="fa fa-angle-right"></i> 上传图片</h4>
					<form class="form-horizontal style-form" action="<c:url value='/AdminIndexServlet?method=imageUpload'/>" method="post" enctype="multipart/form-data">
  					<div class="form-group">
                    	<label class="col-sm-2 col-sm-2 control-label">首页方案id</label>
                        <div class="col-sm-10">
                        	<input name="indexId" value="${indexId }" class="form-control" id="disabledInput" type="text" placeholder="${indexId}" readOnly="true" >
                        </div>
                    </div>
                    <div class="form-group">
                    	<label class="col-sm-2 col-sm-2 control-label">图片位置</label>
                        <div class="col-sm-10">
                        	<input name="location" value="${location }" class="form-control" id="disabledInput" type="text" placeholder="${location}" readOnly="true" >
                        </div>
                    </div>
                    <div class="form-group">
                    	<label class="col-sm-2 col-sm-2 control-label">图片路径</label>
                        <div class="col-sm-10">
                        	<input name="src" value="${src}" class="form-control" id="disabledInput" type="text" placeholder="${src}" readOnly="true" >
                        </div>
                    </div>
                    <div class="form-group">
                    	<label class="col-sm-2 col-sm-2 control-label">图片文件</label>
                        <div class="col-sm-10">
                        	<input name="zhaoPian"  class=" btn btn-theme" type="file">
                        </div>
                    </div>
                   </div>
                    <div class="col-sm-12 text-center">
                          <button type="submit" class=" btn btn-theme">上传</button>
                    </div>

					</form>
          		</div>
          	</div>
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
  </section>
     <%@include file="footer.jsp" %>    
  </body>



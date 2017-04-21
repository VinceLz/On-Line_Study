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
          	<h3><i class="fa fa-angle-right"></i> 上传资源封面图</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		<div class="form-panel">
                  	<h4 class="mb"><i class="fa fa-angle-right"></i> 上传图片</h4>
					<form class="form-horizontal style-form" action="<c:url value='/AdminResourceServlet?method=uploadShowImageSrc'/>" method="post" enctype="multipart/form-data">
  					<div class="form-group">
                    	<label class="col-sm-2 col-sm-2 control-label">资源id</label>
                        <div class="col-sm-10">
                        	<input name="resourceId" value="${resourceId }" class="form-control" id="disabledInput" type="text" placeholder="${resourceId}" readOnly="true" >
                        </div>
                    </div>
                    <div class="form-group">
                    	<label class="col-sm-2 col-sm-2 control-label">资源封面图路径</label>
                        <div class="col-sm-10">
                        	<input name="showImageSrc" value="${resourceShowImageSrc }" class="form-control" id="disabledInput" type="text" placeholder="${resourceShowImageSrc}" readOnly="true" >
                        </div>
                    </div>
                    <div class="form-group">
                    	<label class="col-sm-2 col-sm-2 control-label">上传资源封面</label>
                        <div class="col-sm-10">
                        	<input name="zhaopian"  class=" btn btn-theme" type="file">
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



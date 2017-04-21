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
          	<h3><i class="fa fa-angle-right"></i>修改首页方案</h3>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 首页方案详情</h4>
                      <form class="form-horizontal style-form" action="<c:url value='/AdminIndexServlet'/>" method="post">
                      <input type="hidden" name="method" value="updataIndexModel" /> 
                      	 <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">首页方案id</label>
                              <div class="col-sm-10">
                                  <input name="indexId" value="${indexModel.indexId }" class="form-control" id="disabledInput" type="text" placeholder="${indexModel.indexId}" readOnly="true" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">logo图位置</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="logoImageSrc" value="${indexModel.logoImageSrc }" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=logoImageSrc&src=${indexModel.logoImageSrc}&indexId=${indexModel.indexId}'">修改logo图位置</button>
                              	  <i style="color:red">${logoImageSrcResult}</i>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">logo主题名</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="logoTitle" value="${indexModel.logoTitle }" id="disabledInput" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">主摘要</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="summaryMain" value="${indexModel.summaryMain }" id="disabledInput" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">副摘要</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="summarySub" value="${indexModel.summarySub}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势1主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage1" value="${indexModel.advantage1}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势1副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage1Sub" value="${indexModel.advantage1Sub}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势1图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage1ImageSrc" value="${indexModel.advantage1ImageSrc}" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=advantage1ImageSrc&src=${indexModel.advantage1ImageSrc}&indexId=${indexModel.indexId}'">优势1图地址</button>
                              	  <i style="color:red">${advantage1ImageSrcResult}</i>
                              </div>
                          </div>
                                                    <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势2主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage2" value="${indexModel.advantage2}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势2副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage2Sub" value="${indexModel.advantage2Sub}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势2图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage2ImageSrc" value="${indexModel.advantage2ImageSrc}" readOnly="true">
                              	  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=advantage2ImageSrc&src=${indexModel.advantage2ImageSrc}&indexId=${indexModel.indexId}'">优势2图地址</button>
                           	      <i style="color:red">${advantage2ImageSrcResult}</i>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点1主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit1" value="${indexModel.merit1}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点1副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit1Sub" value="${indexModel.merit1Sub}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点1图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit1ImageSrc" value="${indexModel.merit1ImageSrc}" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=merit1ImageSrc&src=${indexModel.merit1ImageSrc}&indexId=${indexModel.indexId}'">优点1图地址</button>
                              	  <i style="color:red">${merit1ImageSrcResult}</i>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点2主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit2" value="${indexModel.merit2}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点2副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit2Sub" value="${indexModel.merit2Sub}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点2图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit2ImageSrc" value="${indexModel.merit2ImageSrc}" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=merit2ImageSrc&src=${indexModel.merit2ImageSrc}&indexId=${indexModel.indexId}'">优点2图地址</button>
                             	  <i style="color:red">${merit2ImageSrcResult}</i>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点3主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit3" value="${indexModel.merit3}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点3副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit3Sub" value="${indexModel.merit3Sub}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点3图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit3ImageSrc" value="${indexModel.merit3ImageSrc}" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=merit3ImageSrc&src=${indexModel.merit3ImageSrc}&indexId=${indexModel.indexId}'">优点3图地址</button>
                             	  <i style="color:red">${merit3ImageSrcResult}</i>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点4主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit4" value="${indexModel.merit4}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点4副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit4Sub" value="${indexModel.merit4Sub}">
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点4图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit4ImageSrc" value="${indexModel.merit4ImageSrc}" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=merit4ImageSrc&src=${indexModel.merit4ImageSrc}&indexId=${indexModel.indexId}'">优点4图地址</button>
                              	  <i style="color:red">${merit4ImageSrcResult}</i>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">页脚关于我们</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="footerAboutUs" value="${indexModel.footerAboutUs}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">页脚微信</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="footerWeChat" value="${indexModel.footerWeChat}" readOnly="true">
                                  <button type="button" class=" btn btn-theme" onclick="location='AdminIndexServlet?method=showUploadImage&location=footerWeChat&src=${indexModel.footerWeChat}&indexId=${indexModel.indexId}'">优点4图地址</button>
                                  <i style="color:red">${footerWeChatResult}</i>
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
                        </div> 
						<div class="col-sm-12 text-center">
                          <button type="submit" class=" btn btn-theme">修改资源信息</button>
                        </div>
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
    	  var all_options = document.getElementById("beLongToInterestID").options;
    	  var id=${resource.beLongToInterestID};
    	  for(i=0;i<all_options.length;i++){
    		  if (all_options[i].id == id){
    			  all_options[i].selected = true; 
    		  }
    	  }
      };
  </script>

  </body>
</html>
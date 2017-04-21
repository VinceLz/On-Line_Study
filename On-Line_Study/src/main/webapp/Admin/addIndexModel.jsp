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
          	<h3><i class="fa fa-angle-right"></i>添加首页方案</h3>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 添加首页方案</h4>
                      <form class="form-horizontal style-form" action="<c:url value='/AdminIndexServlet'/>" method="post">
                      <input type="hidden" name="method" value="addIndexModel" /> 
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">logo图</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="logoImageSrc" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">logo主题名</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="logoTitle" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">主摘要</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="summaryMain"  id="disabledInput" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">副摘要</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="summarySub" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势1主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage1" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势1副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage1Sub" >
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势1图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage1ImageSrc" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
                              </div>
                          </div>
                                                    <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势2主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage2" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势2副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage2Sub" >
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优势2图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="advantage2ImageSrc" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点1主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit1" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点1副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit1Sub" >
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点1图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit1ImageSrc" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点2主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit2" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点2副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit2Sub" >
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点2图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit2ImageSrc" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点3主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit3" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点3副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit3Sub" >
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点3图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit3ImageSrc" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点4主标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit4" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点4副标题</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit4Sub" >
                              </div>
                          </div>    
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">优点4图地址</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="merit4ImageSrc" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">页脚关于我们</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="footerAboutUs" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">页脚微信</label>
                              <div class="col-sm-10">
                                  <input class="form-control"  type="text" name="footerWeChat" value="请在添写其它内容并提交后，到修改界面添加图片" readOnly="true">
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
                          <button type="submit" class=" btn btn-theme">添加首页方案</button>
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
      

  </script>

  </body>
</html>
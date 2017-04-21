<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>智源学堂后台登录</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path %>/Admin/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="<%=path %>/Admin/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<%=path %>/Admin/assets/css/style.css" rel="stylesheet">
    <link href="<%=path %>/Admin/assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="<c:url value='/AdminLoginServlet'/>">
		        <h2 class="form-login-heading">管理员登录</h2>
		        <div class="login-wrap">
		            <input type="text" class="form-control" id="account" placeholder="管理员账号" autofocus name="username">
		            <br>
		            <input type="password" class="form-control" id="pwd" placeholder="密码" name="password">
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> 忘记密码?</a>
		                </span>
		            </label>
		             <input type="text" class="form-control" placeholder="验证码" name="code" id="code">
		              <input type="hidden" class="form-control" name="method" value="login">
		              <img src="<c:url value='/ImageServlet'/>"onclick="change(this)" style="float: right;" /><br/><a style="float: right;">点击图片换一张</a><br/><br/>
		            <br/><button  onclick="return check()" class="btn btn-theme btn-block" href="<c:url value='AdminLoginServlet'/>" type="submit"><i class="fa fa-lock"></i> 登录</button>
		            <hr>
		            
		            <div class="login-social-link centered">
		          
		                <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
		                <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
		            </div>
		
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">忘记密码?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>输入你的邮箱</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
		                          <button class="btn btn-theme" type="button">提交</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<%=path %>/Admin/assets/js/jquery.js"></script>
    <script src="<%=path %>/Admin/assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="<%=path %>/Admin/assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("<%=path %>/Admin/assets/img/login-bg.jpg", {speed: 500});
        function change(image){
            image.src=image.src+"?"+new Date().getTime();
            }
        function check(){
        	
        	var account=document.getElementById("account");
        	var pwd=document.getElementById("pwd");
        	var code=document.getElementById("code");
        	if(""==account.value){
        		alert("用户账号不能为空");
        		return false;
        	}
        	if(""==pwd.value){
        		alert("用户密码不能为空");
        		return false;
        	}
        	if(""==code.value){
        		alert("验证码不能为空");
        		return false;
        	}
        }
    </script>


  </body>
</html>

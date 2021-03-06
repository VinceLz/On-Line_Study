<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=drive-width,initial-scale=1.0"/>
<title>${indexModel.logoTitle }</title>

<!-- Bootstrap core CSS -->
<link href="<%=path %>/User/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path %>/User/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="<%=path %>/User/CSS/Index/styles.css" rel="stylesheet">
<!-- Custom styles for this template -->
<script type="text/javascript" src="<%=path %>/User/bootstrap/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/User/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path %>/User/bootstrap/js/bootstrap.min.js"></script>  
<script type="text/javascript" src="<%=path %>/User/JavaScript/Index/jquery.placeholder.js"></script>   
<script type="text/javascript" src="<%=path %>/User/JavaScript/Index/main.js"></script>  

</head>
<style>
@charset "utf-8";
/* CSS Document */
/*初始化*/
body,ul,ol,li,p,h1,h2,h3,h4,h5,h6,form,fieldset,table,td,img,div,dl,dt,dd,input
	{
	margin: 0;
	padding: 0;
}

body {
	font-size: 14px;
}

img {
	border: none;
}

li {
	list-style: none;
}

a,a:focus,input,botton,botton:focus,select,textarea {
	outline: none;
}

textarea {
	resize: none;
}

a,a:hover {
	text-decoration: none;
}
/*header*/
.nav_bar_con {
	width: 1000px;
}

.nav_bar_con {
	
}

.logo {
	padding: 8px 15px;
}

.logo img {
	height: 32px;
	line-height: 32px;
}

.item_list li:hover {
	color: #fff;
	background-color: #ff4e4e;
}

.search_c,.search_cc {
	padding: 7px 8px;
	color: #9d9d9d;
	font-size: 16px;
	line-height: 16px;
	display: inline-block;
}

.search_c:hover,.search_cc:hover {
	color: #FFF;
}

.message span {
	font-size: 16px;
	line-height: 16px;
}

.search_ip {
	border: none;
	background-color: #666;
	color: #FFF;
	margin: 0 5px;
	height: 32px;
}

.search {
	display: none;
}

@media ( max-width :768px) {
	.nav_bar_con {
		width: auto;
	}
	.navbar-nav {
		margin: 7.5px 0px;
	}
	#search {
		width: 98%;
	}
	.blogroll1 li {
		font-size: 14px;
		line-height: 26px;
		text-align: center;
		float: left;
	}
	.blogroll1 ul {
		margin: 0 auto;
	}
}

@media ( max-width :1000px) {
	.nav_bar_con {
		width: auto;
	}
}
/*footer*/
.footer {
	background-color: #eee;
}

.footer,.footer a {
	color: #aaa;
}

.footer a:hover {
	color: #ff4e4e;
}

.footercon {
	margin: 50px auto 0;
}

.logo p,.logo h5 {
	margin-left: 115px;
	font-size: 14px;
	line-height: 26px;
}

.logo h5 {
	margin-top: -24px;
}

.logo p {
	margin-top: 15px;
}

.blogroll1 p,.WeChat p {
	margin: 13px 0 5px;
	text-align: center;
}

.blogroll1 li {
	font-size: 14px;
	line-height: 26px;
	text-align: left;
	margin: 0 34px;
}

.WeChat {
	text-align: center;
}

.WeChat img {
	width: 100px;
	height: 100px;
	margin-top: 5px;
}

.nav_bar_con hr {
	border-top: 1px solid #ccc;
}

.footerbom {
	text-align: center;
	margin-bottom: 30px;
	font-size: 14px;
}

.lgAndRg {
	font-size: 14px;
}

.tabs_bar a,.checkbox a,.vcode a {
	color: #000;
}

.tabs_bar li a:hover {
	background-color: #ff4e4e;
	color: #FFF;
}

.checkbox a:hover,.vcode a:hover {
	color: #ff4e4e;
}

.vcode img {
	margin: 0 8px;
	width: 100px;
	height: 35px;
}

.modal-footer img {
	width: 28px;
	height: 28px;
	border-radius: 14px;
}

.modal-footer a {
	padding-left: 10px;
}

.loandre_btn {
	background-image: linear-gradient(to bottom, #ff4e4e, #ff4e4e 100%);
	border-color: #ff4e4e;
	color: #FFF;
}

.loandre_btn:hover {
	background-image: linear-gradient(to bottom, #fd3131, #fd3131 100%);
	border-color: fd3131;
	color: #FFF;
}
</style>
<body>
<div class="navigation">
	<div class="promo-wrapper">
            <!-- ******HEADER****** --> 
            <header style="padding-top: 30px;" id="header" class="header">  
                <div class="container">            
                    <h1 class="logo pull-left">
                        <a href="">
                            <img class="logo-image" src="<%=path %>${indexModel.logoImageSrc }" alt="3rd Wave Media logo">
                           <%--  <span class="logo-title">${indexModel.logoTitle }</span> --%>
                        </a>
                    </h1><!--//logo-->              
                    <nav id="main-nav" class="main-nav navbar-right" role="navigation">
                        <div class="navbar-header">
                            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button><!--//nav-toggle-->
                        </div><!--//navbar-header-->            
                        <div style="height: 1px;" class="navbar-collapse collapse" id="navbar-collapse">
                            <ul class="nav navbar-nav">
                                <c:forEach items="${menuList}" var="menuList">
									<li class="nav-item"><a href="${menuList.menuAddr }">${menuList.menuName }</a></li>                         
                                </c:forEach>
                            </ul><!--//nav-->
                            
                          	<ul class="nav navbar-nav navright">
                            	 <form class="navbar-form navbar-left" role="search">
						<span class="search" id="search"> <input type="text"
							class="form-control search_ip" placeholder="请输入想要查询的内容">
							<a href="#" onClick="hideSearch_ip()" id="search_cc"><span
								class="glyphicon glyphicon-search search_cc" aria-hidden="true"></span></a></span>
						<a href="#" onClick="showSearch_ip()" id="search_c"><span
							class="glyphicon glyphicon-search search_c" aria-hidden="true"></span></a>
					</form>
					<li><a href="#" class="message"><span
							class="glyphicon glyphicon-bell" aria-hidden="true"></span></a></li>
					<li><a href="#" class="message"><span
							class="glyphicon glyphicon-comment" aria-hidden="true"></span></a></li>
                                <c:if test="${user==null }">
                               <li><a href="#loginon" class="scrollto loginon"
							title="Login or Register" data-toggle="modal"
							data-target="#lgAndRg" onClick="showLoginon()"><span>登录</span></a></li>
						<li><a href="#register" class="scrollto register"
							title="Login or Register" data-toggle="modal"
							data-target="#lgAndRg" onClick="showRegister()"><span>注册</span></a></li>
                                </c:if>
                                <c:if test="${user!=null }">
                                   
                                    <li class="nav-item"><a class="scrollto" href="">欢迎您${user.nickName }</a></li>

                                <li class="nav-item"><a class="scrollto" href="">退出</a></li>
                                   
                                </c:if>
                            </ul><!--//nav-->
                        </div><!--//navabr-collapse-->
                    </nav><!--//main-nav-->           
                </div><!--//container-->
            </header><!--//header-->
            
            <!-- ******PROMO****** --> 
            <section id="promo" class="promo section">
                <div class="container intro text-center">
                    <h2 class="title">${indexModel.logoTitle }<br><span class="sub">${indexModel.summaryMain }</span></h2>
                    <h3 class="summary">${indexModel.summarySub }</h3>
                    <div class="btn-wrapper">
                        <a class="btn btn-cta btn-cta-primary btn-scrollto" href="#advantage">${indexModel.logoTitle }</a>
                        <div class="clearfix visible-xs"></div>
                        <a class="btn btn-cta btn-cta-secondary btn-scrollto" href="#products">开始学习</a>            
                    </div>
                </div><!--//intro-->   
            </section><!--//promo-->
        </div>
</div>
<div class="advantage" id="advantage">
	<div class="content">
    <div class="row">
   	  <div class="advantageL col-md-6">
        	<img class="Media" src="<%=path %>/${indexModel.advantage1ImageSrc }">
            <div class="advL">
                <h4>${indexModel.advantage1 }</h4>
                <h5>${indexModel.advantage1Sub }</h5>
            </div>
        </div>
      <div class="advantageR col-md-6">
       	  <img class="Checklist" src="<%=path %>/${indexModel.advantage2ImageSrc }">
          <div class="advR">
              <h4>${indexModel.advantage2 }</h4>
              <h5>${indexModel.advantage2Sub }</h5>
          </div>
        </div>
    </div>
    </div>	
</div>
<div class="merit1">
  <div class="content">
  	<img class="merimg1" src="<%=path %>/${indexModel.merit1ImageSrc }">
    <div class="merp">
        <h3>${indexModel.merit1 }</h3>
        <h4>${indexModel.merit1Sub }</h4>
    </div>
  </div>
</div>
<div class="merit2">
  <div class="content">
  	<div class="merp">
        <h3>${indexModel.merit2 }</h3>
        <h4>${indexModel.merit2Sub }</h4>
    </div>
    <img class="merimg2" src="<%=path %>/${indexModel.merit2ImageSrc }">
  </div>
</div>
<div class="merit3">
  <div class="content">
  	<img class="merimg3" src="<%=path %>/${indexModel.merit3ImageSrc }">
    <div class="merp">
        <h3>${indexModel.merit3 }${indexModel.merit3 }${indexModel.merit3 }</h3>
        <h4>${indexModel.merit3Sub }</h4>
    </div>
  </div>
</div>
<div class="merit4">
  <div class="content">
    
  	<div class="merp">
        <h3>${indexModel.merit4 }</h3>
        <h4>${indexModel.merit4Sub }</h4>
    </div>
    <img class="merimg4" src="<%=path %>${indexModel.merit4ImageSrc }">
  </div>
</div>
<div class="course">
	<div class="coursecon">
    	<div class="coursenav">   	
            <c:forEach items="${interestList}" var="interest">
            	<a class="courseNava" href="">${interest.interestName}</a>            
         	</c:forEach>
        </div>
          <c:forEach items="${resourceListList }" var="resourceList">
          	<c:forEach items="${resourceList }"  var="resource">
          		<div class="${resource.frontClassName }">
           		<a class="coursea" href="${resource.linkSrc }">
           		<img class="courseImg" src="${resource.showImageSrc }"  />
            	<p class="coursep">${resource.resourceName }</p>
                <p class="coursepl">${resource.uploadeDate }</p>
                <p class="coursepr">${resource.likeSum }点赞</p>
              	</a>
              	</div>
          	</c:forEach>
          </c:forEach>

        </div>
        <div class="register">
        <a class="btn btn-cta btn-cta-register btn-scrollto" href="#advantage">立即注册</a>
    	</div>
    </div>    
</div>

<!-- footer -->
	<nav class="footer">
		<div class="container-fluid nav_bar_con">
			<div class="footercon clearfix">
				<div class="logo col-sm-6">
					<h1>${indexModel.logoTitle }</h1>
					
					<p>Spring是一个致力于便捷，快速的网上学习平台用于大量学习资源，方便用户随时随地使用各种终端登录学习。</p>
				</div>
				<div class="blogroll1 col-sm-2 clearfix">
					<p>友情链接</p>
					<ul class="clearfix">
						<li><a href="">netkeeper</a></li>
						<li><a href="">potplayer</a></li>
						<li><a href="">iTunes</a></li>
						<li><a href="">jjaghgeihg</a></li>
					</ul>
				</div>
				<div class="blogroll1 col-sm-2 clearfix">
					<p>友情链接</p>
					<ul>
						<li><a href="">netkeeper</a></li>
						<li><a href="">potplayer</a></li>
						<li><a href="">iTunes</a></li>
						<li><a href="">jjaghgeihg</a></li>
					</ul>
				</div>
				<div class="WeChat col-sm-2 clearfix">
					<p>微信公众号</p>
					<img class="aa" src="<%=path %>${indexModel.footerWeChat}">
				</div>
			</div>
			<hr>
			<div class="footerbom">Copyright &copy; 2016 zhiyuan.com All
				Rights Reserved | 京ICP备 111111111号-2</div>
		</div>
	</nav>
<script type="text/javascript">
		function showLoginon() {
			document.getElementById("loginon").className = "active";
			document.getElementById("register").className = "";
			document.getElementById("Loginon").className = "tab-pane fade active in";
			document.getElementById("Register").className = "tab-pane fade";
		}
		function showRegister() {
			document.getElementById("loginon").className = "";
			document.getElementById("register").className = "active";
			document.getElementById("Loginon").className = "tab-pane fade";
			document.getElementById("Register").className = "tab-pane fade active in";
		}
	</script>

	<!--添加登录注册对话框-->
	<div class="modal fade" data-show="true" id="lgAndRg" class="lgAndRg">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- 添加类样式modal-body -->
				<div class="modal-body">
					<!-- 选项卡式导航 -->
					<ul class="nav nav-tabs tabs_bar">
						<li id="loginon"><a href="#Loginon" data-toggle="tab">登录</a></li>
						<li id="register"><a href="#Register" data-toggle="tab">注册</a></li>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</ul>
					<!--选项卡面板-->
					<div class="tab-content">
						<div class="tab-pane fade" id="Loginon">
							<form id="form_id" action="UserServlet?method=userLogin"
								method="post">
								<fieldset>
									<div class="form-group" style="margin-top:20px">
										<input type="text" id="account" name="account"
											class="form-control" placeholder="请输入用户名或Email">
									</div>
									<div class="form-group">
										<input type="password" id="pwd" name="pwd"
											class="form-control" placeholder="请输入你的密码">
									</div>
									<div class="form-group vcode">
										<input type="text" id="validate" name="validate"
											class="form-control" placeholder="请输入验证码"
											style="width:130px;float:left"> <img
											src="VerifyCodeServlet" id="img" onclick="change(this)">
										<a href="#" onclick="change(img)"><span
											class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox"> 记住密码
										</label> <span style="float:right"><a href="#">找回密码</a></span>
									</div>
									<div class="">
										<input type="submit" class="btn btn-lg btn-block loandre_btn"
											value="登陆">
									</div>
								</fieldset>
							</form>
						</div>


						<!--注册模块  -->
						<div class="tab-pane fade" id="Register">
							<form id="form_rs" action="UserServlet?method=userRegister" method="Post">
								<fieldset>
									<div class="form-group" style="margin-top:20px">
										<input type="text" id="account" name="account"
											class="form-control" placeholder="请输入注册用户名或Email"><div id="accountError">2332</div>
									</div>
									<div class="form-group">
										<input type="password" id="pwd" name="pwd"
											class="form-control" placeholder="请输入你的密码">
									</div>
									<div class="form-group">
										<input type="password" id="pwd1" name="pwd1"
											class="form-control" placeholder="请再次输入你的密码">
									</div>
									<div class="form-group">
										<select id="province" name="province" class="form-control"
											style="width:135px;float:left">
											<option selected="selected">-请选择省份-</option>
										</select> <select id="city" name="city" class="form-control"
											style="width:130px;">
											<option selected="selected">-请选择城市-</option>
											</select>
									</div>
									<div class="form-group">
										<input type="text" id="e_mail" name="e_mail"
											class="form-control" placeholder="请输入你的邮箱">
									</div>
									<div id="sex" name="sex" class="radio">
										<label style="width:60px"> <input type="radio"
											name="optionsRadios" id="optionsRadios1" value="option1"
											checked> 男
										</label> <label> <input type="radio" name="optionsRadios"
											id="optionsRadios2" value="option2"> 女
										</label>
									</div>
									<div class="form-group vcode">
										<input type="text" id="validate" name="validate"
											class="form-control" placeholder="请输入验证码"
											style="width:130px;float:left"> <img
											src="Images/Home/vcode.jpg"> <a href="#"><span
											class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a>
									</div>
									<div class="">
										<input type="submit" class="btn btn-lg btn-block loandre_btn"
											value="立刻注册">
								</fieldset>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<span>用第三方登陆</span> <a href="#"><img class="inco1"
						src="Images/Home/qq.jpg"></a> <a href="#"><img class="inco1"
						src="Images/Home/wechat.jpg"></a> <a href="#"><img
						class="inco1" src="Images/Home/sina.jpg"></a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function change(image) {
			image.src = image.src + "?" + new Date().getTime();
		}
		function showSearch_ip() {
			var search_ip = document.getElementById("search");
			var search_c = document.getElementById("search_c");
			search_ip.style.display = "inline-block";
			search_c.style.display = "none";
		}
		function hideSearch_ip() {
			var search_ip = document.getElementById("search");
			var search_c = document.getElementById("search_c");
			search_ip.style.display = "none";
			search_c.style.display = "inline-block";
		}
		
	</script>
</body>
  
</html>


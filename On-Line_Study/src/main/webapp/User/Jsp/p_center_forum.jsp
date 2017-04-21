<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=drive-width,initial-scale=1.0"/>
<title>${indexModel.logoTitle }</title>

<!-- Bootstrap core CSS -->



<!-- Custom styles for this template -->
<!-- Custom styles for this template -->
<script type="text/javascript"
	src="<%=path %>/User/bootstrap/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/User/bootstrap/js/bootstrap.js"></script>

<%-- <script type="text/javascript" src="<%=path %>/User/bootstrap/js/bootstrap.min.js"></script>   --%>
<script type="text/javascript" src="<%=path %>/User/JavaScript/Index/jquery.placeholder.js"></script>   
<script type="text/javascript" src="<%=path %>/User/JavaScript/Index/main.js"></script>

<link href="<%=path %>/User/CSS/Index/styles.css" rel="stylesheet">
<link href="<%=path %>/User/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path %>/User/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<style>
@charset "utf-8";
/* CSS Document */
/*初始化*/
body, ul, ol, li, p, h1, h2, h3, h4, h5, h6, form, fieldset, table, td, img, div, dl, dt, dd, input {
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
a, a:focus, input, botton, botton:focus, select, textarea {
	outline: none;
}
textarea {
	resize: none;
}
a, a:hover {
	text-decoration: none;
	color: #000;
}
.fl {
	float: left;
}
.fr {
	float: right;
}
/*header*/
.nav_bar_con {
	width: 72%;
	margin: 0 auto;
}
.logo {
	padding: 8px 15px;
}
.logo img {
	height: 32px;
}
.item_list li:hover {
	color: #fff;
	background-color: #ff4e4e;
}
.search_c, .search_cc {
	padding: 7px 8px;
	color: #9d9d9d;
	font-size: 16px;
	line-height: 16px;
	display: inline-block;
}
.search_c:hover, .search_cc:hover {
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
@media (max-width:768px) {
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
@media (max-width:1000px) {
.nav_bar_con {
	width: auto;
}
}
/*footer*/
.footer {
	background-color: #eee;
}
.footer, .footer a {
	color: #aaa;
}
.footer a:hover {
	color: #ff4e4e;
}
.footercon {
	margin: 50px auto 0;
}
.logo p, .logo h5 {
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
.blogroll1 p, .WeChat p {
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
.tabs_bar a, .checkbox a, .vcode a {
	color: #000;
}
.tabs_bar li a:hover {
	background-color: #ff4e4e;
	color: #FFF;
}
.checkbox a:hover, .vcode a:hover {
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
<style>
@charset "utf-8";
/* CSS Document */
/*初始化*/

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
<style>
		
			.col-md-2 ul{
				background-color: #fff;
				border:2px solid #ebebeb;
				color:#666666;
				min-height:calc(100vh - 80px);
				text-align: center;
				padding:30px 0;
			}
			.content{
				background-color: #fff;
				border:2px solid #ebebeb;
				padding: 20px;
				display: flex;
				justify-content: flex-start;
				align-items: center;
				color:#666666;
				width:100%;
			}
			.left_image img{
				width: 80px;
				height: 80px;
				overflow: hidden;
				border: 1px solid #fff;
				border-radius: 50%;
			}
			.right_text{
				margin-left: 16px;
			}
			.top a{
				color:#000;
				font-size: 16px;
				font-weight: bold;
			}
		
			.mid{
				margin:40px 20px;
			}
			.upload_area{
				background-color: #fff;
				border:2px solid #ebebeb;
			}
			.left_area,.mid_area,.right_area{
				border:2px solid #f1f1f5;
				border-right-color:#ebebeb; 
				padding: 20px;

			}
			.upload_btn{
				width: 150px;
				border:2px solid #f1f1f5; 
				padding:10px 10px;
				text-align: center;
			}
			.upload_title{
				display: flex;
				justify-content: space-around;
				align-items: center;
			}
			.count{
				font-size: 22px;
				color:#ff6460;
				margin-left: 34px;
			}
			#forRight{
			margin-left: 30%;
			}
		</style>
<body>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid nav_bar_con">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand logo" href="#"><img alt="Brand"
					src="Images/logo.png"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse item_list"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:forEach items="${menuList}" var="menu">
			<li><a href="<%=path %>/${menu.menuAddr }">${menu.menuName }</a></li>                         
        </c:forEach>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					 <form class="navbar-form navbar-left" role="search">
						            <a href="#Serch"   data-toggle="modal" data-target="#lgAndRgS">
						            <span class="glyphicon glyphicon-search search_c" ></span></a>				
					             </form>
				
					<c:if test="${user==null }">
						<li><a href="#loginon" class="scrollto loginon"
							title="Login or Register" data-toggle="modal"
							data-target="#lgAndRg" onClick="showLoginon()"><span>登录</span></a></li>
						<li><a href="#register" class="scrollto register"
							title="Login or Register" data-toggle="modal"
							data-target="#lgAndRg" onClick="showRegister()"><span>注册</span></a></li>
					</c:if>
					<c:if test="${user!=null }">
	                 <li><a href="<%=path %>/IndexDoorServlet?method=forowdMessage" class="message"><span
							class="glyphicon glyphicon-bell" aria-hidden="true"></span>
							<c:if test="${message>0 }">
							<span class="badge"  style="margin-top: -15px;background-color: red;font-size: 1px;">${message }</span>
							</c:if>
							</a></li>
					<li><a href="<%=path %>/IndexDoorServlet?method=forowdNotice" class="message"><span
							class="glyphicon glyphicon-comment" aria-hidden="true"></span>
							<c:if test="${notice>0 }">
							<span class="badge"  style="margin-top: -15px;background-color: red;font-size: 1px;">${notice }</span>
							</c:if>
							</a></li>
						    <li class="nav-item"><a  href="<%=path %>/PCenterServlet?method=ForwdCenter_Main"  >${user.nickName }</a></li>
						     <script>						     
						     var val=$("#wel");
							    for(var i=0;i<val.length;i++){
							    	var text=val[i].innerHTML;
							    	if(text.length>6){
										var te=text.substr(0,6);
										val[i].innerHTML=te+"...";
									}else{		
								    }	
							    }
						     </script>
						    <!--   <li class="nav-item"><a class="scrollto" href=""  onclick="logout();">我的帖子</a></li> -->
                                     <li class="nav-item"><a class="scrollto" href=""  onclick="logout();">退出</a></li>
			</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>


	<!-- 填充界面 888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888-->
	<!-- notice -->
<div class="container-fluid mid">
			<div class="row">
				<div class="col-md-2">
					<ul class="nav nav-pills nav-stacked" role="tablist">
				 <li  role="presentation"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_Main"><span style="margin-right: 10%;" class="glyphicon glyphicon-home"></span>主页<span id="forRight" class="glyphicon glyphicon-chevron-right"></span></a></li>	
<li  role="presentation"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_Class"><span style="margin-right: 10%;" class="glyphicon glyphicon-facetime-video"></span>课程<span id="forRight" class="glyphicon glyphicon-chevron-right"></span></a></li>
<li  role="presentation" class="active"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_Forum"><span style="margin-right: 10%;" class="glyphicon glyphicon-list"></span>论坛<span id="forRight" class="glyphicon glyphicon-chevron-right"></span></a></li>
<li  role="presentation"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_Comment"><span style="margin-right: 10%;" class="glyphicon glyphicon-bullhorn"></span>评论<span id="forRight" class="glyphicon glyphicon-chevron-right"></span></a></li>
<li  role="presentation"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_Track"><span style="margin-right: 10%;" class="glyphicon glyphicon-stats"></span>足迹<span id="forRight" class="glyphicon glyphicon-chevron-right"></span></a></li>
<li  role="presentation"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_Note"><span style="margin-right: 10%;" class="glyphicon glyphicon-list-alt"></span>笔记<span id="forRight" class="glyphicon glyphicon-chevron-right"></span></a></li>
<li  role="presentation"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_Data"><span style="margin-right: 10%;" class="glyphicon glyphicon-folder-open"></span>资料<span id="forRight" class="glyphicon glyphicon-chevron-right"></span></a></li>
<li  role="presentation"><a href="<%=path %>/PCenterServlet?method=ForwdCenter_ChgPw"><span style="margin-right: 10%;" class="glyphicon glyphicon-edit"></span>修改密码<span id="forRight" style="margin-left: 10%" class="glyphicon glyphicon-chevron-right"></span></a></li>
					</ul>
				</div>
				<div class="col-md-10">
					<div class=" col-md-10 content ">
						<div class="left_image">
							<img src="<c:url value="/User/Jsp/Images/p1.jpg"></c:url>" alt="头像">
						</div>
						<div class="right_text">
							<span>染井吉樱</span><br>
							<span>keep calm and carry on</span><span><a href="#"><img src="<c:url value="/User/Jsp/Images/edit.png"></c:url>" alt="编辑"></a></span>
						</div>
					</div>
					<div class="upload_area">
						<div class="">
							<div class="col-md-4 left_area">
								<div class="upload_title">
									<p>原创</p>
									<div class="upload_btn"><a href="#">上传</a></div>	
								</div>
								<div class="count">12</div>
							</div>
							<div class="col-md-4 mid_area">
								<div class="upload_title">
									<p>媒体</p>
									<div class="upload_btn"><a href="#">上传</a></div>	
								</div>
								<div class="count">0</div>
							</div>
							<div class="col-md-4 right_area">
								<div class="upload_title">
									<p>个人资料</p>
									<div class="upload_btn"><a href="#">上传</a></div>	
								</div>
								<div class="count">80%</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			
		</script>



	<!-- footer -->
	<nav class="footer">
		<div class="container-fluid nav_bar_con">
			<div class="footercon clearfix">
				<div class="logo col-sm-6">
					<h3>智源学堂</h3>
					<h5>关于我们</h5>
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
					<img class="aa" src="Images/Home/WeChat1.jpg">
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
											class="form-control" placeholder="请输入注册用户名或Email"><div id="accountError"></div>
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
											src="VerifyCodeServlet" id="img" onclick="change(this)">
										<a href="#" onclick="change(img)"><span
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
	
	function logout(){
		window.location.href="UserServlet?method=userLogout";
		} 
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
		<!--搜索框  -->
<div class="modal fade " data-show="true" id="lgAndRgS" class="lgAndRgS">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- 添加类样式modal-body -->
				    <div class="modal-body" style="background-color: #eee;width: 150%; ">
									<form class="bs-example bs-example-form" role="form" action="ResourceServlet" method="post">
										<div class="row">
											<div class="col-lg-12">
												<div class="input-group">
												<input type="hidden" name="method" value="SerchResource">
													<input type="text" class="form-control" placeholder="请输入想要查询的内容">
													<span class="input-group-btn">
														<input class="btn btn-default" type="submit" value="搜索"/>
													</span>
												</div><!-- /input-group -->
											</div><!-- /.col-lg-6 -->
										</div><!-- /.row -->
									</form>
				     </div>
				</div>
		</div>
	</div>
</body>

</html>

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
/*notice*/
.notice {
	margin-bottom: 30px;
	width: 100%;
	max-height: 600px;
}
.notice .nav_bar_con {
	padding: 0 40px;
}
.notice_header {
	height: 60px;
	border-bottom: 2px solid #ccc;
}
.notice_header ul li {
	float: left;
}
.notice_header ul li a {
	padding: 0 25px;
	line-height: 58px;
	font-size: 16px;
	color: #000;
}
.notice_header ul li a:hover {
	color: #ff4e4e;
}
.notice_header .notice_active {
	border-bottom: 2px solid #ff4e4e;
}
.notice_header .notice_active a {
	color: #ff4e4e;
}
/*message*/
.message_list {
	width: 25%;
	height: 100%;
	background-color: #ddd;
	padding: 0 25px;
}
.message_list ul li {
	padding: 15px 0;
	border-bottom: 1px solid #ccc;
}
.message_list .meaasge_active {
	background-color: #eee;
	margin: 0 -25px;
}
.message_list ul li img {
	margin-left: 15px;
	width: 50px;
	height: 50px;
	border: 1px solid #bbb;
	border-radius: 50%;
}
.message_list .message_text {
	margin-left: 20px;
	line-height: 25px;
}
.message_list .message_list_foot {
	margin: 20px auto;
	text-align: center;
}
.message_con {
	min-height: 465px;
	width: 75%;
	background-color: #eee;
	padding: 20px 40px;
	position: relative;
}
.message_con img {
	border-radius: 50%;
}
.message_con h4 span {
	color: #999;
	font-size: 14px;
}
.message_con .comment_re {
	color: #999;
}
.message_con .comment_re:hover {
	color: #000;
}
.message_con .comment_text {
	margin-top: 20px;
	height: 160px;
	width: 100%;
	border: 1px solid #ccc;
}
.message_con .comment_submit {
	padding: 5px 40px;
	margin-top: 10px;
	float: right;
	border: 1px solid #ff4e4e;
	background-color: #ff4e4e;
	color: #FFF;
}
.pag_bar {
	width: 100%;
	margin-left: -40px;
	text-align: center;
	position: absolute;
	bottom: 0;
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
<div class="notice message">
  <div class="nav_bar_con clearfix">
    <div class="notice_header">
      <ul class="clearfix">
        <li ><a href="<%=path %>/IndexDoorServlet?method=forowdNotice">通知</a></li>
        <li  class="notice_active" ><a href="<%=path %>/IndexDoorServlet?method=forowdMessage">消息</a></li>
      </ul>
    </div>
    <div class="message_list fl">
      <ul class="">
        <li class="meaasge_active clearfix"> <a href="#"> <img src="../Images/User/user.gif" class="fl">
          <div class="message_text fl">
            <p>标题标题标题标题标题</p>
            <p>2016-03-13 19:41:40</p>
          </div>
          </a> </li>
        <li class="clearfix"> <a href="#"> <img src="../Images/User/user.gif" class="fl">
          <div class="message_text fl">
            <p>标题标题标题标题标题</p>
            <p>2016-03-13 19:41:40</p>
          </div>
          </a> </li>
        <li class="clearfix"> <a href="#"> <img src="../Images/User/user.gif" class="fl">
          <div class="message_text fl">
            <p>标题标题标题标题标题</p>
            <p>2016-03-13 19:41:40</p>
          </div>
          </a> </li>
        <li class="clearfix"> <a href="#"> <img src="../Images/User/user.gif" class="fl">
          <div class="message_text fl">
            <p>标题标题标题标题标题</p>
            <p>2016-03-13 19:41:40</p>
          </div>
          </a> </li>
        
      </ul>
      <div class="message_list_foot"> <a href="#"><span class="glyphicon glyphicon-menu-left"></span></a>&nbsp;&nbsp;&nbsp; <a href="#"><span class="glyphicon glyphicon-menu-right"></span></a> </div>
    </div>
    <div class="message_con fr">
      <div class="bs-example clearfix" data-example-id="default-media">
        <div class="media">
          <div class="media-left"> <a href="#"> <img data-holder-rendered="true" src="../Images/User/user.gif" style="width: 64px; height: 64px;" class="media-object" data-src="holder.js/64x64" alt="64x64"> </a> </div>
          <div class="media-body" id="media-body">
            <h4 class="media-heading">玥玥说她不叫玥玥&nbsp;&nbsp;&nbsp;&nbsp;<span>2016-03-13 19:41:40</span></h4>
            超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！
            <p><a class="comment_re fr" id="comment_re" name="comment_re">回复</a></p>
          </div>
        </div>
       
        <div class="media">
          <div class="media-left"> <a href="#"> <img data-holder-rendered="true" src="../Images/User/user.gif" style="width: 64px; height: 64px;" class="media-object" data-src="holder.js/64x64" alt="64x64"> </a> </div>
          <div class="media-body" id="media-body">
            <h4 class="media-heading">玥玥说她不叫玥玥&nbsp;&nbsp;&nbsp;&nbsp;<span>2016-03-13 19:41:40</span></h4>
            超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！超实用的~~学习了[抱拳]！！
            <p><a class="comment_re fr" id="comment_re" name="comment_re">回复</a></p>
          </div>
        </div>
        <div class="media">
          <div class="media-left"> <a href="#"> <img data-holder-rendered="true" src="../Images/User/user.gif" style="width: 64px; height: 64px;" class="media-object" data-src="holder.js/64x64" alt="64x64"> </a> </div>
          <div class="media-body">
            <h4 class="media-heading">H_entai&nbsp;&nbsp;&nbsp;&nbsp;<span>2016-03-13 19:41:40</span></h4>
            很好 很实用~希望多更新~
            <p><a class="comment_re fr" id="comment_re" name="comment_re">回复</a></p>
            <div class="media">
              <div class="media-left"> <a href="#"> <img data-holder-rendered="true" src="../Images/User/user.gif" style="width: 64px; height: 64px;" class="media-object" data-src="holder.js/64x64" alt="64x64"> </a> </div>
              <div class="media-body">
                <h4 class="media-heading">我&nbsp;&nbsp;&nbsp;&nbsp;<span>2016-03-13 19:41:40</span></h4>
                正在更新中ing......
                <p><a class="comment_re fr" id="comment_re" name="comment_re">回复</a></p>
              </div>
            </div>
          </div>
        </div>
        <div class="media">
          <div class="media-left"> <a href="#"> <img data-holder-rendered="true" src="../Images/User/user.gif" style="width: 64px; height: 64px;" class="media-object" data-src="holder.js/64x64" alt="64x64"> </a> </div>
          <div class="media-body">
            <h4 class="media-heading">Shlouisa&nbsp;&nbsp;&nbsp;&nbsp;<span>2016-03-13 19:41:40</span></h4>
            很好的学习资料~收藏了~
            <p><a class="comment_re fr" id="comment_re" name="comment_re">回复</a></p>
          </div>
        </div>
      </div>
      
      <div class="pag_bar">
        <ul class="pagination">
          <li> <a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li> <a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a> </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	var i=0;
	$('.comment_re').click(function(){
		if(i==0){
			$(this).parent().parent().append('<form class="clearfix comment_re_box" id="comment_re_box"><textarea id="comment" name="comment" class="comment_text" cols="45" rows="8" maxlength="65525" aria-required="true" required></textarea><input name="submit" id="submit" class="comment_submit" value="提交" type="submit"></form>');
			i=1;
		}else{
			$('#comment_re_box').remove();
			i=0;
		}
	});
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

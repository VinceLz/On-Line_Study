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


<link href="<%=path %>/User/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path %>/User/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="<%=path %>/User/CSS/Comment/comment.css" rel="stylesheet">



<link rel="stylesheet" href="http://www.helloweba.com/demo/css/main.css" />
<link rel="stylesheet" href="<%=path %>/User/CSS/Comment/style.css" />
<style type="text/css">
h2.top_title{border-bottom:none;background:none;text-align:center;line-height:32px; font-size:20px}
h2.top_title span{font-size:12px; color:#666;font-weight:500}
</style>
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
	.message span badge{
	
	}
	.sidebar .nei_box .hot_tag a{
	font-size: 50%;
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
                               <li class="nav-item"><a class="scrollto" href=""  onclick="">我的帖子</a></li>
                                     <li class="nav-item"><a class="scrollto" href=""  onclick="logout();">退出</a></li>
			</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>


	<!-- 填充界面 888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888-->

  
 
  
  


<div id="container" class="">
 
  
<div class="col-md-8">
  <div class="content_box">
          <section id="cd-timeline" class="cd-container">
          
          <c:forEach items="${forumList}" var="forum">
				<div class="cd-timeline-block">
					<div class="cd-timeline-img cd-picture">
						<img src="<%=path %>/User/Jsp/Images/cd-icon-picture.svg" alt="Picture">
					</div>
					<div class="cd-timeline-content">
						<h2>${forum.title }</h2>
						<p>${forum.content }</p>
						<a href="http://www.helloweba.com/view-blog-285.html" class="cd-read-more" target="_blank">阅读全文</a>
						<span class="cd-date">${forum.pub_date }</span>
					</div>
				</div>
			</c:forEach>    
	</section>
   <%@include file="fenye.jsp" %>
  </div>
 </div>
  <!--侧边栏 begin-->
  <div class="col-md-3">
  <div class="sidebar"> 
    
    <!--侧边栏  分类 begin-->
    <div class="nei_box">
      <h3>分类目录<span class="glyphicon glyphicon-list" aria-hidden="true"></span></h3>
      <ul class="fenlei">
      
      <c:forEach items="${forum_categories}" var="categories" >
         <li class="cat-item cat-item-13"><a href="#" >${categories.name }</a> （${categories.resv1 }） </li>
        </c:forEach>
        
      </ul>
    </div>
    
    <!--侧边栏  热门文章 begin-->
    
    <div class="nei_box">
      <h3>最新发布的帖子<span class="glyphicon glyphicon-book" aria-hidden="true"></span></h3>
      <div class="img_box"> <a href="<%=path %>/IndexDoorServlet?method=forowdCommentInfo&id=${newforumList.get(0).id}" target="dakai"><img src="User/Jsp/Images/con00.jpg" alt="ThinkingData获百万级天使轮融资，大数据应用正在游戏行业萌芽" class="thumbnail"></a>
        <div class="art_title"> <span><i class="glyphicon glyphicon-camera" aria-hidden="true"></i>${newforumList.get(0).pub_date }</span>
          <h4><a href="<%=path %>/IndexDoorServlet?method=forowdCommentInfo&id=${newforumList.get(0).id}" target="">${newforumList.get(0).title }</a></h4>
        </div>
      </div>

      <!--随机获取3篇文章 开始-->
      <c:forEach items="${newforumList}" var="newforumList"  begin="1">
      <dl>
        <dt><a href="<%=path %>/IndexDoorServlet?method=forowdCommentInfo&id=${newforumList.id}" title="${newforumList.title }" target=""><img src="User/Jsp/Images/con05.jpg" alt="二次创业者，如何走出“二年生症候群”困境？" class="thumbnail"></a></dt>
        <dd class="biaoti"><a href="<%=path %>/IndexDoorServlet?method=forowdCommentInfo&id=${newforumList.id}" title="${newforumList.title }" target="">${newforumList.title }</a></dd>
        <dd class="date"><i class="glyphicon glyphicon-camera" aria-hidden="true"></i>${newforumList.pub_date }</dd>
      </dl>
      </c:forEach>

      <!--随机获取3篇文章结束--> 
    </div>
    
    <!--侧边栏  热门标签 begin-->
    
    <div class="nei_box">
      <h3>热门标签<span class="glyphicon glyphicon-tags" aria-hidden="true"></span></h3>
      <div class="hot_tag">
        <ul>
          <a href="#" class="tag-link-9" title="1个话题" style="color: ##FFFFFF;">css</a> <a href="#" class="tag-link-18" title="1个话题" style="color: ##FFFFFF;">css3</a> <a href="#" class="tag-link-28" title="1个话题" style="color: ##FFFFFF;">css样式</a> <a href="#" class="tag-link-20" title="1个话题" style="color: ##FFFFFF;">HTML优化</a> <a href="#" class="tag-link-24" title="1个话题" style="color: ##FFFFFF;">sublime</a> <a href="#" class="tag-link-19" title="3个话题" style="color: ##FFFFFF;">WEB前端</a> <a href="#" class="tag-link-25" title="1个话题" style="color: ##FFFFFF;">快捷键</a> <a href="#" class="tag-link-10" title="2个话题" style="color: ##FFFFFF;">技术</a> <a href="#" class="tag-link-11" title="1个话题" style="color: ##FFFFFF;">摄影</a> <a href="#" class="tag-link-12" title="1个话题" style="color: ##FFFFFF;">旅游</a> <a href="#" class="tag-link-27" title="1个话题" style="color: ##FFFFFF;">朋友圈</a> <a href="#" class="tag-link-26" title="1个话题" style="color: ##FFFFFF;">分享</a>
        </ul>
      </div>
    </div>
    
    <!--侧边栏  文章归档 begin-->
    
    <div class="nei_box">
      <h3>文章归档<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span></h3>
      <div class="hot_tag">
        <li><a href="<%=path %>/IndexDoorServlet?method=forowdCommentInfo">2016年三月</a></li>
        <li><a href="#">2016年二月</a></li>
        <li><a href="#">2016年一月</a></li>
      </div>
    </div>
    
    <!--侧边栏  关注我们 begind-->
    <div class="nei_box">
      <div class="title">
        <h6> 关注我啊~么么哒！</h6>
      </div>
      <div class="contact"> <a href="#"><i class="fa fa-renren"></i></a> <a href="#" class="email"><i class="fa fa-weibo"></i></a> <a href="#" class="weixin"><i class="fa fa-weixin"></i></a> <a href="#" class="qq"><i class="fa fa-qq"></i></a> </div>
    </div>
  </div>
  <!--侧边栏 end--> 
  <!--侧边栏 end--> 
</div>
</div>
<!--结束填充界面 888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888 -->




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
							<form id="form_id" action="UserServlet?method=userLogin&url"
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

</html><script type="text/javascript">
	 
	
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

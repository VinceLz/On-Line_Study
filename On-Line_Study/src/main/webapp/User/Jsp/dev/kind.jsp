<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link href="<%=path %>/User/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path %>/User/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<script type="text/javascript" src="<%=path %>/User/bootstrap/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/User/bootstrap/js/bootstrap.js"></script>
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
a,a:focus, input, botton,botton:focus, select, textarea {
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
.tabs_bar a,.checkbox a,.vcode a{
	color: #000;
	
}
.tabs_bar li a:hover{
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


/*kind*/
.kind {
	margin: 10px auto;
}
.kind .nav_bar_con, .kind_list .nav_bar_con {
	padding: 10px 20px 0;
}
.kind h3 {
	font-size: 20px;
	font-weight: bold;
	line-height: 26px;
	
}
.kind .kind_nav {
	border-top: 2px solid #CCC;
	border-bottom: 2px solid #CCC;
	margin: 15px 0 0;
}
.kind .kind_nav .kind_row {
	border-bottom: 1px solid #ddd;
	padding: 10px 0;
}
.kind .kind_nav .kind_row:last-child {
	border-bottom: none;
}
.kind .kind_nav .kind_row dt {
	line-height: 30px;
	width: 8%;
	text-align: right;
	float:left;
}
.kind .kind_nav .kind_row .kind_all {
	width: 10%;
	float: left;
	line-height: 30px;
	text-align: center;
}
.kind_row a {
	padding: 5px;
}
.kind_row .kind_avtive {
	color: #FFF;
	background-color: #ff4e4e;
	
}
.kind_text ul {
	float: left;
	width: 82%;
}
.kind_text ul li{
	float: left;
	line-height: 30px;
}
.kind_text ul li a{
	margin-right: 20px;
	color: #333;
}
.kind_text ul li a:hover{
	color: #ff4e4e;
}
.kind .kind_tit {
	background: #eee;
}
.kind .kind_tit ul li{
	float: left;
}
.kind .kind_tit ul li a{
	line-height: 36px;
	padding: 12px 20px;
}
.kind .kind_tit ul li a:hover{
	background-color: rgba(0,0,0,.1);
}


/*kind_list*/
.kind_list .kind_con {
	padding: 20px;
}
.kind_list .kind_con:hover {
	box-shadow: 0 0 6px #999;
}
.kind_list .kind_con img {
	width: 100%;
}
.kind_list .kind_con .kind_p {
	margin-top: 10px;
	font-size: 14px;
	font-weight: bold;
	line-height: 30px;
	color: #000;
}
.kind_list .kind_con p {
	font-size: 12px;
	line-height: 22px;
	color: #999;
}
.kind_list .nav_bar_con .page_bar {
	
	text-align: center;
}
.pagination {
	margin: 30px 0;
}
</style>
</head>

<body>
<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid nav_bar_con"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand logo" href="#"><img alt="Brand" src="Images/logo.png"></a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse item_list" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">课程</a></li>
        <li><a href="#">计划</a></li>
        <li><a href="#">文章</a></li>
        <li><a href="#">问答</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-left" role="search">
          <span class="search" id="search">
          <input type="text" class="form-control search_ip" placeholder="请输入想要查询的内容">
          <a href="#" onClick="hideSearch_ip()" id="search_cc"><span class="glyphicon glyphicon-search search_cc" aria-hidden="true"></span></a></span> <a href="#" onClick="showSearch_ip()" id="search_c"><span class="glyphicon glyphicon-search search_c" aria-hidden="true"></span></a>
        </form>
        <li><a href="#" class="message"><span class="glyphicon glyphicon-bell" aria-hidden="true"></span></a></li>
        <li><a href="#" class="message"><span class="glyphicon glyphicon-comment" aria-hidden="true"></span></a></li>
        <li><a href="#loginon" class="scrollto loginon" title="Login or Register" data-toggle="modal" data-target="#lgAndRg" onClick="showLoginon()"><span>登录</span></a></li>
        <li><a href="#register" class="scrollto register" title="Login or Register" data-toggle="modal" data-target="#lgAndRg" onClick="showRegister()"><span>注册</span></a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>


<!-- 填充界面 -->
<div class="kind">
    <div class="nav_bar_con">
    	<h3>全部课程</h3>
        <div class="kind_nav clearfix">
        	<dl class="kind_row clearfix">
            	<dt>方向：</dt>
                <dd class="kind_all"><a href="#" class="kind_avtive">全部</a></dd>
                <dd class="kind_text clearfix">
                	<ul class="clearfix">
                    	<li><a href="#">前端开发</a></li>
                        <li><a href="#">后端开发</a></li>
                        <li><a href="#">移动开发</a></li>
                        <li><a href="#">数据处理</a></li>
                        <li><a href="#">图像处理</a></li>
                    </ul>
                </dd>
            </dl>
            <dl class="kind_row clearfix">
            	<dt>分类：</dt>
                <dd class="kind_all"><a href="#" class="kind_avtive">全部</a></dd>
                <dd class="kind_text">
                    <ul class="clearfix">
                        <li><a href="#">HTML/CSS</a></li>
                        <li><a href="#">JavaScript</a></li>
                        <li><a href="#">CSS3</a></li>
                        <li><a href="#">Html5</a></li>
                        <li><a href="#">jQuery</a></li>
                        <li><a href="#">AngularJS</a></li>
                        <li><a href="#">Node.js</a></li>
                        <li><a href="#">Bootstrap</a></li>
                        <li><a href="#">WebApp</a></li>
                        <li><a href="#">前端工具</a></li>
                        <li><a href="#">PHP</a></li>
                        <li><a href="#">JAVA</a></li>
                        <li><a href="#">Linux</a></li>
                        <li><a href="#">Python</a></li>
                        <li><a href="#">C</a></li>
                        <li><a href="#">C++</a></li>
                        <li><a href="#">Go</a></li>
                        <li><a href="#">C#</a></li>
                        <li><a href="#">数据结构</a></li>
                        <li><a href="#">Android</a></li>
                    </ul>
                </dd>
            </dl>
            <dl class="kind_row clearfix">
            	<dt>难度：</dt>
                <dd class="kind_all"><a href="#" class="kind_avtive">全部</a></dd>
                <dd class="kind_text">
                    <ul class="clearfix">
                        <li><a href="#">初级</a></li>
                        <li><a href="#">中级</a></li>
                        <li><a href="#">高级</a></li>
                    </ul>
                </dd>
            </dl>
        </div>
        <div class="kind_tit">
        	<ul class="clearfix">
            	<li><a href="#">最新</a></li>
                <li><a href="#">最热</a></li>
                <li><a href="#">推荐</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="kind_list">
    <div class="nav_bar_con">
    	<div class="row">
    		<div class="col-md-3 col-sm-6">
    			<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
    		</div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
    	</div>
        <div class="row">
    		<div class="col-md-3 col-sm-6">
    			<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
    		</div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
    	</div>
        <div class="row">
    		<div class="col-md-3 col-sm-6">
    			<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
    		</div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
    	</div>
        <div class="row">
    		<div class="col-md-3 col-sm-6">
    			<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
    		</div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
            <div class="col-md-3 col-sm-6">
            	<div class="kind_con">
                	<a href="#"><img src="../Images/kind/kind1.jpg"></a>
                    <a href="#"><p class="kind_p">HTML+CSS基础课程</p></a>
                    <a href="#"><p>8小时带领大家步步深入学习标签...</p></a>
                    <p class="clearfix"><span class="fl">更新完毕</span><span class="fr">123456人学习</span></p>
    			</div>
            </div>
    	</div>
        <div class="page_bar">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</div>
    </div>
</div>


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
        <img class="aa" src="Images/Home/WeChat1.jpg"> </div>
    </div>
    <hr>
    <div class="footerbom"> Copyright &copy; 2016 zhiyuan.com All Rights Reserved | 京ICP备 111111111号-2 </div>
  </div>
</nav>







<script type="text/javascript">
	function showLoginon(){
		document.getElementById("loginon").className = "active";
		document.getElementById("register").className = "";
		document.getElementById("Loginon").className = "tab-pane fade active in";
		document.getElementById("Register").className = "tab-pane fade";
	}
	function showRegister(){
		document.getElementById("loginon").className = "";
		document.getElementById("register").className = "active";
		document.getElementById("Loginon").className = "tab-pane fade";
		document.getElementById("Register").className = "tab-pane fade active in";
	}
</script> 

<!--添加登录注册对话框-->
<div class="modal fade" data-show="true"  id="lgAndRg" class="lgAndRg">
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
            <form id="form_id">
              <fieldset>
                <div class="form-group" style="margin-top:20px">
                  <input type="text" id="account" name="account" class="form-control" placeholder="请输入用户名或Email">
                </div>
                <div class="form-group">
                  <input type="password" id="pwd" name="pwd" class="form-control" placeholder="请输入你的密码">
                </div>
                <div class="form-group vcode">
                  <input type="text" id="validate" name="validate" class="form-control" placeholder="请输入验证码" style="width:130px;float:left">
                  <img src="Images/Home/vcode.jpg">
                  <a href="#"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a>
                </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox">
                    记住密码</label>
                  <span style="float:right"><a href="#">找回密码</a></span> </div>
                <div class="">
                  <button type="submit" class="btn btn-lg btn-block loandre_btn">立刻登录</button>
                </div>
              </fieldset>
            </form>
          </div>
          <div class="tab-pane fade" id="Register">
            <form id="form_rs">
              <fieldset>
                <div class="form-group" style="margin-top:20px">
                  <input type="text" id="account" name="account" class="form-control" placeholder="请输入注册用户名或Email">
                </div>
                <div class="form-group">
                  <input type="password" id="pwd" name="pwd" class="form-control" placeholder="请输入你的密码">
                </div>
                <div class="form-group">
                  <input type="password" id="pwd1" name="pwd1" class="form-control" placeholder="请再次输入你的密码">
                </div>
                <div class="form-group">
                  <select id="province" name="province" class="form-control" style="width:135px;float:left">
                    <option selected = "selected">-请选择省份-</option>
                    <option value="">陕西</option>
                    <option value="">新疆</option>
                    <option value="">西藏</option>
                    <option value="">内蒙古</option>
                  </select>
                  <select id="city" name="city" class="form-control" style="width:130px;">
                    <option selected = "selected">-请选择城市-</option>
                    <option value="">西安</option>
                    <option value="">榆林</option>
                    <option value="">延安</option>
                    <option value="">渭南</option>
                    <option value="">铜川</option>
                    <option value="">宝鸡</option>
                  </select>
                </div>
                <div class="form-group">
                  <input type="text" id="e_mail" name="e_mail" class="form-control" placeholder="请输入你的邮箱">
                </div>
                <div id="sex" name="sex" class="radio">
                  <label style="width:60px">
                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                    男 </label>
                  <label>
                    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                    女 </label>
                </div>
                <div class="form-group vcode">
                  <input type="text" id="validate" name="validate" class="form-control" placeholder="请输入验证码" style="width:130px;float:left">
                  <img src="Images/Home/vcode.jpg">
                  <a href="#"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a>
                </div>
                <div class="">
                  <button type="submit" class="btn btn-lg btn-block loandre_btn">立刻注册</button>
              </fieldset>
            </form>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <span>用第三方登陆</span>
        <a href="#"><img class="inco1" src="Images/Home/qq.jpg"></a>
        <a href="#"><img class="inco1" src="Images/Home/wechat.jpg"></a>
        <a href="#"><img class="inco1" src="Images/Home/sina.jpg"></a>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	function showSearch_ip() {
        var search_ip =  document.getElementById("search");
		var search_c =  document.getElementById("search_c");
        search_ip.style.display = "inline-block";
		search_c.style.display = "none";
	}
	function hideSearch_ip() {
        var search_ip =  document.getElementById("search");
		var search_c =  document.getElementById("search_c");
        search_ip.style.display = "none";
		search_c.style.display = "inline-block";
	}
</script>
</body>
</html>

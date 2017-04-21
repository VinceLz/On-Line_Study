<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>详情一</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      	<img src="images/logo.png" width="200px">

    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">课程<span class="sr-only">(current)</span></a></li>
        <li><a href="#">计划</a></li>
       	<li><a href="#">文章</a></li>
        <li><a href="#">问答</a></li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
      	 <form class="navbar-form navbar-left" role="search">
        	<div class="form-group">
         	 <input type="text" class="form-control" placeholder="请输入你要搜索的内容">
        	</div>
        	<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
     	 </form>
        <li><div style="color:#CCC" style="float:LEFT"><img src="images/touxiang.png"/>&nbsp;&nbsp;&nbsp;个人中心</div></li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="top form-group">
	<h4>全部课程</h4>
    <hr/>
     <div class="row">
      <div class="col-md-2">
      <span class="glyphicon glyphicon-chevron-right text-primary"><strong>专业分类</strong></span></div>
      <div class="col-md-1">
      <button type="button" class="btn btn-primary btn-xs">全部</button></div>
      <div class="col-md-1"><a>计算机</a></div>
      <div class="col-md-1"><a>软件工程</a></div>
      <div class="col-md-1"><a>电子商务</a></div>
      <div class="col-md-1"><a>物联网</a></div>
      <div class="col-md-2"><a>电子信息工程</a></div>
    </div>
	<p style=" line-height:10px">&nbsp;</p>
     <div class="row">
      <div class="col-md-2">
      <span class="glyphicon glyphicon-chevron-right text-primary"><strong>详细分类</strong></span></div>
      <div class="col-md-1">
      <button type="button" class="btn btn-primary btn-xs">全部</button></div>
      <div class="col-md-1"><a>HTML/CSS</a></div>
      <div class="col-md-1"><a>JavaScript</a></div>
      <div class="col-md-1"><a>CSS3</a></div>
      <div class="col-md-1"><a>Html5</a></div>
      <div class="col-md-1"><a>JQuery</a></div>
      <div class="col-md-1"><a>AngularJS</a></div>
      <div class="col-md-1"><a>Node.js</a></div>
    </div>
    <p style=" line-height:10px">&nbsp;</p>
    <div class="row">
      <div class="col-xs-2 col-sm-2"><a>Bootstrap</a></div>
      <div class="col-xs-2 col-sm-2"><a>WebApp前端工具</a></div>
    
      <!-- Add the extra clearfix for only the required viewport -->
      <div class="clearfix visible-xs-block"></div>
    
      <div class="col-xs-4 col-sm-1"><a>PHP</a></div>
      <div class="col-xs-4 col-sm-1"><a>JAVA</a></div>
      <div class="col-xs-4 col-sm-1"><a>Linux</a></div>
      <div class="col-xs-4 col-sm-1"><a>Python</a></div>
</div>
	<p style=" line-height:10px">&nbsp;</p>
	<div class="row">
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/1.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/2.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/3.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/1.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/4.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/1.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/3.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
      </div>
    </div>
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/4.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/2.jpg" alt="...">
         <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/3.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
	  <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/4.jpg" alt="...">
         <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
          <img src="images/2.jpg" alt="...">
          <div class="caption">
           <div class="clearfix">
    <!-- 4_2加右浮动类样式pull-right -->
            <h5>jQuery 插件 fullage.js</h5>
            <div class="pull-left" style="color:#848383;">讲师：blue</div>
            <!-- 4_3添加左浮动类样式pull-right -->
            <div class="pull-right" style="color:#848383;">课程已完结</div>
          </div>
          </div>
        </div>
      </div>
      
       <div class="center-block">
       	  <a>上一页</a>
          <a>1</a>
          <a>2</a>
          <a>3</a>
          <a>4</a>
          <a>5</a>
          <a>6</a>
          <a>下一页</a>
       </div>
</div>
</div>
<div class="footer-bottom">
	
		<div class="container">
        	
			<div class="footer-grids">
				<div class="col-md-5 footer-grid">
					<h3><strong>智源学堂</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关于我们</h3>
					<ul>
						<li>Spring是一个致力于便捷，快速的网上学习平台</li>
						<li>用于大量学习资源，方便用户随时随地使用各种</li>
						<li>终端登录学习</li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid list-group">
					<ul>
                    	<h3>友情链接</h3>
						<li>netkeeper</li>
						<li>potplayer</li>
						<li>iTunes</li>
						<li>jjaghgeihg</li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					
					<ul>
                    <h3>友情链接</h3>
						<li>netkeeper</li>
						<li>potplayer</li>
						<li>iTunes</li>
						<li>jjaghgeihg</li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>legal</h4>
					<ul>
						<li><a href="#">Privacy</a></li>
						<li><a href="#">Terms and Conditions</a></li>
						<li><a href="#">Social Responsibility</a></li>
					</ul>
				</div>
			</div>
		</div>
    <!-- 如果要使用Bootstrap的JS插件，必须引入jQuery --> 
  <script src="js/jquery.min.js"></script>

  <!-- 包含已编译的全部Bootstrap的JS插件(或者包含必须的独立文件) --> 
  <script src="bootstrap/js/bootstrap.js"></script>
  </body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->  
	<link href="<%=path %>/User/CSS/Err/print.css" rel="stylesheet">
    <link href="<%=path %>/User/CSS/Err/screen.css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/User/JavaScript/Err/scripts.js"></script>

  </head>
  
  <body id="e404" >
<div id="root">
	<div id="content">
		<div class="outer">
			<div id="error">
				<h1 class="a">404 未找到!</h1>
				<p>您请求的页面没找到你可以去 <a href="#back"><span class="go-back">上一页</span></a> 或者去<a href="<%=path %>/IndexDoorServlet?method=indexDoor">首页</a></p>
			</div>
		</div>
	</div>
</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>${msg }</h1>
<table align="center" width="60%" border="1">
  <tr>
    <th>编号</th>
    <th>文件名称</th>
    <th>上传时间</th>
    <th>种类</th>
    <th>摘要</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${resourceList }" var="resourceList">
  <tr>
    <td>${resourceList.id }</td>
    <td>${resourceList.resourceName }</td>
    <td>${resourceList.uploadeDate }</td>
    <td>${resourceList.category }</td>
    <td>${resourceList.resume }</td>
    <td>
    <a href="<c:url value='/ResourceServlet?method=downloadFile&sid=${resourceList.id }'/>">下载</a>
    <a href="<c:url value='/ResourceServlet?method=deleteResourceById&sid=${resourceList.id }'/>">删除</a>
    </td>
  </tr>
  
  </c:forEach>
  
</table>
  </body>
</html>

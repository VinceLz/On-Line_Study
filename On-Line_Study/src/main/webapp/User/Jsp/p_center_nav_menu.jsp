<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<li role="presentation" class="active"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_Main"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-home"></span>主页<span
		id="forRight" class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
<li role="presentation"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_Class"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-facetime-video"></span>课程<span
		id="forRight" class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
<li role="presentation"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_Forum"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-list"></span>论坛<span
		id="forRight" class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
<li role="presentation"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_Comment"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-bullhorn"></span>评论<span
		id="forRight" class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
<li role="presentation"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_Track"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-stats"></span>足迹<span
		id="forRight" class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
<li role="presentation"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_Note"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-list-alt"></span>笔记<span
		id="forRight" class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
<li role="presentation"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_Data"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-folder-open"></span>资料<span
		id="forRight" class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
<li role="presentation"><a
	href="<%=path%>/PCenterServlet?method=ForwdCenter_ChgPw"><span
		style="margin-right: 10%;" class="glyphicon glyphicon-edit"></span>修改密码<span
		id="forRight" style="margin-left: 10%"
		class="glyphicon glyphicon-chevron-right"></span>
</a>
</li>
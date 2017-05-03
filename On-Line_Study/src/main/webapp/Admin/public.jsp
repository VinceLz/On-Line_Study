<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>智源网站后台管理</title>

<!-- Bootstrap core CSS -->
<link href="/On-Line_Study/Admin/assets/css/bootstrap.css"
	rel="stylesheet">
<!--external css-->
<link
	href="/On-Line_Study/Admin/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="/On-Line_Study/Admin/assets/js/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="/On-Line_Study/Admin/assets/js/bootstrap-daterangepicker/daterangepicker.css" />

<!-- Custom styles for this template -->
<link href="/On-Line_Study/Admin/assets/css/style.css" rel="stylesheet">
<link href="/On-Line_Study/Admin/assets/css/style-responsive.css"
	rel="stylesheet">
<link href="/On-Line_Study/Admin/css/index.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
	function getDateDemo() {
		/*  
		  
		    //声明时间  
		    var date = new Date();  
		    alert(date);//当前时间  
		    alert(date.toLocaleString());//转化为本地时间  
		    alert(date.getFullYear());//显示年份  
		    alert(date.getMonth() + 1);//显示月份 0-11，需要加1  
		    alert(date.getDate());//显示一月中的日期  
		    alert(date.getDay());//显示一周的日期，星期几  
		    alert(date.getHours());//获取小时时间  
		    alert(date.getMinutes());//获取当前分钟  
		    alert(date.getSeconds());//获取当前秒数  
		    alert(date.getMilliseconds());//获取当前的毫秒数  
		    alert(date.getTime());//获取从1970年1月1日午夜零时，到当前时间的毫秒值  
		 */
		//分别获取年、月、日、时、分、秒  
		var myDate = new Date();
		var year = myDate.getFullYear();
		var month = myDate.getMonth() + 1;
		var date = myDate.getDate();
		var hours = myDate.getHours();
		var minutes = myDate.getMinutes();
		var seconds = myDate.getSeconds();

		//月份的显示为两位数字如09月  
		if (month < 10) {
			month = "0" + month;
		}
		if (date < 10) {
			date = "0" + date;
		}

		//时间拼接  
		var dateTime = year + "年" + month + "月" + date + "日" + hours + "时"
				+ minutes + "分" + seconds + "秒";

		//document.write(dateTime);//打印当前时间  

		var divNode = document.getElementById("time");
		divNode.innerHTML = dateTime;

	}
	window.setInterval("getDateDemo()", 1000);//每隔1秒，调用一次getDateDemo()
</script>
</head>

<body>
	<c:if test="${admin==null }"><jsp:forward
			page="/Admin/login.jsp" /></c:if>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href='<c:url value="/Admin/index.jsp"></c:url>' class="logo"><b>智源学堂后台管理</b>
			</a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- settings start -->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="index.html#"> <i
							class="fa fa-tasks"></i> <span class="badge bg-theme">4</span> </a>
						<ul class="dropdown-menu extended tasks-bar">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 4 pending tasks</p>
							</li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">DashGum Admin Panel</div>
										<div class="percent">40%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%">
											<span class="sr-only">40% Complete (success)</span>
										</div>
									</div> </a>
							</li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Database Update</div>
										<div class="percent">60%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div> </a>
							</li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Product Development</div>
										<div class="percent">80%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
											style="width: 80%">
											<span class="sr-only">80% Complete</span>
										</div>
									</div> </a>
							</li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Payments Sent</div>
										<div class="percent">70%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="70" aria-valuemin="0"
											aria-valuemax="100" style="width: 70%">
											<span class="sr-only">70% Complete (Important)</span>
										</div>
									</div> </a>
							</li>
							<li class="external"><a href="#">See All Tasks</a>
							</li>
						</ul>
					</li>
					<!-- settings end -->
					<!-- inbox dropdown start-->
					<li id="header_inbox_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
							<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span>
					</a>
						<ul class="dropdown-menu extended inbox">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 5 new messages</p>
							</li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-zac.jpg"> </span> <span
									class="subject"> <span class="from">Zac Snider</span> <span
										class="time">Just now</span> </span> <span class="message"> Hi
										mate, how is everything? </span> </a>
							</li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-divya.jpg"> </span> <span
									class="subject"> <span class="from">Divya Manian</span>
										<span class="time">40 mins.</span> </span> <span class="message">
										Hi, I need your help with this. </span> </a>
							</li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-danro.jpg"> </span> <span
									class="subject"> <span class="from">Dan Rogers</span> <span
										class="time">2 hrs.</span> </span> <span class="message"> Love
										your new Dashboard. </span> </a>
							</li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-sherman.jpg"> </span> <span
									class="subject"> <span class="from">Dj Sherman</span> <span
										class="time">4 hrs.</span> </span> <span class="message">
										Please, answer asap. </span> </a>
							</li>
							<li><a href="index.html#">See all messages</a>
							</li>
						</ul>
					</li>
					<!-- inbox dropdown end -->
				</ul>
				<!--  notification end -->
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout"
						href='<c:url value="/index.jsp"></c:url>'>前台首页</a></li>
					<li><a class="logout"
						href='<c:url value="Admin/index.jsp"></c:url>'>首页</a></li>
					<li><a class="logout"
						href='<c:url value="/AdminLoginOutServlet?method=logout"></c:url>'>退出</a>
					</li>

				</ul>
			</div>
		</header>



		<div id="sidebar" class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu" id="nav-accordion">

				<p class="centered">
					<a
						href='<c:url value="/AdminInfoServlet?method=updateImageForword"></c:url>'><img
						src='<c:url value="/Admin/${img }"></c:url>' class="img-circle"
						width="60"> </a>
				</p>
				<h5 class="centered">${nakename }</h5>
				<c:if test="${admin_teacher.rank eq 0}">
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>用户管理</span> </a>
						<ul class="sub">
							<li><a
								href="<c:url value='/AdminShowUserInfoServlet?method=showinfoonly&count=${count }&page=${page }'></c:url>">查看所有用户</a>
							</li>
							<li><a
								href="<c:url value='/AdminShowUserInfoServlet?method=adminadduser'></c:url>">添加用户</a>
							</li>
						</ul></li>


					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>管理员管理</span> </a>
						<ul class="sub">
							<li><a
								href="<c:url value='/AdminInfoServlet?method=showinfoonly&count=${count }&page=${page }'></c:url>">管理员列表</a>
							</li>
							<li><a
								href="<c:url value='/AdminInfoServlet?method=addadminForword'></c:url>">添加管理员</a>
							</li>
						</ul></li>
				</c:if>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="glyphicon glyphicon-tags"></i> <span>资源种类管理</span> </a>
					<ul class="sub">
						<li><a
							href="<c:url value='/AdminCategoryServlet?method=showAllCategory&count=5&page=1'/>">查看所有资源种类</a>
						</li>
						<li><a
							href="<c:url value='/AdminCategoryServlet?method=showAddCategory'/>">增加资源种类</a>
						</li>
					</ul></li>


				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-book"></i> <span>资源管理</span> </a>
					<ul class="sub">
						<li><a
							href="<c:url value='/AdminResourceServlet?method=showAddResource'/>">添加资源</a>
						</li>
						<li><a
							href="<c:url value='/AdminResourceServlet?method=showAllResource&count=5&page=1'/>">查看所有资源</a>
						</li>
					</ul></li>



				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-tasks"></i> <span>兴趣管理</span> </a>
					<ul class="sub">
						<li><a
							href="<c:url value='/AdminManageInterestServlet?method=allinterestonly&count=${count }&page=${page }'></c:url>">查看兴趣列表</a>
						</li>
						<li><a
							href="<c:url value='/AdminManageInterestServlet?method=AddInterestName1'></c:url>">添加兴趣名称</a>
						</li>
						<li><a
							href="<c:url value='/AdminManageInterestServlet?method=AddInterest'></c:url>">添加兴趣</a>
						</li>
						<li><a
							href="<c:url value='/AdminManageInterestServlet?method=AddInterestCategory'></c:url>">添加兴趣细则</a>
						</li>
					</ul></li>


				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-tasks"></i> <span>论坛管理</span> </a>
					<ul class="sub">
						<li><a href="form_component.html">待审核帖子</a></li>
						<li><a href="form_component.html">待审核言论</a></li>
						<li><a href="form_component.html">帖子管理</a></li>
					</ul></li>


				<c:if test="${admin_teacher.rank eq 0}">
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>菜单管理</span> </a>
						<ul class="sub">
							<li><a
								href="<c:url value='/AdminMenuServlet?method=showAllMenu'/>">查看菜单</a>
							</li>
							<li><a
								href="<c:url value='/AdminMenuServlet?method=showMenuOrder'/>">调整顺序</a>
							</li>
							<li><a
								href="<c:url value='/AdminMenuServlet?method=addMenuFirst'/>">增加菜单</a>
							</li>
						</ul></li>
				</c:if>
				<c:if test="${admin_teacher.rank eq 0}">
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-bookmark-o"></i> <span>首页管理</span> </a>
						<ul class="sub">
							<li><a
								href="<c:url value='/AdminIndexServlet?method=showAllIndexDoor'/>">查看首页方案</a>
							</li>
							<li><a
								href="<c:url value='/AdminIndexServlet?method=addIndexFirst'/>">增加首页方案</a>
							</li>
						</ul></li>
				</c:if>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-bookmark-o"></i> <span>考试管理</span> </a>
					<ul class="sub">
						<li><a href="<c:url value='/ExamServlet?method=showAll'/>">查看考试情况</a>
						</li>
						<li><a
							href="<c:url value='/ExamServlet?method=showAllPaper'/>">试卷管理</a>
						</li>
						<li><a
							href="<c:url value='/ExamServlet?method=addQuestPre'/>">考题录入</a>
						</li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class=" fa fa-bar-chart-o"></i> <span>个人中心</span> </a>
					<ul class="sub">
						<li><a
							href="<c:url value='/AdminInfoServlet?method=MyInfo&account=${admin }'></c:url>">我的信息</a>
						</li>
						<li><a
							href="<c:url value='/AdminInfoServlet?method=ChangeMyInfo&account=${admin }'></c:url>">修改个人信息</a>
						</li>
						<li><a
							href="<c:url value='AdminInfoServlet?method=ChangPwd'/>">修改密码</a>
						</li>
						<li><a href="chartjs.html"></a></li>
						<li><a href="chartjs.html"></a></li>
					</ul></li>

			</ul>
			<!-- sidebar menu end-->
		</div>
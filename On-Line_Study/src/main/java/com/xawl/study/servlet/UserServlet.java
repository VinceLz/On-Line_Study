package com.xawl.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.Area;
import com.xawl.study.model.City;
import com.xawl.study.model.ClassName;
import com.xawl.study.model.Comment;
import com.xawl.study.model.CommentInfo;
import com.xawl.study.model.Forum;
import com.xawl.study.model.IndexModel;
import com.xawl.study.model.Login_Log;
import com.xawl.study.model.MenuModel;
import com.xawl.study.model.Page;
import com.xawl.study.model.Province;
import com.xawl.study.model.Resource;
import com.xawl.study.model.Student;
import com.xawl.study.service.AreaService;
import com.xawl.study.service.CityService;
import com.xawl.study.service.CommentService;
import com.xawl.study.service.ForumService;
import com.xawl.study.service.IndexModelService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.Login_LogService;
import com.xawl.study.service.MenuService;
import com.xawl.study.service.ProvinceService;
import com.xawl.study.service.ResourceService;
import com.xawl.study.service.StudentService;
import com.xawl.study.util.PageUtil;

/**
 * 用户相关的操作
 * 
 * @author Zhao
 * 
 */
public class UserServlet extends BaseServlets {// 直接用户相关的servlet
	@Autowired
	MenuService menuService;
	@Autowired
	ResourceService resourceService;
	@Autowired
	InterestService interestService;
	@Autowired
	IndexModelService indexModelService;
	@Autowired
	ProvinceService ps;
	@Autowired
	CityService cs;
	@Autowired
	AreaService as;
	@Autowired
	StudentService service;
	@Autowired
	Login_LogService login_LogService;
	@Autowired
	CommentService commentService;
	@Autowired
	ServletUtil servletUtil;

	@Autowired
	ForumService forumService;
	private static String regist = "";

	/**
	 * 获取省份列表，输出到前台
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void GetProvince(HttpServletRequest request,
			HttpServletResponse response) throws IOException {// 返回省的列表

		StringBuilder sb = new StringBuilder();
		List<Province> PList = ps.GetAllProvinceList();
		for (int i = 0; i < PList.size(); i++) {
			sb.append(PList.get(i).getProvinceID());
			sb.append(",");
			sb.append(PList.get(i).getProvince());
			if (i < PList.size() - 1) {
				sb.append(",");
			}
		}
		response.getWriter().print(sb);
	}

	/**
	 * 根据省份的ID 获取市的列表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void GetCity(HttpServletRequest request, HttpServletResponse response)
			throws IOException {// 返回市的列表
		String provinceID = request.getParameter("provinceID");

		StringBuilder sb = new StringBuilder();
		List<City> PList = cs.GetListByProvince(provinceID);
		for (int i = 0; i < PList.size(); i++) {
			sb.append(PList.get(i).getCityID());
			sb.append(",");
			sb.append(PList.get(i).getCity());
			if (i < PList.size() - 1) {
				sb.append(",");
			}
		}
		response.getWriter().print(sb);
	}

	/**
	 * 根据市的Id获取县的列表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void GetArea(HttpServletRequest request, HttpServletResponse response)
			throws IOException {// 返回县的列表
		String cityID = request.getParameter("cityID");

		StringBuilder sb = new StringBuilder();
		List<Area> PList = as.GetAreaByCity(cityID);
		for (int i = 0; i < PList.size(); i++) {
			sb.append(PList.get(i).getAreaID());
			sb.append(",");
			sb.append(PList.get(i).getArea());
			if (i < PList.size() - 1) {
				sb.append(",");
			}
		}
		response.getWriter().print(sb);
	}

	/**
	 * 用户登录处理方法
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("deprecation")
	public String userLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("account");
		String password = request.getParameter("pwd");
		String code = request.getParameter("validate");
		String uri = request.getHeader("Referer");
		int i = uri.lastIndexOf("/");
		String realUrl = uri.substring(i);
		Student student = new Student();
		student.setAccount(name);
		student.setE_mail(name);
		student.setPwd(password);
		System.out.println(request.getSession().getAttribute("vCode"));
		System.out.println(code);
		if ((request.getSession().getAttribute("vCode")).toString()
				.toUpperCase().equals(code.toUpperCase())) {

			Student studentr = new Student();
			studentr = service.StudentLogin(student);// 返回的登陆结果
			if (studentr != null) {
				request.getSession().setAttribute("user", studentr);
				if ("/UserServlet?method=userRegister".equals(realUrl)
						|| "/UserServlet?method=userLogin".equals(realUrl)
						|| "/UserServlet?method=userLogout".equals(realUrl)) {
					realUrl = regist;
				} else {
					regist = realUrl;
				}
				// 保存登录数据到数据库
				Login_Log log = new Login_Log();
				log.setLogin_Account(name);
				log.setLogin_Ip(request.getLocalAddr());
				log.setLogin_Month(new Date().getMonth() + 1 + "");
				log.setLogin_Time(new Date().toLocaleString());
				login_LogService.AddLogin_Log(log);
				return "r:/" + realUrl;
			} else {
				return "f:/User/Jsp/error/loginFail.jsp";
			}
		} else {
			return "f:/User/Jsp/error/loginFail.jsp";
		}

	}

	/*
	 * 用户退出
	 */
	public String userLogout(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		String uri = request.getHeader("Referer");
		int i = uri.lastIndexOf("/");
		String realUrl = uri.substring(i);
		if ("/UserServlet?method=userRegister".equals(realUrl)
				|| "/UserServlet?method=userLogin".equals(realUrl)
				|| "/UserServlet?method=userLogout".equals(realUrl)) {
			realUrl = regist;
		} else {
			regist = realUrl;
		}

		return "f:/" + realUrl;
	}

	/**
	 * 用戶註冊方法
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	public String userRegister(HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * 获取数据
		 */
		String username = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String pwd1 = request.getParameter("pwd1");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String e_mail = request.getParameter("e_mail");
		String optionsRadios = request.getParameter("optionsRadios");
		int classId = Integer.parseInt(request.getParameter("classname"));
		if ("option2".equals(optionsRadios)) {
			optionsRadios = "女";
		} else {
			optionsRadios = "男";
		}
		/**
		 * 后台简单验证
		 */
		System.out.println(optionsRadios + "********************************");
		if (!pwd.equals(pwd1)) {
			throw new RuntimeException("两次密码不一致");
		}

		/**
		 * 封装数据
		 */

		province = ps.getProvinceNameByID(province);
		city = cs.getCityNameByCityID(city);
		Student student = new Student();
		student.setAccount(username);
		student.setCity(city);
		student.setE_mail(e_mail);
		student.setProvince(province);
		student.setDate(new Date().toLocaleString());
		student.setSex(optionsRadios);
		student.setPwd(pwd);
		student.setNickName("飞翔的蚂蚁");
		student.setPicture("/Images/logo.jpg");
		ClassName cla = new ClassName();
		cla.setClassId(classId);
		student.setClassId(cla);
		/*
		 * 验证用户是否已存在
		 */
		if (service.FindStudentByAccount(student) != null) {
			throw new RuntimeException("账号已被注册");
		}
		/*
		 * 验证邮箱是否已注册
		 */
		if (service.FindStudentByEmail(student) != null) {
			throw new RuntimeException("邮箱已被注册");
		}
		String uri = request.getHeader("Referer");
		int i = uri.lastIndexOf("/");
		String realUrl = uri.substring(i);
		if (service.StudnetRegist(student)) {
			if ("/UserServlet?method=userRegister".equals(realUrl)
					|| "/UserServlet?method=userLogin".equals(realUrl)
					|| "/UserServlet?method=userLogout".equals(realUrl)) {
				realUrl = regist;
			} else {
				regist = realUrl;
			}
			return "f:/" + realUrl;
		} else {
			return "f:/model.jsp";
		}
	}

	/**
	 * 验证用户名是否已被注册
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkStudentAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String username = request.getParameter("account");
		Student student = new Student();
		student.setAccount(username);
		if (service.FindStudentByAccount(student) != null) {
			response.getWriter().write("用户名已注册");
		}
	}

	/*
	 * 验证邮箱是否已被注册
	 */
	public void checkStudentEmail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String e_mail = request.getParameter("e_mail");
		Student student = new Student();
		student.setE_mail(e_mail);
		if (service.FindStudentByEmail(student) != null) {
			response.getWriter().write("邮箱已注册");
		}
	}

	public void addComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");// 资源id
		String content = request.getParameter("content");// 资源id
		String toUser = "";
		try {
			toUser = request.getParameter("toUser");

		} catch (Exception e) {

		}
		Comment commentinfo = new Comment();
		Student studentt = new Student();
		try {
			studentt = (Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect(request.getContextPath()
					+ "IndexDoorServlet?method=indexDoor");
		}
		commentinfo.setComment_user_acct(studentt.getAccount());
		commentinfo.setComment_to_user_acct(toUser);
		commentinfo.setContent(content);
		commentinfo.setResv1(id);
		commentinfo.setResv2("1");
		commentinfo.setComment_type(0);
		commentinfo.setComment_date(new Date().toLocaleString());

		commentService.AddComment(commentinfo);
		// 查询评论信息
		List<CommentInfo> listCommentInfo = new ArrayList<CommentInfo>();
		List<Comment> comment = commentService.FindCommentByRES(
				Integer.parseInt(id), 0);
		for (int i = 0; i < comment.size(); i++) {
			Student student = new Student();
			CommentInfo commentInfo = new CommentInfo();
			student.setAccount(comment.get(i).getComment_user_acct());
			Student studentInfo = service.FindStudentByAccount(student);
			commentInfo.setStudent(studentInfo);
			commentInfo.setComment(comment.get(i));
			listCommentInfo.add(commentInfo);
		}
		request.setAttribute("listCommentInfo", listCommentInfo);

		Resource resourceList = new Resource();// 一种兴趣的所有视频资源
		resourceList = resourceService.findResourceById(Integer.parseInt(id));
		request.setAttribute("resourceList", resourceList);
		// 首页方案
		IndexModel indexModel = new IndexModel();
		indexModel = indexModelService.findUseModel();
		request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		response.sendRedirect(request.getContextPath()
				+ "/IndexDoorServlet?method=forowdVideo&id=" + id);
		// request.getRequestDispatcher("User/Jsp/video.jsp").forward(request,
		// response);
	}

	public void addCommentForum(HttpServletRequest request,// ajax请求
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");// 资源id
		String content = request.getParameter("content");// 资源id
		String toUser = "";
		String fatherId = "";
		try {
			toUser = request.getParameter("toUser");
			fatherId = request.getParameter("fatherId");
		} catch (Exception e) {

		}
		Comment commentinfo = new Comment();
		Student studentt = (Student) request.getSession().getAttribute("user");
		commentinfo.setComment_user_acct(studentt.getAccount());
		commentinfo.setComment_to_user_acct(toUser);
		commentinfo.setContent(content);
		commentinfo.setResv1(id);
		commentinfo.setResv2("0");
		commentinfo.setFather_id(Integer.parseInt(fatherId));
		commentinfo.setComment_type(1);
		commentinfo.setRead_state(1);
		commentinfo.setComment_date(new Date().toLocaleString());

		commentService.AddComment(commentinfo);

	}

	public void addFCommentForum(HttpServletRequest request,// ajax请求
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");// 资源id
		String content = request.getParameter("content");// 资源id
		Comment commentinfo = new Comment();
		Student studentt = (Student) request.getSession().getAttribute("user");
		commentinfo.setComment_user_acct(studentt.getAccount());
		commentinfo.setContent(content);
		commentinfo.setResv1(id);
		commentinfo.setResv2("0");
		commentinfo.setComment_type(1);
		commentinfo.setRead_state(1);
		commentinfo.setComment_date(new Date().toLocaleString());
		commentService.AddComment(commentinfo);

	}

	public String forowdMyForumList(HttpServletRequest request,// 转发到我的帖子详情页面
			HttpServletResponse response) throws ServletException, IOException {
		try {
			((Student) request.getSession().getAttribute("user")).getAccount();
		} catch (Exception e) {
			// TODO: handle exception

		}
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		// // 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		String account = (((Student) request.getSession().getAttribute("user"))
				.getAccount());
		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}
		Page page = PageUtil.createPage(5,
				forumService.FindForumByAccountNotPageCount(account),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(5,
					forumService.FindForumByAccountNotPageCount(account),
					page.getTotalPage());
		}
		List<Forum> forums = forumService.FindForumByAccountPage(account, page);
		for (int i = 0; i < forums.size(); i++) {
			forums.get(i).setContent(
					forums.get(i).getContent().length() > 50 ? forums.get(i)
							.getContent().substring(0, 150)
							+ "..." : forums.get(i).getContent());
			forums.get(i).setPub_date(
					forums.get(i)
							.getPub_date()
							.toString()
							.substring(
									0,
									forums.get(i).getPub_date().toString()
											.lastIndexOf(".")));

		}

		request.setAttribute("forumList", forums);

		request.setAttribute("page", page);
		request.setAttribute("servlet", "UserServlet");
		request.setAttribute("method", "forowdMyForumList");

		return "f:/User/Jsp/myForumList.jsp";
	}
}

package com.xawl.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xawl.study.dao.impl.NoticeInfo;
import com.xawl.study.model.ClassName;
import com.xawl.study.model.Comment;
import com.xawl.study.model.CommentInfo;
import com.xawl.study.model.Forum;
import com.xawl.study.model.Forum_category;
import com.xawl.study.model.IndexModel;
import com.xawl.study.model.Interest;
import com.xawl.study.model.MenuModel;
import com.xawl.study.model.Page;
import com.xawl.study.model.Resource;
import com.xawl.study.model.Student;
import com.xawl.study.service.CommentService;
import com.xawl.study.service.ForumService;
import com.xawl.study.service.Forum_categoryService;
import com.xawl.study.service.IndexModelService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.MenuService;
import com.xawl.study.service.ResourceService;
import com.xawl.study.service.StudentService;
import com.xawl.study.util.JsonUtils;
import com.xawl.study.util.PageUtil;

import fr.opensagres.xdocreport.document.json.JSONObject;

@Controller()
public class IndexDoorServlet extends BaseServlets {
	@Autowired
	private MenuService menuService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private InterestService interestService;
	@Autowired
	private IndexModelService indexModelService;
	@Autowired
	private ServletUtil servletUtil;
	@Autowired
	CommentService commentService;
	@Autowired
	StudentService studentService;
	@Autowired
	ForumService forumService;

	@Autowired
	Forum_categoryService categoryService;

	public String indexDoor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消数量放入到用户request中
		// ---获取首页启用的菜单---
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		// ---获取首页展示的兴趣---
		List<Interest> interestList = interestService.FindIsUseInterest();
		request.setAttribute("interestList", interestList);

		// ---按兴趣获取首页视频资源---
		// 得到兴趣的id集合
		List<Integer> interestIdList = new ArrayList<Integer>();
		for (Interest interest : interestList) {
			interestIdList.add(interest.getId());
		}

		// 获取首页各兴趣的视频
		List<List<Resource>> resourceListList = new ArrayList<List<Resource>>();// 所有兴趣的视频资源
		List<List<Resource>> resourceListListN = new ArrayList<List<Resource>>();// 需要兴趣的视频资源
		int num = 0;
		for (int i = 0; i < interestIdList.size(); i++) {
			List<Resource> resourceList = new ArrayList<Resource>();// 一种兴趣的所有视频资源
			resourceList = resourceService.findResourceByTypeAndInterest(0,
					interestIdList.get(i));

			resourceListList.add(resourceList);
		}
		int temp = 0;
		for (int i = 0; i < resourceListList.size(); i++) {
			List<Resource> resourceListT = new ArrayList<Resource>();
			for (int j = 0; j < resourceListList.get(i).size(); j++) {
				temp++;

				resourceListT.add(resourceListList.get(i).get(j));
				if (temp > 5) {
					break;
				}
			}
			resourceListListN.add(resourceListT);
			if (temp > 5) {
				break;
			}
		}
		request.setAttribute("resourceListList", resourceListListN);

		// ---获取启用的首页方案---
		IndexModel indexModel = new IndexModel();
		indexModel = indexModelService.findUseModel();
		request.setAttribute("indexModel", indexModel);

		return "User/Jsp/index1.jsp";
	}

	@RequestMapping("/forowdMessage")
	public String forowdMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (null == request.getSession().getAttribute("user")) {
			throw new RuntimeException("请先登录");
		}
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		//
		// // 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		return "f:/User/Jsp/message.jsp";
	}

	@RequestMapping("/forowdNotice")
	public String forowdNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (null == request.getSession().getAttribute("user")) {
			throw new RuntimeException("请先登录");
		}
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		// // 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}
		Page page = PageUtil.createPage(6, commentService
				.FindForumCommentUserAccountCount(((Student) request
						.getSession().getAttribute("user")).getAccount()),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(6, commentService
					.FindForumCommentUserAccountCount(((Student) request
							.getSession().getAttribute("user")).getAccount()),
					page.getTotalPage());
		}

		// 加载消息，注意已读和未读
		List<Comment> comments = commentService.FindForumCommentByUserAccount(
				((Student) request.getSession().getAttribute("user"))
						.getAccount(), page, 1);
		List<NoticeInfo> comment = new ArrayList<NoticeInfo>();
		for (int i = 0; i < comments.size(); i++) {
			NoticeInfo info = new NoticeInfo();
			comments.get(i).setComment_date(
					comments.get(i).getComment_date().substring(0, 19));
			info.setComment(comments.get(i));
			Forum forum = forumService.FindForumByID(Integer.parseInt(comments
					.get(i).getResv1()));
			info.setForum(forum);
			comment.add(info);
		}
		request.setAttribute("comment", comment);
		request.setAttribute("servlet", "IndexDoorServlet");
		request.setAttribute("method", "forowdNotice");
		request.setAttribute("page", page);

		return "f:/User/Jsp/notice.jsp";
	}

	public void ForowdNoticeSetReadAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (null == request.getSession().getAttribute("user")) {
			throw new RuntimeException("请先登录");
		}
		commentService.SetCommentReadAll(((Student) request.getSession()
				.getAttribute("user")).getAccount());

		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		// // 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}
		Page page = PageUtil.createPage(6, commentService
				.FindForumCommentUserAccountCount(((Student) request
						.getSession().getAttribute("user")).getAccount()),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(6, commentService
					.FindForumCommentUserAccountCount(((Student) request
							.getSession().getAttribute("user")).getAccount()),
					page.getTotalPage());
		}

		// 加载消息，注意已读和未读
		List<Comment> comments = commentService.FindForumCommentByUserAccount(
				((Student) request.getSession().getAttribute("user"))
						.getAccount(), page, 1);
		List<NoticeInfo> comment = new ArrayList<NoticeInfo>();
		for (int i = 0; i < comments.size(); i++) {
			NoticeInfo info = new NoticeInfo();
			comments.get(i).setComment_date(
					comments.get(i).getComment_date().substring(0, 19));
			info.setComment(comments.get(i));
			Forum forum = forumService.FindForumByID(Integer.parseInt(comments
					.get(i).getResv1()));
			info.setForum(forum);
			comment.add(info);
		}
		request.setAttribute("comment", comment);
		request.setAttribute("servlet", "IndexDoorServlet");
		request.setAttribute("method", "forowdNotice");
		request.setAttribute("page", page);

		// request.getRequestDispatcher(request.getContextPath()+"IndexDoorServlet&method=forowdNotice").forward(request,
		// response);
		response.sendRedirect(request.getContextPath()
				+ "/IndexDoorServlet?method=forowdNotice");
	}

	public String forowdComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		// // 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}

		Page page = PageUtil.createPage(8,
				forumService.FindForumBySupportCount(),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil
					.createPage(8, forumService.FindForumBySupportCount(),
							page.getTotalPage());
		}
		request.setAttribute("page", page);
		request.setAttribute("servlet", "IndexDoorServlet");
		request.setAttribute("method", "forowdComment");
		// 取得帖子的值
		List<Forum> forumList = forumService.FindForumBySupport(page);
		for (int i = 0; i < forumList.size(); i++) {// 循环添加头像
			Student student = new Student();
			student.setAccount(forumList.get(i).getPub_account());
			Student userURL = studentService.FindStudentByAccount(student);
			forumList.get(i).setUserURL(userURL.getPicture());

			forumList.get(i).setPub_date(
					forumList.get(i).getPub_date().substring(0, 19));
		}
		request.setAttribute("forumList", forumList);
		// 获取分类，按照分类下面的帖子数量获取
		List<Forum_category> forum_categories = new ArrayList<Forum_category>();
		forum_categories = categoryService.FindForum_categoryBySupport();
		request.setAttribute("forum_categories", forum_categories);
		// 获取最新发布的帖子
		List<Forum> newforumList = forumService.FindForumByPub_Date();
		for (int i = 0; i < newforumList.size(); i++) {// 循环转换时间
			newforumList.get(i).setPub_date(
					newforumList.get(i).getPub_date().substring(0, 19));
		}
		request.setAttribute("newforumList", newforumList);

		return "f:/User/Jsp/commentList.jsp";
	}

	public String forowdCommentInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置未读消息问已读
		String commentId = "";
		try {
			commentId = request.getParameter("commentId");
			commentService.SetCommentReadById(commentId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		// // 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		// 帖子信息
		String id = request.getParameter("id");
		Forum forum = forumService.FindForumByID(Integer.parseInt(id));
		forum.setPub_date(forum.getPub_date().substring(0, 19));
		request.setAttribute("forum", forum);
		// 评论信息

		int a = commentService.FindCommentByRESCount(Integer.parseInt(id), 1);
		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}
		Page page = PageUtil.createPage(4, a, Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(4, a, page.getTotalPage());
		}
		request.setAttribute("page", page);
		request.setAttribute("servlet", "IndexDoorServlet");
		request.setAttribute("other", "&id=" + id);
		request.setAttribute("method", "forowdCommentInfo");

		//

		List<Comment> comments = new ArrayList<Comment>();
		comments = commentService.FindCommentByRES(Integer.parseInt(id), 1);
		List<List<CommentInfo>> list = new ArrayList<List<CommentInfo>>();

		List<Comment> comments2 = new ArrayList<Comment>();
		comments2 = commentService.FindCommentByRESFirst(Integer.parseInt(id),
				1, page);
		// 加载子条
		for (int i = 0; i < comments2.size(); i++) {
			List<Comment> comments3 = new ArrayList<Comment>();
			comments3.add(comments2.get(i));
			for (int j = 0; j < comments.size(); j++) {// 通过循环找出一条评论的对话
				if (comments2.get(i).getId() == comments.get(j).getFather_id()) {
					comments3.add(comments.get(j));
				}
			}
			List<CommentInfo> listCommentInfo = new ArrayList<CommentInfo>();
			for (int k = 0; k < comments3.size(); k++) {
				Student student = new Student();
				CommentInfo commentInfo = new CommentInfo();
				student.setAccount(comments3.get(k).getComment_user_acct());
				Student studentInfo = studentService
						.FindStudentByAccount(student);
				commentInfo.setStudent(studentInfo);
				commentInfo.setComment(comments3.get(k));
				listCommentInfo.add(commentInfo);
			}
			list.add(listCommentInfo);
		}
		request.setAttribute("comments", list);
		// 最热的帖子列表
		List<Forum> newforumList = forumService.FindForumByPub_Date();
		for (int i = 0; i < newforumList.size(); i++) {// 循环转换时间
			newforumList.get(i).setPub_date(
					newforumList.get(i).getPub_date().substring(0, 19));
		}
		request.setAttribute("newforumList", newforumList);
		// 获取上一篇帖子和下一篇贴子
		Forum backForum = new Forum();
		Forum nextForum = new Forum();
		List<Forum> newforumListInfo = forumService.FindForumByPub_DateNoPage();

		if (newforumListInfo.get(0).getId() == Integer.parseInt(id)) {
			nextForum = newforumListInfo.get(1);
		}
		if (newforumListInfo.get(newforumListInfo.size() - 1).getId() == Integer
				.parseInt(id)) {
			backForum = newforumListInfo.get(newforumListInfo.size() - 2);
		}
		for (int i = 1; i < newforumListInfo.size() - 2; i++) {
			if (newforumListInfo.get(i).getId() == Integer.parseInt(id)) {
				backForum = newforumListInfo.get(i - 1);
				nextForum = newforumListInfo.get(i + 1);
			}
		}
		request.setAttribute("backForum", backForum);
		request.setAttribute("nextForum", nextForum);

		// 获取发布帖子用户的信息
		Student s = new Student();
		s.setAccount(forum.getPub_account());
		Student student = studentService.FindStudentByAccount(s);
		request.setAttribute("pub_user", student);

		return "f:/User/Jsp/commentInfo.jsp";
	}

	public String forowdVideo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		String id = request.getParameter("id");
		// 查询评论信息
		List<CommentInfo> listCommentInfo = new ArrayList<CommentInfo>();
		//
		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}
		Page page = PageUtil.createPage(6,
				commentService.FindCommentByRESCount(Integer.parseInt(id), 0),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(6, commentService.FindCommentByRESCount(
					Integer.parseInt(id), 0), page.getTotalPage());
		}

		List<Comment> comment = commentService.FindCommentByRESFirst(
				Integer.parseInt(id), 0, page);
		for (int i = 0; i < comment.size(); i++) {
			comment.get(i).setComment_date(
					comment.get(i).getComment_date().substring(0, 19));
		}
		for (int i = 0; i < comment.size(); i++) {
			Student student = new Student();
			CommentInfo commentInfo = new CommentInfo();
			student.setAccount(comment.get(i).getComment_user_acct());
			Student studentInfo = studentService.FindStudentByAccount(student);
			commentInfo.setStudent(studentInfo);
			commentInfo.setComment(comment.get(i));
			listCommentInfo.add(commentInfo);
		}
		request.setAttribute("listCommentInfo", listCommentInfo);

		Resource resourceList = new Resource();// 一种兴趣的所有视频资源
		resourceList = resourceService.findResourceById(Integer.parseInt(id));
		request.setAttribute("resourceList", resourceList);
		// // 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		request.setAttribute("page", page);
		request.setAttribute("resId", id);
		request.setAttribute("servlet", "IndexDoorServlet");
		request.setAttribute("method", "forowdVideo");
		request.setAttribute("other", "&id=" + id);
		System.out.println("-------我响应完了");
		return "f:/User/Jsp/video.jsp";
	}

	public String getAllClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ClassName> classname = interestService.getAllClass();
		String objectToJson = JsonUtils.objectToJson(classname);
		response.getWriter().print(objectToJson);
		return null;
	}
}

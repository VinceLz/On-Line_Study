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
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ�������������뵽�û�request��
		// ---��ȡ��ҳ���õĲ˵�---
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		// ---��ȡ��ҳչʾ����Ȥ---
		List<Interest> interestList = interestService.FindIsUseInterest();
		request.setAttribute("interestList", interestList);

		// ---����Ȥ��ȡ��ҳ��Ƶ��Դ---
		// �õ���Ȥ��id����
		List<Integer> interestIdList = new ArrayList<Integer>();
		for (Interest interest : interestList) {
			interestIdList.add(interest.getId());
		}

		// ��ȡ��ҳ����Ȥ����Ƶ
		List<List<Resource>> resourceListList = new ArrayList<List<Resource>>();// ������Ȥ����Ƶ��Դ
		List<List<Resource>> resourceListListN = new ArrayList<List<Resource>>();// ��Ҫ��Ȥ����Ƶ��Դ
		int num = 0;
		for (int i = 0; i < interestIdList.size(); i++) {
			List<Resource> resourceList = new ArrayList<Resource>();// һ����Ȥ��������Ƶ��Դ
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

		// ---��ȡ���õ���ҳ����---
		IndexModel indexModel = new IndexModel();
		indexModel = indexModelService.findUseModel();
		request.setAttribute("indexModel", indexModel);

		return "User/Jsp/index1.jsp";
	}

	@RequestMapping("/forowdMessage")
	public String forowdMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (null == request.getSession().getAttribute("user")) {
			throw new RuntimeException("���ȵ�¼");
		}
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		//
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		return "f:/User/Jsp/message.jsp";
	}

	@RequestMapping("/forowdNotice")
	public String forowdNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (null == request.getSession().getAttribute("user")) {
			throw new RuntimeException("���ȵ�¼");
		}
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
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

		// ������Ϣ��ע���Ѷ���δ��
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
			throw new RuntimeException("���ȵ�¼");
		}
		commentService.SetCommentReadAll(((Student) request.getSession()
				.getAttribute("user")).getAccount());

		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
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

		// ������Ϣ��ע���Ѷ���δ��
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
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
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
		// ȡ�����ӵ�ֵ
		List<Forum> forumList = forumService.FindForumBySupport(page);
		for (int i = 0; i < forumList.size(); i++) {// ѭ�����ͷ��
			Student student = new Student();
			student.setAccount(forumList.get(i).getPub_account());
			Student userURL = studentService.FindStudentByAccount(student);
			forumList.get(i).setUserURL(userURL.getPicture());

			forumList.get(i).setPub_date(
					forumList.get(i).getPub_date().substring(0, 19));
		}
		request.setAttribute("forumList", forumList);
		// ��ȡ���࣬���շ������������������ȡ
		List<Forum_category> forum_categories = new ArrayList<Forum_category>();
		forum_categories = categoryService.FindForum_categoryBySupport();
		request.setAttribute("forum_categories", forum_categories);
		// ��ȡ���·���������
		List<Forum> newforumList = forumService.FindForumByPub_Date();
		for (int i = 0; i < newforumList.size(); i++) {// ѭ��ת��ʱ��
			newforumList.get(i).setPub_date(
					newforumList.get(i).getPub_date().substring(0, 19));
		}
		request.setAttribute("newforumList", newforumList);

		return "f:/User/Jsp/commentList.jsp";
	}

	public String forowdCommentInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ����δ����Ϣ���Ѷ�
		String commentId = "";
		try {
			commentId = request.getParameter("commentId");
			commentService.SetCommentReadById(commentId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		// ������Ϣ
		String id = request.getParameter("id");
		Forum forum = forumService.FindForumByID(Integer.parseInt(id));
		forum.setPub_date(forum.getPub_date().substring(0, 19));
		request.setAttribute("forum", forum);
		// ������Ϣ

		int a = commentService.FindCommentByRESCount(Integer.parseInt(id), 1);
		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
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
		// ��������
		for (int i = 0; i < comments2.size(); i++) {
			List<Comment> comments3 = new ArrayList<Comment>();
			comments3.add(comments2.get(i));
			for (int j = 0; j < comments.size(); j++) {// ͨ��ѭ���ҳ�һ�����۵ĶԻ�
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
		// ���ȵ������б�
		List<Forum> newforumList = forumService.FindForumByPub_Date();
		for (int i = 0; i < newforumList.size(); i++) {// ѭ��ת��ʱ��
			newforumList.get(i).setPub_date(
					newforumList.get(i).getPub_date().substring(0, 19));
		}
		request.setAttribute("newforumList", newforumList);
		// ��ȡ��һƪ���Ӻ���һƪ����
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

		// ��ȡ���������û�����Ϣ
		Student s = new Student();
		s.setAccount(forum.getPub_account());
		Student student = studentService.FindStudentByAccount(s);
		request.setAttribute("pub_user", student);

		return "f:/User/Jsp/commentInfo.jsp";
	}

	public String forowdVideo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		String id = request.getParameter("id");
		// ��ѯ������Ϣ
		List<CommentInfo> listCommentInfo = new ArrayList<CommentInfo>();
		//
		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
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

		Resource resourceList = new Resource();// һ����Ȥ��������Ƶ��Դ
		resourceList = resourceService.findResourceById(Integer.parseInt(id));
		request.setAttribute("resourceList", resourceList);
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		request.setAttribute("page", page);
		request.setAttribute("resId", id);
		request.setAttribute("servlet", "IndexDoorServlet");
		request.setAttribute("method", "forowdVideo");
		request.setAttribute("other", "&id=" + id);
		System.out.println("-------����Ӧ����");
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

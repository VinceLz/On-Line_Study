package com.xawl.study.servlet;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.Category;
import com.xawl.study.model.Comment;
import com.xawl.study.model.CommentInfo;
import com.xawl.study.model.IndexModel;
import com.xawl.study.model.Interest;
import com.xawl.study.model.MenuModel;
import com.xawl.study.model.Page;
import com.xawl.study.model.Res_Support;
import com.xawl.study.model.Resource;
import com.xawl.study.model.Student;
import com.xawl.study.model.Teach_Class;
import com.xawl.study.service.CategoryService;
import com.xawl.study.service.CommentService;
import com.xawl.study.service.IndexModelService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.MenuService;
import com.xawl.study.service.Res_SupportService;
import com.xawl.study.service.ResourceService;

import com.xawl.study.service.StudentService;
import com.xawl.study.util.ImageUtil;

import com.xawl.study.util.PageUtil;

//import sun.misc.BASE64Encoder;
import sun.misc.BASE64Encoder;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

public class ResourceServlet extends BaseServlets {
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private IndexModelService indexModelService;
	@Autowired
	private InterestService interestService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	ServletUtil servletUtil;
	@Autowired
	CommentService commentService;
	@Autowired
	StudentService studentService;
	@Autowired
	Res_SupportService res_SupportService;

	// 文件上传
	public String FileUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 添加真实文件
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(
				1024 * 1024 * 1024, new File("C:/f/temp"));
		// 解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// sfu.setFileSizeMax(100 * 1024);// 限制单个文件大小为100K
		// sfu.setSizeMax(1024 * 1024);// 限制整个表单大小为1M

		// 解析，得到List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);

			// 1. 得到文件保存的路径
			String root = this.getServletContext().getRealPath("/files/");

			// 2. 生成二层目录 1). 得到文件名称 2). 得到hashCode 3). 转发成16进制 4). 获取前二个字符用来生成目录
			String filename = fi.getName();// 获取上传的文件名称

			// 处理文件名的绝对路径问题
			int index = filename.lastIndexOf("\\");
			if (index != -1) {
				filename = filename.substring(index + 1);
			}

			// 给文件名称添加uuid前缀，处理文件同名问题
			String savename = CommonUtils.uuid() + "_" + filename;

			// 1. 得到hashCode
			int hCode = filename.hashCode();
			String hex = Integer.toHexString(hCode);

			// 2. 获取hex的前两个字母，与root连接在一起，生成一个完整的路径
			File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));

			// 3. 创建目录链
			dirFile.mkdirs();

			// 4. 创建目录文件
			File destFile = new File(dirFile, savename);

			// 5. 保存
			fi.write(destFile);
			Resource resource = new Resource();
			resource.setResourceName(filename);
			resource.setBeLongToDegreeID(1);
			resource.setBeLongToInterestID(1);
			resource.setCategory(2);
			resource.setClassNameID(2);
			resource.setUploadeDate(new Date());
			resource.setResume("摘要");
			resource.setScore(1);
			resource.setSrc(root + "\\" + hex.charAt(0) + "\\" + hex.charAt(1)
					+ "\\" + savename);
			// 在数据库中添加资源信息
			String result = resourceService.addResource(resource);

			request.setAttribute("msg", "文件" + filename + result);

		} catch (FileUploadException e) {
			if (e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "您上传的文件超出了100KB！");
				request.getRequestDispatcher("/msg.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "f:/Test/msg.jsp";
	}

	// 查找所有资源文件
	public String findResourceAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Resource> resourceList = resourceService.findAllResourceNotPage();
		if (null == resourceList) {
			request.setAttribute("msg", "未查到相关文件！");
		}
		request.setAttribute("msg", "查询到的文件为：");
		request.setAttribute("resourceList", resourceList);
		return "f:/Test/list.jsp";
	}

	// 删除数据库中资源信息
	public String deleteResourceById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("sid"));
		Resource resource = new Resource();
		resource = resourceService.findResourceById(id);
		if (resource == null) {
			request.setAttribute("msg", "您要删除的文件不存在！");
			return "f:/Test/msg.jsp";
		}
		String path = resource.getSrc();
		File resFile = new File(path);
		resFile.delete();// 删除真实文件
		String result = resourceService.deleteResource(id);// 删除数据库中的信息

		request.setAttribute("msg", result);
		return "f:/Test/msg.jsp";
	}

	// --------------------删除真实文件（备用）---------------------
	// 删除文件夹
	public static void delFolder(String folderPath) {
		try {
			deleteAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除指定文件夹下的所有文件
	public static boolean deleteAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				deleteAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	// ---------------------------------------------------------

	// 文件下载
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("sid"));
		Resource resource = resourceService.findResourceById(id);
		/*
		 * 两个头一个流 1. Content-Type 2. Content-Disposition 3. 流：下载文件的数据
		 */
		String resouceSrc = resource.getSrc();
		String fileName = resource.getResourceName();
		// 为了使下载框中显示中文文件名称不出乱码！
		String framename = filenameEncoding(fileName, request);

		String contentType = this.getServletContext().getMimeType(fileName);// 通过文件名称获取MIME类型
		String contentDisposition = "attachment;filename=" + framename;
		// 一个流

		// 文件的后缀

		String newChar = resource.getResourceName().substring(
				resource.getResourceName().lastIndexOf(".") + 1,
				resource.getResourceName().length());
		FileInputStream input = null;

		input = new FileInputStream(request.getRealPath(resouceSrc));

		// 设置头
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);

		// 获取绑定了响应端的流
		ServletOutputStream output = response.getOutputStream();

		IOUtils.copy(input, output);// 把输入流中的数据写入到输出流中。

		input.close();
		output.close();

	}

	// 用来对下载的文件名称进行编码的！
	public static String filenameEncoding(String filename,
			HttpServletRequest request) throws IOException {
		String agent = request.getHeader("User-Agent"); // 获取浏览器
		if (agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else if (agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}

	// 跳转到资源列表页
	@SuppressWarnings("deprecation")
	public String showAllResource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消数量放入到用户request中
		// ---获取启用的菜单---
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		// // ---获取启用的首页方案---
		// ImageUtil util = new ImageUtil();
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();

		// String LogoSrc = indexModel.getLogoImageSrc();
		// String newLogoSrc = LogoSrc;
		// indexModel.setLogoImageSrc(newLogoSrc);
		//
		// request.setAttribute("indexModel", indexModel);

		// ---获取兴趣方向---
		List<Interest> interestList = interestService.findAllInterest();
		request.setAttribute("interestList", interestList);

		// ---获取详细分类---

		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("categoryList", categoryList);

		/*
		 * Map<String,String> allDetailMap = new HashMap<String, String>(); for
		 * (Interest interest : interestList) { String detail =
		 * interest.getAttribute(); List<String> preList = new
		 * ArrayList<String>(); preList =
		 * Arrays.asList(detail.split(";"));//{[name,url][name,url]} for (String
		 * str : preList) { String[] strArray = str.split(",");//[name,url]
		 * allDetailMap.put(strArray[0], strArray[1]); } }
		 * request.setAttribute("allDetailMap", allDetailMap);
		 */

		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}
		Page page = PageUtil.createPage(12,
				resourceService.findAllResourceCount(),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil
					.createPage(12, resourceService.findAllResourceCount(),
							page.getTotalPage());
		}
		// ---获取资源---

		// 判断当前用户是否登陆了
		Student attribute = (Student) request.getSession().getAttribute("user");
		String sql = "0";
		if (attribute != null) {
			// 获取当前学生的所有老师id
			int classId = attribute.getClassId().getClassId();
			List<Teach_Class> findByClassid = studentService
					.findByClassid(classId + "");
			for (Teach_Class t : findByClassid) {
				sql = sql + "," + t.getAid();
			}
		}

		List<Resource> resourceList = resourceService
				.findAllResource(page, sql);
		for (int i = 0; i < resourceList.size(); i++) {// 限制长度

			/*
			 * try { SimpleDateFormat sf=new
			 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); SimpleDateFormat sdf =
			 * new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String dateString =
			 * sdf.format(resourceList.get(i).getUploadeDate());
			 * System.out.println(dateString); Date date=sf.parse(dateString);
			 * 
			 * System.out.println(date);
			 * resourceList.get(i).setUploadeDate(date); } catch (ParseException
			 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
			 */

			resourceList
					.get(i)
					.setResourceName(
							resourceList.get(i).getResourceName().length() > 11 ? resourceList
									.get(i).getResourceName().substring(0, 11)
									+ "...."
									: resourceList.get(i).getResourceName());
			resourceList
					.get(i)
					.setResume(
							resourceList.get(i).getResume().length() > 20 ? resourceList
									.get(i).getResume().substring(0, 20)
									+ "...."
									: resourceList.get(i).getResume());
			// resourceList.get(i).setUploadeDate(new
			// Date(resourceList.get(i).getUploadeDate().toLocaleString()) );
		}
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("page", page);
		request.setAttribute("servlet", "ResourceServlet");
		request.setAttribute("method", "showAllResource");
		return "f:/User/Jsp/kindReal.jsp";
	}

	@SuppressWarnings("deprecation")
	public String showAllDocument(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消数量放入到用户request中
		// ---获取启用的菜单---
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		// // ---获取启用的首页方案---
		// ImageUtil util = new ImageUtil();
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		//
		// String LogoSrc = indexModel.getLogoImageSrc();
		// String newLogoSrc = LogoSrc;
		// indexModel.setLogoImageSrc(newLogoSrc);
		//
		// request.setAttribute("indexModel", indexModel);

		// ---获取兴趣方向---
		List<Interest> interestList = interestService.findAllInterest();
		request.setAttribute("interestList", interestList);

		// ---获取详细分类---

		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("categoryList", categoryList);

		/*
		 * Map<String,String> allDetailMap = new HashMap<String, String>(); for
		 * (Interest interest : interestList) { String detail =
		 * interest.getAttribute(); List<String> preList = new
		 * ArrayList<String>(); preList =
		 * Arrays.asList(detail.split(";"));//{[name,url][name,url]} for (String
		 * str : preList) { String[] strArray = str.split(",");//[name,url]
		 * allDetailMap.put(strArray[0], strArray[1]); } }
		 * request.setAttribute("allDetailMap", allDetailMap);
		 */

		String current = request.getParameter("current");
		if (current == null) {// 首次进入的时候会初始化为第一页
			current = "1";
		}
		Page page = PageUtil.createPage(20,
				resourceService.findAllDocumentResourceCount(),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(20,
					resourceService.findAllDocumentResourceCount(),
					page.getTotalPage());
		}
		// 判断当前用户是否登陆了
		Student attribute = (Student) request.getSession().getAttribute("user");
		String sql = "0";
		if (attribute != null) {
			// 获取当前学生的所有老师id
			int classId = attribute.getClassId().getClassId();
			List<Teach_Class> findByClassid = studentService
					.findByClassid(classId + "");
			for (Teach_Class t : findByClassid) {
				sql = sql + "," + t.getAid();
			}
		}
		// ---获取资源---
		List<Resource> resourceList = resourceService.findAllDocumentResource(
				page, sql);
		for (int i = 0; i < resourceList.size(); i++) {// 限制长度
			String newChar = resourceList
					.get(i)
					.getResourceName()
					.substring(
							resourceList.get(i).getResourceName()
									.lastIndexOf(".") + 1,
							resourceList.get(i).getResourceName().length());
			resourceList.get(i).setDownload_src(
					resourceList.get(i).getSrc().replace("html", newChar));
			// 控制文档名称长度
			resourceList
					.get(i)
					.setResourceName(
							resourceList.get(i).getResourceName().length() > 110 ? resourceList
									.get(i).getResourceName().substring(0, 11)
									+ "...."
									: resourceList.get(i).getResourceName());
			resourceList
					.get(i)
					.setResume(
							resourceList.get(i).getResume().length() > 20 ? resourceList
									.get(i).getResume().substring(0, 20)
									+ "...."
									: resourceList.get(i).getResume());
			// resourceList.get(i).setUploadeDate(new
			// Date(resourceList.get(i).getUploadeDate().toLocaleString()) );
		}
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("page", page);
		request.setAttribute("servlet", "ResourceServlet");
		request.setAttribute("method", "showAllDocument");
		return "f:/User/Jsp/documentList.jsp";
	}

	public String forowdDocumentInfo(HttpServletRequest request,// 转发到文档显示的页面
			HttpServletResponse response) throws ServletException, IOException {

		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中

		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		// 帖子信息
		String id = request.getParameter("id");
		Resource resource = resourceService.findResourceById(Integer
				.parseInt(id));

		String end = resource.getSrc().substring(
				resource.getSrc().lastIndexOf(".") + 1);
		if ("doc".equals(end) || "docx".equals(end) || "xls".equals(end)) {
			resource.setSrc(resource.getSrc().replace(end, "html"));
		}
		request.setAttribute("resource", resource);
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

		return "f:/User/Jsp/documentInfo.jsp";
	}

	public String SerchResource(HttpServletRequest request,// 转发到文档显示的页面
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// 将未读的消息数量放入到用户request中
		// 首页方案
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// 菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		// 帖子信息
		String id = request.getParameter("id");
		Resource resource = resourceService.findResourceById(Integer
				.parseInt(id));

		request.setAttribute("resource", resource);
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

		return "f:/User/Jsp/documentInfo.jsp";
	}

	@SuppressWarnings("deprecation")
	public String AddSupport(HttpServletRequest request,// 转发到文档显示的页面
			HttpServletResponse response) throws ServletException, IOException {
		// ajax 方法
		Student studentt = new Student();
		try {
			studentt = (Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if (studentt == null) {
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		String id = request.getParameter("id");
		Res_Support res_Support = new Res_Support();
		res_Support.setSupport_res(Integer.parseInt(id));
		res_Support.setSupport_date(new Date().toLocaleString());
		res_Support.setSupport_account(((Student) request.getSession()
				.getAttribute("user")).getAccount());
		res_SupportService.addRes_Support(res_Support);
		return null;
	}
}

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

	// �ļ��ϴ�
	public String FileUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// �����ʵ�ļ�
		// ����
		DiskFileItemFactory factory = new DiskFileItemFactory(
				1024 * 1024 * 1024, new File("C:/f/temp"));
		// ������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// sfu.setFileSizeMax(100 * 1024);// ���Ƶ����ļ���СΪ100K
		// sfu.setSizeMax(1024 * 1024);// ������������СΪ1M

		// �������õ�List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);

			// 1. �õ��ļ������·��
			String root = this.getServletContext().getRealPath("/files/");

			// 2. ���ɶ���Ŀ¼ 1). �õ��ļ����� 2). �õ�hashCode 3). ת����16���� 4). ��ȡǰ�����ַ���������Ŀ¼
			String filename = fi.getName();// ��ȡ�ϴ����ļ�����

			// �����ļ����ľ���·������
			int index = filename.lastIndexOf("\\");
			if (index != -1) {
				filename = filename.substring(index + 1);
			}

			// ���ļ��������uuidǰ׺�������ļ�ͬ������
			String savename = CommonUtils.uuid() + "_" + filename;

			// 1. �õ�hashCode
			int hCode = filename.hashCode();
			String hex = Integer.toHexString(hCode);

			// 2. ��ȡhex��ǰ������ĸ����root������һ������һ��������·��
			File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));

			// 3. ����Ŀ¼��
			dirFile.mkdirs();

			// 4. ����Ŀ¼�ļ�
			File destFile = new File(dirFile, savename);

			// 5. ����
			fi.write(destFile);
			Resource resource = new Resource();
			resource.setResourceName(filename);
			resource.setBeLongToDegreeID(1);
			resource.setBeLongToInterestID(1);
			resource.setCategory(2);
			resource.setClassNameID(2);
			resource.setUploadeDate(new Date());
			resource.setResume("ժҪ");
			resource.setScore(1);
			resource.setSrc(root + "\\" + hex.charAt(0) + "\\" + hex.charAt(1)
					+ "\\" + savename);
			// �����ݿ��������Դ��Ϣ
			String result = resourceService.addResource(resource);

			request.setAttribute("msg", "�ļ�" + filename + result);

		} catch (FileUploadException e) {
			if (e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "���ϴ����ļ�������100KB��");
				request.getRequestDispatcher("/msg.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "f:/Test/msg.jsp";
	}

	// ����������Դ�ļ�
	public String findResourceAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Resource> resourceList = resourceService.findAllResourceNotPage();
		if (null == resourceList) {
			request.setAttribute("msg", "δ�鵽����ļ���");
		}
		request.setAttribute("msg", "��ѯ�����ļ�Ϊ��");
		request.setAttribute("resourceList", resourceList);
		return "f:/Test/list.jsp";
	}

	// ɾ�����ݿ�����Դ��Ϣ
	public String deleteResourceById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("sid"));
		Resource resource = new Resource();
		resource = resourceService.findResourceById(id);
		if (resource == null) {
			request.setAttribute("msg", "��Ҫɾ�����ļ������ڣ�");
			return "f:/Test/msg.jsp";
		}
		String path = resource.getSrc();
		File resFile = new File(path);
		resFile.delete();// ɾ����ʵ�ļ�
		String result = resourceService.deleteResource(id);// ɾ�����ݿ��е���Ϣ

		request.setAttribute("msg", result);
		return "f:/Test/msg.jsp";
	}

	// --------------------ɾ����ʵ�ļ������ã�---------------------
	// ɾ���ļ���
	public static void delFolder(String folderPath) {
		try {
			deleteAllFile(folderPath); // ɾ����������������
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // ɾ�����ļ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ɾ��ָ���ļ����µ������ļ�
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
				deleteAllFile(path + "/" + tempList[i]);// ��ɾ���ļ���������ļ�
				delFolder(path + "/" + tempList[i]);// ��ɾ�����ļ���
				flag = true;
			}
		}
		return flag;
	}

	// ---------------------------------------------------------

	// �ļ�����
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("sid"));
		Resource resource = resourceService.findResourceById(id);
		/*
		 * ����ͷһ���� 1. Content-Type 2. Content-Disposition 3. ���������ļ�������
		 */
		String resouceSrc = resource.getSrc();
		String fileName = resource.getResourceName();
		// Ϊ��ʹ���ؿ�����ʾ�����ļ����Ʋ������룡
		String framename = filenameEncoding(fileName, request);

		String contentType = this.getServletContext().getMimeType(fileName);// ͨ���ļ����ƻ�ȡMIME����
		String contentDisposition = "attachment;filename=" + framename;
		// һ����

		// �ļ��ĺ�׺

		String newChar = resource.getResourceName().substring(
				resource.getResourceName().lastIndexOf(".") + 1,
				resource.getResourceName().length());
		FileInputStream input = null;

		input = new FileInputStream(request.getRealPath(resouceSrc));

		// ����ͷ
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);

		// ��ȡ������Ӧ�˵���
		ServletOutputStream output = response.getOutputStream();

		IOUtils.copy(input, output);// ���������е�����д�뵽������С�

		input.close();
		output.close();

	}

	// ���������ص��ļ����ƽ��б���ģ�
	public static String filenameEncoding(String filename,
			HttpServletRequest request) throws IOException {
		String agent = request.getHeader("User-Agent"); // ��ȡ�����
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

	// ��ת����Դ�б�ҳ
	@SuppressWarnings("deprecation")
	public String showAllResource(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ�������������뵽�û�request��
		// ---��ȡ���õĲ˵�---
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		// // ---��ȡ���õ���ҳ����---
		// ImageUtil util = new ImageUtil();
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();

		// String LogoSrc = indexModel.getLogoImageSrc();
		// String newLogoSrc = LogoSrc;
		// indexModel.setLogoImageSrc(newLogoSrc);
		//
		// request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();
		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---

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
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
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
		// ---��ȡ��Դ---

		// �жϵ�ǰ�û��Ƿ��½��
		Student attribute = (Student) request.getSession().getAttribute("user");
		String sql = "0";
		if (attribute != null) {
			// ��ȡ��ǰѧ����������ʦid
			int classId = attribute.getClassId().getClassId();
			List<Teach_Class> findByClassid = studentService
					.findByClassid(classId + "");
			for (Teach_Class t : findByClassid) {
				sql = sql + "," + t.getAid();
			}
		}

		List<Resource> resourceList = resourceService
				.findAllResource(page, sql);
		for (int i = 0; i < resourceList.size(); i++) {// ���Ƴ���

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
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ�������������뵽�û�request��
		// ---��ȡ���õĲ˵�---
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		// // ---��ȡ���õ���ҳ����---
		// ImageUtil util = new ImageUtil();
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		//
		// String LogoSrc = indexModel.getLogoImageSrc();
		// String newLogoSrc = LogoSrc;
		// indexModel.setLogoImageSrc(newLogoSrc);
		//
		// request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();
		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---

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
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
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
		// �жϵ�ǰ�û��Ƿ��½��
		Student attribute = (Student) request.getSession().getAttribute("user");
		String sql = "0";
		if (attribute != null) {
			// ��ȡ��ǰѧ����������ʦid
			int classId = attribute.getClassId().getClassId();
			List<Teach_Class> findByClassid = studentService
					.findByClassid(classId + "");
			for (Teach_Class t : findByClassid) {
				sql = sql + "," + t.getAid();
			}
		}
		// ---��ȡ��Դ---
		List<Resource> resourceList = resourceService.findAllDocumentResource(
				page, sql);
		for (int i = 0; i < resourceList.size(); i++) {// ���Ƴ���
			String newChar = resourceList
					.get(i)
					.getResourceName()
					.substring(
							resourceList.get(i).getResourceName()
									.lastIndexOf(".") + 1,
							resourceList.get(i).getResourceName().length());
			resourceList.get(i).setDownload_src(
					resourceList.get(i).getSrc().replace("html", newChar));
			// �����ĵ����Ƴ���
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

	public String forowdDocumentInfo(HttpServletRequest request,// ת�����ĵ���ʾ��ҳ��
			HttpServletResponse response) throws ServletException, IOException {

		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��

		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		// ������Ϣ
		String id = request.getParameter("id");
		Resource resource = resourceService.findResourceById(Integer
				.parseInt(id));

		String end = resource.getSrc().substring(
				resource.getSrc().lastIndexOf(".") + 1);
		if ("doc".equals(end) || "docx".equals(end) || "xls".equals(end)) {
			resource.setSrc(resource.getSrc().replace(end, "html"));
		}
		request.setAttribute("resource", resource);
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

		return "f:/User/Jsp/documentInfo.jsp";
	}

	public String SerchResource(HttpServletRequest request,// ת�����ĵ���ʾ��ҳ��
			HttpServletResponse response) throws ServletException, IOException {
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		// ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		// ������Ϣ
		String id = request.getParameter("id");
		Resource resource = resourceService.findResourceById(Integer
				.parseInt(id));

		request.setAttribute("resource", resource);
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

		return "f:/User/Jsp/documentInfo.jsp";
	}

	@SuppressWarnings("deprecation")
	public String AddSupport(HttpServletRequest request,// ת�����ĵ���ʾ��ҳ��
			HttpServletResponse response) throws ServletException, IOException {
		// ajax ����
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

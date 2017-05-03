package com.xawl.study.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.commons.CommonUtils;

import com.xawl.study.model.Administrator;
import com.xawl.study.model.Category;
import com.xawl.study.model.Interest;
import com.xawl.study.model.Page;
import com.xawl.study.model.Resource;
import com.xawl.study.service.CategoryService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.ResourceService;
import com.xawl.study.util.ImageUtil;
import com.xawl.study.util.PageUtil;
import com.xawl.study.util.word2html;

public class AdminResourceServlet extends BaseServlets {
	@Autowired
	ResourceService resourceService;
	@Autowired
	InterestService interestService;
	@Autowired
	CategoryService categoryService;

	// ��ʾ���е���Դ
	public String showAllResource(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String count = request.getParameter("count");// ÿҳ��ʾ����������
		String pagecount = request.getParameter("page");// �ڼ�ҳ
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));

		Administrator admin = (Administrator) request.getSession()
				.getAttribute("admin_teacher");
		List<Resource> resourceList = null;
		int resourceCount = 0;
		if (admin.getRank() == 0) {
			// ����Աȫ����ʾ
			resourceList = resourceService.queryByPage(page);
			resourceCount = resourceService.CountResource();
		} else {
			resourceList = resourceService.queryByPage(page, admin.getId());
			resourceCount = resourceService.CountResource(admin.getId());
		}

		int num = Integer.parseInt((String) request.getSession().getAttribute(
				"count"));// ÿҳ��ʾ����������
		if ((resourceCount % num) == 0) {
			request.getSession().setAttribute("weiye", resourceCount / num);
		} else {
			request.getSession().setAttribute("weiye",
					(resourceCount / num) + 1);
		}
		request.getSession().setAttribute("weiye", resourceCount / num);
		if ((Integer.parseInt(pagecount) <= resourceCount / num)
				&& (Integer.parseInt(pagecount) > 0)) {
			request.getSession().setAttribute("page", pagecount);
		}

		request.setAttribute("resourceList", resourceList);
		return "f:/Admin/showAllResource.jsp";
	}

	// ����ÿҳ��ʾ����Դ����
	public String changePage(HttpServletRequest request,
			HttpServletResponse response)// �ӹ���Ա�б��е���޸ĵ�ʱ����ã�������ת���޸�����ҳ��
			throws IOException {
		String count = request.getParameter("count");
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("page", "1");
		return "f:/AdminResourceServlet?method=showAllResource&count="
				+ request.getSession().getAttribute("count") + "&page="
				+ request.getSession().getAttribute("page");
	}

	// ��ʾ������Դ��Ϣ
	public String showResourceDetailById(HttpServletRequest request,
			HttpServletResponse response)// �ӹ���Ա�б��е���޸ĵ�ʱ����ã�������ת���޸�����ҳ��
			throws IOException {

		Integer resourceId = 0;
		if (request.getParameter("rId") != null) {
			resourceId = Integer.parseInt(request.getParameter("rId"));
		} else {
			resourceId = (Integer) request.getAttribute("rId");
		}
		Resource resource = resourceService.findResourceById(resourceId);

		List<Interest> interestList = interestService.findAllInterest();
		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("interestList", interestList);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("resource", resource);

		return "f:/Admin/showResourceDetail.jsp";
	}

	// �޸���Դ��Ϣ
	public String updataResource(HttpServletRequest request,
			HttpServletResponse response)// �ӹ���Ա�б��е���޸ĵ�ʱ����ã�������ת���޸�����ҳ��
			throws IOException {
		Resource resource = new Resource();
		int rId = Integer.parseInt(request.getParameter("resourceId"));
		resource.setId(rId);
		resource.setBeLongToDegreeID(Integer.parseInt(request
				.getParameter("beLongToDegreeID")));
		resource.setBeLongToInterestID(Integer.parseInt(request
				.getParameter("beLongToInterestID")));
		resource.setCategory(Integer.parseInt(request.getParameter("category")));
		resource.setClassNameID(Integer.parseInt(request
				.getParameter("classNameID")));
		resource.setFrontClassName(request.getParameter("frontClassName"));
		resource.setLikeSum(Integer.parseInt(request.getParameter("likeSum")));
		resource.setLinkSrc(request.getParameter("linkSrc"));
		resource.setResourceName(request.getParameter("resourceName"));
		resource.setResourceType(Integer.parseInt(request
				.getParameter("resourceType")));
		int partype = Integer.valueOf(request.getParameter("type"));
		resource.setType(partype);
		resource.setResume(request.getParameter("resume"));
		resource.setScore(Integer.parseInt(request.getParameter("score")));
		resource.setShowImageSrc(request.getParameter("showImageSrc"));
		resource.setSrc(request.getParameter("src"));

		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data = request.getParameter("uploadeDate");
		Date date;
		try {
			date = fmt.parse(data);
			resource.setUploadeDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = resourceService.updataResourceById(rId, resource);
		request.setAttribute("result", result);
		return "f:/Admin/result.jsp";
	}

	// ��ת���ϴ���Դҳ��
	public String showUploadResource(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		if (request.getParameter("resourceId") != null) {
			int resourceId = Integer.parseInt(request
					.getParameter("resourceId"));
			String resourceSrc = new String(request.getParameter("resourceSrc")
					.getBytes("ISO8859-1"), "UTF-8");
			request.setAttribute("resourceId", resourceId);
			request.setAttribute("resourceSrc", resourceSrc);
		}
		return "f:/Admin/showUploadResource.jsp";
	}

	// �ϴ���Դ
	public String uploadResource(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// �����ʵ�ļ�
		// ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ������
		ServletFileUpload sfu = new ServletFileUpload(factory);

		String flag = "update";
		// �������õ�List
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem fi = fileItemList.get(2);

			// 1. �õ��ļ������·��
			String root = this.getServletContext().getRealPath(
					"/resourceFiles/");

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

			// �����ݿ����޸���Ϣ
			if (fileItemList.get(0).getSize() != 0) {// ������Դ
				ImageUtil imageUtil = new ImageUtil();
				int resourceId = Integer.parseInt(fileItemList.get(0)
						.getString());
				String relativePath = imageUtil
						.getImageSrc(root, hex, savename);
				String src = new String(fileItemList.get(1).getString()
						.getBytes("ISO8859-1"), "UTF-8");

				String result = resourceService.updateSrc(resourceId,
						relativePath);

				// ��ȡ��Դ·��

				String realPath = imageUtil.getRealPath(root, src);
				File resFile = new File(realPath);
				resFile.delete();// ɾ����ʵ�ļ�

				request.setAttribute("resourceUploadResult", result);
				request.setAttribute("rId", resourceId);
			} else {
				// ����Դ
				flag = "new";
				ImageUtil imageUtil = new ImageUtil();
				String relativePath = imageUtil
						.getImageSrc(root, hex, savename);
				request.getSession().setAttribute("resourceSrc", relativePath);
				request.getSession().setAttribute("resourceName", filename);
				DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				request.getSession().setAttribute("resourceTime",
						fmt.format(date));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (flag == "update") {
			return this.showResourceDetailById(request, response);
		} else {
			return this.showAddResource(request, response);
		}
	}

	// ��ת���ϴ���Դ����ͼ
	public String showUploadShowImageSrc(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (request.getParameter("resourceId") != null) {
			int resourceId = Integer.parseInt(request
					.getParameter("resourceId"));
			String resourceShowImageSrc = new String(request.getParameter(
					"resourceShowImageSrc").getBytes("ISO8859-1"), "UTF-8");
			request.setAttribute("resourceId", resourceId);
			request.setAttribute("resourceShowImageSrc", resourceShowImageSrc);
		}
		return "f:/Admin/showUploadShowImageSrc.jsp";
	}

	// �ϴ���Դ����ͼ
	public String uploadShowImageSrc(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory(20 * 1024 * 1024,
				new File("C:/f/temp"));

		ServletFileUpload sfu = new ServletFileUpload(factory);
		String flag = "update";
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem fi = fileItemList.get(2);
			String root = this.getServletContext().getRealPath(
					"/resourceShowImgFiles/");
			String filename = fi.getName();// ��ȡ�ϴ����ļ�����
			int index = filename.lastIndexOf("\\");
			if (index != -1) {
				filename = filename.substring(index + 1);
			}
			String savename = CommonUtils.uuid().substring(4, 10) + "_"
					+ filename;
			int hCode = filename.hashCode();
			String hex = Integer.toHexString(hCode);
			File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));
			dirFile.mkdirs();
			File destFile = new File(dirFile, savename);
			fi.write(destFile);

			if (fileItemList.get(0).getSize() != 0) {
				ImageUtil imageUtil = new ImageUtil();
				int resourceId = Integer.parseInt(fileItemList.get(0)
						.getString());
				String relativePath = imageUtil
						.getImageSrc(root, hex, savename);
				String src = new String(fileItemList.get(1).getString()
						.getBytes("ISO8859-1"), "UTF-8");

				String result = resourceService.updateShowImageSrc(resourceId,
						request.getContextPath() + "/" + relativePath);

				// ��ȡ��Դ·��

				String realPath = imageUtil.getRealPath(root, src);
				File resFile = new File(realPath);
				resFile.delete();// ɾ����ʵ�ļ�

				request.setAttribute("showImageUploadResult", result);
				request.setAttribute("rId", resourceId);
			} else {
				flag = "new";
				ImageUtil imageUtil = new ImageUtil();
				String relativePath = imageUtil
						.getImageSrc(root, hex, savename);

				request.getSession().setAttribute("showImageSrc",
						request.getContextPath() + "/" + relativePath);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag != "new") {
			return this.showResourceDetailById(request, response);
		} else {
			return this.showAddResource(request, response);
		}
	}

	// ��ת�������Դҳ��
	public String showAddResource(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		List<Interest> interestList = interestService.findAllInterest();
		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("interestList", interestList);
		request.setAttribute("categoryList", categoryList);
		return "/Admin/addResource.jsp";
	}

	// �����Դ
	public String addResource(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Resource resource = new Resource();

		String resourceName = request.getParameter("resourceName");// �ļ���
		String src = request.getParameter("src");// resourceFiles/c/3/2877A5D4F1DE4703956CAA3DD5161570_֧���ӿ�.docx
		int category = Integer.parseInt(request.getParameter("category"));
		int beLongToInterestID = Integer.parseInt(request
				.getParameter("beLongToInterestID"));
		int beLongToDegreeID = Integer.parseInt(request
				.getParameter("beLongToDegreeID"));
		String resume = request.getParameter("resume");
		int classNameID = Integer.parseInt(request.getParameter("classNameID"));
		String showImageSrc = request.getParameter("showImageSrc");
		int resourceType = Integer.parseInt(request
				.getParameter("resourceType"));
		String linkSrc = request.getParameter("linkSrc");
		String frontClassName = request.getParameter("frontClassName");
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data = request.getParameter("uploadeDate");
		int partype = Integer.valueOf(request.getParameter("type"));
		resource.setType(partype);
		Date date;
		try {
			date = fmt.parse(data);
			resource.setUploadeDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resource.setBeLongToDegreeID(beLongToDegreeID);
		resource.setBeLongToInterestID(beLongToInterestID);
		resource.setCategory(category);
		resource.setClassNameID(classNameID);
		resource.setFrontClassName(frontClassName);
		resource.setLikeSum(1);
		resource.setLinkSrc(linkSrc);
		resource.setResourceName(resourceName);
		resource.setResourceType(resourceType);
		resource.setResume(resume);
		resource.setScore(1);
		resource.setShowImageSrc(showImageSrc);
		resource.setSrc(src);

		if (resourceType == 1) {// ������ĵ��������²���

			int indexOf = resource.getSrc().indexOf(".");
			String end = resource.getSrc().substring(indexOf + 1);// docx
			switch (end) {
			case "pdf":// pdf Ĭ���ǲ���Ҫת����
				resource.setOk_read(1);
				resource.setSrc("/" + resource.getSrc());
				break;
			case "doc":
			case "xls":
			case "docx":
				String realSrc = request.getRealPath(resource.getSrc());// E:\apache-tomcat-7.0.62\webapps\On-Line_Study\resourceFiles\c\3\2877A5D4F1DE4703956CAA3DD5161570_֧���ӿ�.docx
				int i = realSrc.lastIndexOf(".");
				String rsrc = realSrc.substring(0, i);// E:\apache-tomcat-7.0.62\webapps\On-Line_Study\resourceFiles\c\3\2877A5D4F1DE4703956CAA3DD5161570_֧���ӿ�
				String laseSrc = rsrc + ".html";
				// ת��resource�е����ӵ�ַ��ת��Ϊhtml����ǰ̨ҳ����ʾ�����ڴ洢���ݿ�
				String realSrc1 = resource.getSrc();
				int i1 = realSrc1.lastIndexOf(".");
				String rsrc1 = realSrc1.substring(0, i1);
				String laseSrc1 = rsrc1 + ".html";
				word2html.tran(realSrc, laseSrc, request.getRealPath("/"));// ת������
				// resource.setSrc("/" + laseSrc1);// �滻ԭ�е�����
				resource.setSrc("/" + resource.getSrc());
				resource.setOk_read(1);
				break;
			default:
				resource.setOk_read(0);
				break;
			// ������ʽ��ʱ��֧�����߹ۿ�
			}
		}
		String result = resourceService.addResource(resource);
		request.setAttribute("result", result);

		request.getSession().removeAttribute("resourceSrc");
		request.getSession().removeAttribute("resourceName");
		request.getSession().removeAttribute("resourceTime");

		return "/Admin/result.jsp";
	}

	// ɾ����Դ
	public String deleteResourceById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int resourceId = Integer.parseInt(request.getParameter("rId"));

		// ɾ���ļ�
		Resource resource = resourceService.findResourceById(resourceId);

		String src = resource.getSrc();
		String showImageSrc = resource.getShowImageSrc();

		String resourceFileRoot = this.getServletContext().getRealPath(
				"/resourceFiles/");
		String showImageFileRoot = this.getServletContext().getRealPath(
				"/resourceShowImgFiles/");

		ImageUtil imageUtil = new ImageUtil();
		String resourceFileRealPath = imageUtil.getRealPath(resourceFileRoot,
				src);
		String showImageFileRealPath = imageUtil.getRealPath(showImageFileRoot,
				showImageSrc);

		// �ȸ�����Դ�ĺ�׺,�����.doc docx xls �����ֻ���Ҫɾ��html&imgage
		// pdf &��������ֱ��ɾ��
		String end = src.substring(src.lastIndexOf(".") + 1).toLowerCase();
		if ("doc".toLowerCase().equals(end) || "docx".toLowerCase().equals(end)
				|| "xls".toLowerCase().equals(end)) {
			// ��Ҫɾ��html&image
			// TODO ��ʱ��ֻҪ�����ļ�����������ɵģ�����image����ɾ��
			String real = src.replace(end, "html");
			String path = imageUtil.getRealPath(resourceFileRoot, real);
			File realFile = new File(path);
			realFile.delete();
		}

		File resourceFile = new File(resourceFileRealPath);
		File showImageFile = new File(showImageFileRealPath);
		resourceFile.delete();
		showImageFile.delete();

		String result = resourceService.deleteResource(resourceId);
		request.setAttribute("result", result);

		return "/Admin/result.jsp";
	}
}

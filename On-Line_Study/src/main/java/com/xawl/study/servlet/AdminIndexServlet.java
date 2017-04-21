package com.xawl.study.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.xawl.study.model.IndexModel;
import com.xawl.study.service.IndexModelService;
import com.xawl.study.util.ImageUtil;

public class AdminIndexServlet extends BaseServlets {
	@Autowired
	IndexModelService indexService;

	// 显示所有首页方案
	public String showAllIndexDoor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<IndexModel> indexModelList = new ArrayList<IndexModel>();

		indexModelList = indexService.findAllIndex();
		request.setAttribute("indexModelList", indexModelList);

		return "f:/Admin/showAllIndexDoor.jsp";
	}

	// 显示单个首页方案
	public String showIndexDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int indexId;
		if (request.getParameter("indexId") != null) {
			indexId = Integer.parseInt(request.getParameter("indexId"));
		} else {
			indexId = (Integer) request.getAttribute("indexId");
		}

		IndexModel indexModel = new IndexModel();
		indexModel = indexService.findIndexModelById(indexId);

		request.setAttribute("indexModel", indexModel);

		return "f:/Admin/showIndexDetail.jsp";
	}

	// 修改首页方案
	public String updataIndexModel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取isUse的值
		Integer isUse = 1;
		if (request.getParameter("isUse") == null) {
			isUse = 1;
		} else {
			isUse = 0;
		}

		// 若改为启用；关闭已启用对象；打开本次修改的对象
		if (isUse == 0) {
			// 新状态为 启用
			if (indexService.closeUseIndex()) {
				String result = "没有找到已经启用的方案";
				request.setAttribute("result", result);
			}
		}

		int indexId = Integer.parseInt(request.getParameter("indexId"));
		String advantage1 = request.getParameter("advantage1");
		String advantage1ImageSrc = request.getParameter("advantage1ImageSrc");
		String advantage1Sub = request.getParameter("advantage1Sub");
		String advantage2 = request.getParameter("advantage2");
		String advantage2ImageSrc = request.getParameter("advantage2ImageSrc");
		String advantage2Sub = request.getParameter("advantage2Sub");
		String footerAboutUs = request.getParameter("footerAboutUs");
		String footerWeChat = request.getParameter("footerWeChat");
		String logoImageSrc = request.getParameter("logoImageSrc");
		String logoTitle = request.getParameter("logoTitle");
		String merit1 = request.getParameter("merit1");
		String merit1ImageSrc = request.getParameter("merit1ImageSrc");
		String merit1Sub = request.getParameter("merit1Sub");
		String merit2 = request.getParameter("merit2");
		String merit2ImageSrc = request.getParameter("merit2ImageSrc");
		String merit2Sub = request.getParameter("merit2Sub");
		String merit3 = request.getParameter("merit3");
		String merit3ImageSrc = request.getParameter("merit3ImageSrc");
		String merit3Sub = request.getParameter("merit3Sub");
		String merit4 = request.getParameter("merit4");
		String merit4ImageSrc = request.getParameter("merit4ImageSrc");
		String merit4Sub = request.getParameter("merit4Sub");
		String summaryMain = request.getParameter("summaryMain");
		String summarySub = request.getParameter("summarySub");

		IndexModel indexModel = new IndexModel();
		indexModel.setIndexId(indexId);
		indexModel.setAdvantage1(advantage1);
		indexModel.setAdvantage1ImageSrc(advantage1ImageSrc);
		indexModel.setAdvantage1Sub(advantage1Sub);
		indexModel.setAdvantage2(advantage2);
		indexModel.setAdvantage2ImageSrc(advantage2ImageSrc);
		indexModel.setAdvantage2Sub(advantage2Sub);
		indexModel.setFooterAboutUs(footerAboutUs);
		indexModel.setFooterWeChat(footerWeChat);
		indexModel.setIsUse(isUse);
		indexModel.setLogoImageSrc(logoImageSrc);
		indexModel.setLogoTitle(logoTitle);
		indexModel.setMerit1(merit1);
		indexModel.setMerit1ImageSrc(merit1ImageSrc);
		indexModel.setMerit1Sub(merit1Sub);
		indexModel.setMerit2(merit2);
		indexModel.setMerit2ImageSrc(merit2ImageSrc);
		indexModel.setMerit2Sub(merit2Sub);
		indexModel.setMerit3(merit3);
		indexModel.setMerit3ImageSrc(merit3ImageSrc);
		indexModel.setMerit3Sub(merit3Sub);
		indexModel.setMerit4(merit4);
		indexModel.setMerit4ImageSrc(merit4ImageSrc);
		indexModel.setMerit4Sub(merit4Sub);
		indexModel.setSummaryMain(summaryMain);
		indexModel.setSummarySub(summarySub);

		String result = indexService.updateIndexModelById(indexId, indexModel);
		request.setAttribute("result", result);
		return "f:/Admin/result.jsp";
	}

	// 删除首页方案
	public String deleteIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int IndexId = Integer.parseInt(request.getParameter("indexId"));
		String result = indexService.deleteIndexModelById(IndexId);
		request.setAttribute("result", result);
		return "f:/Admin/result.jsp";
	}

	// 显示上传图片的jsp页面
	public String showUploadImage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("location", request.getParameter("location"));
		request.setAttribute("indexId", request.getParameter("indexId"));
		String src1 = request.getParameter("src");
		String src = new String(src1.getBytes("ISO8859-1"), "UTF-8");
		request.setAttribute("src", src);

		return "f:/Admin/indexImageUpload.jsp";
	}

	// 上传图片（方案id，图片位置）
	public String imageUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 添加真实文件
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(20 * 1024 * 1024,
				new File("C:/f/temp"));
		// 解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);

		// 解析，得到List
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem fi = fileItemList.get(3);

			// 1. 得到文件保存的路径
			String root = this.getServletContext().getRealPath(
					"/indexImageFiles/");

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

			// 在数据库中修改信息
			ImageUtil imageUtil = new ImageUtil();
			int indexId = Integer.parseInt(fileItemList.get(0).getString());
			String location = fileItemList.get(1).getString();
			String relativePath = imageUtil.getImageSrc(root, hex, savename);
			String src = new String(fileItemList.get(2).getString()
					.getBytes("ISO8859-1"), "UTF-8");

			String result = indexService.updateImage(indexId, location,
					relativePath);

			// 获取图片路径

			String realPath = imageUtil.getRealPath(root, src);
			File resFile = new File(realPath);
			resFile.delete();// 删除真实文件

			request.setAttribute(location + "Result", result);
			request.setAttribute("indexId", indexId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.showIndexDetail(request, response);
	}

	// 跳转到增加首页方案
	public String addIndexFirst(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return "f:/Admin/addIndexModel.jsp";
	}

	// 增加首页方案
	public String addIndexModel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取isUse的值
		Integer isUse = 1;
		if (request.getParameter("isUse") == null) {
			isUse = 1;
		} else {
			isUse = 0;
		}

		// 若改为启用；关闭已启用对象；打开本次修改的对象
		if (isUse == 0) {
			// 新状态为 启用
			if (indexService.closeUseIndex()) {
				String result = "没有找到已经启用的方案";
				request.setAttribute("result", result);
			}
		}

		String advantage1 = request.getParameter("advantage1");
		String advantage1ImageSrc = request.getParameter("advantage1ImageSrc");
		String advantage1Sub = request.getParameter("advantage1Sub");
		String advantage2 = request.getParameter("advantage2");
		String advantage2ImageSrc = request.getParameter("advantage2ImageSrc");
		String advantage2Sub = request.getParameter("advantage2Sub");
		String footerAboutUs = request.getParameter("footerAboutUs");
		String footerWeChat = request.getParameter("footerWeChat");
		String logoImageSrc = request.getParameter("logoImageSrc");
		String logoTitle = request.getParameter("logoTitle");
		String merit1 = request.getParameter("merit1");
		String merit1ImageSrc = request.getParameter("merit1ImageSrc");
		String merit1Sub = request.getParameter("merit1Sub");
		String merit2 = request.getParameter("merit2");
		String merit2ImageSrc = request.getParameter("merit2ImageSrc");
		String merit2Sub = request.getParameter("merit2Sub");
		String merit3 = request.getParameter("merit3");
		String merit3ImageSrc = request.getParameter("merit3ImageSrc");
		String merit3Sub = request.getParameter("merit3Sub");
		String merit4 = request.getParameter("merit4");
		String merit4ImageSrc = request.getParameter("merit4ImageSrc");
		String merit4Sub = request.getParameter("merit4Sub");
		String summaryMain = request.getParameter("summaryMain");
		String summarySub = request.getParameter("summarySub");

		IndexModel indexModel = new IndexModel();
		indexModel.setAdvantage1(advantage1);
		indexModel.setAdvantage1ImageSrc(advantage1ImageSrc);
		indexModel.setAdvantage1Sub(advantage1Sub);
		indexModel.setAdvantage2(advantage2);
		indexModel.setAdvantage2ImageSrc(advantage2ImageSrc);
		indexModel.setAdvantage2Sub(advantage2Sub);
		indexModel.setFooterAboutUs(footerAboutUs);
		indexModel.setFooterWeChat(footerWeChat);
		indexModel.setIsUse(isUse);
		indexModel.setLogoImageSrc(logoImageSrc);
		indexModel.setLogoTitle(logoTitle);
		indexModel.setMerit1(merit1);
		indexModel.setMerit1ImageSrc(merit1ImageSrc);
		indexModel.setMerit1Sub(merit1Sub);
		indexModel.setMerit2(merit2);
		indexModel.setMerit2ImageSrc(merit2ImageSrc);
		indexModel.setMerit2Sub(merit2Sub);
		indexModel.setMerit3(merit3);
		indexModel.setMerit3ImageSrc(merit3ImageSrc);
		indexModel.setMerit3Sub(merit3Sub);
		indexModel.setMerit4(merit4);
		indexModel.setMerit4ImageSrc(merit4ImageSrc);
		indexModel.setMerit4Sub(merit4Sub);
		indexModel.setSummaryMain(summaryMain);
		indexModel.setSummarySub(summarySub);

		String result = indexService.addIndexModel(indexModel);
		request.setAttribute("result", result);

		return "f:/Admin/result.jsp";
	}

}

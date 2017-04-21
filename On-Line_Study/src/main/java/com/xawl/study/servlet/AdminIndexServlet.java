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

	// ��ʾ������ҳ����
	public String showAllIndexDoor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<IndexModel> indexModelList = new ArrayList<IndexModel>();

		indexModelList = indexService.findAllIndex();
		request.setAttribute("indexModelList", indexModelList);

		return "f:/Admin/showAllIndexDoor.jsp";
	}

	// ��ʾ������ҳ����
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

	// �޸���ҳ����
	public String updataIndexModel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡisUse��ֵ
		Integer isUse = 1;
		if (request.getParameter("isUse") == null) {
			isUse = 1;
		} else {
			isUse = 0;
		}

		// ����Ϊ���ã��ر������ö��󣻴򿪱����޸ĵĶ���
		if (isUse == 0) {
			// ��״̬Ϊ ����
			if (indexService.closeUseIndex()) {
				String result = "û���ҵ��Ѿ����õķ���";
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

	// ɾ����ҳ����
	public String deleteIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int IndexId = Integer.parseInt(request.getParameter("indexId"));
		String result = indexService.deleteIndexModelById(IndexId);
		request.setAttribute("result", result);
		return "f:/Admin/result.jsp";
	}

	// ��ʾ�ϴ�ͼƬ��jspҳ��
	public String showUploadImage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("location", request.getParameter("location"));
		request.setAttribute("indexId", request.getParameter("indexId"));
		String src1 = request.getParameter("src");
		String src = new String(src1.getBytes("ISO8859-1"), "UTF-8");
		request.setAttribute("src", src);

		return "f:/Admin/indexImageUpload.jsp";
	}

	// �ϴ�ͼƬ������id��ͼƬλ�ã�
	public String imageUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// �����ʵ�ļ�
		// ����
		DiskFileItemFactory factory = new DiskFileItemFactory(20 * 1024 * 1024,
				new File("C:/f/temp"));
		// ������
		ServletFileUpload sfu = new ServletFileUpload(factory);

		// �������õ�List
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem fi = fileItemList.get(3);

			// 1. �õ��ļ������·��
			String root = this.getServletContext().getRealPath(
					"/indexImageFiles/");

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
			ImageUtil imageUtil = new ImageUtil();
			int indexId = Integer.parseInt(fileItemList.get(0).getString());
			String location = fileItemList.get(1).getString();
			String relativePath = imageUtil.getImageSrc(root, hex, savename);
			String src = new String(fileItemList.get(2).getString()
					.getBytes("ISO8859-1"), "UTF-8");

			String result = indexService.updateImage(indexId, location,
					relativePath);

			// ��ȡͼƬ·��

			String realPath = imageUtil.getRealPath(root, src);
			File resFile = new File(realPath);
			resFile.delete();// ɾ����ʵ�ļ�

			request.setAttribute(location + "Result", result);
			request.setAttribute("indexId", indexId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.showIndexDetail(request, response);
	}

	// ��ת��������ҳ����
	public String addIndexFirst(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return "f:/Admin/addIndexModel.jsp";
	}

	// ������ҳ����
	public String addIndexModel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ��ȡisUse��ֵ
		Integer isUse = 1;
		if (request.getParameter("isUse") == null) {
			isUse = 1;
		} else {
			isUse = 0;
		}

		// ����Ϊ���ã��ر������ö��󣻴򿪱����޸ĵĶ���
		if (isUse == 0) {
			// ��״̬Ϊ ����
			if (indexService.closeUseIndex()) {
				String result = "û���ҵ��Ѿ����õķ���";
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

package com.xawl.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.servlet.BaseServlet;

import com.xawl.study.model.Category;
import com.xawl.study.model.IndexModel;
import com.xawl.study.model.Interest;
import com.xawl.study.model.MenuModel;
import com.xawl.study.model.Page;
import com.xawl.study.model.Resource;
import com.xawl.study.service.CategoryService;
import com.xawl.study.service.IndexModelService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.MenuService;
import com.xawl.study.service.ResourceService;
import com.xawl.study.util.ImageUtil;
import com.xawl.study.util.PageUtil;

public class CategoryServlet extends BaseServlets {
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

	// ������Ȥ����id������,�ĵ�
	public String showCategoryByInterestForDocument(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//
//		// ---��ȡ���õĲ˵�---
//		List<MenuModel> menuList = menuService.findAllUseMenu();
//		request.setAttribute("menuList", menuList);
//
//		// ---��ȡ���õ���ҳ����---
//		ImageUtil util = new ImageUtil();
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//
//		String LogoSrc = indexModel.getLogoImageSrc();
//		String newLogoSrc = LogoSrc;
//		indexModel.setLogoImageSrc(newLogoSrc);
//
//		request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();
		int interestId = Integer.parseInt(request.getParameter("interestId"));

		for (Interest interest : interestList) {
			if (interest.getId() == interestId) {
				interest.setAttribute("kind_avtive");
				request.setAttribute("interestId", interestId);
				request.setAttribute("categoryId", 0);
			}
		}

		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---
		List<Category> categoryList = categoryService
				.findCategoryListByInterestId(interestId);
		request.setAttribute("categoryList", categoryList);

		// ---��ȡ��Դ---

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
			current = "1";
		}
		Page page = PageUtil.createPage(20, resourceService
				.findResourceByTypeAndInterest(1, interestId).size(), Integer
				.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(20, resourceService
					.findResourceByTypeAndInterest(1, interestId).size(), page
					.getTotalPage());
		}

		List<Resource> resourceList = resourceService
				.findResourceByTypeAndInterest(1, interestId, page);
		for (int i = 0; i < resourceList.size(); i++) {// ���Ƴ���
			resourceList
					.get(i)
					.setResourceName(
							resourceList.get(i).getResourceName().length() > 100 ? resourceList
									.get(i).getResourceName().substring(0, 11)
									+ "...."
									: resourceList.get(i).getResourceName());
			// resourceList.get(i).setUploadeDate(new
			// Date(resourceList.get(i).getUploadeDate().toLocaleString()) );
		}
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("page", page);
		request.setAttribute("servlet", "CategoryServlet");
		request.setAttribute("method", "showCategoryByInterest");
		request.setAttribute("other", "&interestId=" + interestId);
		return "f:/User/Jsp/documentList.jsp";
	}

	// ������Ȥ����id�����࣬��Ƶ
	public String showCategoryByInterest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//
//		// ---��ȡ���õĲ˵�---
//		List<MenuModel> menuList = menuService.findAllUseMenu();
//		request.setAttribute("menuList", menuList);
//
//		// ---��ȡ���õ���ҳ����---
//		ImageUtil util = new ImageUtil();
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//
//		String LogoSrc = indexModel.getLogoImageSrc();
//		String newLogoSrc = LogoSrc;
//		indexModel.setLogoImageSrc(newLogoSrc);
//
//		request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();
		int interestId = Integer.parseInt(request.getParameter("interestId"));

		for (Interest interest : interestList) {
			if (interest.getId() == interestId) {
				interest.setAttribute("kind_avtive");
				request.setAttribute("interestId", interestId);
				request.setAttribute("categoryId", 0);
			}
		}

		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---
		List<Category> categoryList = categoryService
				.findCategoryListByInterestId(interestId);
		request.setAttribute("categoryList", categoryList);

		// ---��ȡ��Դ---

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
			current = "1";
		}
		Page page = PageUtil.createPage(8, resourceService
				.findResourceByTypeAndInterest(0, interestId).size(), Integer
				.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(8, resourceService
					.findResourceByTypeAndInterest(0, interestId).size(), page
					.getTotalPage());
		}

		List<Resource> resourceList = resourceService
				.findResourceByTypeAndInterest(0, interestId, page);
		for (int i = 0; i < resourceList.size(); i++) {// ���Ƴ���
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
		request.setAttribute("servlet", "CategoryServlet");
		request.setAttribute("method", "showCategoryByInterest");
		request.setAttribute("other", "&interestId=" + interestId);
		return "f:/User/Jsp/kindReal.jsp";
	}

	// ������Ȥ����Դ
	public String showResourceByChooseCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//
//		// ---��ȡ���õĲ˵�---
//		List<MenuModel> menuList = menuService.findAllUseMenu();
//		request.setAttribute("menuList", menuList);
//
//		// ---��ȡ���õ���ҳ����---
//		ImageUtil util = new ImageUtil();
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//
//		String LogoSrc = indexModel.getLogoImageSrc();
//		String newLogoSrc = LogoSrc;
//		indexModel.setLogoImageSrc(newLogoSrc);
//
//		request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();

		int interestId = Integer.parseInt(request.getParameter("interestId"));
		for (Interest interest : interestList) {
			if (interest.getId() == interestId) {
				interest.setAttribute("kind_avtive");
				request.setAttribute("interestId", interestId);
			}
		}
		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---
		List<Category> categoryList = categoryService
				.findCategoryListByInterestId(interestId);

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		for (Category category : categoryList) {
			if (category.getCategoryId() == categoryId) {
				category.setCategoryLink("kind_avtive");
				request.setAttribute("categoryId", categoryId);
			}
		}

		request.setAttribute("categoryList", categoryList);

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
			current = "1";
		}
		Page page = PageUtil.createPage(12, resourceService
				.findResourceByCategory(categoryId, 0).size(), Integer
				.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(12, resourceService
					.findResourceByCategory(categoryId, 0).size(), page
					.getTotalPage());
		}
		// ---��ȡ��Դ---
		List<Resource> resourceList = resourceService.findResourceByCategory(
				categoryId, 0, page);
		for (int i = 0; i < resourceList.size(); i++) {// ���Ƴ���
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
		request.setAttribute("servlet", "CategoryServlet");
		request.setAttribute("method", "showResourceByChooseCategory");
		request.setAttribute("other", "&categoryId=" + categoryId
				+ "&interestId=" + interestId);
		return "f:/User/Jsp/kindReal.jsp";
	}

	// ������Ȥ����Դ���ĵ�
	public String showResourceByChooseCategoryForDocument(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
//		// ---��ȡ���õĲ˵�---
//		List<MenuModel> menuList = menuService.findAllUseMenu();
//		request.setAttribute("menuList", menuList);
//
//		// ---��ȡ���õ���ҳ����---
//		ImageUtil util = new ImageUtil();
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//
//		String LogoSrc = indexModel.getLogoImageSrc();
//		String newLogoSrc = LogoSrc;
//		indexModel.setLogoImageSrc(newLogoSrc);
//
//		request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();

		int interestId = Integer.parseInt(request.getParameter("interestId"));
		for (Interest interest : interestList) {
			if (interest.getId() == interestId) {
				interest.setAttribute("kind_avtive");
				request.setAttribute("interestId", interestId);
			}
		}
		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---
		List<Category> categoryList = categoryService
				.findCategoryListByInterestId(interestId);

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		for (Category category : categoryList) {
			if (category.getCategoryId() == categoryId) {
				category.setCategoryLink("kind_avtive");
				request.setAttribute("categoryId", categoryId);
			}
		}

		request.setAttribute("categoryList", categoryList);

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
			current = "1";
		}
		Page page = PageUtil.createPage(12, resourceService
				.findResourceByCategory(categoryId, 1).size(), Integer
				.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(12, resourceService
					.findResourceByCategory(categoryId, 1).size(), page
					.getTotalPage());
		}
		// ---��ȡ��Դ---
		List<Resource> resourceList = resourceService.findResourceByCategory(
				categoryId, 0, page);
		for (int i = 0; i < resourceList.size(); i++) {// ���Ƴ���
			resourceList
					.get(i)
					.setResourceName(
							resourceList.get(i).getResourceName().length() > 100 ? resourceList
									.get(i).getResourceName().substring(0, 11)
									+ "...."
									: resourceList.get(i).getResourceName());
			// resourceList.get(i).setUploadeDate(new
			// Date(resourceList.get(i).getUploadeDate().toLocaleString()) );
		}
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("page", page);
		request.setAttribute("servlet", "CategoryServlet");
		request.setAttribute("method", "showResourceByChooseCategory");
		request.setAttribute("other", "&categoryId=" + categoryId
				+ "&interestId=" + interestId);
		return "f:/User/Jsp/documentList.jsp";
	}

	// ���·���
	public String showResourceByChooseNew(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		// ---��ȡ���õĲ˵�---
//		List<MenuModel> menuList = menuService.findAllUseMenu();
//		request.setAttribute("menuList", menuList);
//
//		// ---��ȡ���õ���ҳ����---
//		ImageUtil util = new ImageUtil();
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//
//		String LogoSrc = indexModel.getLogoImageSrc();
//		String newLogoSrc = LogoSrc;
//		indexModel.setLogoImageSrc(newLogoSrc);
//
//		request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();

		int interestId = Integer.parseInt(request.getParameter("interestId"));
		for (Interest interest : interestList) {
			if (interest.getId() == interestId) {
				interest.setAttribute("kind_avtive");
				request.setAttribute("interestId", interestId);
				request.setAttribute("categoryId", 0);
			}
		}
		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---
		List<Category> categoryList = categoryService
				.findCategoryListByInterestId(interestId);

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		for (Category category : categoryList) {
			if (category.getCategoryId() == categoryId) {
				category.setCategoryLink("kind_avtive");
				request.setAttribute("categoryId", categoryId);
			}
		}

		request.setAttribute("categoryList", categoryList);

		// ---��ȡ��Դ---
		List<Resource> resourceList = resourceService.showResourceByChooseNew(
				categoryId, interestId, 0);
		request.setAttribute("resourceList", resourceList);
		return "f:/User/Jsp/kindReal.jsp";
	}

	// ���ȷ���
	public String showResourceByChooseHot(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		// ---��ȡ���õĲ˵�---
//		List<MenuModel> menuList = menuService.findAllUseMenu();
//		request.setAttribute("menuList", menuList);
//
//		// ---��ȡ���õ���ҳ����---
//		ImageUtil util = new ImageUtil();
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//
//		String LogoSrc = indexModel.getLogoImageSrc();
//		String newLogoSrc = LogoSrc;
//		indexModel.setLogoImageSrc(newLogoSrc);
//
//		request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();

		int interestId = Integer.parseInt(request.getParameter("interestId"));
		for (Interest interest : interestList) {
			if (interest.getId() == interestId) {
				interest.setAttribute("kind_avtive");
				request.setAttribute("interestId", interestId);
				request.setAttribute("categoryId", 0);
			}
		}
		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---
		List<Category> categoryList = categoryService
				.findCategoryListByInterestId(interestId);

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		for (Category category : categoryList) {
			if (category.getCategoryId() == categoryId) {
				category.setCategoryLink("kind_avtive");
				request.setAttribute("categoryId", categoryId);
			}
		}

		request.setAttribute("categoryList", categoryList);

		// ---��ȡ��Դ---
		List<Resource> resourceList = resourceService.showResourceByChooseHot(
				categoryId, interestId, 0);
		request.setAttribute("resourceList", resourceList);
		return "f:/User/Jsp/kindReal.jsp";
	}

	// �Ƽ�����
	public String showResourceByChoosePut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		return "f:/User/Jsp/kindReal.jsp";
	}

}

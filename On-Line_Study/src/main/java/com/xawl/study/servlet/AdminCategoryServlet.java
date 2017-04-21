package com.xawl.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.Category;
import com.xawl.study.model.Page;
import com.xawl.study.service.CategoryService;
import com.xawl.study.util.PageUtil;

public class AdminCategoryServlet extends BaseServlets {
	@Autowired
	CategoryService categoryService;

	// 跳转
	public String showAddCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		return "f:/Admin/addCategory.jsp";
	}

	// 添加一个资源种类
	public String addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String categoryName = request.getParameter("categoryName");
		String categoryLink = request.getParameter("categoryLink");
		Category newCategory = new Category();
		newCategory.setCategoryName(categoryName);
		newCategory.setCategoryLink(categoryLink);

		String result = categoryService.addCategory(newCategory);

		request.setAttribute("result", result);
		return "f:/Admin/result.jsp";
	}

	// 显示所有种类
	public String showAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String count = request.getParameter("count");// 每页显示的数据数量
		String pagecount = request.getParameter("page");// 第几页
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));

		List<Category> categoryList = categoryService.queryByPage(page);
		int categoryCount = categoryService.countCategory();
		int num = Integer.parseInt((String) request.getSession().getAttribute(
				"count"));// 每页显示的数据数量
		if ((categoryCount % num) == 0) {
			request.getSession().setAttribute("weiye", categoryCount / num);
		} else {
			request.getSession().setAttribute("weiye",
					(categoryCount / num) + 1);
		}
		request.getSession().setAttribute("weiye", categoryCount / num);
		if ((Integer.parseInt(pagecount) <= categoryCount / num)
				&& (Integer.parseInt(pagecount) > 0)) {
			request.getSession().setAttribute("page", pagecount);
		}

		request.setAttribute("categoryList", categoryList);
		return "f:/Admin/showAllCategory.jsp";
	}

	// 删除种类
	public String deleteCategoryById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int cId = Integer.parseInt(request.getParameter("cId"));
		String result = categoryService.deleteCategoryById(cId);

		request.setAttribute("result", result);
		return "f:/Admin/result.jsp";
	}

	// 显示种类详细页
	public String showCategoryDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int cId = Integer.parseInt(request.getParameter("cId"));
		Category category = categoryService.findCategoryById(cId);

		request.setAttribute("category", category);

		return "f:/Admin/showCategoryDetail.jsp";
	}

	// 修改
	public String updateCategoryById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int cId = Integer.parseInt(request.getParameter("categoryId"));

		String categoryName = request.getParameter("categoryName");
		String categoryLink = request.getParameter("categoryLink");
		Category newCategory = new Category();
		newCategory.setCategoryId(cId);
		newCategory.setCategoryName(categoryName);
		newCategory.setCategoryLink(categoryLink);
		String result = categoryService.updateCategory(cId, newCategory);
		request.setAttribute("result", result);

		return "f:/Admin/result.jsp";
	}

}

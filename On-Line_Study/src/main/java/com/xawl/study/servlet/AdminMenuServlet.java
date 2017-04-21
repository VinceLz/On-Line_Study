package com.xawl.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.MenuModel;
import com.xawl.study.service.MenuService;

import cn.itcast.servlet.BaseServlet;

public class AdminMenuServlet extends BaseServlets {
	@Autowired
	private MenuService menuService;

	// ������ʾ���в˵���
	public String showAllMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<MenuModel> menuList = new ArrayList<MenuModel>();
		menuList = menuService.findAllMenu();
		request.setAttribute("menuList", menuList);

		return "f:/Admin/showAllMenu.jsp";
	}

	// ����id��ʾһ���˵���
	public String showMenuDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer mid = Integer.parseInt(request.getParameter("mid"));
		MenuModel menu = menuService.findMenuById(mid);
		request.setAttribute("menu", menu);

		return "f:/Admin/showMenuDetail.jsp";
	}

	// �޸Ĳ˵���
	public String updataMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer menuId = Integer.parseInt(request.getParameter("menuId"));
		Integer parentMenuId = Integer.parseInt(request
				.getParameter("parentMenuId"));
		String menuName = request.getParameter("menuName");
		String menuAddr = request.getParameter("menuAddr");
		Integer menuOrder = Integer.parseInt(request.getParameter("menuOrder"));
		Integer isUse = 0;
		if (request.getParameter("isUse") == null) {
			isUse = 1;
		} else {
			isUse = 0;
		}
		MenuModel menu = new MenuModel();
		menu.setMenuId(menuId);
		menu.setIsUse(isUse);
		menu.setMenuAddr(menuAddr);
		menu.setMenuName(menuName);
		menu.setMenuOrder(menuOrder);
		menu.setParentMenuId(parentMenuId);
		String result = menuService.updataMenuById(menuId, menu);
		request.setAttribute("result", result);

		return "f:/Admin/result.jsp";
	}

	// ��ߵ�������ת����Ӳ˵�
	public String addMenuFirst(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		return "f:/Admin/addMenu.jsp";
	}

	// ��Ӳ˵�
	public String addMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MenuModel menuModel = new MenuModel();
		menuModel.setParentMenuId(Integer.parseInt(request
				.getParameter("parentMenuId")));
		menuModel.setIsUse(Integer.parseInt(request.getParameter("isUse")));
		menuModel.setMenuAddr(request.getParameter("menuAddr"));
		menuModel.setMenuName(request.getParameter("menuName"));
		menuModel.setMenuOrder(0);

		String result = menuService.addMenu(menuModel);
		request.setAttribute("result", result);

		return "f:/Admin/result.jsp";
	}

	// ɾ���˵�
	public String deleteMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int menuId = Integer.parseInt(request.getParameter("menuId"));
		String result = menuService.deleteMenuById(menuId);
		request.setAttribute("result", result);
		return "f:/Admin/result.jsp";
	}

	// ��ߵ�������ת���˵�����
	public String showMenuOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<MenuModel> menuList = new ArrayList<MenuModel>();
		menuList = menuService.findAllMenu();
		request.setAttribute("menuList", menuList);

		return "f:/Admin/showMenuOrder.jsp";
	}

	// ʹ�˵���ǰ�ƶ�һλ
	public String menuUpOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int menuOldOrder = Integer.parseInt(request.getParameter("menuOrder"));

		MenuModel menu1 = menuService.fingMenuByMenuOrder(menuOldOrder - 1);// Ҫ�����menu
		MenuModel menu = menuService.findMenuById(menuId);// ��menu

		menu.setMenuOrder(menuOldOrder - 1);
		menu1.setMenuOrder(menuOldOrder);
		Integer menu1Id = menu1.getMenuId();

		menuService.updataMenuById(menuId, menu);
		menuService.updataMenuById(menu1Id, menu1);

		List<MenuModel> menuList = new ArrayList<MenuModel>();
		menuList = menuService.findAllMenu();
		request.setAttribute("menuList", menuList);

		return "f:/Admin/showMenuOrder.jsp";
	}

	// ʹ�˵�����ƶ�һλ
	public String menuDownOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int menuOldOrder = Integer.parseInt(request.getParameter("menuOrder"));

		MenuModel menu1 = menuService.fingMenuByMenuOrder(menuOldOrder + 1);// Ҫ�����menu
		MenuModel menu = menuService.findMenuById(menuId);// ��menu

		menu.setMenuOrder(menuOldOrder + 1);
		menu1.setMenuOrder(menuOldOrder);
		Integer menu1Id = menu1.getMenuId();

		menuService.updataMenuById(menuId, menu);
		menuService.updataMenuById(menu1Id, menu1);

		List<MenuModel> menuList = new ArrayList<MenuModel>();
		menuList = menuService.findAllMenu();
		request.setAttribute("menuList", menuList);

		return "f:/Admin/showMenuOrder.jsp";
	}
}

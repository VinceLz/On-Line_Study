package com.xawl.study.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.MenuDao;
import com.xawl.study.model.MenuModel;
import com.xawl.study.service.MenuService;
import com.xawl.study.util.MenuComparatorUtil;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuDao menuDao;

	// 添加菜单
	public String addMenu(MenuModel menu) {
		if (menuDao.addMenu(menu)) {
			return "添加成功！";
		} else {
			return "添加出错！请稍后再试！";
		}
	}

	// 按id查菜单
	public MenuModel findMenuById(int id) {
		return menuDao.findMenuById(id);
	}

	// 按顺序值查找菜单
	public MenuModel fingMenuByMenuOrder(int menuOrder) {
		return menuDao.findMenuByMenuOrder(menuOrder);
	}

	// 查找所有菜单
	public List<MenuModel> findAllMenu() {
		List<MenuModel> menuList = new ArrayList<MenuModel>();// 未排序的menuList
		menuList = menuDao.findAllMenu();
		MenuComparatorUtil menuComparatorUtil = new MenuComparatorUtil();
		Collections.sort(menuList, menuComparatorUtil);// 排序
		return menuList;
	}

	// 查找所有启用的菜单
	public List<MenuModel> findAllUseMenu() {

		List<MenuModel> menuList = new ArrayList<MenuModel>();// 未排序的menuList
		menuList = menuDao.findAllUseMenu();
		MenuComparatorUtil menuComparatorUtil = new MenuComparatorUtil();
		Collections.sort(menuList, menuComparatorUtil);// 排序

		return menuList;
	}

	// 按id删除菜单
	public String deleteMenuById(int id) {
		MenuModel menu = new MenuModel();
		menu = findMenuById(id);
		if (menu != null) {
			if (menuDao.deleteMenuById(id)) {
				return "删除成功！";
			} else {
				return "未知原因删除失败！";
			}
		} else {
			return "该菜单不存在！删除失败！";
		}
	}

	// 按id修改菜单
	public String updataMenuById(int id, MenuModel newMenu) {
		if (menuDao.updataMenuModel(id, newMenu)) {
			return "更新成功！";
		} else {
			return "更新失败！";
		}
	}

}

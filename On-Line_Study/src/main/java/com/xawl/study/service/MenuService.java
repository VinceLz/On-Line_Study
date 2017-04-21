package com.xawl.study.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.MenuDao;
import com.xawl.study.model.MenuModel;
import com.xawl.study.util.MenuComparatorUtil;

public interface MenuService {

	// 添加菜单
	public String addMenu(MenuModel menu);

	// 按id查菜单
	public MenuModel findMenuById(int id);

	// 按顺序值查找菜单
	public MenuModel fingMenuByMenuOrder(int menuOrder);

	// 查找所有菜单
	public List<MenuModel> findAllMenu();

	// 查找所有启用的菜单
	public List<MenuModel> findAllUseMenu();

	// 按id删除菜单
	public String deleteMenuById(int id);

	// 按id修改菜单
	public String updataMenuById(int id, MenuModel newMenu);

}

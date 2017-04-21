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

	// ��Ӳ˵�
	public String addMenu(MenuModel menu);

	// ��id��˵�
	public MenuModel findMenuById(int id);

	// ��˳��ֵ���Ҳ˵�
	public MenuModel fingMenuByMenuOrder(int menuOrder);

	// �������в˵�
	public List<MenuModel> findAllMenu();

	// �����������õĲ˵�
	public List<MenuModel> findAllUseMenu();

	// ��idɾ���˵�
	public String deleteMenuById(int id);

	// ��id�޸Ĳ˵�
	public String updataMenuById(int id, MenuModel newMenu);

}

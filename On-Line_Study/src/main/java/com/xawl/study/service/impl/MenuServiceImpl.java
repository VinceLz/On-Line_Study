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

	// ��Ӳ˵�
	public String addMenu(MenuModel menu) {
		if (menuDao.addMenu(menu)) {
			return "��ӳɹ���";
		} else {
			return "��ӳ������Ժ����ԣ�";
		}
	}

	// ��id��˵�
	public MenuModel findMenuById(int id) {
		return menuDao.findMenuById(id);
	}

	// ��˳��ֵ���Ҳ˵�
	public MenuModel fingMenuByMenuOrder(int menuOrder) {
		return menuDao.findMenuByMenuOrder(menuOrder);
	}

	// �������в˵�
	public List<MenuModel> findAllMenu() {
		List<MenuModel> menuList = new ArrayList<MenuModel>();// δ�����menuList
		menuList = menuDao.findAllMenu();
		MenuComparatorUtil menuComparatorUtil = new MenuComparatorUtil();
		Collections.sort(menuList, menuComparatorUtil);// ����
		return menuList;
	}

	// �����������õĲ˵�
	public List<MenuModel> findAllUseMenu() {

		List<MenuModel> menuList = new ArrayList<MenuModel>();// δ�����menuList
		menuList = menuDao.findAllUseMenu();
		MenuComparatorUtil menuComparatorUtil = new MenuComparatorUtil();
		Collections.sort(menuList, menuComparatorUtil);// ����

		return menuList;
	}

	// ��idɾ���˵�
	public String deleteMenuById(int id) {
		MenuModel menu = new MenuModel();
		menu = findMenuById(id);
		if (menu != null) {
			if (menuDao.deleteMenuById(id)) {
				return "ɾ���ɹ���";
			} else {
				return "δ֪ԭ��ɾ��ʧ�ܣ�";
			}
		} else {
			return "�ò˵������ڣ�ɾ��ʧ�ܣ�";
		}
	}

	// ��id�޸Ĳ˵�
	public String updataMenuById(int id, MenuModel newMenu) {
		if (menuDao.updataMenuModel(id, newMenu)) {
			return "���³ɹ���";
		} else {
			return "����ʧ�ܣ�";
		}
	}

}

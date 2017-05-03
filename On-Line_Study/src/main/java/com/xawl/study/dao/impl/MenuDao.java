package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.MenuModel;
@Repository
public class MenuDao extends BaseDaoImpl {
	public boolean addMenu(MenuModel menu) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.save(menu);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}

		return isok;
	}

	// �������в˵�
	public List<MenuModel> findAllMenu() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from MenuModel");
		List<MenuModel> menuList = query.list();

		return menuList;
	}

	// ��id��˵�
	public MenuModel findMenuById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from MenuModel as m where m.menuId = " + id);
		MenuModel menu = (MenuModel) query.uniqueResult();

		return menu;
	}

	// ��idɾ���˵�
	public boolean deleteMenuById(int id) {
		boolean isok = false;
		MenuModel menu = findMenuById(id);
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.delete(menu);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}

		return isok;
	}

	// �����������õĲ˵�
	public List<MenuModel> findAllUseMenu() {
		Session session = getSessionFactory().getCurrentSession();

		Query query = session
				.createQuery("from MenuModel as m where m.isUse = 0");
		List<MenuModel> menuList = query.list();

		return menuList;
	}

	// �޸Ĳ˵���
	public boolean updataMenuModel(int id, MenuModel newMenu) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		MenuModel menu = new MenuModel();
		Query query = session
				.createQuery("from MenuModel as m where m.menuId = " + id);
		menu = (MenuModel) query.uniqueResult();
		try {
			menu = newMenu;
			menu.setMenuId(id);
			session.clear();
			session.update(menu);

			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("�˵������ڣ�����ʧ�ܣ�");
		}
		return isok;
	}

	// ��˳��ֵ��˵�
	public MenuModel findMenuByMenuOrder(int menuOrder) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from MenuModel as m where m.menuOrder = "
						+ menuOrder);
		MenuModel menu = (MenuModel) query.uniqueResult();

		return menu;
	}
}

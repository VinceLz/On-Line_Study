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

	// 查找所有菜单
	public List<MenuModel> findAllMenu() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from MenuModel");
		List<MenuModel> menuList = query.list();

		return menuList;
	}

	// 按id查菜单
	public MenuModel findMenuById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from MenuModel as m where m.menuId = " + id);
		MenuModel menu = (MenuModel) query.uniqueResult();

		return menu;
	}

	// 按id删除菜单
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

	// 查找所有启用的菜单
	public List<MenuModel> findAllUseMenu() {
		Session session = getSessionFactory().getCurrentSession();

		Query query = session
				.createQuery("from MenuModel as m where m.isUse = 0");
		List<MenuModel> menuList = query.list();

		return menuList;
	}

	// 修改菜单项
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
			throw new RuntimeException("菜单不存在，更新失败！");
		}
		return isok;
	}

	// 按顺序值查菜单
	public MenuModel findMenuByMenuOrder(int menuOrder) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from MenuModel as m where m.menuOrder = "
						+ menuOrder);
		MenuModel menu = (MenuModel) query.uniqueResult();

		return menu;
	}
}

package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.AdministratorDao;
import com.xawl.study.model.Administrator;
import com.xawl.study.model.Page;
import com.xawl.study.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	public AdministratorDao ad;

	public boolean AddAdmin(Administrator admin) {// 管理员注册
		boolean isok = false;
		if (!((ad.CheckAdmin(admin)) == true)) {
			ad.AddAdministrator(admin);
			isok = true;
		} else {
			// throw new RuntimeException("管理员已存在");
		}
		return isok;
	}

	public boolean AdminLogin(Administrator admin) {// 验证管理员登陆
		boolean isok = false;
		if (ad.AdminLogin(admin)) {
			isok = true;
		}
		return isok;
	}

	public Administrator FindAdminByAccount(Administrator admin) {// 按照账号查找管理员的信息
		return ad.FindAdminByAccount(admin);
	}

	public List<Administrator> FindAllAdmin() {// 获取所有管理员的信息
		return ad.FindAllAdmin();
	}

	public boolean DeleteAdministratorByAccount(Administrator admin) {// 按照账号删除管理员账户
		return ad.DeleteAdministratorByAccount(admin);
	}

	public boolean UpdatePictureByAccount(Administrator admin) {
		return ad.UpdatePictureByAccount(admin);
	}

	public boolean UpdateLoginTimeByAccount(Administrator admin) {
		return ad.UpdateLoginTiemByAccount(admin);
	}

	public List<Administrator> queryByPage(Page page) {
		return ad.queryByPage(page);
	}

	public int CountAdmin() {// 得到管理员的数量
		return ad.CountAdmin();
	}

	public boolean UpdateAdminByAcount(Administrator admin) {// 按照账号更新管理员信息
		return ad.UpdateAdminByAcount(admin);
	}

	public boolean UpdateAdminById(Administrator admin) {// 按照账号更新管理员信息
		return ad.UpdateAdminById(admin);
	}

	public boolean UpdateAdminPwdByAccount(Administrator admin) {// 按照账号更新管理员密码
		return ad.UpdateAdminPwdByAccount(admin);
	}

	public boolean UpdateAdminByAcountForNikeNameAndCell(Administrator admin) {// 按照账号更新管理员信息,自己修改信息时候调用
		return ad.UpdateAdminByAcountForNikeNameAndCell(admin);
	}
}

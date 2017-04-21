package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.AdministratorDao;
import com.xawl.study.model.Administrator;
import com.xawl.study.model.Page;

public interface AdminService {

	public boolean AddAdmin(Administrator admin);

	public boolean AdminLogin(Administrator admin);

	public Administrator FindAdminByAccount(Administrator admin);

	public List<Administrator> FindAllAdmin();

	public boolean DeleteAdministratorByAccount(Administrator admin);

	public boolean UpdatePictureByAccount(Administrator admin);

	public boolean UpdateLoginTimeByAccount(Administrator admin);

	public List<Administrator> queryByPage(Page page);

	public int CountAdmin();

	public boolean UpdateAdminByAcount(Administrator admin);

	public boolean UpdateAdminById(Administrator admin);

	public boolean UpdateAdminPwdByAccount(Administrator admin);

	public boolean UpdateAdminByAcountForNikeNameAndCell(Administrator admin);
}

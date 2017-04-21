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

	public boolean AddAdmin(Administrator admin) {// ����Աע��
		boolean isok = false;
		if (!((ad.CheckAdmin(admin)) == true)) {
			ad.AddAdministrator(admin);
			isok = true;
		} else {
			// throw new RuntimeException("����Ա�Ѵ���");
		}
		return isok;
	}

	public boolean AdminLogin(Administrator admin) {// ��֤����Ա��½
		boolean isok = false;
		if (ad.AdminLogin(admin)) {
			isok = true;
		}
		return isok;
	}

	public Administrator FindAdminByAccount(Administrator admin) {// �����˺Ų��ҹ���Ա����Ϣ
		return ad.FindAdminByAccount(admin);
	}

	public List<Administrator> FindAllAdmin() {// ��ȡ���й���Ա����Ϣ
		return ad.FindAllAdmin();
	}

	public boolean DeleteAdministratorByAccount(Administrator admin) {// �����˺�ɾ������Ա�˻�
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

	public int CountAdmin() {// �õ�����Ա������
		return ad.CountAdmin();
	}

	public boolean UpdateAdminByAcount(Administrator admin) {// �����˺Ÿ��¹���Ա��Ϣ
		return ad.UpdateAdminByAcount(admin);
	}

	public boolean UpdateAdminById(Administrator admin) {// �����˺Ÿ��¹���Ա��Ϣ
		return ad.UpdateAdminById(admin);
	}

	public boolean UpdateAdminPwdByAccount(Administrator admin) {// �����˺Ÿ��¹���Ա����
		return ad.UpdateAdminPwdByAccount(admin);
	}

	public boolean UpdateAdminByAcountForNikeNameAndCell(Administrator admin) {// �����˺Ÿ��¹���Ա��Ϣ,�Լ��޸���Ϣʱ�����
		return ad.UpdateAdminByAcountForNikeNameAndCell(admin);
	}
}

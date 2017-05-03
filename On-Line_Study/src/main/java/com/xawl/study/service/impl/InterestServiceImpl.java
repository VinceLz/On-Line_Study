package com.xawl.study.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.InterestDao;
import com.xawl.study.model.ClassName;
import com.xawl.study.model.Interest;
import com.xawl.study.model.Page;
import com.xawl.study.service.InterestService;

@Service
public class InterestServiceImpl implements InterestService{
	@Autowired
	InterestDao interestDao;

	public boolean AddInterest(Interest interest) {// ����dao��ķ��������Ȥ
		boolean isok = false;

		if (interestDao.addInterest(interest)) {
			isok = true;
		}
		return isok;
	}

	public List<Interest> FindInteresByAttribute(Interest inter) {// �������Բ����û�
		List<Interest> list = new ArrayList<Interest>();
		list = interestDao.findInteresByAttribute(inter.getAttribute());
		return list;
	}

	public List<Interest> FindInteresByName(Interest inter) {// ������Ȥ���Ʋ����û�
		List<Interest> list = new ArrayList<Interest>();
		list = interestDao.findInteresByInterestName(inter.getInterestName());
		return list;
	}

	// ����������Ȥ
	public List<Interest> findAllInterest() {
		List<Interest> interestList = interestDao.findAllInterest();
		return interestList;
	}

	public List<Interest> FindIsUseInterest() {// ������Ȥ�Ƿ����ò�����Ȥ
		return interestDao.FindIsUseInterest();
	}

	public List<Interest> findAllInterestPage(Page page) {// ��ҳ������Ȥ
		return interestDao.findAllInterestPage(page);
	}

	public int CountInterest() {
		return interestDao.CountInterest();
	}

	public Interest findInteresById(int id) {// ������ȤId��ѯ��Ȥ
		return interestDao.findInteresById(id);
	}

	public boolean UpdateInterestById(Interest inter) {// ������ȤID�޸���Ȥ��Ϣ
		return interestDao.UpdateInterestById(inter);
	}

	public boolean DeleteInterestById(Interest inter) {// ɾ����Ȥ
		return interestDao.DeleteInterestById(inter);
	}

	// ����������Ȥ,��ҳ��ʾ,���ǲ���ʾ����Ϊ�յ���Ȥ
	public List<Interest> findAllInterestPageAttributeNotNull(Page page) {
		return interestDao.findAllInterestPageAttributeNotNull(page);
	}

	// ����������Ȥ,����ҳ��ʾ,������ʾ����Ϊ�յ���Ȥ
	public List<Interest> findAllInterestPageAttributeNull() {
		return interestDao.findAllInterestPageAttributeNull();
	}

	public boolean UpdateInterestByInterestName(Interest inter) {// ������ȤID�޸���Ȥ��Ϣ
		return interestDao.UpdateInterestByInterestName(inter);
	}

	@Override
	public List<ClassName> getAllClass() {
		return interestDao.getAllClass();
	}
}

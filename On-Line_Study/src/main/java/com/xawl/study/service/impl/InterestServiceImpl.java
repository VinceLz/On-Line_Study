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

	public boolean AddInterest(Interest interest) {// 调用dao层的方法添加兴趣
		boolean isok = false;

		if (interestDao.addInterest(interest)) {
			isok = true;
		}
		return isok;
	}

	public List<Interest> FindInteresByAttribute(Interest inter) {// 按照属性查找用户
		List<Interest> list = new ArrayList<Interest>();
		list = interestDao.findInteresByAttribute(inter.getAttribute());
		return list;
	}

	public List<Interest> FindInteresByName(Interest inter) {// 按照兴趣名称查找用户
		List<Interest> list = new ArrayList<Interest>();
		list = interestDao.findInteresByInterestName(inter.getInterestName());
		return list;
	}

	// 查找所有兴趣
	public List<Interest> findAllInterest() {
		List<Interest> interestList = interestDao.findAllInterest();
		return interestList;
	}

	public List<Interest> FindIsUseInterest() {// 按照兴趣是否启用查找兴趣
		return interestDao.FindIsUseInterest();
	}

	public List<Interest> findAllInterestPage(Page page) {// 分页查找兴趣
		return interestDao.findAllInterestPage(page);
	}

	public int CountInterest() {
		return interestDao.CountInterest();
	}

	public Interest findInteresById(int id) {// 按照兴趣Id查询兴趣
		return interestDao.findInteresById(id);
	}

	public boolean UpdateInterestById(Interest inter) {// 按照兴趣ID修改兴趣信息
		return interestDao.UpdateInterestById(inter);
	}

	public boolean DeleteInterestById(Interest inter) {// 删除兴趣
		return interestDao.DeleteInterestById(inter);
	}

	// 查找所有兴趣,分页显示,但是不显示详情为空的兴趣
	public List<Interest> findAllInterestPageAttributeNotNull(Page page) {
		return interestDao.findAllInterestPageAttributeNotNull(page);
	}

	// 查找所有兴趣,不分页显示,但是显示详情为空的兴趣
	public List<Interest> findAllInterestPageAttributeNull() {
		return interestDao.findAllInterestPageAttributeNull();
	}

	public boolean UpdateInterestByInterestName(Interest inter) {// 按照兴趣ID修改兴趣信息
		return interestDao.UpdateInterestByInterestName(inter);
	}

	@Override
	public List<ClassName> getAllClass() {
		return interestDao.getAllClass();
	}
}

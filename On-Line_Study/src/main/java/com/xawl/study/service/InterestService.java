package com.xawl.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.InterestDao;
import com.xawl.study.model.ClassName;
import com.xawl.study.model.Interest;
import com.xawl.study.model.Page;

public interface InterestService {

	public boolean AddInterest(Interest interest);

	public List<Interest> FindInteresByAttribute(Interest inter);

	public List<Interest> FindInteresByName(Interest inter);

	// 查找所有兴趣
	public List<Interest> findAllInterest();

	public List<Interest> FindIsUseInterest();

	public List<Interest> findAllInterestPage(Page page);

	public int CountInterest();

	public Interest findInteresById(int id);

	public boolean UpdateInterestById(Interest inter);

	public boolean DeleteInterestById(Interest inter);

	// 查找所有兴趣,分页显示,但是不显示详情为空的兴趣
	public List<Interest> findAllInterestPageAttributeNotNull(Page page);

	// 查找所有兴趣,不分页显示,但是显示详情为空的兴趣
	public List<Interest> findAllInterestPageAttributeNull();

	public boolean UpdateInterestByInterestName(Interest inter);

	public List<ClassName> getAllClass();
}

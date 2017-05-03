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

	// ����������Ȥ
	public List<Interest> findAllInterest();

	public List<Interest> FindIsUseInterest();

	public List<Interest> findAllInterestPage(Page page);

	public int CountInterest();

	public Interest findInteresById(int id);

	public boolean UpdateInterestById(Interest inter);

	public boolean DeleteInterestById(Interest inter);

	// ����������Ȥ,��ҳ��ʾ,���ǲ���ʾ����Ϊ�յ���Ȥ
	public List<Interest> findAllInterestPageAttributeNotNull(Page page);

	// ����������Ȥ,����ҳ��ʾ,������ʾ����Ϊ�յ���Ȥ
	public List<Interest> findAllInterestPageAttributeNull();

	public boolean UpdateInterestByInterestName(Interest inter);

	public List<ClassName> getAllClass();
}

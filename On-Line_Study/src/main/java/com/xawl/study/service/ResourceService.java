package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.ResourceDao;
import com.xawl.study.model.Page;
import com.xawl.study.model.Resource;

/**
 * @author kernel
 * 
 */
public interface ResourceService {

	public List<Resource> findAllResource(Page page, String sql);

	// ��id����Դ
	public Resource findResourceById(int id);

	// ����������Դ����
	public int findAllResourceCount();

	// ����������Դ
	public List<Resource> findAllResourceNotPage();

	// ����Ȥid��
	public List<Resource> findResourceByInterestID(int id);

	// ����Դ����
	public List<Resource> findResourceByName(String resourceName);

	// ������category������Դ
	public List<Resource> findResourceByCategory(int categoryId, int type,
			Page page);

	// ������category������Դ
	public List<Resource> findResourceByCategory(int categoryId, int type);

	// ���γ�id������Դ
	public List<Resource> findResourceByClassNameId(int classNameId);

	// ����Դ���Ͳ���Դ����Ƶ����
	public List<Resource> findResourceByResourceType(int type);

	// ������Դ���ͺ���Ȥ���Ͳ���Դ
	public List<Resource> findResourceByTypeAndInterest(int type, int interestId);

	// ������Դ���ͺ���Ȥ���Ͳ���Դ
	public List<Resource> findResourceByTypeAndInterest(int type,
			int interestId, Page page);

	// ���
	public String addResource(Resource resource);

	// ɾ��
	public String deleteResource(int id);

	// ��ҳ
	public List<Resource> queryByPage(Page page);

	// ��ȡ��Դ����
	public int CountResource();

	// �޸���Դ
	public String updataResourceById(int id, Resource newResource);

	// �ϴ���Դ
	public String updateSrc(int resourceId, String relativePath);

	// �ϴ�����ͼ
	public String updateShowImageSrc(int resourceId, String relativePath);

	// ���·���
	public List<Resource> showResourceByChooseNew(int categoryId,
			int interestId, int i);

	// ���ȷ���
	public List<Resource> showResourceByChooseHot(int categoryId,
			int interestId, int type);

	// ���������ĵ���Դ
	public List<Resource> findAllDocumentResource(Page page, String sql);

	// ���������ĵ���Դ
	public List<Resource> findAllDocumentResourceNotPage();

	// ���������ĵ���Դ����
	public int findAllDocumentResourceCount();

	public List<Resource> queryByPage(Page page, int id);

	public int CountResource(int id);
}

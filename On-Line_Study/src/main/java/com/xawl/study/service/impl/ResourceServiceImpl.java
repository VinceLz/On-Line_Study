package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.ResourceDao;
import com.xawl.study.model.Page;
import com.xawl.study.model.Resource;
import com.xawl.study.service.ResourceService;
@Service
public class ResourceServiceImpl implements ResourceService{
	@Autowired
	ResourceDao resourceDao;

	// ����������Դ
	public List<Resource> findAllResource(Page page) {
		return resourceDao.findAllResource(page);
	}

	// ��id����Դ
	public Resource findResourceById(int id) {
		return resourceDao.findResourceById(id);
	}

	// ����������Դ����
	public int findAllResourceCount() {
		return resourceDao.findAllResourceCount();
	}

	// ����������Դ
	public List<Resource> findAllResourceNotPage() {
		return resourceDao.findAllResourceNotPage();
	}

	// ����Ȥid��
	public List<Resource> findResourceByInterestID(int id) {
		return resourceDao.findResourceByInterestID(id);
	}

	// ����Դ����
	public List<Resource> findResourceByName(String resourceName) {
		return resourceDao.findResourceByName(resourceName);
	}

	// ������category������Դ
	public List<Resource> findResourceByCategory(int categoryId, int type,
			Page page) {
		return resourceDao.findResourceByCategory(categoryId, type, page);
	}

	// ������category������Դ
	public List<Resource> findResourceByCategory(int categoryId, int type) {
		return resourceDao.findResourceByCategory(categoryId, type);
	}

	// ���γ�id������Դ
	public List<Resource> findResourceByClassNameId(int classNameId) {
		return resourceDao.findResourceByClassNameId(classNameId);
	}

	// ����Դ���Ͳ���Դ����Ƶ����
	public List<Resource> findResourceByResourceType(int type) {
		return resourceDao.findResourceByResourceType(type);
	}

	// ������Դ���ͺ���Ȥ���Ͳ���Դ
	public List<Resource> findResourceByTypeAndInterest(int type, int interestId) {
		return resourceDao.findResourceByTypeAndInterest(type, interestId);
	}

	// ������Դ���ͺ���Ȥ���Ͳ���Դ
	public List<Resource> findResourceByTypeAndInterest(int type,
			int interestId, Page page) {
		return resourceDao
				.findResourceByTypeAndInterest(type, interestId, page);
	}

	// ���
	public String addResource(Resource resource) {
		if (resourceDao.addResource(resource)) {
			return "��ӳɹ���";
		} else {
			return "��ӳ������Ժ����ԣ�";
		}
	}

	// ɾ��
	public String deleteResource(int id) {
		Resource resource = resourceDao.findResourceById(id);
		if (resource != null) {
			if (resourceDao.deleteResourceById(id)) {
				return "ɾ���ɹ�!";
			} else {
				return "δ֪ԭ��ɾ��ʧ��!";
			}
		} else {
			return "��Ҫɾ�����ļ��Ѿ��������ˣ�";
		}
	}

	// ��ҳ
	public List<Resource> queryByPage(Page page) {
		return resourceDao.queryByPage(page);
	}

	// ��ȡ��Դ����
	public int CountResource() {
		return resourceDao.CountResource();
	}

	// �޸���Դ
	public String updataResourceById(int id, Resource newResource) {
		if (resourceDao.updataResource(id, newResource)) {
			return "���³ɹ���";
		} else {
			return "����ʧ�ܣ�";
		}
	}

	// �ϴ���Դ
	public String updateSrc(int resourceId, String relativePath) {
		if (resourceDao.updateSrc(resourceId, relativePath)) {
			return "�ϴ��ɹ���";
		} else {
			return "�ϴ�ʧ�ܣ�";
		}
	}

	// �ϴ�����ͼ
	public String updateShowImageSrc(int resourceId, String relativePath) {
		if (resourceDao.updateShowImageSrc(resourceId, relativePath)) {
			return "�ϴ��ɹ���";
		} else {
			return "�ϴ�ʧ�ܣ�";
		}
	}

	// ���·���
	public List<Resource> showResourceByChooseNew(int categoryId,
			int interestId, int i) {
		if (categoryId == 0) {
			return resourceDao.findResourceByInterestID(interestId);
		} else {
			return resourceDao.showResourceByChooseNew(categoryId, i);
		}
	}

	// ���ȷ���
	public List<Resource> showResourceByChooseHot(int categoryId,
			int interestId, int type) {
		if (categoryId == 0) {
			return resourceDao.findResourceByInterestIDHot(interestId);
		} else {
			return resourceDao.showResourceByChooseHot(categoryId, interestId,
					type);
		}
	}

	// ���������ĵ���Դ
	public List<Resource> findAllDocumentResource(Page page) {
		return resourceDao.findAllDocumentResource(page);
	}

	// ���������ĵ���Դ
	public List<Resource> findAllDocumentResourceNotPage() {
		return resourceDao.findAllDocumentResourceNotPage();
	}

	// ���������ĵ���Դ����
	public int findAllDocumentResourceCount() {
		return resourceDao.findAllDocumentResourceCount();
	}
	
}

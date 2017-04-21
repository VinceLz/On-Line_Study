package com.xawl.study.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Page;
import com.xawl.study.model.Resource;
@Repository
public class ResourceDao extends BaseDaoImpl {

	// �����Դ
	public boolean addResource(Resource resource) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.save(resource);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}
		return isok;
	}

	// ����������Ƶ��Դ
	public List<Resource> findAllResource(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=0");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// ���������ĵ���Դ
	public List<Resource> findAllDocumentResource(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=1");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// ����������Ƶ��Դ
	public List<Resource> findAllResourceNotPage() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource r where r.resourceType=0");
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// ���������ĵ���Դ
	public List<Resource> findAllDocumentResourceNotPage() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource r where r.resourceType=1");
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// ����������Ƶ��Դ����
	public int findAllResourceCount() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=0");
		List<Resource> resourceList = query.list();
		return resourceList.size();
	}

	// ���������ĵ���Դ����
	public int findAllDocumentResourceCount() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=1");
		List<Resource> resourceList = query.list();
		return resourceList.size();
	}

	// ����Դid ����Դ
	public Resource findResourceById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Resource as r where r.id = "
				+ id);
		Resource rescource = new Resource();
		rescource = (Resource) query.uniqueResult();
		return rescource;
	}

	// ����Դ������Դ
	public List<Resource> findResourceByName(String resourceName) {

		Session session = getSessionFactory().getCurrentSession();

		Query query = session
				.createQuery("from Resource as r where r.resourceName like '%"
						+ resourceName + "%'");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// ������category������Դ
	public List<Resource> findResourceByCategory(int categoryId, int type,
			Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.category = "
						+ categoryId + "and r.resourceType = " + type);
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		List<Resource> rescourceList = query.list();
		return rescourceList;
	}

	// ������category������Դ
	public List<Resource> findResourceByCategory(int categoryId, int type) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.category = "
						+ categoryId + "and r.resourceType = " + type);
		List<Resource> rescourceList = query.list();
		return rescourceList;
	}

	// ���γ�id������Դ
	public List<Resource> findResourceByClassNameId(int classNameId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.classNameID = "
						+ classNameId);
		List<Resource> rescourceList = query.list();
		return rescourceList;
	}

	// ������Ȥid������Դ
	public List<Resource> findResourceByInterestID(int interestId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.beLongToInterestID = "
						+ interestId + "order by r.uploadeDate desc");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// ����Դ���ͣ���Ƶ���ĵ���������Դ
	public List<Resource> findResourceByResourceType(int type) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.resourceType =" + type);
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// ������Դ���ͺ���Ȥ���Ͳ���Դ
	public List<Resource> findResourceByTypeAndInterest(int type, int interestId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.resourceType = "
						+ type + " and r.beLongToInterestID = " + interestId
						+ "order by r.likeSum desc");
		List<Resource> resourceList = query.setMaxResults(6).list();

		return resourceList;
	}

	// ������Դ���ͺ���Ȥ���Ͳ���Դ
	public List<Resource> findResourceByTypeAndInterest(int type,
			int interestId, Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.resourceType = "
						+ type + " and r.beLongToInterestID = " + interestId
						+ "order by r.likeSum desc");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		List<Resource> resourceList = query.list();

		return resourceList;
	}

	// ������Դidɾ����Դ
	public boolean deleteResourceById(int id) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Resource resource = findResourceById(id);
		try {
			session.delete(resource);
			isok = true;
		} catch (Exception e) {
			isok = false;
		}
		return isok;
	}

	// ��ҳ
	public List<Resource> queryByPage(Page page) {
		List<Resource> resourceList = new ArrayList<Resource>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Resource");
		// ����ÿҳ��ʾ���ٸ������ö������
		query.setMaxResults(page.getEveryPage());
		// �������
		query.setFirstResult(page.getBeginIndex());
		resourceList = query.list();

		return resourceList;
	}

	// �õ���Դ����
	public int CountResource() {
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Resource");
		List<Resource> resourceList = new ArrayList<Resource>();
		resourceList = query.list();
		sum = resourceList.size();

		return sum;
	}

	// �޸���Դ
	public boolean updataResource(int id, Resource newResource) {
		boolean isok = false;
		Session session = getSessionFactory().getCurrentSession();
		Resource resource = new Resource();

		Query query = session.createQuery("from Resource as r where r.id = "
				+ id);
		resource = (Resource) query.uniqueResult();
		try {
			resource = newResource;
			resource.setId(id);
			;
			session.clear();
			session.update(resource);

			isok = true;
		} catch (Exception e) {
			throw new RuntimeException("��Դ�����ڣ�����ʧ�ܣ�");
		}
		return isok;

	}

	// �ϴ���Դ�޸���Դ��ַ
	public boolean updateSrc(int resourceId, String src) {
		boolean isok = false;
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session
					.createQuery("update Resource as r set r.src ='" + src
							+ "' where r.id =" + resourceId);
			query.executeUpdate();

			isok = true;
		} catch (Exception e) {
			isok = false;
		}
		return isok;
	}

	// �ϴ�����ͼ
	public boolean updateShowImageSrc(int resourceId, String relativePath) {
		boolean isok = false;
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session
					.createQuery("update Resource as r set r.showImageSrc ='"
							+ relativePath + "' where r.id =" + resourceId);
			query.executeUpdate();

			isok = true;
		} catch (Exception e) {
			isok = false;
		}
		return isok;
	}

	// ���·���
	public List<Resource> showResourceByChooseNew(int categoryId, int type) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.category = "
						+ categoryId + "and r.resourceType = " + type
						+ "order by r.uploadeDate desc");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// ���ȷ���
	public List<Resource> showResourceByChooseHot(int categoryId,
			int interestId, int type) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.category = "
						+ categoryId + "and r.resourceType = " + type
						+ "order by r.likeSum desc");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	public List<Resource> findResourceByInterestIDHot(int interestId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.beLongToInterestID = "
						+ interestId + "order by r.likeSum desc");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

}

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

	// 添加资源
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

	// 查找所有视频资源
	public List<Resource> findAllResource(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=0");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// 查找所有文档资源
	public List<Resource> findAllDocumentResource(Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=1");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// 查找所有视频资源
	public List<Resource> findAllResourceNotPage() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource r where r.resourceType=0");
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// 查找所有文档资源
	public List<Resource> findAllDocumentResourceNotPage() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource r where r.resourceType=1");
		List<Resource> resourceList = query.list();
		return resourceList;
	}

	// 查找所有视频资源数量
	public int findAllResourceCount() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=0");
		List<Resource> resourceList = query.list();
		return resourceList.size();
	}

	// 查找所有文档资源数量
	public int findAllDocumentResourceCount() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource  r where r.resourceType=1");
		List<Resource> resourceList = query.list();
		return resourceList.size();
	}

	// 按资源id 查资源
	public Resource findResourceById(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Resource as r where r.id = "
				+ id);
		Resource rescource = new Resource();
		rescource = (Resource) query.uniqueResult();
		return rescource;
	}

	// 按资源名查资源
	public List<Resource> findResourceByName(String resourceName) {

		Session session = getSessionFactory().getCurrentSession();

		Query query = session
				.createQuery("from Resource as r where r.resourceName like '%"
						+ resourceName + "%'");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// 按种类category查找资源
	public List<Resource> findResourceByCategory(int categoryId, int type,
			Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.category = "
						+ categoryId + "and r.resourceType = " + type);
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		List<Resource> rescourceList = query.list();
		return rescourceList;
	}

	// 按种类category查找资源
	public List<Resource> findResourceByCategory(int categoryId, int type) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.category = "
						+ categoryId + "and r.resourceType = " + type);
		List<Resource> rescourceList = query.list();
		return rescourceList;
	}

	// 按课程id查找资源
	public List<Resource> findResourceByClassNameId(int classNameId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.classNameID = "
						+ classNameId);
		List<Resource> rescourceList = query.list();
		return rescourceList;
	}

	// 按照兴趣id查找资源
	public List<Resource> findResourceByInterestID(int interestId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.beLongToInterestID = "
						+ interestId + "order by r.uploadeDate desc");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// 按资源类型（视频？文档？）查资源
	public List<Resource> findResourceByResourceType(int type) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.resourceType =" + type);
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// 按照资源类型和兴趣类型查资源
	public List<Resource> findResourceByTypeAndInterest(int type, int interestId) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.resourceType = "
						+ type + " and r.beLongToInterestID = " + interestId
						+ "order by r.likeSum desc");
		List<Resource> resourceList = query.setMaxResults(6).list();

		return resourceList;
	}

	// 按照资源类型和兴趣类型查资源
	public List<Resource> findResourceByTypeAndInterest(int type,
			int interestId, Page page) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.resourceType = "
						+ type + " and r.beLongToInterestID = " + interestId
						+ "order by r.likeSum desc");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		List<Resource> resourceList = query.list();

		return resourceList;
	}

	// 按照资源id删除资源
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

	// 分页
	public List<Resource> queryByPage(Page page) {
		List<Resource> resourceList = new ArrayList<Resource>();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Resource");
		// 设置每页显示多少个，设置多大结果。
		query.setMaxResults(page.getEveryPage());
		// 设置起点
		query.setFirstResult(page.getBeginIndex());
		resourceList = query.list();

		return resourceList;
	}

	// 得到资源总数
	public int CountResource() {
		int sum = 0;
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Resource");
		List<Resource> resourceList = new ArrayList<Resource>();
		resourceList = query.list();
		sum = resourceList.size();

		return sum;
	}

	// 修改资源
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
			throw new RuntimeException("资源不存在，更新失败！");
		}
		return isok;

	}

	// 上传资源修改资源地址
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

	// 上传封面图
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

	// 最新分类
	public List<Resource> showResourceByChooseNew(int categoryId, int type) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("from Resource as r where r.category = "
						+ categoryId + "and r.resourceType = " + type
						+ "order by r.uploadeDate desc");
		List<Resource> rescourceList = query.list();

		return rescourceList;
	}

	// 最热分类
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

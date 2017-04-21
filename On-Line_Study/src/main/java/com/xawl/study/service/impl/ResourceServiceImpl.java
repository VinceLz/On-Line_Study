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

	// 查找所有资源
	public List<Resource> findAllResource(Page page) {
		return resourceDao.findAllResource(page);
	}

	// 按id查资源
	public Resource findResourceById(int id) {
		return resourceDao.findResourceById(id);
	}

	// 查找所有资源数量
	public int findAllResourceCount() {
		return resourceDao.findAllResourceCount();
	}

	// 查找所有资源
	public List<Resource> findAllResourceNotPage() {
		return resourceDao.findAllResourceNotPage();
	}

	// 按兴趣id查
	public List<Resource> findResourceByInterestID(int id) {
		return resourceDao.findResourceByInterestID(id);
	}

	// 按资源名查
	public List<Resource> findResourceByName(String resourceName) {
		return resourceDao.findResourceByName(resourceName);
	}

	// 按种类category查找资源
	public List<Resource> findResourceByCategory(int categoryId, int type,
			Page page) {
		return resourceDao.findResourceByCategory(categoryId, type, page);
	}

	// 按种类category查找资源
	public List<Resource> findResourceByCategory(int categoryId, int type) {
		return resourceDao.findResourceByCategory(categoryId, type);
	}

	// 按课程id查找资源
	public List<Resource> findResourceByClassNameId(int classNameId) {
		return resourceDao.findResourceByClassNameId(classNameId);
	}

	// 按资源类型查资源（视频？）
	public List<Resource> findResourceByResourceType(int type) {
		return resourceDao.findResourceByResourceType(type);
	}

	// 按照资源类型和兴趣类型查资源
	public List<Resource> findResourceByTypeAndInterest(int type, int interestId) {
		return resourceDao.findResourceByTypeAndInterest(type, interestId);
	}

	// 按照资源类型和兴趣类型查资源
	public List<Resource> findResourceByTypeAndInterest(int type,
			int interestId, Page page) {
		return resourceDao
				.findResourceByTypeAndInterest(type, interestId, page);
	}

	// 添加
	public String addResource(Resource resource) {
		if (resourceDao.addResource(resource)) {
			return "添加成功！";
		} else {
			return "添加出错！请稍后再试！";
		}
	}

	// 删除
	public String deleteResource(int id) {
		Resource resource = resourceDao.findResourceById(id);
		if (resource != null) {
			if (resourceDao.deleteResourceById(id)) {
				return "删除成功!";
			} else {
				return "未知原因删除失败!";
			}
		} else {
			return "您要删除的文件已经不存在了！";
		}
	}

	// 分页
	public List<Resource> queryByPage(Page page) {
		return resourceDao.queryByPage(page);
	}

	// 获取资源总数
	public int CountResource() {
		return resourceDao.CountResource();
	}

	// 修改资源
	public String updataResourceById(int id, Resource newResource) {
		if (resourceDao.updataResource(id, newResource)) {
			return "更新成功！";
		} else {
			return "更新失败！";
		}
	}

	// 上传资源
	public String updateSrc(int resourceId, String relativePath) {
		if (resourceDao.updateSrc(resourceId, relativePath)) {
			return "上传成功！";
		} else {
			return "上传失败！";
		}
	}

	// 上传封面图
	public String updateShowImageSrc(int resourceId, String relativePath) {
		if (resourceDao.updateShowImageSrc(resourceId, relativePath)) {
			return "上传成功！";
		} else {
			return "上传失败！";
		}
	}

	// 最新分类
	public List<Resource> showResourceByChooseNew(int categoryId,
			int interestId, int i) {
		if (categoryId == 0) {
			return resourceDao.findResourceByInterestID(interestId);
		} else {
			return resourceDao.showResourceByChooseNew(categoryId, i);
		}
	}

	// 最热分类
	public List<Resource> showResourceByChooseHot(int categoryId,
			int interestId, int type) {
		if (categoryId == 0) {
			return resourceDao.findResourceByInterestIDHot(interestId);
		} else {
			return resourceDao.showResourceByChooseHot(categoryId, interestId,
					type);
		}
	}

	// 查找所有文档资源
	public List<Resource> findAllDocumentResource(Page page) {
		return resourceDao.findAllDocumentResource(page);
	}

	// 查找所有文档资源
	public List<Resource> findAllDocumentResourceNotPage() {
		return resourceDao.findAllDocumentResourceNotPage();
	}

	// 查找所有文档资源数量
	public int findAllDocumentResourceCount() {
		return resourceDao.findAllDocumentResourceCount();
	}
	
}

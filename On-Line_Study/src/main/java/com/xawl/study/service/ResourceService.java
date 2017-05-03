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

	// 按id查资源
	public Resource findResourceById(int id);

	// 查找所有资源数量
	public int findAllResourceCount();

	// 查找所有资源
	public List<Resource> findAllResourceNotPage();

	// 按兴趣id查
	public List<Resource> findResourceByInterestID(int id);

	// 按资源名查
	public List<Resource> findResourceByName(String resourceName);

	// 按种类category查找资源
	public List<Resource> findResourceByCategory(int categoryId, int type,
			Page page);

	// 按种类category查找资源
	public List<Resource> findResourceByCategory(int categoryId, int type);

	// 按课程id查找资源
	public List<Resource> findResourceByClassNameId(int classNameId);

	// 按资源类型查资源（视频？）
	public List<Resource> findResourceByResourceType(int type);

	// 按照资源类型和兴趣类型查资源
	public List<Resource> findResourceByTypeAndInterest(int type, int interestId);

	// 按照资源类型和兴趣类型查资源
	public List<Resource> findResourceByTypeAndInterest(int type,
			int interestId, Page page);

	// 添加
	public String addResource(Resource resource);

	// 删除
	public String deleteResource(int id);

	// 分页
	public List<Resource> queryByPage(Page page);

	// 获取资源总数
	public int CountResource();

	// 修改资源
	public String updataResourceById(int id, Resource newResource);

	// 上传资源
	public String updateSrc(int resourceId, String relativePath);

	// 上传封面图
	public String updateShowImageSrc(int resourceId, String relativePath);

	// 最新分类
	public List<Resource> showResourceByChooseNew(int categoryId,
			int interestId, int i);

	// 最热分类
	public List<Resource> showResourceByChooseHot(int categoryId,
			int interestId, int type);

	// 查找所有文档资源
	public List<Resource> findAllDocumentResource(Page page, String sql);

	// 查找所有文档资源
	public List<Resource> findAllDocumentResourceNotPage();

	// 查找所有文档资源数量
	public int findAllDocumentResourceCount();

	public List<Resource> queryByPage(Page page, int id);

	public int CountResource(int id);
}

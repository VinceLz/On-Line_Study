package com.xawl.study.service;

import java.util.List;

import com.xawl.study.model.IndexModel;

public interface IndexModelService {

	// 添加首页方案
	public String addIndexModel(IndexModel index);

	// 查找所有首页方案
	public List<IndexModel> findAllIndex();

	// 查找启用的首页方案
	public IndexModel findUseModel();

	// 按照id查首页方案
	public IndexModel findIndexModelById(int id);

	// 删除首页方案
	public String deleteIndexModelById(int id);

	// 关闭已经启用的方案
	public boolean closeUseIndex();

	// 按id修改首页方案
	public String updateIndexModelById(int id, IndexModel indexModel);

	// 按id和图片位置修改首页方案
	public String updateImage(int indexId, String location, String relativePath);
}

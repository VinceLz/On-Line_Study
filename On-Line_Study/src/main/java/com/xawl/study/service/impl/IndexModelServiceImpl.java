package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.IndexModelDao;
import com.xawl.study.model.IndexModel;
import com.xawl.study.service.IndexModelService;

@Service
public class IndexModelServiceImpl implements IndexModelService{
	@Autowired
	IndexModelDao indexModelDao ;
	//添加首页方案
	public String addIndexModel(IndexModel index){
		if(indexModelDao.addIndexModel(index)){
			return "添加成功！";
		}else{
			return "添加失败！请稍后再试！";
		}
	}
	
	//查找所有首页方案
	public List<IndexModel> findAllIndex(){
		return indexModelDao.findAllIndex();
	}
	
	//查找启用的首页方案
	public IndexModel findUseModel(){
		return indexModelDao.findUseModel();
	}
	
	//按照id查首页方案
	public IndexModel findIndexModelById(int id){
		return indexModelDao.findIndexModelById(id);
	}
	
	//删除首页方案
	public String deleteIndexModelById(int id){
		IndexModel indexModel = new IndexModel();
		indexModel = this.findIndexModelById(id);
		if(indexModel != null){
			if(indexModelDao.deleteIndexModelById(indexModel)){
				return "删除成功！";
			}else{
				return "未知原因删除失败！";
			}			
		}else{
			return"该首页方案不存在！删除失败！";
		}
	}

	//关闭已经启用的方案
	public boolean closeUseIndex() {
		return indexModelDao.closeUseIndex();
	}
	
	//按id修改首页方案
	public String updateIndexModelById(int id,IndexModel indexModel){
		if(indexModelDao.updateIndexModel(id, indexModel)){
			return "更新成功！";
		}else{
			return "更新失败！";
		}
	}

	//按id和图片位置修改首页方案
	public String updateImage(int indexId, String location, String relativePath) {
		if(indexModelDao.updateImage(indexId, location,relativePath)){
			return "更新图片成功！";
		}else{
			return "更新图片失败！";
		}
		
	}
	
}

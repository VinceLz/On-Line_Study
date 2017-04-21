package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.ProvinceDao;
import com.xawl.study.model.Province;

public interface ProvinceService {

	public List<Province> GetAllProvinceList();

	public String getProvinceNameByID(String id);
}

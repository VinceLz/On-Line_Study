package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.ProvinceDao;
import com.xawl.study.model.Province;
import com.xawl.study.service.ProvinceService;
@Service
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	ProvinceDao pd;

	public List<Province> GetAllProvinceList() {
		return pd.GetAllProvinceList();
	}

	public String getProvinceNameByID(String id) {
		return pd.getProvinceNameByID(id);
	}

}
